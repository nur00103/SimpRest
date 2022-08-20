package com.example.simprest.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class Author {
    private String id;
    private String author;
}
