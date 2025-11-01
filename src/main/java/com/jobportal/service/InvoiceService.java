package com.jobportal.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.jobportal.entity.Payment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    public byte[] generateInvoice(Payment pay) {
        try {
            Document document = new Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, baos);
            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLDITALIC);
            Paragraph title = new Paragraph("Payment Invoice Copy", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Invoice ID: " + pay.getTransactionId()));
            document.add(new Paragraph("User ID: " + pay.getUserId()));
            document.add(new Paragraph("Plan ID: " + pay.getPlanId()));
            document.add(new Paragraph("Currency: " + pay.getCurrency()));
            document.add(new Paragraph("Amount Paid: Rs " + pay.getAmount()));
            document.add(new Paragraph("Payment Status: " + pay.getPaymentStatus()));
            document.add(new Paragraph("Date: " + pay.getTimeStamp()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Thank you for using Zidio."));

            document.close();

            return baos.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error generating invoice", e);
        }
    }
}
