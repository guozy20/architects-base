package com.guozy.pdf.example.pdfdemo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ProjectName pdfdemo
 * @Classname TestPdfDemo1
 * @Description TODO
 * @Date 2020/9/30 16:54
 * @Created by guozy
 */
public class TestPdfDemo1 {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        // 1.新建document对象
        Document document = new Document();

        // 2.建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/guozy/test.pdf"));

        // 3.打开文件
        document.open();

        // 4.添加一个内容段落
        document.add(new Paragraph("hello world"));

        // 5.关闭文档
        document.close();
    }
}
