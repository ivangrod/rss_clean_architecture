package org.ivangrod.rssclean.infrastructure.converter;

import com.rometools.rome.feed.synd.SyndEntry;
import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.Topic;
import org.springframework.util.CollectionUtils;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class FeedEntryToPost {

    private FeedEntryToPost() {
        throw new IllegalStateException("Private access to constructor");
    }

    public static Post convertFeedEntryToPost(final Feed origin, final SyndEntry entry) {

        Post.PostBuilder postBuilder = new Post.PostBuilder();

        postBuilder.withTitle(entry.getTitle()).withUri(entry.getLink()).withCreator(entry.getAuthor()).withOrigin(origin);
        postBuilder.withPublicationAt(Optional.ofNullable(entry.getPublishedDate()).orElse(entry.getUpdatedDate()));
        postBuilder.withCollectAt(Date.from(Instant.now()));

        if (!CollectionUtils.isEmpty(entry.getContents())) {
            StringBuilder strBuilder = new StringBuilder();
            entry.getContents().forEach(content -> strBuilder.append(content.getValue()));
            postBuilder.withContent(strBuilder.toString());
        }

        if (!CollectionUtils.isEmpty(entry.getCategories())) {
            Set<Topic> topics = entry.getCategories().stream().map(syndCategory -> new Topic(syndCategory.getName()))
                    .collect(Collectors.toSet());
            postBuilder.withTopics(topics);
        }

        return postBuilder.createPost();
    }
}
