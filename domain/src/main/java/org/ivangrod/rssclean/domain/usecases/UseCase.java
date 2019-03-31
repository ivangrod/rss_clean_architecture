package org.ivangrod.rssclean.domain.usecases;

public interface UseCase<T extends UseCaseParams> {

    Object execute(T params);
}
