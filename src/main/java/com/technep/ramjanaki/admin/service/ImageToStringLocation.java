package com.technep.ramjanaki.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by surajgautam on 7/16/17.
 */
@Service
public class ImageToStringLocation {


    public String writeFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String PATH = "/home/surajgautam/Desktop/RamJanakiFurnishing/src/main/webapp/assets/images/";
        String fileName = file.getOriginalFilename();
        File file1 = new File(PATH+fileName);


        String originalFileName= PATH.split("assets")[1];
        System.out.println(originalFileName);


        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        return "/resources"+ originalFileName + fileName+"/";
    }


}
