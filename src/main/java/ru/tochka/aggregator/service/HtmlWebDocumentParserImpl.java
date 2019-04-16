package ru.tochka.aggregator.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.tochka.aggregator.entity.Post;
import ru.tochka.aggregator.entity.Website;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class HtmlWebDocumentParserImpl implements WebDocumentParser {

    @Override
    public List<Post> parse(Website website) {
        List<Post> posts = new ArrayList<>();
        String url = website.getUrl();

        try {
            Document doc = Jsoup.connect(url).get();

            String postTagName = website.getParseRule().getPostTagName();
            String postTitleClass = website.getParseRule().getPostTitleClass();
            String postBodyClass = website.getParseRule().getPostBodyClass();

            Elements items = doc.getElementsByTag(postTagName);
            items.forEach(item -> {
                String title = item.getElementsByClass(postTitleClass).text();
                String body = item.getElementsByClass(postBodyClass).text();

                Post post = new Post();
                post.setTitle(title);
                post.setBody(body);
                posts.add(post);
            });
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return posts;
    }
}
