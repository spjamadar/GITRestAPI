package com.codeassay.gitrestapi.models;

import java.util.Base64;

public class Blob {
    private String sha;
    private String node_id;
    private String size;
    private String url;
    private String content;
    private String encoding;

    public Blob() {
    }

    public String getSha() {
        return this.sha;
    }

    public String getNode_id() {
        return this.node_id;
    }

    public String getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public String getContent() {
        return this.content;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContent(String content) {
        content=Base64.getDecoder().decode(content).toString();
        this.content = content;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Blob)) return false;
        final Blob other = (Blob) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$sha = this.getSha();
        final Object other$sha = other.getSha();
        if (this$sha == null ? other$sha != null : !this$sha.equals(other$sha)) return false;
        final Object this$node_id = this.getNode_id();
        final Object other$node_id = other.getNode_id();
        if (this$node_id == null ? other$node_id != null : !this$node_id.equals(other$node_id)) return false;
        final Object this$size = this.getSize();
        final Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$encoding = this.getEncoding();
        final Object other$encoding = other.getEncoding();
        if (this$encoding == null ? other$encoding != null : !this$encoding.equals(other$encoding)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Blob;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $sha = this.getSha();
        result = result * PRIME + ($sha == null ? 43 : $sha.hashCode());
        final Object $node_id = this.getNode_id();
        result = result * PRIME + ($node_id == null ? 43 : $node_id.hashCode());
        final Object $size = this.getSize();
        result = result * PRIME + ($size == null ? 43 : $size.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $encoding = this.getEncoding();
        result = result * PRIME + ($encoding == null ? 43 : $encoding.hashCode());
        return result;
    }

    public String toString() {
        return "Blob(sha=" + this.getSha() + ", node_id=" + this.getNode_id() + ", size=" + this.getSize() + ", url=" + this.getUrl() + ", content=" + this.getContent() + ", encoding=" + this.getEncoding() + ")";
    }
}
