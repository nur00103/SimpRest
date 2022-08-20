package com.example.simprest.dto.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class AuthorRequest {
    private String id;
    private String author;
}
