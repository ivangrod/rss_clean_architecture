package org.ivangrod.rssclean.infrastructure.config;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.item.FeedListener;
import org.ivangrod.rssclean.domain.model.item.ItemCollection;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.item.CreateItem;
import org.ivangrod.rssclean.usecases.item.params.CreatingItemParams;
import org.ivangrod.rssclean.usecases.rss.CollectFeed;
import org.ivangrod.rssclean.usecases.rss.params.CollectingFeedParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializr {

//    @Bean
//    @Autowired
//    public UseCase<CollectingFeedParams> collectFeedUseCase(FeedListener feedListener, DomainEventPublisher domainEventPublisher) {
//        return new CollectFeed(feedListener, domainEventPublisher);
//    }
//
//    @Bean
//    public UseCase<CreatingItemParams> createItemUseCase(ItemCollection itemCollection, DomainEventPublisher domainEventPublisher) {
//        return new CreateItem(itemCollection, domainEventPublisher);
//    }
}
