package es.nextdigital.springprojectboilerplate.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import javax.persistence.Entity;

import static com.tngtech.archunit.core.domain.JavaModifier.ABSTRACT;
import static com.tngtech.archunit.core.domain.JavaModifier.FINAL;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = BaseArchTest.BASE_PACKAGE, importOptions = {ImportOption.DoNotIncludeTests.class})
public class DomainTests extends BaseArchTest {

    @ArchTest
    static final ArchRule domain_classes_should_be_abstract_or_final =
            classes()
                    .that().areAnnotatedWith(Entity.class)
                    .or().resideInAPackage(DOMAIN_PACKAGE)
                    .and().haveSimpleNameNotEndingWith("Builder")
                    .should().haveModifier(FINAL)
                    .orShould().haveModifier(ABSTRACT);

    @ArchTest
    static final ArchRule all_fields_in_domain_classes_should_be_private_and_final =
            fields()
                    .that().areDeclaredInClassesThat().areAnnotatedWith(Entity.class)
                    .or().areDeclaredInClassesThat().resideInAPackage(DOMAIN_PACKAGE)
                    .and().areDeclaredInClassesThat().areNotEnums()
                    .and().areDeclaredInClassesThat().haveSimpleNameNotEndingWith("Builder")
                    .and().areDeclaredInClassesThat().doNotHaveSimpleName("Auditable")
                    .should().beFinal()
                    .andShould().bePrivate();

    @ArchTest
    static final ArchRule domain_classes_should_only_be_accessed_by_application_services =
            classes()
                    .that().areAnnotatedWith(Entity.class)
                    .or().resideInAPackage(DOMAIN_PACKAGE)
                    .should().onlyBeAccessed().byAnyPackage(DOMAIN_PACKAGE, APPLICATION_PACKAGE, INTEGRATION_PACKAGE);

    @ArchTest
    static final ArchRule domain_should_not_depend_on_any_other_layer =
            noClasses()
                    .that().areAnnotatedWith(Entity.class)
                    .or().resideInAPackage(DOMAIN_PACKAGE)
                    .should().dependOnClassesThat().resideInAnyPackage(REST_PACKAGE, INFRASTRUCTURE_PACKAGE, APPLICATION_PACKAGE);
}
