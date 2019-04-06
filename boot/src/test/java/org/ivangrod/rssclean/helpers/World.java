package org.ivangrod.rssclean.helpers;

import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class World {

    private Feed feed;

    private List<Post> postsCollected;

    public void reset() {
        feed = null;
        postsCollected = new ArrayList<>();
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public void setPostsCollected(List<Post> postsCollected) {
        this.postsCollected = postsCollected;
    }

    public List<Post> getPostsCollected() {
        return postsCollected;
    }
}
