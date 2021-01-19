package es.nextdigital.springprojectboilerplate.application.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * DTO que representa una respuesta paginada
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {

    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private boolean first;
    private boolean last;

    public PageResponse(Page<T> page) {
        this.items = page.getContent();
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.first = page.isFirst();
        this.last = page.isLast();
    }

    public PageResponse(Page<?> page, List<T> items) {
        this.items = items;
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.first = page.isFirst();
        this.last = page.isLast();
    }
}
