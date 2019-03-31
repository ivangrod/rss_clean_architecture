package org.ivangrod.rssclean.domain.model.item.events;

import org.ivangrod.rssclean.domain.model.item.Item;

public class StoredItem extends ItemEvent {

    public StoredItem(Item item) {
        super(item);
    }
}
