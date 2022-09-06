package com.test.pdf;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.OutlineHandler;
import com.itextpdf.html2pdf.css.apply.ICssApplier;
import com.itextpdf.html2pdf.css.apply.ICssApplierFactory;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.node.IElementNode;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class PdfService {

    private static final String TEST_FILE_NAME = "test"+System.currentTimeMillis();

    public void generatePdf(String html) throws IOException {
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setOutlineHandler(new OutlineHandler());

        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new File("d:\\" + TEST_FILE_NAME + ".pdf")));
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());


        HtmlConverter.convertToPdf(html,
                pdfDocument, converterProperties);
    }

//    public void generatePdf() throws URISyntaxException, IOException {
//        File source = getFileFromResource("mail/"+TEST_FILE_NAME + ".html");
//
//
//        ConverterProperties converterProperties = new ConverterProperties();
//        converterProperties.setOutlineHandler(new OutlineHandler());
//        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(new File("d:\\" + TEST_FILE_NAME + ".pdf")));
//        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
//
//        HtmlConverter.convertToPdf(new FileInputStream(source),
//                pdfDocument, converterProperties);
//    }
//
//    private File getFileFromResource(String fileName) throws URISyntaxException {
//
//        ClassLoader classLoader = getClass().getClassLoader();
//        URL resource = classLoader.getResource(fileName);
//        if (resource == null) {
//            throw new IllegalArgumentException("file not found! " + fileName);
//        } else {
//
//            // failed if files have whitespaces or special characters
//            //return new File(resource.getFile());
//
//            return new File(resource.toURI());
//        }
//
//    }
}
