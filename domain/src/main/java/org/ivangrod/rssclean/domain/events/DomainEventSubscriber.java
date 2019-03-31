package org.ivangrod.rssclean.domain.events;

public interface DomainEventSubscriber {

    void process(DomainEvent event);
}
