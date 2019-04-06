package org.ivangrod.rssclean.infrastructure.services;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.FeedListener;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.infrastructure.converter.FeedEntryToPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RssFeedListener implements FeedListener {

    private final static Logger log = LoggerFactory.getLogger(RssFeedListener.class);

    @Override
    public List<Post> extract(final Feed feed) {

        List<Post> postsCollected = new ArrayList<>();

        try {

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feedLoaded = input.build(new XmlReader(feed.getUri()));

            postsCollected.addAll(feedLoaded.getEntries()
                    .stream()
                    .map(entry -> FeedEntryToPost.convertFeedEntryToPost(feed, entry))
                    .collect(Collectors.toList()));

        } catch (IOException | FeedException exception) {
            log.error("An error has been produced when the feed from source [{0}] was loaded", feed.getSource(), exception);
        }

        return postsCollected;
    }
}
