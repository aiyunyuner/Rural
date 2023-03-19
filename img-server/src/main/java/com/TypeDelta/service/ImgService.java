package com.TypeDelta.service;

import com.TypeDelta.mapper.ImgMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImgService {
    @Value("${web.upload-path}")
    private String targetFilePath;

    @Value("${web.http-string}")

    private String HTTPString;
    @Autowired
    private ImgMapper imgMapper;

    public String upload(MultipartFile zipFile) {

        String fileName = UUID.randomUUID().toString().replace("-", "") + zipFile.getOriginalFilename().substring(zipFile.getOriginalFilename().lastIndexOf("."));
        File targetFile = new File(targetFilePath + File.separator + fileName);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(targetFile);
            IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
        } catch (IOException e) {
            return "error";
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {

            }
        }
        return HTTPString + fileName;
    }
}
