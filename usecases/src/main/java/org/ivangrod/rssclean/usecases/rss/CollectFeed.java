package org.ivangrod.rssclean.domain.usecases.rss;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.FeedListener;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.model.item.events.CollectedItem;
import org.ivangrod.rssclean.domain.usecases.UseCase;
import org.ivangrod.rssclean.domain.usecases.rss.params.CollectingFeedParams;

import java.util.Collections;
import java.util.List;

public class CollectFeed implements UseCase<CollectingFeedParams> {

    private final FeedListener feedListener;
    private final DomainEventPublisher domainEventPublisher;

    public CollectFeed(FeedListener feedListener, DomainEventPublisher domainEventPublisher) {
        this.feedListener = feedListener;
        this.domainEventPublisher = domainEventPublisher;
    }

    public List<Item> execute(CollectingFeedParams params) {

        Feed feed = params.createObject();

        List<Item> itemsCollected = feedListener.extract(feed).orElse(Collections.emptyList());
        itemsCollected.forEach(item -> domainEventPublisher.publish(new CollectedItem(item)));

        return itemsCollected;
    }
}
