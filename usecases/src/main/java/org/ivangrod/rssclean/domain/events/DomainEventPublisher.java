package org.ivangrod.rssclean.domain.events;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
