package com.example;

import java.awt.Rectangle;
import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main {

    public static void main(String[] args) {
        String result = null;
        try {
            File image = new File("src/main/resources/ThaiIDCard_Mr._Sample.jpg");
            Tesseract tesseract = new Tesseract();
            tesseract.setLanguage("tha+eng");
            // tesseract.setPageSegMode(1);
            // tesseract.setOcrEngineMode(1);
            tesseract.setDatapath("src/main/resources/tessdata_best");
            result = tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        // System.out.println("result");
    }

}