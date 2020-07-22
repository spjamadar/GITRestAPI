package com.codeassay.gitrestapi.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommitRequest {
    private List<String> parents = new ArrayList<>();
    private String tree;
    private String message;
}
