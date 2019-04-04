package org.ivangrod.rssclean.infrastructure.repositories;

import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.model.item.ItemCollection;
import org.ivangrod.rssclean.infrastructure.repositories.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MongoDBItemCollection implements ItemCollection {

    @Autowired
    MongoDBItemDocumentRepository itemDocumentRepository;

    @Override
    public Item create(Item item) {
        return ItemMapper.documentToEntity(itemDocumentRepository.save(ItemMapper.entityToDocument(item)));
    }

    @Override
    public Set<Item> readAll() {
        return itemDocumentRepository.findAll()
                .stream()
                .map(itemDocument -> ItemMapper.documentToEntity(itemDocument))
                .collect(Collectors.toSet());
    }
}
