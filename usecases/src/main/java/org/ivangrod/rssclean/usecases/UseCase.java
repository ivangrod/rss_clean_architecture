package org.ivangrod.rssclean.usecases;

import org.ivangrod.rssclean.domain.usecases.UseCaseParams;

public interface UseCase<T extends UseCaseParams> {

    Object execute(T params);
}
