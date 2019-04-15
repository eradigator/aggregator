package ru.tochka.aggregator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String body;
}
