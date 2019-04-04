package org.ivangrod.rssclean.usecases.item;

import org.ivangrod.rssclean.domain.model.item.Item;

import java.util.List;
import java.util.stream.Collectors;

//public class RetrieveItems implements UseCase<RetrieveItemsParams> {
//
//    // TODO ItemCollection ¿?
//    private final ItemCollection itemRepository;
//
//    public RetrieveItems(ItemCollection itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    public Cursor<Item> execute(RetrieveItemsParams params) {
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
//        Cursor<Item> items = itemRepository.search(criteria);
//
//        List<String> ids =
//                groups.getElements().stream().map(group -> group.getId()).collect(Collectors.toList());
//        List<Group> filledGroups = groupRepository.findById(ids).collect(Collectors.toList());
//        return groups.clone(filledGroups);
//    }
//}
