package com.example.simprest.dto.response;

import com.example.simprest.model.Status;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@Builder
@XmlRootElement
public class ResponseModel <T>{
    private T result;
    private Status status;
}
