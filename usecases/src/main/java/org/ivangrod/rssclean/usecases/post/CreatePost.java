package org.ivangrod.rssclean.usecases.post;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.exceptions.DuplicateInstanceException;
import org.ivangrod.rssclean.domain.exceptions.EntityAlreadyExistsException;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.domain.model.post.events.CreatedPost;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.post.params.CreatingPostParams;

public class CreatePost implements UseCase<CreatingPostParams> {

    private final PostCollection postCollection;
    private final DomainEventPublisher domainEventPublisher;

    public CreatePost(PostCollection postCollection, DomainEventPublisher domainEventPublisher) {
        this.postCollection = postCollection;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Post execute(CreatingPostParams params) {

        Post post = params.createObject();

        try {
            post = postCollection.create(post);
            domainEventPublisher.publish(new CreatedPost(post));
        } catch (EntityAlreadyExistsException exception) {
            throw new DuplicateInstanceException(String.format("The post [%s] already exists", post.getTitle()),
                    exception);
        }

        return post;
    }
}
