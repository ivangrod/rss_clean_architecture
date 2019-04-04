package org.ivangrod.rssclean.usecases.item.params;

import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.usecases.UseCaseParams;

import java.util.Objects;

public class CreatingItemParams implements UseCaseParams {

    private final Item item;

    public CreatingItemParams(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatingItemParams that = (CreatingItemParams) o;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "CreatingItemParams{" + "item=" + item + '}';
    }

    public Item createObject() {
        return (Item) item.clone();
    }
}
