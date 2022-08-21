package com.hit.product.domains.dtos.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationDto<T> {
    private T data;
    private Pagination pagination;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Pagination {
        private Integer page;
        private Integer perPage;
        private Integer lastPage;
        private Long total;
    }
}