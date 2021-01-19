package es.nextdigital.springprojectboilerplate.unit.application.common.utils.date;

import es.nextdigital.springprojectboilerplate.BaseUnitTest;
import es.nextdigital.springprojectboilerplate.application.common.exception.ExceptionConstants;
import es.nextdigital.springprojectboilerplate.application.common.utils.date.DateNotValid;
import es.nextdigital.springprojectboilerplate.application.common.utils.date.DateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTests extends BaseUnitTest {

    @Test
    void should_parse_local_date_with_default_locale() {

        LocalDate expected = LocalDate.of(2020, 7, 15);
        String date = "2020-07-15";
        String pattern = "yyyy-MM-dd";

        LocalDate actual = DateUtils.parseLocalDate(date, pattern);

        assertEquals(expected, actual);
    }

    @Test
    void should_parse_local_date_with_lang_and_country() {

        LocalDate expected = LocalDate.of(2020, 7, 15);
        String date = "15 julio 2020";
        String pattern = "dd MMMM yyyy";

        LocalDate actual = DateUtils.parseLocalDate(date, pattern,"es", "ES");

        assertEquals(expected, actual);
    }

    @Test
    void should_parse_local_date_with_locale() {

        LocalDate expected = LocalDate.of(2020, 7, 15);
        String date = "15 July 2020";
        String pattern = "dd MMMM yyyy";

        LocalDate actual = DateUtils.parseLocalDate(date, pattern, new Locale("en", "US"));

        assertEquals(expected, actual);
    }

    @Test
    void should_fail_parse_local_date_if_null_id() {
        assertThrows(IllegalArgumentException.class, () -> DateUtils.parseLocalDateTime(null, "yyyy-MM-dd"));
    }

    @Test
    void should_parse_local_date_time() {

        LocalDateTime expected = LocalDateTime.of(2020, 7, 15, 23, 45);
        String date = "2020-07-15 23:45";
        String pattern = "yyyy-MM-dd HH:mm";

        LocalDateTime actual = DateUtils.parseLocalDateTime(date, pattern);

        assertEquals(expected, actual);
    }

    @Test
    void should_parse_local_date_time_with_lang_and_country() {

        LocalDateTime expected = LocalDateTime.of(2020, 7, 15, 23, 45);
        String date = "15 julio 2020 23:45";
        String pattern = "dd MMMM yyyy HH:mm";

        LocalDateTime actual = DateUtils.parseLocalDateTime(date, pattern,"es", "ES");

        assertEquals(expected, actual);
    }

    @Test
    void should_parse_local_date_time_with_locale() {

        LocalDateTime expected = LocalDateTime.of(2020, 7, 15, 23, 45);
        String date = "15 July 2020 23:45";
        String pattern = "dd MMMM yyyy HH:mm";

        LocalDateTime actual = DateUtils.parseLocalDateTime(date, pattern, new Locale("en", "US"));

        assertEquals(expected, actual);
    }

    @Test
    void should_fail_parse_local_date_time_if_null_id() {
        assertThrows(IllegalArgumentException.class, () -> DateUtils.parseLocalDateTime(null, "yyyy-MM-dd HH:mm"));
    }

    @Test
    void should_fail_parse_local_date_if_not_valid() {

        String date = "2020-07-15";
        String pattern = "yyyy/MM/dd";

        Exception e = assertThrows(DateNotValid.class, () -> DateUtils.parseLocalDate(date, pattern));

        assertEquals(String.format(ExceptionConstants.DATE_NOT_VALID, date, pattern, "es/ES"), e.getMessage());
    }

    @Test
    void should_fail_parse_local_date_time_if_not_valid() {

        String date = "2020-07-15 23:45";
        String pattern = "yyyy-MM-dd hh:mm";

        Exception e = assertThrows(DateNotValid.class, () -> DateUtils.parseLocalDateTime(date, pattern));

        assertEquals(String.format(ExceptionConstants.DATE_NOT_VALID, date, pattern, "es/ES"), e.getMessage());
    }

    @Test
    void should_check_if_date1_is_same_or_before_date2_when_same() {

        LocalDate date1 = LocalDate.of(2021, 7, 1);
        LocalDate date2 = LocalDate.of(2021, 7, 1);

        assertTrue(DateUtils.isSameOrBefore(date1, date2));
    }

    @Test
    void should_check_if_date1_is_same_or_before_date2_when_before() {

        LocalDate date1 = LocalDate.of(2021, 6, 30);
        LocalDate date2 = LocalDate.of(2021, 7, 1);

        assertTrue(DateUtils.isSameOrBefore(date1, date2));
    }

    @Test
    void should_check_if_date1_is_same_or_before_date2_when_after() {

        LocalDate date1 = LocalDate.of(2021, 8, 30);
        LocalDate date2 = LocalDate.of(2021, 7, 1);

        assertFalse(DateUtils.isSameOrBefore(date1, date2));
    }

    @Test
    void should_check_if_date1_is_same_or_after_date2_when_same() {

        LocalDate date1 = LocalDate.of(2021, 7, 1);
        LocalDate date2 = LocalDate.of(2021, 7, 1);

        assertTrue(DateUtils.isSameOrAfter(date1, date2));
    }

    @Test
    void should_check_if_date1_is_same_or_after_date2_when_after() {

        LocalDate date1 = LocalDate.of(2021, 8, 30);
        LocalDate date2 = LocalDate.of(2021, 7, 1);

        assertTrue(DateUtils.isSameOrAfter(date1, date2));
    }

    @Test
    void should_check_if_date1_is_same_or_after_date2_when_before() {

        LocalDate date1 = LocalDate.of(2021, 6, 30);
        LocalDate date2 = LocalDate.of(2021, 7, 1);

        assertFalse(DateUtils.isSameOrAfter(date1, date2));
    }

    @Test
    void should_check_if_time1_is_same_or_before_time2_when_same() {

        LocalDateTime time1 = LocalDateTime.of(2021, 7, 1, 12, 25,0);
        LocalDateTime time2 = LocalDateTime.of(2021, 7, 1, 12, 25,0);

        assertTrue(DateUtils.isSameOrBefore(time1, time2));
    }

    @Test
    void should_check_if_time1_is_same_or_before_time2_when_before() {

        LocalDateTime time1 = LocalDateTime.of(2021, 7, 1, 12, 25, 0);
        LocalDateTime time2 = LocalDateTime.of(2021, 7, 1, 12, 30, 0);

        assertTrue(DateUtils.isSameOrBefore(time1, time2));
    }

    @Test
    void should_check_if_time1_is_same_or_before_time2_when_after() {

        LocalDateTime time1 = LocalDateTime.of(2021, 7, 1, 12, 30, 0);
        LocalDateTime time2 = LocalDateTime.of(2021, 7, 1, 12, 25, 0);

        assertFalse(DateUtils.isSameOrBefore(time1, time2));
    }

    @Test
    void should_check_if_time1_is_same_or_after_time2_when_same() {

        LocalDateTime time1 = LocalDateTime.of(2021, 7, 1, 12, 25, 0);
        LocalDateTime time2 = LocalDateTime.of(2021, 7, 1, 12, 25, 0);

        assertTrue(DateUtils.isSameOrAfter(time1, time2));
    }

    @Test
    void should_check_if_time1_is_same_or_after_time2_when_after() {

        LocalDateTime time1 = LocalDateTime.of(2021, 7, 1, 12, 35, 0);
        LocalDateTime time2 = LocalDateTime.of(2021, 7, 1, 12, 25, 0);

        assertTrue(DateUtils.isSameOrAfter(time1, time2));
    }

    @Test
    void should_check_if_time1_is_same_or_after_time2_when_before() {

        LocalDateTime time1 = LocalDateTime.of(2021, 7, 1, 12, 20, 0);
        LocalDateTime time2 = LocalDateTime.of(2021, 7, 1, 12, 25, 0);

        assertFalse(DateUtils.isSameOrAfter(time1, time2));
    }
}
