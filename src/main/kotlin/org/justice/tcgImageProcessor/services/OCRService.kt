package org.justice.tcgImageProcessor.services

import com.asprise.ocr.Ocr
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class OCRService {

    fun readImages(images: MutableList<BufferedImage>): MutableList<String> {
        return images.map { readImage(it) }.toMutableList()
    }

    fun readImage(image: BufferedImage): String {
        var result = ""

        Ocr.setUp()
        val ocr = Ocr() // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FAST) // English

        val fileImageTmp = File.createTempFile("temp", ".png")
        ImageIO.write(image, "png", fileImageTmp)
        result =
            ocr.recognize(arrayOf(File(fileImageTmp.absolutePath)), Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT)

        ocr.stopEngine()

        return result
    }

}