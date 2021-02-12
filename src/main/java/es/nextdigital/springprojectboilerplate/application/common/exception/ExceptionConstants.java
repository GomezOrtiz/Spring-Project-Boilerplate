package es.nextdigital.springprojectboilerplate.application.common.exception;

/**
 * Clase de utilidad para agrupar mensajes de error
 */
public final class ExceptionConstants {

    // COMMON
    public static final String NOT_FOUND = "The requested content cannot be found";
    public static final String NOT_VALID = "The request is not valid";
    public static final String ALREADY_EXISTS = "The requested content already exists and cannot be created";
    public static final String NOT_ALLOWED = "The requested operation is not allowed";
    public static final String CONSTRAINT_VIOLATION = "Constraint violation";
    public static final String ARGUMENT_NOT_VALID = "Method argument not valid";
    public static final String ID_REQUIRED = "Id is required";
    public static final String ID_NOT_VALID = "Id %s is not a valid numeric value";

    // UUID UTILS
    public static final String UUID_NOT_VALID = "%s is not a valid UUID";

    // DATE UTILS
    public static final String DATE_REQUIRED = "Date in string format is required";
    public static final String DATE_NOT_VALID = "Date could not be parsed: %s is not a valid date for pattern(s) %s with locale %s";
}
