package com.codeassay.gitrestapi.services;

import com.codeassay.gitrestapi.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface GitServices {
    BaseCommitResponse getLastCommit(String uri);
    GitTreesResponse getTreeBySha(String uri);
    Blob getBlobBySha(String uri);
    BaseTree getBaseTree(String uri);
    GitTreesResponse createNewTreeFromBase(CreateTreeRequest request,String uri) throws JsonProcessingException;
    CommitDetail commit(CommitRequest request,String uri) throws JsonProcessingException;
    BaseCommitResponse push(String sha, String uri);
    BaseCommitResponse saveOrUpdate(GitPushRequest request) throws JsonProcessingException;
}
