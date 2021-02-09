package es.nextdigital.springprojectboilerplate.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import es.nextdigital.springprojectboilerplate.BaseIntegrationTest;
import es.nextdigital.springprojectboilerplate.BaseUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.core.domain.JavaModifier.FINAL;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = BaseArchTest.BASE_PACKAGE)
public class TestClassesTests extends BaseArchTest {

    @ArchTest
    static final ArchRule tests_should_extend_a_base_test =
            classes()
                    .that().areAnnotatedWith(SpringBootTest.class)
                    .or().haveSimpleNameEndingWith("Tests")
                    .should().beAssignableTo(BaseIntegrationTest.class)
                    .orShould().beAssignableTo(BaseUnitTest.class)
                    .orShould().beAssignableTo(BaseArchTest.class);

    @ArchTest
    static final ArchRule tests_should_be_annotated_with_test =
            methods()
                    .that().areDeclaredInClassesThat().areAnnotatedWith(SpringBootTest.class)
                    .or().areDeclaredInClassesThat().haveSimpleNameEndingWith("Tests")
                    .and().arePublic()
                    .should().beAnnotatedWith(Test.class);

    @ArchTest
    static final ArchRule before_each_methods_should_be_private =
            methods()
                    .that().areDeclaredInClassesThat().areAnnotatedWith(SpringBootTest.class)
                    .or().areDeclaredInClassesThat().haveSimpleNameEndingWith("Tests")
                    .and().areAnnotatedWith(BeforeEach.class)
                    .should().bePrivate();

    @ArchTest
    static final ArchRule test_fields_that_are_not_static_should_be_private_or_protected =
            fields()
                    .that().areDeclaredInClassesThat().areAnnotatedWith(SpringBootTest.class)
                    .or().areDeclaredInClassesThat().haveSimpleNameEndingWith("Tests")
                    .and().areNotStatic()
                    .should().bePrivate()
                    .orShould().beProtected();

    @ArchTest
    static final ArchRule mothers_and_writers_should_be_suffixed =
            classes()
                    .that().resideInAPackage(MOTHER_PACKAGE)
                    .should().haveSimpleNameEndingWith("Mother")
                    .orShould().haveSimpleNameStartingWith("Mother")
                    .orShould().haveSimpleNameEndingWith("Writer");

    @ArchTest
    static final ArchRule mothers_should_be_final =
            classes()
                    .that().resideInAPackage(MOTHER_PACKAGE)
                    .and().haveSimpleNameNotEndingWith("Writer")
                    .should().haveModifier(FINAL);

    @ArchTest
    static final ArchRule mothers_methods_should_be_static =
            methods()
                    .that().areDeclaredInClassesThat().haveSimpleNameEndingWith("Mother")
                    .or().areDeclaredInClassesThat().haveSimpleNameStartingWith("Mother")
                    .should().beStatic();

    @ArchTest
    static final ArchRule tests_in_mothers_directory_should_be_disabled_because_they_are_writers =
            methods()
                    .that()
                    .areAnnotatedWith(Test.class).and()
                    .areNotStatic().and()
                    .areDeclaredInClassesThat().resideInAnyPackage(MOTHER_PACKAGE)
                    .or().areDeclaredInClassesThat().haveSimpleNameEndingWith("Writer")
                    .should().beAnnotatedWith(Disabled.class);
}
