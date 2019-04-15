package ru.tochka.aggregator.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.tochka.aggregator.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
