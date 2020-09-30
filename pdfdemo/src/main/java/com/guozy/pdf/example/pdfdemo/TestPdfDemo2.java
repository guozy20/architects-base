package com.guozy.pdf.example.pdfdemo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jdk.nashorn.internal.ir.SetSplitState;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @ProjectName pdfdemo
 * @Classname TestPdfDemo1
 * @Description TODO
 * @Date 2020/9/30 16:54
 * @Created by guozy
 */
public class TestPdfDemo2 {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        // 1.新建document对象
        Document document = new Document();

        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/guozy/test.pdf"));

        // 3.打开文件
        document.open();

        // 4.添加一个内容段落
        document.add(new Paragraph("HD content here"));

        // 3列的表
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距

        List<PdfPRow> rowList = table.getRows();

        //设置列宽
        float[] columnWidths = {1f, 2f, 3f};
        table.setWidths(columnWidths);


        // 行1
        PdfPCell cells1[] = new PdfPCell[3];
        PdfPRow row1 = new PdfPRow(cells1);

        // d单元格
        cells1[0] = new PdfPCell(new Paragraph("1111")); // 单元格内容
        cells1[0].setBorderColor(BaseColor.BLUE); //边框验证
        cells1[0].setPaddingLeft(20); // 左填充20
        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER); // 水平居中
        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE); // 垂直居中

        cells1[1] = new PdfPCell(new Paragraph("2222"));
        cells1[2] = new PdfPCell(new Paragraph("3333"));

        // 行2
        PdfPCell cells2[]= new PdfPCell[3];
        PdfPRow row2 = new PdfPRow(cells2);
        cells2[0] = new PdfPCell(new Paragraph("4444"));

        //把第一行添加到集合
        rowList.add(row1);
        rowList.add(row2);
        //把表格添加到文件中
        document.add(table);

        // 5.关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
