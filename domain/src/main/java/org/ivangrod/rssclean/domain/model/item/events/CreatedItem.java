package org.ivangrod.rssclean.domain.model.item.events;

import org.ivangrod.rssclean.domain.model.item.Item;

public class CreatedItem extends ItemEvent {

    public CreatedItem(Item item) {
        super(item);
    }
}
