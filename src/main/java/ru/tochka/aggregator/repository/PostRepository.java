package ru.tochka.aggregator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tochka.aggregator.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findByTitleContainingIgnoreCase(String title);
}
