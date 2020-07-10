package com.codeassay.gitrestapi.models;

import lombok.Data;

@Data
public class GetLastCommitResponse {
    private String ref;
    private String node_id;
    private String url;
    private Object object;
}
