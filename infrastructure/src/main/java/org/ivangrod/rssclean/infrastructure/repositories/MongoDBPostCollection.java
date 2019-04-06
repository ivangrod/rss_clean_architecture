package org.ivangrod.rssclean.infrastructure.repositories;

import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.infrastructure.repositories.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MongoDBPostCollection implements PostCollection {

    @Autowired
    MongoDBPostDocumentRepository postDocumentRepository;

    @Override
    public Post create(Post post) {
        return PostMapper.documentToEntity(postDocumentRepository.save(PostMapper.entityToDocument(post)));
    }

    @Override
    public Set<Post> readAll() {
        return postDocumentRepository.findAll()
                .stream()
                .map(postDocument -> PostMapper.documentToEntity(postDocument))
                .collect(Collectors.toSet());
    }
}
