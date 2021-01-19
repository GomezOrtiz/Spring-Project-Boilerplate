package es.nextdigital.springprojectboilerplate.application.common.exception;

/**
 * Clase de utilidad para agrupar mensajes de error
 */
public final class ExceptionConstants {

    // COMMON
    public final static String NOT_FOUND = "The requested content cannot be found";
    public final static String NOT_VALID = "The request is not valid";
    public final static String ALREADY_EXISTS = "The requested content already exists and cannot be created";
    public final static String NOT_ALLOWED = "The requested operation is not allowed";
    public final static String CONSTRAINT_VIOLATION = "Constraint violation";
    public final static String ARGUMENT_NOT_VALID = "Method argument not valid";
    public final static String ID_REQUIRED = "Id is required";
    public static final String ID_NOT_VALID = "Id %s is not a valid numeric value";

    // UUID UTILS
    public final static String UUID_NOT_VALID = "%s is not a valid UUID";

    // DATE UTILS
    public final static String DATE_REQUIRED = "Date in string format is required";
    public final static String DATE_NOT_VALID = "Date could not be parsed: %s is not a valid date for pattern(s) %s with locale %s";
}
