package org.ivangrod.rssclean.infrastructure.converter;

import com.rometools.rome.feed.synd.SyndEntry;
import org.ivangrod.rssclean.domain.model.item.Feed;
import org.ivangrod.rssclean.domain.model.item.Item;
import org.ivangrod.rssclean.domain.model.item.Topic;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class FeedEntryToItem {

    private FeedEntryToItem() {
        throw new IllegalStateException("Private access to constructor");
    }

    public static Item convertFeedEntryToItem(final Feed origin, final SyndEntry entry) {

        Item.ItemBuilder itemBuilder = new Item.ItemBuilder();

        itemBuilder.withTitle(entry.getTitle()).withUri(entry.getLink()).withCreator(entry.getAuthor()).withOrigin(origin);
        itemBuilder.withPublicationAt(Optional.ofNullable(entry.getPublishedDate()).orElse(entry.getUpdatedDate()));
        itemBuilder.withCollectAt(Date.from(Instant.now()));

        if (!CollectionUtils.isEmpty(entry.getContents())) {
            StringBuilder strBuilder = new StringBuilder();
            entry.getContents().forEach(content -> strBuilder.append(content.getValue()));
            itemBuilder.withContent(strBuilder.toString());
        }

        if (!CollectionUtils.isEmpty(entry.getCategories())) {
            Set<Topic> topics = entry.getCategories().stream().map(syndCategory -> new Topic(syndCategory.getName()))
                    .collect(Collectors.toSet());
            itemBuilder.withTopics(topics);
        }

        return itemBuilder.createItem();
    }
}
