package com.example.simprest.dto.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class BookRequest {
    private String id;
    private String name;
    private String type;
    private int page;
    private AuthorRequest authorRequest;

}
