package es.nextdigital.springprojectboilerplate.mother.common;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class BooleanMother {

    public static Boolean random() {
        List<Boolean> booleans = Arrays.asList(Boolean.TRUE, Boolean.FALSE);
        return booleans.get(new Random().nextInt(booleans.size()));
    }
}
