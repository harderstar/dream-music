package com.simdy.cms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController()
public class FileUploadController {

    @PostMapping("upload")
    public String uploadFile(@RequestParam(required = false,value = "file") MultipartFile file, HttpServletRequest request) throws Exception {

        // 判断用户是否登录
        if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {

                    String realPath=request.getServletContext().getRealPath("/images/");
                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
                    // 设置存放图片文件的路径
                    path = realPath + trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                        System.out.println("文件成功上传到指定目录下");
//                    Student student = new Student();
//                    student.setId(id);
//                    student.setPicture("images/"+trueFileName);
//                    boolean updateMessage = messageService.updateMessagepic(student);
                      return "images/"+trueFileName;
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return "errortype";
                }
            }else {
                System.out.println("文件类型为空");
                return "nulltype";
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return "nulltype";
        }

    }

}
