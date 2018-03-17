package com.wenhao.security.wenhaosecuritydemo.web.controller;

import com.wenhao.security.wenhaosecuritydemo.dto.FileInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping
    public FileInfo fileUpload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        String folder = "D:/githom/wenhao-security/wenhao-security-demo/src/main/java/com/wenhao/security/wenhaosecuritydemo/web/controller/FileUploadController";

        File localFile = new File(folder, new Date().getTime() + "txt");

        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());
    }
}
