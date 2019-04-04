package org.ivangrod.rssclean.infrastructure.events.subscribers;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.events.DomainEventSubscriber;
import org.ivangrod.rssclean.domain.model.item.events.CollectedItem;
import org.ivangrod.rssclean.domain.model.item.events.CreatedItem;
import org.ivangrod.rssclean.domain.usecases.item.CreateItem;
import org.ivangrod.rssclean.domain.usecases.item.params.CreatingItemParams;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemStatusSubscriber implements DomainEventSubscriber {

    @Autowired
    private CreateItem createItem;

    @Override
    public void process(DomainEvent domainEvent) {

        // TODO REFACTOR - https://dzone.com/articles/instanceof-considered-harmful

        if (domainEvent instanceof CollectedItem) {
            process((CollectedItem) domainEvent);
        }
    }

    private void process(CollectedItem event) {
        createItem.execute(new CreatingItemParams(event.getItem()));
    }
}
