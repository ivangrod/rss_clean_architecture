package org.ivangrod.rssclean.usecases.post;

import org.ivangrod.rssclean.domain.model.post.Post;
import org.ivangrod.rssclean.domain.model.post.PostCollection;
import org.ivangrod.rssclean.usecases.UseCase;
import org.ivangrod.rssclean.usecases.post.params.RetrievingPostParams;

public class RetrievePosts implements UseCase<RetrievingPostParams> {

    private final PostCollection postRepository;

    public RetrievePosts(PostCollection postRepository) {
        this.postRepository = postRepository;
    }

    public Post execute(RetrievingPostParams params) {

        return null;
    }
}
