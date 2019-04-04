package org.ivangrod.rssclean.usecases;

public interface UseCase<T extends UseCaseParams> {

    Object execute(T params);
}
