package org.justice.tcgImageProcessor.services.dividers

import org.justice.tcgImageProcessor.services.ImageService
import org.justice.tcgImageProcessor.services.dividers.interfaces.ImageDivider
import java.awt.image.BufferedImage

class LegacyImageDivider: ImageDivider {

    private val sourceDir = "src/main/resources/"
    private val name = "name.png"
    private val edition = "edition.png"
    private val number = "number.png"
    private val productionNumber = "production-number.png"
    private val base = "base.png"

    private val imageService: ImageService = ImageService()

    override fun divideAllParts(source: BufferedImage): MutableList<BufferedImage> {
        val arr = mutableListOf<BufferedImage>()

        // get name
//        ImageIO.write(imageService.getSubImage(source, 0, 50, 350, 55), "png", File("$sourceDir$name"))
        arr.add(getName(source))

        // get edition
//        ImageIO.write(editionBW, "png", File("$sourceDir$edition"))
        arr.add(getEdition(source))

        // get base
//        ImageIO.write(imageService.getSubImage(source, 520, 445, 64, 35), "png", File("$sourceDir$base"))
        arr.add(getBase(source))

        // get number
//        ImageIO.write(imageService.getSubImage(source, 30, 745, source.width - 30, 50), "png", File("$sourceDir$number"))
        arr.add(getNumber(source))

        // get production number
//        ImageIO.write(imageService.getSubImage(source, 500, 790, source.width - 500, 25), "png", File("$sourceDir$productionNumber"))
        arr.add(getProductionNumber(source))

        return arr
    }

    override fun getName(source: BufferedImage): BufferedImage {
        return imageService.getSubImage(source, 0, 50, 350, 55)
    }

    override fun getEdition(source: BufferedImage): BufferedImage {
        var editionBW: BufferedImage = imageService.getSubImage(source, 45, 458, 10, 19)
        editionBW = imageService.makeBW(editionBW)
        imageService.invertColors(editionBW)

        return editionBW
    }

    override fun getBase(source: BufferedImage): BufferedImage {
        return imageService.getSubImage(source, 520, 445, 64, 35)
    }

    override fun getNumber(source: BufferedImage): BufferedImage {
        return imageService.getSubImage(source, 30, 745, source.width - 30, 50)
    }

    // only one that is needed?
    override fun getProductionNumber(source: BufferedImage): BufferedImage {
        return imageService.getSubImage(source, 500, 790, source.width - 500, 25)
    }

}