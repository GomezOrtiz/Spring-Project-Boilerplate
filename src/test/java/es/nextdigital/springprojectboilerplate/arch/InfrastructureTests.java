package es.nextdigital.springprojectboilerplate.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.data.jpa.repository.JpaRepository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = BaseArchTest.BASE_PACKAGE, importOptions = { ImportOption.DoNotIncludeTests.class })
public class InfrastructureTests extends BaseArchTest {

    @ArchTest
    static final ArchRule infrastructure_should_only_be_accessed_from_application_services =
        classes()
                .that().resideInAPackage(INFRASTRUCTURE_PACKAGE)
                .or().areAssignableTo(JpaRepository.class)
                .should().onlyBeAccessed().byAnyPackage(APPLICATION_PACKAGE, INFRASTRUCTURE_PACKAGE);

    @ArchTest
    static final ArchRule infrastructure_should_not_depend_on_application_services_or_controllers =
        noClasses()
                .that().resideInAPackage(INFRASTRUCTURE_PACKAGE)
                .or().areAssignableTo(JpaRepository.class)
                .should().dependOnClassesThat().resideInAnyPackage(APPLICATION_PACKAGE, REST_PACKAGE);
}
