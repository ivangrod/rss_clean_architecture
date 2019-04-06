package org.ivangrod.rssclean.helpers;

import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class World {

    private Feed feed;

    private List<Item> itemsCollected;

    public void reset() {
        feed = null;
        itemsCollected = new ArrayList<>();
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public void setItemsCollected(List<Item> itemsCollected) {
        this.itemsCollected = itemsCollected;
    }

    public List<Item> getItemsCollected() {
        return itemsCollected;
    }
}
