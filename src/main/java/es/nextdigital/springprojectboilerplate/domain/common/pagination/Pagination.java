package es.nextdigital.springprojectboilerplate.domain.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Objeto que modela la paginación
 * de resultados de búsqueda
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Pagination implements Serializable {

    private static final long serialVersionUID = 4817906405647701872L;

    private final boolean paginated;

    private final Integer pageNum;

    private final Integer pageSize;

    public static Pagination unpaged() {
        return new Pagination(false, null, null);
    }

    public static Pagination of(int pageNum, int pageSize) {
        return new Pagination(true, pageNum, pageSize);
    }
}
