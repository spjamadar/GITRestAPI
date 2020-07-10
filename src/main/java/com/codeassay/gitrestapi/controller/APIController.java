package com.codeassay.gitrestapi.controller;

import com.codeassay.gitrestapi.models.Blob;
import com.codeassay.gitrestapi.models.GetLastCommitResponse;
import com.codeassay.gitrestapi.models.GitTreesResponse;
import com.codeassay.gitrestapi.services.GitServices;
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

    @GetMapping("/latestcommit")
    public GetLastCommitResponse latestcommit(){
        return gitServices.getLastCommit();
    }

    @GetMapping("/trees/{sha}")
    public GitTreesResponse getTreeBySha(@PathVariable String sha){
        return gitServices.getTreeBySha(sha);
    }

    @GetMapping("/blobs/{sha}")
    public Blob getBlobBySha(@PathVariable String sha){
        return gitServices.getBlobBySha(sha);
    }

}
