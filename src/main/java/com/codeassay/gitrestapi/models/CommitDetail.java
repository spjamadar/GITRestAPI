package com.codeassay.gitrestapi.models;

import lombok.Data;

@Data
public class CommitDetail {
    private String sha;
    private String node_id;
    private String url;
    private String html_url;
    private Author author;
    private Committer committer;
    private BaseTree tree;
    private String message;
}
