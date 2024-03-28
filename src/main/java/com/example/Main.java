package com.example;

import java.awt.Rectangle;
import java.io.File;
import java.util.Arrays;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Main {

    public static void main(String[] args) {
        String result = null;
        try {
            File image = new File("src/main/resources/ThaiIDCard_Mr._Sample.jpg");
            Tesseract tesseract = new Tesseract();
            tesseract.setLanguage("tha");
            // tesseract.setPageSegMode(1);
            // tesseract.setOcrEngineMode(1);
            tesseract.setDatapath("src/main/resources/tessdata_best");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(140, 155, 360, 45)));
            System.out.println(result);
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(45, 280, 330, 48)));
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        // System.out.println(result);
        // System.out.println("result");
    }

}