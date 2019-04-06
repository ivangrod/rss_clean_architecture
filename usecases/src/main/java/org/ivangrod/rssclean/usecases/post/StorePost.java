package org.ivangrod.rssclean.usecases.post;

//public class StorePost extends WriteModel implements UseCase<StoringPostParams> {
//
//    // TODO PostCollection ¿?
//    private final PostCollection postRepository;
//
//    public StorePost(PostCollection postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    public Post execute(StoringPostParams params) {
//
//        Post post = params.createObject();
//
//        try {
//            post = postRepository.create(post);
//            domainEventPublisher.publish(new StoredPost(params.triggeredBy(), post));
//        } catch (EntityAlreadyExistsException exception) {
//            throw new DuplicateEntityException(String.format("The post [%s] already exists", post.getTitle()),
//                    exception);
//        }
//
//        return post;
//    }
//}
