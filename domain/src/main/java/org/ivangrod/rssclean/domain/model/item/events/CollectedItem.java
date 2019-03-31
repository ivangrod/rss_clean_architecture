package org.ivangrod.rssclean.domain.model.item.events;

import org.ivangrod.rssclean.domain.model.item.Item;

public class CollectedItem extends ItemEvent {

    public CollectedItem(Item item) {
        super(item);
    }
}
