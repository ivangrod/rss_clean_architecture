package org.ivangrod.rssclean.infrastructure.repositories.mapper;

import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.infrastructure.repositories.entities.ItemDocument;

public final class ItemMapper {

    public static Item documentToEntity(final ItemDocument document) {

        Item.ItemBuilder builder = new Item.ItemBuilder();
        builder.withTitle(document.getTitle())
                .withUri(document.getUri())
                .withOrigin(document.getOrigin())
                .withContent(document.getContent())
                .withCollectAt(document.getCollectAt())
                .withPublicationAt(document.getPublicationAt())
                .withCreator(document.getCreator())
                .withTopics(document.getTopics());

        Item newItem = builder.createItem();
        newItem.setId(document.getId());

        return newItem;
    }

    public static ItemDocument entityToDocument(final Item entity) {
        return new ItemDocument(entity.getId(), entity.getTitle(), entity.getUri(),
                entity.getCreator(), entity.getOrigin(), entity.getContent(), entity.getCollectAt(),
                entity.getPublicationAt(), entity.getTopics());
    }
}
