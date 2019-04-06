package org.ivangrod.rssclean.infrastructure.repositories.mapper;

import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.infrastructure.repositories.entities.PostDocument;

public final class PostMapper {

    public static Post documentToEntity(final PostDocument document) {

        Post.PostBuilder builder = new Post.PostBuilder();
        builder.withTitle(document.getTitle())
                .withUri(document.getUri())
                .withOrigin(document.getOrigin())
                .withContent(document.getContent())
                .withCollectAt(document.getCollectAt())
                .withPublicationAt(document.getPublicationAt())
                .withCreator(document.getCreator())
                .withTopics(document.getTopics());

        Post newPost = builder.createPost();
        newPost.setId(document.getId());

        return newPost;
    }

    public static PostDocument entityToDocument(final Post entity) {
        return new PostDocument(entity.getId(), entity.getTitle(), entity.getUri(),
                entity.getCreator(), entity.getOrigin(), entity.getContent(), entity.getCollectAt(),
                entity.getPublicationAt(), entity.getTopics());
    }
}
