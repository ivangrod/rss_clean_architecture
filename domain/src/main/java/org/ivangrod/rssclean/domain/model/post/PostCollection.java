package org.ivangrod.rssclean.domain.model.post;

import java.util.Set;

/**
 * Repository
 */
public interface PostCollection {

    Post create(Post post);

    Set<Post> readAll();
}
