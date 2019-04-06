package org.ivangrod.rssclean.domain.model.post;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Aggregate Root
 */
public class Post implements Cloneable {

    private String id;

    private String generatedId;

    private String title;

    private String uri;

    private String creator;

    private Feed origin;

    private String content;

    private Date collectAt;

    private Date publicationAt;

    private Set<Topic> topics;

    public Post() {
    }

    private Post(String id, String title, String uri, String creator, Feed origin, String content, Date collectAt, Date publicationAt, Set<Topic> topics) {
        this.generatedId = generateId(uri);
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

    public String getGeneratedId() {
        return generatedId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(uri, post.uri) &&
                Objects.equals(creator, post.creator) &&
                Objects.equals(origin, post.origin) &&
                Objects.equals(content, post.content) &&
                Objects.equals(collectAt, post.collectAt) &&
                Objects.equals(publicationAt, post.publicationAt) &&
                Objects.equals(topics, post.topics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, uri, creator, origin, content, collectAt, publicationAt, topics);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", uri='" + uri + '\'' +
                ", creator='" + creator + '\'' +
                ", origin=" + origin +
                ", content='" + content + '\'' +
                ", collectAt=" + collectAt +
                ", publicationAt=" + publicationAt +
                ", topics=" + topics +
                '}';
    }

    public String generateId(final String uri) {

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
            md.update(uri.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest)
                .toUpperCase();
    }

    @Override
    public Object clone() {
        try {
            return (Post) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Post(this.getId(), this.getTitle(), this.getUri(), this.getCreator(), this.getOrigin(),
                    this.getContent(), this.getCollectAt(), this.getPublicationAt(), this.getTopics());
        }
    }

    public static class PostBuilder {
        private String title;
        private String uri;
        private String creator;
        private Feed origin;
        private String content;
        private Date collectAt;
        private Date publicationAt;
        private Set<Topic> topics;

        public PostBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder withUri(String uri) {
            this.uri = uri;
            return this;
        }

        public PostBuilder withCreator(String creator) {
            this.creator = creator;
            return this;
        }

        public PostBuilder withOrigin(Feed origin) {
            this.origin = origin;
            return this;
        }

        public PostBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public PostBuilder withCollectAt(Date collectAt) {
            this.collectAt = collectAt;
            return this;
        }

        public PostBuilder withPublicationAt(Date publicationAt) {
            this.publicationAt = publicationAt;
            return this;
        }

        public PostBuilder withTopics(Set<Topic> topics) {
            this.topics = topics;
            return this;
        }

        public Post createPost() {
            return new Post(null, title, uri, creator, origin, content, collectAt, publicationAt, topics);
        }
    }
}
