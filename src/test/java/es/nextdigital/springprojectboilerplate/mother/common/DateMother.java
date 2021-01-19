package es.nextdigital.springprojectboilerplate.mother.common;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class DateMother {

    public static LocalDate randomDate(LocalDate from, LocalDate to) {
        Date fromDate = Date.from(from.atStartOfDay(ZoneId.of("UTC")).toInstant());
        Date toDate = Date.from(to.atStartOfDay(ZoneId.of("UTC")).toInstant());
        Instant ins = MotherCreator.random().date().between(fromDate, toDate).toInstant();
        return LocalDate.ofInstant(ins, ZoneId.of("UTC"));
    }

    public static LocalDate randomBirthDate() {
        return randomDate(LocalDate.now().minusYears(80), LocalDate.now().minusYears(18));
    }

    public static String randomHoursAndMinutes() {
        return randomHours().concat(":").concat(randomMinutes());
    }

    private static String randomHours() {
        return StringUtils.leftPad(String.valueOf(MotherCreator.random().number().numberBetween(0, 23)), 2, "0");
    }

    private static String randomMinutes() {
        return StringUtils.leftPad(String.valueOf(MotherCreator.random().number().numberBetween(0, 59)), 2, "0");
    }

    public static String plusHours(String prev, int hours) {
        String[] splitted = prev.split(":");
        hours = Integer.parseInt(splitted[0]) + hours;
        hours = hours >= 24 ? hours - 24 : hours;
        String plusHours = StringUtils.leftPad(String.valueOf(hours), 2, "0");
        String minutes = StringUtils.leftPad(String.valueOf(splitted[1]), 2, "0");
        return plusHours.concat(":").concat(minutes);
    }
}
