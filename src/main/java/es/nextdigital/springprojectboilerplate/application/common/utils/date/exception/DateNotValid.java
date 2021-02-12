package es.nextdigital.springprojectboilerplate.application.common.utils.date.exception;

import es.nextdigital.springprojectboilerplate.application.common.exception.ExceptionConstants;
import es.nextdigital.springprojectboilerplate.application.common.exception.NotValid;

import java.util.Locale;

/**
 * Excepción para controlar errores producidos
 * por el envío de un valor de fecha inadecuado
 */
public final class DateNotValid extends NotValid {

    private static final long serialVersionUID = 7026665656000726581L;

    private static final String DEFAULT_LOCALE = "es/ES";

    public DateNotValid(String date, String pattern) {
        super(ExceptionConstants.DATE_NOT_VALID, date, pattern, DEFAULT_LOCALE);
    }

    public DateNotValid(String date, String pattern, Locale locale) {
        super(ExceptionConstants.DATE_NOT_VALID, date, pattern, String.format("%s/%s", locale.getLanguage(), locale.getCountry()));
    }
}
