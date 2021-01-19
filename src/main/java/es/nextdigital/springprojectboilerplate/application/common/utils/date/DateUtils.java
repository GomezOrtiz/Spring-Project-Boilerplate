package es.nextdigital.springprojectboilerplate.application.common.utils.date;

import es.nextdigital.springprojectboilerplate.application.common.exception.ExceptionConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * Clase de utilidad con métodos para trabajar con fechas
 */
@Slf4j
public final class DateUtils {

    private static final Locale DEFAULT_LOCALE = new Locale("es", "ES");

    public static LocalDate parseLocalDate(String date, String pattern) {
        return parseLocalDate(date, pattern, DEFAULT_LOCALE);
    }

    public static LocalDate parseLocalDate(String date, String pattern, String lang, String country) {
        return parseLocalDate(date, pattern, new Locale(lang, country));
    }

    public static LocalDate parseLocalDate(String date, String pattern, Locale locale) {
        Assert.notNull(date, ExceptionConstants.DATE_REQUIRED);
        try {
            return pattern != null ? LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern).withLocale(locale)) : null;
        } catch(DateTimeParseException e) {
            log.warn(String.format(ExceptionConstants.DATE_NOT_VALID, date, pattern, locale));
            throw new DateNotValid(date, pattern, locale);
        }
    }

    public static LocalDateTime parseLocalDateTime(String date, String pattern) {
        return parseLocalDateTime(date, pattern, DEFAULT_LOCALE);
    }

    public static LocalDateTime parseLocalDateTime(String date, String pattern, String lang, String country) {
        return parseLocalDateTime(date, pattern, new Locale(lang, country));
    }

    public static LocalDateTime parseLocalDateTime(String date, String pattern, Locale locale) {
        Assert.notNull(date, ExceptionConstants.DATE_REQUIRED);
        try {
            return pattern != null ? LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern).withLocale(locale)) : null;
        } catch(DateTimeParseException e) {
            log.warn(String.format(ExceptionConstants.DATE_NOT_VALID, date, pattern, locale));
            throw new DateNotValid(date, pattern, locale);
        }
    }

    public static boolean isSameOrBefore(LocalDate date1, LocalDate date2) {
        Assert.notNull(date1, ExceptionConstants.DATE_REQUIRED);
        Assert.notNull(date2, ExceptionConstants.DATE_REQUIRED);
        return date1.isBefore(date2) || date1.equals(date2);
    }

    public static boolean isSameOrAfter(LocalDate date1, LocalDate date2) {
        Assert.notNull(date1, ExceptionConstants.DATE_REQUIRED);
        Assert.notNull(date2, ExceptionConstants.DATE_REQUIRED);
        return date1.isAfter(date2) || date1.equals(date2);
    }

    public static boolean isSameOrBefore(LocalDateTime date1, LocalDateTime date2) {
        Assert.notNull(date1, ExceptionConstants.DATE_REQUIRED);
        Assert.notNull(date2, ExceptionConstants.DATE_REQUIRED);
        return date1.isBefore(date2) || date1.equals(date2);
    }

    public static boolean isSameOrAfter(LocalDateTime date1, LocalDateTime date2) {
        Assert.notNull(date1, ExceptionConstants.DATE_REQUIRED);
        Assert.notNull(date2, ExceptionConstants.DATE_REQUIRED);
        return date1.isAfter(date2) || date1.equals(date2);
    }
}
