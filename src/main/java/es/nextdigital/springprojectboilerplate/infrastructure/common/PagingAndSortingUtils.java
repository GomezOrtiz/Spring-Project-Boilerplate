package es.nextdigital.springprojectboilerplate.infrastructure.common;

import es.nextdigital.springprojectboilerplate.domain.common.pagination.Pagination;
import es.nextdigital.springprojectboilerplate.domain.common.pagination.Sorting;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public final class PagingAndSortingUtils {

    public static Pageable toPageable(Pagination pagination, Sorting sorting) {
        Sort sort = sorting.isSorted()
                ? Sort.by(Sort.Order.by(sorting.getSortBy()).with(Sort.Direction.fromString(sorting.getSortDirection().value())))
                : Sort.unsorted();
        return pagination.isPaginated()
                ? PageRequest.of(pagination.getPageNum(), pagination.getPageSize(), sort)
                : Pageable.unpaged();
    }
}
