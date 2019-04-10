package org.ivangrod.rssclean.usecases.post;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.exceptions.DuplicateEntityException;
import org.ivangrod.rssclean.domain.exceptions.EntityAlreadyExistsException;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.post.params.StoringPostParams;

public class StorePost implements UseCase<StoringPostParams> {

    private final PostCollection postCollection;
    private final DomainEventPublisher domainEventPublisher;

    public StorePost(PostCollection postCollection, DomainEventPublisher domainEventPublisher) {
        this.postCollection = postCollection;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Post execute(StoringPostParams params) {

        Post post = params.createObject();

        try {
            post = postCollection.create(post);
        } catch (EntityAlreadyExistsException exception) {
            throw new DuplicateEntityException(String.format("The post [%s] already exists", post.getTitle()),
                    exception);
        }

        return post;
    }
}
