package org.ivangrod.rssclean.domain.model.post;

import java.util.List;

public interface FeedListener {

    List<Post> extract(Feed feed);
}
