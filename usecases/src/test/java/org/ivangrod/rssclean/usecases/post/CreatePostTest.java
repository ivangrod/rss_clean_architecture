package org.ivangrod.rssclean.usecases.post;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.FeedListener;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.usecases.rss.CollectFeed;
import org.ivangrod.rssclean.usecases.rss.params.CollectingFeedParams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreatePostTest {


    private final FeedListener feedListener = mock(FeedListener.class);
    private final DomainEventPublisher domainEventPublisher = mock(DomainEventPublisher.class);
    CollectFeed collectFeed;

    @Before
    public void setUp() throws Exception {
        collectFeed = new CollectFeed(feedListener, domainEventPublisher);
    }

    @Test
    public void given_A_Feed_When_Content_Is_Extracted_Then_A_Collection_Of_Posts_Is_Returned() throws Exception {
        // given
        Feed feed = new Feed(new URL("https://medium.com/feed/netflix-techblog"), "Netflix");

        Post postForTest = new Post.PostBuilder().withTitle("title")
                .withUri("uri")
                .withOrigin(feed)
                .withContent("content")
                .withCollectAt(Date.from(Instant.now()))
                .createPost();
        List<Post> postsCollectedForTest = Collections.singletonList(postForTest);

        given(feedListener.extract(feed)).willReturn(postsCollectedForTest);

        // when
        final List<Post> postsCollected = collectFeed.execute(new CollectingFeedParams(feed.getSource(), feed.getUri()
                .toString()));

        // then
        assertTrue(postsCollected != null);
        assertTrue(postsCollected.size() > 0);
        assertTrue(postsCollected.stream()
                .filter(post -> !post.getOrigin()
                        .getSource()
                        .equals("Netflix"))
                .count() == 0);

        verify(domainEventPublisher, times(postsCollected.size()))
                .publish(any(DomainEvent.class));
    }
}
