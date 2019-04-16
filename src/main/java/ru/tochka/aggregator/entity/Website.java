package ru.tochka.aggregator.entity;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Website {

    @Id
    @GeneratedValue
    private Integer id;

    @URL
    private String url;

    @ManyToOne
    private ParseRule parseRule;
}
