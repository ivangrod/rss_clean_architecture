package org.ivangrod.rssclean.domain.model.post.events;

import org.ivangrod.rssclean.domain.model.post.Post;

public class CreatedPost extends PostEvent {

    public CreatedPost(Post post) {
        super(post);
    }
}
