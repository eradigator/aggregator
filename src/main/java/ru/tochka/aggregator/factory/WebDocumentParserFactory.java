package ru.tochka.aggregator.factory;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.tochka.aggregator.entity.Website;
import ru.tochka.aggregator.service.HtmlWebDocumentParserImpl;
import ru.tochka.aggregator.service.WebDocumentParser;
import ru.tochka.aggregator.service.XmlWebDocumentParserImpl;

@Service
@AllArgsConstructor
public class WebDocumentParserFactory {

    private ApplicationContext context;

    public WebDocumentParser getParser(Website website) {

        switch (website.getParseRule().getDocType()) {
            case "html":
                return context.getBean(HtmlWebDocumentParserImpl.class);
            case "xml":
                return context.getBean(XmlWebDocumentParserImpl.class);
            default:
                throw new IllegalArgumentException("Unknown document type");
        }

    }

    ;
}