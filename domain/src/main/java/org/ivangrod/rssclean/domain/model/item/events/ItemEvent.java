package org.ivangrod.rssclean.domain.model.item.events;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.model.item.Item;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;

public class ItemEvent extends DomainEvent {

    private final Item item;

    public ItemEvent(Item item) {
        super(item.getId(), Date.from(Instant.now()));
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEvent itemEvent = (ItemEvent) o;
        return Objects.equals(item, itemEvent.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "ItemEvent{" + "item=" + item + '}';
    }
}
