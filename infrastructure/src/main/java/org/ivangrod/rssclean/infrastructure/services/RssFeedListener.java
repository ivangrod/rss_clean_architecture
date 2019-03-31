package org.ivangrod.rssclean.infrastructure.services;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.FeedListener;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.model.item.events.CollectedItem;
import org.ivangrod.rssclean.infrastructure.converter.FeedEntryToItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RssFeedListener implements FeedListener {

    private final static Logger log = LoggerFactory.getLogger(RssFeedListener.class);

    @Override
    public Optional<List<Item>> extract(final Feed feed) {

        Optional<List<Item>> itemsCollected = null;

        try {

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feedLoaded = input.build(new XmlReader(feed.getUri()));

            itemsCollected = Optional.ofNullable(feedLoaded.getEntries()
                    .stream()
                    .map(entry -> FeedEntryToItem.convertFeedEntryToItem(feed, entry))
                    .collect(Collectors.toList()));

        } catch (IOException | FeedException exception) {
            log.error("An error has been produced when the feed from source [{0}] was loaded", feed.getSource(), exception);
        }

        return itemsCollected;
    }
}
