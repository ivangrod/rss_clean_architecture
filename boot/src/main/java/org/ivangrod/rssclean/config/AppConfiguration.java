package org.ivangrod.rssclean.config;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.item.FeedListener;
import org.ivangrod.rssclean.domain.model.item.ItemCollection;
import org.ivangrod.rssclean.usecases.item.CreateItem;
import org.ivangrod.rssclean.usecases.rss.CollectFeed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public CollectFeed collectFeed(FeedListener feedListener, DomainEventPublisher domainEventPublisher) {
        return new CollectFeed(feedListener, domainEventPublisher);
    }

    @Bean
    public CreateItem createItem(ItemCollection itemCollection, DomainEventPublisher domainEventPublisher) {
        return new CreateItem(itemCollection, domainEventPublisher);
    }
}
