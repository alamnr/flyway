package com.alamnr.flyway.httpClient;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RandomQuote {

    private String author;
    private String quote;
    private List<String> tags;
    private String id;
    private String image;
    private Long length;
    private String category;
    private String language;

}
