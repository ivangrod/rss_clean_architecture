package org.ivangrod.rssclean.usecases.post.params;

import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.usecases.UseCaseParams;

import java.util.Objects;

public class CreatingPostParams implements UseCaseParams {

    private final Post post;

    public CreatingPostParams(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatingPostParams that = (CreatingPostParams) o;
        return Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post);
    }

    @Override
    public String toString() {
        return "CreatingPostParams{" + "post=" + post + '}';
    }

    public Post createObject() {
        return (Post) post.clone();
    }
}
