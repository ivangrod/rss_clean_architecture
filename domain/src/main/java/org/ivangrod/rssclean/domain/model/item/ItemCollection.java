package org.ivangrod.rssclean.domain.model.item;

import java.util.Set;

/**
 * Repository
 */
public interface ItemCollection {

    Item create(Item item);

    Set<Item> readAll();
}
