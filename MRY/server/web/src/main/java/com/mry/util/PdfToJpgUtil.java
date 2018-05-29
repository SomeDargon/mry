package com.mry.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/6/13 10:45
 */
public class PdfToJpgUtil {
    public static List<BufferedImage> PdfToJpg(byte[] data) throws IOException {
        PDDocument document = PDDocument.load(data);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        List<BufferedImage> res = new ArrayList<BufferedImage>();
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage image = pdfRenderer.renderImageWithDPI(i, 120);
            res.add(image);
        }
        document.close();
        data = null;
        return res;
    }
}
