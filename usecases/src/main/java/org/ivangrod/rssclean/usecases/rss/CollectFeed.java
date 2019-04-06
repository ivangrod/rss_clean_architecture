package org.ivangrod.rssclean.usecases.rss;

import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.FeedListener;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.events.CollectedPost;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.rss.params.CollectingFeedParams;

import java.util.List;

public class CollectFeed implements UseCase<CollectingFeedParams> {

    private final FeedListener feedListener;
    private final DomainEventPublisher domainEventPublisher;

    public CollectFeed(FeedListener feedListener, DomainEventPublisher domainEventPublisher) {
        this.feedListener = feedListener;
        this.domainEventPublisher = domainEventPublisher;
    }

    public List<Post> execute(CollectingFeedParams params) {

        Feed feed = params.createObject();

        List<Post> postsCollected = feedListener.extract(feed);
        postsCollected.forEach(post -> domainEventPublisher.publish(new CollectedPost(post)));

        return postsCollected;
    }
}
