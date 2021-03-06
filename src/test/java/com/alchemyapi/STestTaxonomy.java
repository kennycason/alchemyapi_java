package com.alchemyapi;

import com.alchemyapi.api.AlchemyApi;
import com.alchemyapi.helpers.ResourceUtils;
import com.alchemyapi.helpers.TestApiFactory;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;

/**
 * Created by kenny
 */
public class STestTaxonomy {

    private static final Logger LOGGER = Logger.getLogger(STestTaxonomy.class);

    private final AlchemyApi alchemyApi = TestApiFactory.build(new File(System.getProperty("user.home"), ".alchemy/api.key"));

    @Test
    public void url() {
        final Document document = alchemyApi.urlGetTaxonomy("http://www.techcrunch.com/");
        LOGGER.info(document);
    }

    @Test
    public void text() {
        final Document document = alchemyApi.textGetTaxonomy(
                "Hello there, my name is Bob Jones. I live in the United States of America. Where do you live, Fred?");
        LOGGER.info(document);
    }

    @Test
    public void html() {
        final String html = ResourceUtils.toString("data/example.html");
        final Document document = alchemyApi.htmlGetTaxonomy(html, "http://www.test.com/");
        LOGGER.info(document);
    }

}
