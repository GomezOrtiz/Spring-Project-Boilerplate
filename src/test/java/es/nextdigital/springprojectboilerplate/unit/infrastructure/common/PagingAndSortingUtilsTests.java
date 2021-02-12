package es.nextdigital.springprojectboilerplate.unit.infrastructure.common;

import es.nextdigital.springprojectboilerplate.BaseUnitTest;
import es.nextdigital.springprojectboilerplate.domain.common.pagination.Pagination;
import es.nextdigital.springprojectboilerplate.domain.common.pagination.SortDirection;
import es.nextdigital.springprojectboilerplate.domain.common.pagination.Sorting;
import es.nextdigital.springprojectboilerplate.infrastructure.common.PagingAndSortingUtils;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PagingAndSortingUtilsTests extends BaseUnitTest {

    @Test
    void should_map_to_pageable() {

        var pagination = Pagination.of(0, 10);
        var sorting = Sorting.of("date", SortDirection.DESC);
        var expected = PageRequest.of(pagination.getPageNum(), pagination.getPageSize(), Sort.by(Sort.Order.by(sorting.getSortBy()).with(Sort.Direction.fromString(sorting.getSortDirection().value()))));

        var actual = PagingAndSortingUtils.toPageable(pagination, sorting);

        assertEquals(expected, actual);
    }

    @Test
    void should_map_to_pageable_if_unpaged() {

        var pagination = Pagination.unpaged();
        var sorting = Sorting.of("date", SortDirection.DESC);
        var expected = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(Sort.Order.by(sorting.getSortBy()).with(Sort.Direction.fromString(sorting.getSortDirection().value()))));

        var actual = PagingAndSortingUtils.toPageable(pagination, sorting);

        assertEquals(expected, actual);
    }

    @Test
    void should_map_to_pageable_if_unsorted() {

        var pagination = Pagination.of(0, 10);
        var sorting = Sorting.unsorted();
        var expected = PageRequest.of(pagination.getPageNum(), pagination.getPageSize());

        var actual = PagingAndSortingUtils.toPageable(pagination, sorting);

        assertEquals(expected, actual);
    }

    @Test
    void should_map_to_pageable_if_unpaged_and_unsorted() {

        var pagination = Pagination.unpaged();
        var sorting = Sorting.unsorted();
        var expected = Pageable.unpaged();

        var actual = PagingAndSortingUtils.toPageable(pagination, sorting);

        assertEquals(expected, actual);
    }
}
