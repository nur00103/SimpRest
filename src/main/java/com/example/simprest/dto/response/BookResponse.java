package com.example.simprest.dto.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class BookResponse {
    private String id;
    private String name;
    private String type;
    private int page;
    private AuthorResponse authorResponse;
}
