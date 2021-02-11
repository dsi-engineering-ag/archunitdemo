package ch.dsi.archunitdemo;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import java.net.URL;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.Configurations.consideringOnlyDependenciesInDiagram;
import static com.tngtech.archunit.library.plantuml.PlantUmlArchCondition.adhereToPlantUmlDiagram;


@AnalyzeClasses(packages = "ch.dsi.archunitdemo")
public class ArchitectureTest {

    static URL myDiagram = ArchitectureTest.class.getResource("/component-diagram.puml");

    @ArchTest
    static final ArchRule conformToComponentDiagram = classes()
            .should(adhereToPlantUmlDiagram(myDiagram, consideringOnlyDependenciesInDiagram()));


    @ArchTest
    public static final ArchRule noCycles = slices()
            .matching("ch.dsi.archunitdemo.(**)")
            .should().beFreeOfCycles();


    @ArchTest
    static final ArchRule zeroDependencyOfDomain = classes().that()
            .resideInAPackage("..domain..")
            .should().onlyDependOnClassesThat().resideInAnyPackage( "..domain..","java..");

    @ArchTest
    static final ArchRule domainOnlyAccessedByService = classes().that()
            .resideInAPackage("..domain..")
            .should().onlyHaveDependentClassesThat()
            .resideInAnyPackage("..service..");




}