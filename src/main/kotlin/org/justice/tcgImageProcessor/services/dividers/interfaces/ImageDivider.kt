package org.justice.tcgImageProcessor.services.dividers.interfaces

import java.awt.image.BufferedImage

interface ImageDivider {

    fun divideAllParts(source: BufferedImage): MutableList<BufferedImage>

    fun getName(source: BufferedImage): BufferedImage

    fun getEdition(source: BufferedImage): BufferedImage

    fun getBase(source: BufferedImage): BufferedImage

    fun getNumber(source: BufferedImage): BufferedImage

    fun getProductionNumber(source: BufferedImage): BufferedImage

}