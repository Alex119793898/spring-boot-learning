package com.caoliang.springboot.fileUpload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class UploadController {

    private final static String FILE_UPLOAD_PATH ="/Users/caoliang/Downloads/Java_project/spring-boot-learning-processing/spring-boot-learning-processing/spring-boot-file-upload/src/main/resources/static/";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败";
        }

        String filename = file.getOriginalFilename();
        String extName = filename.substring(filename.indexOf("."));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random random = new Random();
        StringBuilder tempFileName = new StringBuilder();
        tempFileName.append(dateFormat.format(new Date())).append(random.nextInt(100)).append(extName);
        String newFileName = tempFileName.toString();

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_UPLOAD_PATH + newFileName);
            Files.write(path, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "上传成功，图片地址为： /files/" + newFileName;
    }

}
