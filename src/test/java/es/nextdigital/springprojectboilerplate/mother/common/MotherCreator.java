package es.nextdigital.springprojectboilerplate.mother.common;

import com.github.javafaker.Faker;

import java.util.Locale;

public final class MotherCreator {

    private static final Faker faker = new Faker(new Locale("es"));

    public static Faker random() {
        return faker;
    }
}
