package com.ws.review.controller;

import com.ws.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Random;


@Controller
public class FileController {

    @Autowired
    UserService userService;



    public String uploadPage(){
        return "uploadPage";
    }
    /**
     * MultipartFile用来接收前台传过来的文件
     * 1、获取本地文件名，然后加上系统当前时间，组合为需要保存的文件名
     * 2、生成一个保存文件的路径
     * 3、在服务器创建文件
     * 4、在服务器打开输入流，将前台传过来的数据写入到输入流中
     * 5、弹回一个上传成功的信息
     * @param request
     * @param file
     * @param m
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile file,Model m) {
        //将系统当前的时间加上文件原来的文件名整为服务器文件名
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("id");
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        String destName = "F:\\uploaded"+ File.separator+fileName;
        File destFile = new File(destName);
        destFile.getParentFile().mkdirs();
        try{
            //将file文件里的内容复制给destFile文件
            file.transferTo(destFile);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException ioe) {
            ioe.printStackTrace();
            //return "上传失败," + ioe.getMessage();
        }
        addFatherFile(fileName);
        userService.increaseFileNumber(id);
        m.addAttribute("message","上传成功");
        return "redirect:/index";
    }

    /**
     * 在fatherfile中随机抽取一个文件名
     * @param request
     * @return
     */
    @RequestMapping("random")
    public String RandomSelectFile(HttpServletRequest request,Model m){
        HttpSession session = request.getSession();
        int id = (Integer)session.getAttribute("id");
        int fileNum = userService.queryFileNumber(id);
        Random random = new Random();
        int random_num = random.nextInt(fileNum);
        File file = new File("F:\\fatherFile\\fileFile.txt");
        BufferedReader in = null;
        String fileName = "";
        try{
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            for(int i=0;i<random_num;i++){
                in.readLine();
            }
            fileName = in.readLine();
        }catch(Exception e){
            throw new RuntimeException("错误信息"+e);
        }
        m.addAttribute("fileName",fileName);
        return "redirect:/index";
    }

    /**
     * 1.打开父文件
     * 2、将父文件作为输入流的源
     * 3、写入上传的文件名和一个换行符
     * 4、更新数据库的上传文件数量
     * @param fileName
     */
    public void addFatherFile(String fileName) {
        File file = new File("F:\\fatherFile\\fileFile.txt");
        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
            out.write(fileName);
            out.newLine();

        }catch(Exception e){
            throw new RuntimeException("错误信息"+e);
        }finally {
            try{
                out.close();
            }catch(IOException ioe){
                throw new RuntimeException("错误信息"+ioe);
            }
        }
    }


}
