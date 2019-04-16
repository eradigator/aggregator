package ru.tochka.aggregator.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    @Column(length = Integer.MAX_VALUE)
    private String body;

    @ManyToOne
    private Website website;
}
