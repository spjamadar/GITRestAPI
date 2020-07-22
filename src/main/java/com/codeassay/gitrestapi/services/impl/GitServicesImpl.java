package com.codeassay.gitrestapi.services.impl;

import com.codeassay.gitrestapi.models.*;
import com.codeassay.gitrestapi.services.GitServices;
import com.codeassay.gitrestapi.util.AppConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Component
public class GitServicesImpl implements GitServices {

    private String token="Rocky@ridhi88";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public BaseCommitResponse getLastCommit(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), BaseCommitResponse.class).getBody();
    }

    @Override
    public GitTreesResponse getTreeBySha(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), GitTreesResponse.class).getBody();
    }

    @Override
    public Blob getBlobBySha(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), Blob.class).getBody();
    }

    @Override
    public BaseTree getBaseTree(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), BaseTree.class).getBody();
    }

    @Override
    public GitTreesResponse createNewTreeFromBase(CreateTreeRequest request, String uri) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String reqJson = mapper.writeValueAsString(request);
        return restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(reqJson,createHeaders("sarala.jitm@gmail.com",token)), GitTreesResponse.class).getBody();
    }

    @Override
    public CommitDetail commit(CommitRequest request, String uri) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String reqJson = mapper.writeValueAsString(request);
        return restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(reqJson,createHeaders("sarala.jitm@gmail.com",token)), CommitDetail.class).getBody();
    }

    @Override
    public BaseCommitResponse push(String sha, String uri) {
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("sha", sha);
        return restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(map,createHeaders("sarala.jitm@gmail.com",token)), BaseCommitResponse.class).getBody();
    }

    @Override
    public BaseCommitResponse saveOrUpdate(GitPushRequest request) throws JsonProcessingException {

        //Get base sha
        BaseCommitResponse baseCommitResponse = getLastCommit(AppConstants.GITHOST+request.getRepo());
        //Get base tree
        BaseObject bo = (BaseObject)(baseCommitResponse.getObject());
        BaseTree baseTree = getBaseTree(bo.getUrl());
        //Create a new Tree
        CreateTreeRequest createTreeRequest = new CreateTreeRequest();
        createTreeRequest.setBase_tree(baseTree.getSha());
        createTreeRequest.setTree(request.getTree());

        GitTreesResponse gitTreesResponse = createNewTreeFromBase(createTreeRequest,baseTree.getUrl().replace(baseTree.getSha(),""));

        //Commit new tree
        CommitRequest commitRequest = new CommitRequest();
        commitRequest.setMessage(request.getMessage());
        commitRequest.setParents(baseTree.getSha());
        commitRequest.setTree(gitTreesResponse.getSha());

        CommitDetail commitDetail = commit(commitRequest,"");

        //Push
        BaseCommitResponse response = push(commitDetail.getSha(),"");

        return response;
    }


    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.getEncoder().encode(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}
