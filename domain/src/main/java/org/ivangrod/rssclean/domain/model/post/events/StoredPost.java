package org.ivangrod.rssclean.domain.model.post.events;

import org.ivangrod.rssclean.domain.model.post.Post;

public class StoredPost extends PostEvent {

    public StoredPost(Post post) {
        super(post);
    }
}
