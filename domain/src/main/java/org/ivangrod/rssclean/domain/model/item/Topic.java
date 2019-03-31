package org.ivangrod.rssclean.domain.model.item;

/**
 * Value Object (part of Item aggregate)
 */
public class Topic {

    public String tag;

    public Topic(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "tag='" + tag + '\'' +
                '}';
    }
}
