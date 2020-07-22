package com.codeassay.gitrestapi.models;

import lombok.Data;

import java.util.List;

@Data
public class CreateTreeRequest {
    private String base_tree;
    private List<Tree> tree;
}
