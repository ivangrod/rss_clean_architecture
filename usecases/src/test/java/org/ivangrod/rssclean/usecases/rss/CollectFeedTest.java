package org.ivangrod.rssclean.usecases.rss;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.FeedListener;
import org.ivangrod.rssclean.domain.model.item.Item;
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
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CollectFeedTest {


    private final FeedListener feedListener = mock(FeedListener.class);
    private final DomainEventPublisher domainEventPublisher = mock(DomainEventPublisher.class);
    CollectFeed collectFeed;

    @Before
    public void setUp() throws Exception {
        collectFeed = new CollectFeed(feedListener, domainEventPublisher);
    }

    @Test
    public void given_A_Feed_When_Content_Is_Extracted_Then_A_Collection_Of_Items_Is_Returned() throws Exception {
        // given
        Feed feed = new Feed(new URL("https://medium.com/feed/netflix-techblog"), "Netflix");

        Item itemForTest = new Item.ItemBuilder().withTitle("title")
                .withUri("uri")
                .withOrigin(feed)
                .withContent("content")
                .withCollectAt(Date.from(Instant.now()))
                .createItem();
        List<Item> itemsCollectedForTest = Collections.singletonList(itemForTest);

        given(feedListener.extract(feed)).willReturn(Optional.ofNullable(itemsCollectedForTest));

        // when
        final List<Item> itemsCollected = collectFeed.execute(new CollectingFeedParams(feed.getSource(), feed.getUri()
                .toString()));

        // then
        assertTrue(itemsCollected != null);
        assertTrue(itemsCollected.size() > 0);
        assertTrue(itemsCollected.stream()
                .filter(item -> !item.getOrigin()
                        .getSource()
                        .equals("Netflix"))
                .count() == 0);

        verify(domainEventPublisher, times(itemsCollected.size()))
                .publish(any(DomainEvent.class));
    }
}
