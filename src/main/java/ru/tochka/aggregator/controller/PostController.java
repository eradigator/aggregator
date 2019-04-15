package ru.tochka.aggregator.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tochka.aggregator.entity.Post;
import ru.tochka.aggregator.entity.SearchRequest;
import ru.tochka.aggregator.repository.PostRepository;
import ru.tochka.aggregator.service.AggregatorService;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {

    private PostRepository postRepository;
    private AggregatorService aggregatorService;

    @GetMapping("/")
    public String root(Model model, SearchRequest searchRequest) {
        List<Post> posts = postRepository.findAll();

        Post post = new Post();
        post.setId(2);
        post.setBody("test");
        post.setTitle("test");
        posts.add(post);

        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/get")
    public String getPosts(Model model, SearchRequest searchRequest) {
        List<Post> posts = aggregatorService.getPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model, SearchRequest searchRequest) {

        System.out.println(searchRequest.getTitle());
        List<Post> posts = new ArrayList<>();

        Post post = new Post();
        post.setId(2);
        post.setBody("найдено");
        post.setTitle("test");
        posts.add(post);

        model.addAttribute("posts", posts);
        return "index";
    }
}
