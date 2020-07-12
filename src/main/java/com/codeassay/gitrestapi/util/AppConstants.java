package com.codeassay.gitrestapi.util;

final public class AppConstants {
    public static final String GITHOST = "https://api.github.com/repos/";
    public static final String GITLATESTCOMMITURI = GITHOST+"git/refs/heads/{branch}/";
    public static final String GITTREEURI = "git/trees/";
    public static final String GITBLOBURI = "git/blobs/";
}
