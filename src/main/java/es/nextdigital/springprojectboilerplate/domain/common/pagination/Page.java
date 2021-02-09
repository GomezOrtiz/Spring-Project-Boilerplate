package es.nextdigital.springprojectboilerplate.domain.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Objeto que modela una página
 * de resultados de búsqueda
 */
@Data
@AllArgsConstructor
public final class Page<T> implements Serializable {

    private static final long serialVersionUID = 2850551471179820428L;

    private final List<T> content;
    private final int number;
    private final int size;
    private final boolean first;
    private final boolean last;
}
