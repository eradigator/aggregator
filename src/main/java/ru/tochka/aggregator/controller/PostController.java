package ru.tochka.aggregator.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tochka.aggregator.entity.Post;
import ru.tochka.aggregator.entity.SearchRequest;
import ru.tochka.aggregator.entity.Website;
import ru.tochka.aggregator.repository.PostRepository;
import ru.tochka.aggregator.service.AggregatorService;

import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {

    private PostRepository postRepository;
    private AggregatorService aggregatorService;

    @GetMapping("/")
    public String root(Model model, SearchRequest searchRequest, Website website) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/get")
    public String getPosts(Model model, SearchRequest searchRequest, Website website) {
        aggregatorService.getPosts(website);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(Model model, SearchRequest searchRequest, Website websiite) {
        List<Post> posts = postRepository.findByTitleContainingIgnoreCase(searchRequest.getTitle());
        model.addAttribute("posts", posts);
        return "index";
    }
}
