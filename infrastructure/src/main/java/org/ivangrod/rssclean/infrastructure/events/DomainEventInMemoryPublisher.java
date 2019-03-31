package org.ivangrod.rssclean.infrastructure.events;

import org.ivangrod.rssclean.domain.events.DomainEvent;
import org.ivangrod.rssclean.domain.events.DomainEventPublisher;
import org.ivangrod.rssclean.domain.events.DomainEventSubscriber;
import org.ivangrod.rssclean.infrastructure.events.subscribers.ItemStatusSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DomainEventInMemoryPublisher implements DomainEventPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(DomainEventInMemoryPublisher.class);

    @Autowired
    private ItemStatusSubscriber itemStatusSubscriber;

    private List<DomainEventSubscriber> subscribers;

    public DomainEventInMemoryPublisher() {
        this.subscribers = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        addSubscriber(itemStatusSubscriber);
    }

    @Override
    public void publish(DomainEvent event) {
        this.subscribers.forEach((subscriber) -> {
            LOG.trace(" > publishing {} to {}", event.getClass().getSimpleName(),
                    subscriber.getClass().getSimpleName());
            subscriber.process(event);
        });
    }

    public void addSubscriber(DomainEventSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }
}
