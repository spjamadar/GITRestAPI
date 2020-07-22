package com.codeassay.gitrestapi.models;

import lombok.Data;

@Data
public class Tree {
    private String path;
    private String mode;
    private String type;
    private String sha;
    private String size;
    private String url;
    private String content;
}
