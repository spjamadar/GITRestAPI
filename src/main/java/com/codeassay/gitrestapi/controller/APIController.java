package com.codeassay.gitrestapi.controller;

import com.codeassay.gitrestapi.models.Blob;
import com.codeassay.gitrestapi.models.GetLastCommitResponse;
import com.codeassay.gitrestapi.models.GitTreesResponse;
import com.codeassay.gitrestapi.services.GitServices;
import com.codeassay.gitrestapi.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(value = "com.codeassay.gitrestapi")
public class APIController {

    @Autowired
    GitServices gitServices;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @GetMapping("/{user}/{repo}/git/refs/heads/{branch}")
    public GetLastCommitResponse latestcommit(@PathVariable String user, @PathVariable String repo, @PathVariable String branch){
        return gitServices.getLastCommit(AppConstants.GITHOST+user+"/"+repo+"/git/refs/heads/"+branch);
    }

    @GetMapping("/{user}/{repo}/git/trees/{sha}")
    public GitTreesResponse getTreeBySha(@PathVariable String user, @PathVariable String repo, @PathVariable String sha){
        return gitServices.getTreeBySha(AppConstants.GITHOST+user+"/"+repo+"/"+AppConstants.GITTREEURI+sha+"?recursive=true");
    }

    @GetMapping("/{user}/{repo}/blobs/{sha}")
    public Blob getBlobBySha(@PathVariable String user, @PathVariable String repo,@PathVariable String sha){
        return gitServices.getBlobBySha(AppConstants.GITHOST+user+"/"+repo+"/"+AppConstants.GITBLOBURI+sha);
    }

}
