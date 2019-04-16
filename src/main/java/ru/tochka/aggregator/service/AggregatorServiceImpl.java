package ru.tochka.aggregator.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tochka.aggregator.entity.Post;
import ru.tochka.aggregator.entity.Website;
import ru.tochka.aggregator.factory.WebDocumentParserFactory;
import ru.tochka.aggregator.repository.PostRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AggregatorServiceImpl implements AggregatorService {

    private PostRepository postRepository;
    private WebDocumentParserFactory webDocumentParserFactory;

    public void getPosts(Website website) {
        postRepository.deleteAll();
        WebDocumentParser parser = webDocumentParserFactory.getParser(website);
        List<Post> posts = parser.parse(website);
        postRepository.saveAll(posts);
    }
}
