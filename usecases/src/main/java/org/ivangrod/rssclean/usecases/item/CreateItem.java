package org.ivangrod.rssclean.domain.usecases.item;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.exceptions.DuplicateInstanceException;
import org.ivangrod.rssclean.domain.exceptions.EntityAlreadyExistsException;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.model.item.ItemCollection;
import org.ivangrod.rssclean.domain.model.item.events.CreatedItem;
import org.ivangrod.rssclean.domain.usecases.UseCase;
import org.ivangrod.rssclean.domain.usecases.item.params.CreatingItemParams;

public class CreateItem implements UseCase<CreatingItemParams> {

    private final ItemCollection itemCollection;
    private final DomainEventPublisher domainEventPublisher;

    public CreateItem(ItemCollection itemCollection, DomainEventPublisher domainEventPublisher) {
        this.itemCollection = itemCollection;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Item execute(CreatingItemParams params) {

        Item item = params.createObject();

        try {
            item = itemCollection.create(item);
            domainEventPublisher.publish(new CreatedItem(item));
        } catch (EntityAlreadyExistsException exception) {
            throw new DuplicateInstanceException(String.format("The item [%s] already exists", item.getTitle()),
                    exception);
        }

        return item;
    }
}
