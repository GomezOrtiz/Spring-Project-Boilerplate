package es.nextdigital.springprojectboilerplate.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = BaseArchTest.BASE_PACKAGE, importOptions = { ImportOption.DoNotIncludeTests.class })
public class ApplicationTests extends BaseArchTest {

    @ArchTest
    static final ArchRule application_services_should_only_be_accessed_from_controllers =
        classes()
                .that().areAnnotatedWith(Service.class)
                .and().resideInAPackage(APPLICATION_PACKAGE)
                .should().onlyBeAccessed().byAnyPackage(APPLICATION_PACKAGE, REST_PACKAGE);

    @ArchTest
    static final ArchRule application_services_should_not_depend_on_controllers =
        noClasses()
                .that().areAnnotatedWith(Service.class)
                .and().resideInAPackage(APPLICATION_PACKAGE)
                .should().dependOnClassesThat().resideInAnyPackage(REST_PACKAGE);

    @ArchTest
    static final ArchRule methods_in_application_services_should_have_transactional_annotation =
            methods()
                    .that().areDeclaredInClassesThat().areAnnotatedWith(Service.class)
                    .and().areDeclaredInClassesThat().resideInAPackage(APPLICATION_PACKAGE)
                    .and().arePublic()
                    .should().beAnnotatedWith(Transactional.class);

    @ArchTest
    static final ArchRule dtos_should_be_placed_in_application =
            classes()
                    .that().haveSimpleNameEndingWith("DTO")
                    .or().haveSimpleNameEndingWith("Request")
                    .or().haveSimpleNameEndingWith("Response")
                    .should().resideInAPackage(APPLICATION_PACKAGE);

    @ArchTest
    static final ArchRule utils_should_be_placed_in_application =
            classes()
                    .that().haveSimpleNameEndingWith("Utils")
                    .should().resideInAnyPackage(APPLICATION_PACKAGE, INFRASTRUCTURE_PACKAGE);
}
