package ru.tochka.aggregator.service;

import ru.tochka.aggregator.entity.Post;
import ru.tochka.aggregator.entity.Website;

import java.util.List;

public interface WebDocumentParser {

    List<Post> parse(Website website);
}
