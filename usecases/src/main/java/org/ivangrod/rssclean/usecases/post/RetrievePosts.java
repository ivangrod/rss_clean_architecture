package org.ivangrod.rssclean.usecases.post;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.post.params.RetrievingPostParams;

public class RetrievePosts implements UseCase<RetrievingPostParams> {

    private final PostCollection postCollection;
    private final DomainEventPublisher domainEventPublisher;

    public RetrievePosts(PostCollection postCollection, DomainEventPublisher domainEventPublisher) {
        this.postCollection = postCollection;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Post execute(RetrievingPostParams params) {
        return null;
    }
}
