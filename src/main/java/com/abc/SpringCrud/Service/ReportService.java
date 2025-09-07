package com.abc.SpringCrud.Service;

import com.abc.SpringCrud.Entity.Student;
import com.abc.SpringCrud.Repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportService {

    private final StudentRepository studentRepository;

    public ReportService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public byte[] generateReport() throws Exception {
        List<Student> students = studentRepository.findAll();

        // Load jrxml file
        JasperReport jasperReport = JasperCompileManager
                .compileReport(getClass().getResourceAsStream("/reports/student_report.jrxml"));

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);

        return out.toByteArray();
    }
}

