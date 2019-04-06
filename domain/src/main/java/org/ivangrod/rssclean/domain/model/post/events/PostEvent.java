package org.ivangrod.rssclean.domain.model.post.events;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.model.post.Post;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class PostEvent extends DomainEvent {

    private final Post post;

    public PostEvent(Post post) {
        super(post.getId(), Date.from(Instant.now()));
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEvent postEvent = (PostEvent) o;
        return Objects.equals(post, postEvent.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post);
    }

    @Override
    public String toString() {
        return "PostEvent{" + "post=" + post + '}';
    }
}
