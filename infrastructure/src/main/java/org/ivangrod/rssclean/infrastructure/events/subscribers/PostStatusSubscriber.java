package org.ivangrod.rssclean.infrastructure.events.subscribers;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.events.DomainEventSubscriber;
import org.ivangrod.rssclean.domain.model.post.events.CollectedPost;
import org.ivangrod.rssclean.domain.model.post.events.CreatedPost;
import org.ivangrod.rssclean.usecases.post.CreatePost;
import org.ivangrod.rssclean.usecases.post.StorePost;
import org.ivangrod.rssclean.usecases.post.params.CreatingPostParams;
import org.ivangrod.rssclean.usecases.post.params.StoringPostParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostStatusSubscriber implements DomainEventSubscriber {

    @Autowired
    private CreatePost createPost;

    @Autowired
    private StorePost storePost;

    @Override
    public void process(DomainEvent domainEvent) {

        // TODO REFACTOR - https://dzone.com/articles/instanceof-considered-harmful

        if (domainEvent instanceof CollectedPost) {
            process((CollectedPost) domainEvent);
        } else if (domainEvent instanceof CreatedPost) {
            process((CreatedPost) domainEvent);
        }
    }

    private void process(CollectedPost event) {
        createPost.execute(new CreatingPostParams(event.getPost()));
    }

    private void process(CreatedPost event) {
        storePost.execute(new StoringPostParams(event.getPost()));
    }
}
