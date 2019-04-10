package org.ivangrod.rssclean.infrastructure.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Component
public class ElasticPostCollection implements PostCollection {

    private RestHighLevelClient client;

    private ObjectMapper objectMapper;

    @Autowired
    public ElasticPostCollection(RestHighLevelClient client, ObjectMapper objectMapper) {
        this.client = client;
        this.objectMapper = objectMapper;
    }

    @Override
    public Post create(Post post) {

        Map<String, Object> postMapper = objectMapper.convertValue(post, Map.class);
        IndexRequest indexRequest = new IndexRequest("feed-collector").type("post").id(post.getId())
                .source(postMapper);
        IndexResponse indexResponse = null;

        try {
            indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return post;
    }

    @Override
    public Set<Post> readAll() {
        return null;
    }
}
