package org.ivangrod.rssclean.domain.model.post.events;

import org.ivangrod.rssclean.domain.model.post.Post;

public class CollectedPost extends PostEvent {

    public CollectedPost(Post post) {
        super(post);
    }
}
