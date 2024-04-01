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
            File image = new File("src/main/resources/ThaiIDCard_Mr._Sample.jpg");
            Tesseract tesseract = new Tesseract();
            // tesseract.setLanguage("tha");
            tesseract.setLanguage("eng");
            // tesseract.setPageSegMode(1);
            // tesseract.setOcrEngineMode(1);
            tesseract.setDatapath("src/main/resources/tessdata_best");
            // result = tesseract.doOCR(image);
            // result = tesseract.doOCR(image, Arrays.asList(new Rectangle(140, 155, 360,
            // 45)));
            // System.out.println(result);
            // result = tesseract.doOCR(image, Arrays.asList(new Rectangle(45, 280, 330,
            // 48)));
            // System.out.println(result);
            List<Word> words = tesseract.getWords(ImageIO.read(image), ITessAPI.TessPageIteratorLevel.RIL_WORD);

            for (Word word : words) {
                String text = word.getText();
                Rectangle rect = word.getBoundingBox();
                System.out.println(text + ":" + rect.x + ", " + rect.y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(result);
        // System.out.println("result");
    }

}