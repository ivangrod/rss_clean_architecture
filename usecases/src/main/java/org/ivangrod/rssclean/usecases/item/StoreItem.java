package org.ivangrod.rssclean.usecases.item;

//public class StoreItem extends WriteModel implements UseCase<StoringItemParams> {
//
//    // TODO ItemCollection ¿?
//    private final ItemCollection itemRepository;
//
//    public StoreItem(ItemCollection itemRepository) {
//        this.itemRepository = itemRepository;
//    }
//
//    public Item execute(StoringItemParams params) {
//
//        Item item = params.createObject();
//
//        try {
//            item = itemRepository.create(item);
//            domainEventPublisher.publish(new StoredItem(params.triggeredBy(), item));
//        } catch (EntityAlreadyExistsException exception) {
//            throw new DuplicateInstanceException(String.format("The item [%s] already exists", item.getTitle()),
//                    exception);
//        }
//
//        return item;
//    }
//}
