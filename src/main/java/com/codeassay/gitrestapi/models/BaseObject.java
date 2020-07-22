package com.codeassay.gitrestapi.models;

import lombok.Data;

@Data
public class BaseObject {
    private String sha;
    private String type;
    private String url;
}
