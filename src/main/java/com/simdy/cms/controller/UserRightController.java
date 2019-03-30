package com.simdy.cms.controller;

import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName UserRightController
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/29 15:29
 * @Version 1.0
 **/
@RestController()
@CrossOrigin
public class UserRightController {

    @Autowired
    UserService userService;

    @RequestMapping("/download/{fileName:[a-zA-Z0-9\\\\.]+}")
    public void musicDownload(@PathVariable("fileName") String fileName , HttpServletRequest request, HttpServletResponse response) {
        String downloadFilePath = "D:/imageTemp/image/upload/"+fileName;//被下载的文件在服务器中的路径,
        File file = new File(downloadFilePath);
        System.out.println(file.exists());
        if (file.exists()){
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                UserListEnt user = (UserListEnt) request.getSession().getAttribute("user");
                userService.subDownLoadSize(user.getId());
                user.setDownloadSize(user.getDownloadSize()-1);
                request.getSession().setAttribute("user",user);

                response.setStatus(200);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            response.setStatus(405);
        }

    }
}
