package org.ivangrod.rssclean.usecases.post;

//public class RetrievePosts implements UseCase<RetrievePostsParams> {
//
//    // TODO PostCollection ¿?
//    private final PostCollection postRepository;
//
//    public RetrievePosts(PostCollection postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    public Cursor<Post> execute(RetrievePostsParams params) {
//
////        if (CollectionUtils.isNotEmpty(params.getFilteredBy())) {
////            List<GroupFilterBy> groupFilterBy = toGroupFilterBy(params.getFilteredBy());
////            return groupRepository.paginate(params.getFirst(), params.getAfter(), groupFilterBy);
////        }
//
//        // TODO INFRASTRUCTURE
//        //        Criteria<SolrQuery> criteria = new SolrCriteria();
//        //        criteria.addField(GroupDbNaming.NAME, params.getKeywords());
//        //        criteria.type(SolrNaming.GROUP_TYPE);
//        //        criteria.sort(Sort.asc(GroupDbNaming.NAME + "_str"));
//        //        criteria.limit(params.getFirst());
//        //        criteria.nextCursorMark(params.getAfter());
//        Cursor<Post> posts = postRepository.search(criteria);
//
//        List<String> ids =
//                groups.getElements().stream().map(group -> group.getId()).collect(Collectors.toList());
//        List<Group> filledGroups = groupRepository.findById(ids).collect(Collectors.toList());
//        return groups.clone(filledGroups);
//    }
//}
