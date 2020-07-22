package com.codeassay.gitrestapi.models;

import lombok.Data;

@Data
public class CommitRequest {
    private String parents;
    private String tree;
    private String message;
}
