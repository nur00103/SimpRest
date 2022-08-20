package com.example.simprest.dto.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class AuthorResponse {
    private String id;
    private String author;
}
