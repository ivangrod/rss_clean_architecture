package org.ivangrod.rssclean.infrastructure.config;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.post.FeedListener;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.usecases.post.CreatePost;
import org.ivangrod.rssclean.usecases.post.RetrievePosts;
import org.ivangrod.rssclean.usecases.post.StorePost;
import org.ivangrod.rssclean.usecases.rss.CollectFeed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializr {

    @Bean
    public CollectFeed collectFeed(FeedListener feedListener, DomainEventPublisher domainEventPublisher) {
        return new CollectFeed(feedListener, domainEventPublisher);
    }

    @Bean
    public CreatePost createPost(PostCollection postCollection, DomainEventPublisher domainEventPublisher) {
        return new CreatePost(postCollection, domainEventPublisher);
    }

    @Bean
    public RetrievePosts retrievePosts(PostCollection postCollection, DomainEventPublisher domainEventPublisher) {
        return new RetrievePosts(postCollection, domainEventPublisher);
    }

    @Bean
    public StorePost storePost(PostCollection postCollection, DomainEventPublisher domainEventPublisher) {
        return new StorePost(postCollection, domainEventPublisher);
    }
}
