package com.technep.ramjanaki.files;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/


import com.sun.mail.iap.ByteArray;
import com.technep.ramjanaki.sales.model.SalesModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileExportController{


    @GetMapping(value = "/export-pdf/sales")
    public ResponseEntity<ByteArray[]> exportAsPDFForSales(@RequestBody SalesModel salesModel, ServletContext servletContext) throws FileNotFoundException, JRException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        String realPath = servletContext.getRealPath("/reporting/TrialBalance.jrxml");
        InputStream inputStream = new FileInputStream(realPath);


        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);


        Map param = new HashMap();
        param.put("title","Ram Janaki Furnishing And Decor");
        param.put("date", new Date());
        return null;





    }

}
