package com.codeassay.gitrestapi.models;

import lombok.Data;

import java.util.List;

@Data
public class GitTreesResponse {
    private String sha;
    private String url;
    private List<Tree> tree;
    private String truncated;
}
