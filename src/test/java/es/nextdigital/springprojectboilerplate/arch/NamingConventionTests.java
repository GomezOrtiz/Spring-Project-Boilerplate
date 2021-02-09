package es.nextdigital.springprojectboilerplate.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = BaseArchTest.BASE_PACKAGE, importOptions = {ImportOption.DoNotIncludeTests.class})
public class NamingConventionTests extends BaseArchTest {

    @ArchTest
    static final ArchRule application_services_should_be_in_the_right_package =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .should().resideInAPackage(APPLICATION_PACKAGE);

    @ArchTest
    static final ArchRule application_services_should_not_be_suffixed =
            classes()
                    .that().areAnnotatedWith(Service.class)
                    .or().resideInAPackage(APPLICATION_PACKAGE)
                    .should().haveSimpleNameNotEndingWith("Service")
                    .andShould().haveSimpleNameNotEndingWith("ServiceImpl");

    @ArchTest
    static final ArchRule repository_interfaces_should_be_in_the_right_package =
            classes()
                    .that().haveSimpleNameEndingWith("Repository").and().areInterfaces()
                    .and().areNotAssignableTo(JpaRepository.class)
                    .should().resideInAPackage(DOMAIN_PACKAGE);

    @ArchTest
    static final ArchRule repositories_in_domain_package_should_be_interfaces =
            classes()
                    .that().haveSimpleNameEndingWith("Repository").and().resideInAPackage(DOMAIN_PACKAGE)
                    .should().notBeAssignableTo(JpaRepository.class)
                    .andShould().beInterfaces();

    @ArchTest
    static final ArchRule repository_implementations_should_be_in_the_right_package =
            classes()
                    .that().haveSimpleNameEndingWith("Repository").and().areNotInterfaces()
                    .or().areAssignableTo(JpaRepository.class)
                    .should().resideInAPackage(INFRASTRUCTURE_PACKAGE);

    @ArchTest
    static final ArchRule jpa_repository_implementations_should_be_suffixed =
            classes()
                    .that().resideInAPackage(INFRASTRUCTURE_PACKAGE)
                    .and().areAssignableTo(JpaRepository.class)
                    .should().haveSimpleNameEndingWith("Repository");

    @ArchTest
    static final ArchRule controllers_should_be_in_the_right_package =
            classes()
                    .that().areAnnotatedWith(RestController.class)
                    .or().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage(REST_PACKAGE);

    @ArchTest
    static final ArchRule controllers_should_be_suffixed =
            classes()
                    .that().areAnnotatedWith(RestController.class)
                    .or().resideInAPackage(REST_PACKAGE)
                    .and().resideOutsideOfPackage("..common..")
                    .should().haveSimpleNameEndingWith("Controller");

    @ArchTest
    static final ArchRule config_should_be_in_the_right_package =
            classes()
                    .that().haveSimpleNameEndingWith("Config")
                    .should().resideInAPackage(CONFIG_PACKAGE);

    @ArchTest
    static final ArchRule config_should_be_suffixed =
            classes()
                    .that().areAnnotatedWith(Configuration.class)
                    .should().haveSimpleNameEndingWith("Config");

    @ArchTest
    static final ArchRule domain_entities_should_be_in_the_right_package =
            classes()
                    .that().areAnnotatedWith(Entity.class)
                    .should().resideInAPackage(DOMAIN_PACKAGE);

    @ArchTest
    static final ArchRule domain_entities_should_not_be_suffixed =
            classes()
                    .that().areAnnotatedWith(Entity.class)
                    .or().resideInAPackage(DOMAIN_PACKAGE)
                    .should().haveSimpleNameNotEndingWith("Entity")
                    .andShould().haveSimpleNameNotEndingWith("Model");
}
