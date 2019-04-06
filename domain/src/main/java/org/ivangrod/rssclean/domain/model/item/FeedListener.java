package org.ivangrod.rssclean.domain.model.item;

import java.util.List;
import java.util.Optional;

public interface FeedListener {

    List<Item> extract(Feed feed);
}
