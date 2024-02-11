package org.justice.tcgImageProcessor.services;

import org.jsoup.Jsoup
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements

class ScraperService(url: String) {
    val doc = Jsoup.connect(url).get()
    init {

    }

    fun getDocument(): Document {
        // may need to set headers
        return doc;
    }

    fun getElements(selector: String): Elements {
        return doc.select(selector)
    }

}
