package com.codeassay.gitrestapi.models;

import lombok.Data;

import java.util.Date;

@Data
public class Committer {
    private String name;
    private String email;
    private Date date;
}
