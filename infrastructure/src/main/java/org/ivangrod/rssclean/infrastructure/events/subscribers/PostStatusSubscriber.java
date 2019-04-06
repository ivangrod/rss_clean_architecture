package org.ivangrod.rssclean.infrastructure.events.subscribers;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.events.DomainEventSubscriber;
import org.ivangrod.rssclean.domain.model.post.events.CollectedPost;
import org.ivangrod.rssclean.usecases.post.CreatePost;
import org.ivangrod.rssclean.usecases.post.params.CreatingPostParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostStatusSubscriber implements DomainEventSubscriber {

    @Autowired
    private CreatePost createPost;

    @Override
    public void process(DomainEvent domainEvent) {

        // TODO REFACTOR - https://dzone.com/articles/instanceof-considered-harmful

        if (domainEvent instanceof CollectedPost) {
            process((CollectedPost) domainEvent);
        }
    }

    private void process(CollectedPost event) {
        createPost.execute(new CreatingPostParams(event.getPost()));
    }
}
