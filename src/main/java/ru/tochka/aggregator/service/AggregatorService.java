package ru.tochka.aggregator.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.tochka.aggregator.entity.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AggregatorService {

    public List<Post> getPosts() {
//        String url = "https://lenta.ru/rss/";

        String url = "https://habr.com/ru/";


        List<Post> posts = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            //Elements items = doc.select("item");
            Elements items = doc.getElementsByClass("post__title_link");


            Integer i = 1;

            for (Element item : items) {
                //String title = item.getElementsByTag("title").text();
                String title = item.text();

                Post post = new Post();
                post.setId(i);
                post.setTitle(title);
                posts.add(post);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }
}
