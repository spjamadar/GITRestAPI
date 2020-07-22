package com.codeassay.gitrestapi.controller;

import com.codeassay.gitrestapi.models.*;
import com.codeassay.gitrestapi.services.GitServices;
import com.codeassay.gitrestapi.util.AppConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

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
    public BaseCommitResponse latestcommit(@PathVariable String user, @PathVariable String repo, @PathVariable String branch){
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

    @GetMapping("/{user}/{repo}/basetree/{sha}")
    public BaseTree getBaseTree(@PathVariable String user, @PathVariable String repo, @PathVariable String sha){
        return gitServices.getBaseTree(AppConstants.GITHOST+user+"/"+repo+"/"+AppConstants.COMMITDETAILS+sha);
    }

    @PostMapping(value="/saveupdate", consumes = "application/json", produces = "application/json")
    public BaseCommitResponse saveOrUpdateRepo(@RequestBody GitPushRequest request){
        try {
            return gitServices.saveOrUpdate(request);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
