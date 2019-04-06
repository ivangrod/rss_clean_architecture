package org.ivangrod.rssclean.usecases.rss.params;

import org.ivangrod.rssclean.domain.exceptions.EntityValidationException;
import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.usecases.UseCaseParams;

import java.net.MalformedURLException;
import java.net.URL;

public class CollectingFeedParams implements UseCaseParams {

    private final String source;
    private final String url;

    public CollectingFeedParams(String source, String url) {
        this.source = source;
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "CollectingFeedParams{" + "source='" + source + '\'' + ", url='" + url + '\'' + '}';
    }

    public Feed createObject() {
        try {
            return new Feed(new URL(url), source);
        } catch (MalformedURLException e) {
            throw new EntityValidationException("Feed couldn't be created");
        }
    }
}
