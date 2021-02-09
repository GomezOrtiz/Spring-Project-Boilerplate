package es.nextdigital.springprojectboilerplate.domain.common.pagination;

public enum SortDirection {
    ASC("asc"),
    DESC("desc");

    private final String type;

    SortDirection(String type) {
        this.type = type;
    }

    public boolean isAsc() {
        return this == ASC;
    }

    public String value() {
        return type;
    }
}
