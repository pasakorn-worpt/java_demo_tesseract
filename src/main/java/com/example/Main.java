package com.example;

import java.awt.Rectangle;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;

public class Main {

    public static void main(String[] args) {
        String result = null;
        try {
            File image = new File("src/main/resources/image.png");
            Tesseract tesseract = new Tesseract();
            // tesseract.setLanguage("tha");
            tesseract.setLanguage("eng");
            // tesseract.setPageSegMode(1);
            // tesseract.setOcrEngineMode(1);
            tesseract.setDatapath("src/main/resources/tessdata_best");
            // result = tesseract.doOCR(image);

            System.out.println("---- Get Position ----");
            tesseract.setLanguage("eng");
            List<Word> words = tesseract.getWords(ImageIO.read(image),
                    ITessAPI.TessPageIteratorLevel.RIL_WORD);

            for (Word word : words) {
                String text = word.getText();
                if (text.equals("Thai") || text.equals("National") || text.equals("ID") || text.equals("Card")) {
                    Rectangle rect = word.getBoundingBox();
                    System.out.println(text + ":  " + rect.x + ", " + rect.y);
                }
            }

            System.out.println("---- Read Info ----");
            tesseract.setLanguage("eng");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(450, 70, 440,
                    50)));
            System.out.println("ID card: " + result);
            tesseract.setLanguage("tha");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(245, 125, 745,
                    75)));
            System.out.println("Name th: " + result);
            tesseract.setLanguage("eng");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(305, 195, 685,
                    35)));
            System.out.println("Name en: " + result);
            tesseract.setLanguage("eng");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(305, 230, 685,
                    50)));
            System.out.println("Lastname en: " + result);
            tesseract.setLanguage("tha");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(305, 280, 445,
                    55)));
            System.out.println("DoB th: " + result);
            tesseract.setLanguage("eng");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(305, 335, 445,
                    55)));
            System.out.println("DoB en: " + result);

            tesseract.setLanguage("tha");
            result = tesseract.doOCR(image, Arrays.asList(new Rectangle(105, 375, 650,
                    130)));
            System.out.println("Addrs th: " + result);
            // result = tesseract.doOCR(image, Arrays.asList(new Rectangle(45, 280, 330,
            // 48)));
            // System.out.println(result);
        } catch (

        Exception e) {
            e.printStackTrace();
        }
        // System.out.println(result);
        // System.out.println("result");
    }

}