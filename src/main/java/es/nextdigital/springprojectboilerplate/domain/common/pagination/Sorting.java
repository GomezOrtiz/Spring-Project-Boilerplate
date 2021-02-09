package es.nextdigital.springprojectboilerplate.domain.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Objeto que modela la ordenación
 * de resultados de búsqueda
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Sorting implements Serializable {

    private static final long serialVersionUID = -2303563483247726805L;

    private final boolean sorted;

    private final String sortBy;

    private final SortDirection sortDirection;

    public static Sorting unsorted() {
        return new Sorting(false, null, null);
    }

    public static Sorting of(@NotBlank String sortBy, @NotNull SortDirection sortDirection) {
        return new Sorting(true, sortBy, sortDirection);
    }
}
