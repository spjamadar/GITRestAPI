package com.codeassay.gitrestapi.services;

import com.codeassay.gitrestapi.models.Blob;
import com.codeassay.gitrestapi.models.GetLastCommitResponse;
import com.codeassay.gitrestapi.models.GitTreesResponse;

public interface GitServices {
    GetLastCommitResponse getLastCommit(String uri);
    GitTreesResponse getTreeBySha(String sha);
    Blob getBlobBySha(String sha);
}
