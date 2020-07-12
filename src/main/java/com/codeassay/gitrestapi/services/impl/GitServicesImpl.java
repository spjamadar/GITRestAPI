package com.codeassay.gitrestapi.services.impl;

import com.codeassay.gitrestapi.models.Blob;
import com.codeassay.gitrestapi.models.GetLastCommitResponse;
import com.codeassay.gitrestapi.models.GitTreesResponse;
import com.codeassay.gitrestapi.services.GitServices;
import com.codeassay.gitrestapi.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

@Component
public class GitServicesImpl implements GitServices {

    private String token="Rocky@ridhi88";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public GetLastCommitResponse getLastCommit(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), GetLastCommitResponse.class).getBody();
    }

    @Override
    public GitTreesResponse getTreeBySha(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), GitTreesResponse.class).getBody();
    }

    @Override
    public Blob getBlobBySha(String uri) {
        return restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(createHeaders("sarala.jitm@gmail.com",token)), Blob.class).getBody();
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
