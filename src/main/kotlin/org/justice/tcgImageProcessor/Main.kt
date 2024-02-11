package org.justice.tcgImageProcessor

import org.justice.tcgImageProcessor.constants.SizeConstants
import org.justice.tcgImageProcessor.services.ImageService
import org.justice.tcgImageProcessor.services.dividers.LegacyImageDivider
import org.justice.tcgImageProcessor.services.OCRService
import org.justice.tcgImageProcessor.services.ScraperService
import org.justice.tcgImageProcessor.services.dividers.interfaces.ImageDivider
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    scrape()
//    val divider: ImageDivider = LegacyImageDivider()
//    val sourceDir2 = "src/main/resources/"
//    val img: BufferedImage = ImageIO.read(File("${sourceDir2}name.png"))
//    val str = OCRService().readImage(img)
//    println("Result of read image: $str")
//
//    System.exit(1)
//    val sourceDir = "src/main/resources/"
////    val name = "45163.jpg"
//    val name = "42402.jpg"
//
//    // get image
//    // once this is a library, the image itself might be passed in directly and don't need this step
//    val source = ImageIO.read(File("$sourceDir$name"))
//
//    // re-adjust to correct size
//    val resized = ImageService().resize(source, SizeConstants().width(), SizeConstants().height())
//
//    // send it to divider
//    val arr: MutableList<BufferedImage> = divider.divideAllParts(resized)
//
//    // send list to OCR
//    println(OCRService().readImages(arr))
//
//    // set all data to card data
//
//    // validate the required data exists
//
//    // scrape web for low and high price
//
//    // store data to google sheets
}

fun scrape() {
    val scraper = ScraperService("http://www.google.com")
    println("Doc: ${scraper.getDocument()}")
}

