package org.justice.tcgImageProcessor.validation

import org.justice.tcgImageProcessor.model.CardData

class LegacyValidator {

    fun isValid(card: CardData): Boolean {
        return !(card.name.isBlank() || card.number.isBlank() || card.productionNumber.isBlank())
    }

}