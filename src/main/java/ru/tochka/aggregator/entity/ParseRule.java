package ru.tochka.aggregator.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ParseRule {

    @Id
    @GeneratedValue
    private Integer id;

    private String docType;

    private String postTagName;
    private String postTitleClass;
    private String postBodyClass;
}
