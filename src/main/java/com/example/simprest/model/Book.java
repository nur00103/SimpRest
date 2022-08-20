package com.example.simprest.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class Book {
    private String id;
    private String name;
    private String type;
    private int page;
    private Author author;

}
