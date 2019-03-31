package org.ivangrod.rssclean.infrastructure.repositories;

import org.ivangrod.rssclean.infrastructure.repositories.entities.ItemDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBItemDocumentRepository extends MongoRepository<ItemDocument, String> {

}