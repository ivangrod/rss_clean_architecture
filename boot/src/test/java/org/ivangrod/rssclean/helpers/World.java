package org.ivangrod.rssclean.helpers;

import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class World {

    private Feed source;

    private List<Item> itemsCollected;

    public void reset() {
        source = null;
    }

    public Feed getSource() {
        return source;
    }

    public void setSource(Feed source) {
        this.source = source;
    }

    public void setItemsCollected(List<Item> itemsCollected) {
        this.itemsCollected = itemsCollected;
    }

    public List<Item> getItemsCollected() {
        return itemsCollected;
    }
}
