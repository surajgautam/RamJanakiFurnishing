package com.technep.ramjanaki;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTrialbalance {

    public static void main(String[] args) throws FileNotFoundException, JRException {

        InputStream employeeReportStream
                = new FileInputStream(new File("/home/surajgautam/projects/RamJanakiFurnishing/src/main/webapp/WEB-INF/reporting/test.jrxml"));
        JasperReport jasperReport
                = JasperCompileManager.compileReport(employeeReportStream);


        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("particulars", "Employee Report");
        parameters.put("debit", 15000.0);
        parameters.put("credit", 2000.00);

        JasperPrint jasperPrint
                = JasperFillManager.fillReport(jasperReport, parameters);

        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput("trialbalancetest.pdf"));

        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("baeldunsurajg");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
    }
}
