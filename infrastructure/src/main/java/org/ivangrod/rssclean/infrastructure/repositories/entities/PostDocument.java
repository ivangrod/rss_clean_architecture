package org.ivangrod.rssclean.infrastructure.repositories.entities;

import org.ivangrod.rssclean.domain.model.post.Feed;
import org.ivangrod.rssclean.domain.model.post.Topic;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document(value = "post")
public class PostDocument {

    @Id
    public String id;

    private String generatedId;

    private String title;

    private String uri;

    private String creator;

    private Feed origin;

    private String content;

    private Date collectAt;

    private Date publicationAt;

    private Set<Topic> topics;

    public PostDocument() {
    }

    public PostDocument(String id, String title, String uri, String creator, Feed origin, String content, Date collectAt, Date publicationAt, Set<Topic> topics) {
        this.id = id;
        this.title = title;
        this.uri = uri;
        this.creator = creator;
        this.origin = origin;
        this.content = content;
        this.collectAt = collectAt;
        this.publicationAt = publicationAt;
        this.topics = topics;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Feed getOrigin() {
        return origin;
    }

    public void setOrigin(Feed origin) {
        this.origin = origin;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCollectAt() {
        return collectAt;
    }

    public void setCollectAt(Date collectAt) {
        this.collectAt = collectAt;
    }

    public Date getPublicationAt() {
        return publicationAt;
    }

    public void setPublicationAt(Date publicationAt) {
        this.publicationAt = publicationAt;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "PostDocument{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", uri='" + uri + '\'' +
                ", creator='" + creator + '\'' +
                ", origin=" + origin +
                ", content='" + content + '\'' +
                ", collectAt=" + collectAt +
                ", publicationAt=" + publicationAt +
                ", topics=" + topics +
                '}';
    }
}
