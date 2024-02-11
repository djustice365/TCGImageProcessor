package org.justice.tcgImageProcessor.services

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ImageService {

    fun resize(img: BufferedImage, newW: Int, newH: Int): BufferedImage {
        val tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH)
        val dimg = BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB)
        val g2d = dimg.createGraphics()
        g2d.drawImage(tmp, 0, 0, null)
        g2d.dispose()
        println("resized height: " + dimg.height)
        println("resized width: " + dimg.width)
        return dimg
    }

    fun makeBW(original: BufferedImage): BufferedImage {
        val blackWhite = BufferedImage(original.width, original.height, BufferedImage.TYPE_BYTE_BINARY)
        val g2d: Graphics2D = blackWhite.createGraphics()
        g2d.drawImage(original, 0, 0, null)
        g2d.dispose()

        return blackWhite

//        ImageService().invertColors(blackWhite)
//
//        ImageIO.write(blackWhite, "png", File("${sourceDir}edition-bw.png"))
    }

    fun hasImage(img: BufferedImage): Boolean {
        val initialColor: Int = img.getRGB(0, 0)
        for (x in 0 until img.width) {
            for (y in 0 until img.height) {
                if (img.getRGB(x, y) != initialColor)
                    return true
            }
        }

        return false;
    }

    fun invertColors(img: BufferedImage) {
        for (x in 0 until img.width) {
            for (y in 0 until img.height) {
                val rgba: Int = img.getRGB(x, y)
                var col = Color(rgba, true)
                col = Color(
                    255 - col.red,
                    255 - col.green,
                    255 - col.blue
                )
                img.setRGB(x, y, col.rgb)
            }
        }
    }

    fun getSubImage(source: BufferedImage, x: Int, y: Int, w: Int, h: Int): BufferedImage {
        return source.getSubimage(x, y, w, h)
    }
}