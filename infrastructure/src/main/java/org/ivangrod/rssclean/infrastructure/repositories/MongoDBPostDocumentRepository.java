package org.ivangrod.rssclean.infrastructure.repositories;

import org.ivangrod.rssclean.infrastructure.repositories.entities.PostDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDBPostDocumentRepository extends MongoRepository<PostDocument, String> {

}