package com.egbas.demoPDFGeneration;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Path;
import com.itextpdf.text.pdf.parser.clipper.Paths;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public class PDFGeneration {

    public static void main(String[] args) throws FileNotFoundException, DocumentException, URISyntaxException {

        // The document size can also be set in a different variable such as
       // Rectangle docSize = new Rectangle(PageSize.A4) this can be done also and passed into the new document
        // The document to be written on is created here
        Document document = new Document(new Rectangle(PageSize.A4));

        // The file below can also be created in another format
        // OutputStream outputStream = new FileOutputStream("sample.pdf"); Then the outputStream is passed into the get instance method

        PdfWriter.getInstance(document, new FileOutputStream("sample.pdf"));

        // The document has been created and has opened it to be written on by the line below
        document.open();

        Paragraph paragraph = new Paragraph("This is my first document created");
        document.add(paragraph);
        Paragraph pa = new Paragraph(" ");
        document.add(pa);
        Paragraph par = new Paragraph();
        document.add(par);

        PdfPTable table = new PdfPTable(3);
        tableHeader(table);
        addRow(table);
        addCustomRow(table);

        document.add(table);
        document.close();

    }

    private static void tableHeader(PdfPTable table){
        Stream.of("Id", "Firstname", "Lastname").forEach(title -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.BLUE);
            header.setBorderWidth(1);
            header.setPhrase(new Phrase(title));
            table.addCell(header);

        });
    }

    private static void addRow(PdfPTable table){
        table.addCell("1");
        table.addCell("Emmanuel");
        table.addCell("Onaivi");
    }

    private static void addCustomRow(PdfPTable table) throws URISyntaxException {
        PdfPCell id = new PdfPCell(new Phrase("2"));
        id.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(id);

        PdfPCell firstname = new PdfPCell(new Phrase("Joshua"));
        firstname.setVerticalAlignment(Element.ALIGN_RIGHT);
        table.addCell(firstname);

        PdfPCell lastname = new PdfPCell(new Phrase("Ashaire"));
        lastname.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(lastname);

    }
}
