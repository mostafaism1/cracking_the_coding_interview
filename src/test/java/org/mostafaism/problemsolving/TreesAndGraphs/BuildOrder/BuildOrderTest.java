package org.mostafaism.problemsolving.TreesAndGraphs.BuildOrder;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BuildOrderTest {
    /*
     * Testing strategy for {@code List<String> buildOrder(List<String> projects,
     * List<Entry<String, String>> dependencies)}
     * 
     * Cover the sub-domains of these partitions:
     * 
     * Partition on projects.size(): 0, 1, 2, > 2
     * 
     * Partition on dependencies.size(): 0, 1, 2, > 2
     * 
     * Partition on dependencies are cyclic: false, true
     * 
     * Partition on the maximum number of times the same project appears as a
     * dependee: 0, 1, > 1
     * 
     * * Partition on the maximum number of times the same project appears as a
     * dependent: 0, 1, > 1
     */

    private BuildOrder<String> buildOrder;
    private Set<String> projects;
    private Set<Entry<String, String>> dependencies;
    private String project1Name;
    private String project2Name;
    private String project3Name;
    private Map.Entry<String, String> dependency1;
    private Map.Entry<String, String> dependency2;
    private Map.Entry<String, String> dependency3;

    @BeforeEach
    void setup() {
        buildOrder = new BuildOrder<>();
        project1Name = "project1";
        project2Name = "project2";
        project3Name = "project3";
    }

    // Covers: projects.size() = 0, dependencies.size() = 0, cyclic dependencies =
    // false, max number a project appears as a dependee = 0, max number a project
    // appears as a dependent = 0.
    @Test
    void givenEmptyProjects_thenShouldReturnEmptyList() throws NoValidBuildOrderException {
        // Given.
        projects = Collections.emptySet();
        dependencies = Collections.emptySet();

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual).isEmpty();
    }

    // Covers: projects.size() = 1, dependencies.size() = 0, cyclic dependencies =
    // false, max number a project appears as a dependee = 0, max number a project
    // appears as a dependent = 0.
    @Test
    void givenASingleProjectAndNoDependencies_thenShouldReturnTheSingleProject() throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name);
        dependencies = Collections.emptySet();

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual).isEqualTo(new ArrayList<>(projects));
    }

    // Covers: projects.size() = 1, dependencies.size() = 1, cyclic dependencies =
    // true, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenASingleProjectAndASelfDependency_thenShouldThrowAnException() {
        // Given.
        projects = Set.of(project1Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project1Name);
        dependencies = Set.of(dependency1);

        // When, then.
        thenThrownBy(() -> buildOrder.buildOrder(projects, dependencies))
                .isInstanceOf(NoValidBuildOrderException.class);
    }

    // Covers: projects.size() = 2, dependencies.size() = 0, cyclic dependencies =
    // false, max number a project appears as a dependee = 0, max number a project
    // appears as a dependent = 0.
    @Test
    void givenProjectsOfSizeTwoAndNoDependencies_thenShouldReturnTheProjectsInAnyOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name);
        dependencies = Collections.emptySet();

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(actual.contains(project1Name)).isTrue();
        then(actual.contains(project2Name)).isTrue();
    }

    // Covers: projects.size() = 2, dependencies.size() = 2, cyclic dependencies =
    // false, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeTwoAndADependencyBetweenTheTwoProjects_thenShouldReturnTheProjectsInAValidOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependencies = Set.of(dependency1);

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(2);
        then(actual.get(0)).isEqualTo(project1Name);
        then(actual.get(1)).isEqualTo(project2Name);
    }

    // Covers: projects.size() = 2, dependencies.size() = 2, cyclic dependencies =
    // true, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeTwoAndACyclicDependencyBetweenTheTwoProjects_thenShouldThrowAnException() {
        // Given.
        projects = Set.of(project1Name, project2Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependency2 = new AbstractMap.SimpleEntry<>(project2Name, project1Name);
        dependencies = Set.of(dependency1, dependency2);

        // When, then.
        thenThrownBy(() -> buildOrder.buildOrder(projects, dependencies))
                .isInstanceOf(NoValidBuildOrderException.class);
    }

    // Covers: projects.size() > 2, dependencies.size() = 0, cyclic dependencies =
    // false, max number a project appears as a dependee = 0, max number a project
    // appears as a dependent = 0.
    @Test
    void givenProjectsOfSizeThreeAndNoDependencies_thenShouldReturnTheProjectsInAnyOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependencies = Collections.emptySet();

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.contains(project1Name)).isTrue();
        then(actual.contains(project2Name)).isTrue();
        then(actual.contains(project3Name)).isTrue();
    }

    // Covers: projects.size() > 2, dependencies.size() = 1, cyclic dependencies =
    // false, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeThreeAndASingleDependency_thenShouldReturnTheProjectsInAValidOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependencies = Set.of(dependency1);

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.contains(project1Name)).isTrue();
        then(actual.contains(project2Name)).isTrue();
        then(actual.contains(project3Name)).isTrue();
        then(actual.indexOf(project1Name)).isLessThan(actual.indexOf(project2Name));
    }

    // Covers: projects.size() > 2, dependencies.size() 2, cyclic dependencies =
    // false, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeThreeAndDependenciesOfSizeTwoAndMaxDependeesAre1AndMaxDependentsAre1_thenShouldReturnTheProjectsInAValidOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependency2 = new AbstractMap.SimpleEntry<>(project2Name, project3Name);
        dependencies = Set.of(dependency1, dependency2);

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.get(0)).isEqualTo(project1Name);
        then(actual.get(1)).isEqualTo(project2Name);
        then(actual.get(2)).isEqualTo(project3Name);
    }

    // Covers: projects.size() > 2, dependencies.size() = 2, cyclic dependencies =
    // false, max number a project appears as a dependee = 2, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeThreeAndDependenciesOfSizeTwoAndMaxDependeesAre2AndMaxDependentsAre1_thenShouldReturnTheProjectsInAValidOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependency2 = new AbstractMap.SimpleEntry<>(project1Name, project3Name);
        dependencies = Set.of(dependency1, dependency2);

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.get(0)).isEqualTo(project1Name);
        then(actual.contains(project2Name)).isTrue();
        then(actual.contains(project3Name)).isTrue();
    }

    // Covers: projects.size() > 2, dependencies.size() = 2, cyclic dependencies =
    // false, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 2.
    @Test
    void givenProjectsOfSizeThreeAndDependenciesOfSizeTwoAndMaxDependeesAre1AndMaxDependentsAre2_thenShouldReturnTheProjectsInAValidOrder()
            throws NoValidBuildOrderException {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project2Name, project1Name);
        dependency2 = new AbstractMap.SimpleEntry<>(project3Name, project1Name);
        dependencies = Set.of(dependency1, dependency2);

        // When.
        List<String> actual = buildOrder.buildOrder(projects, dependencies);

        // Then.
        then(actual.size()).isEqualTo(3);
        then(actual.contains(project2Name)).isTrue();
        then(actual.contains(project3Name)).isTrue();
        then(actual.get(2)).isEqualTo(project1Name);
    }

    // Covers: projects.size() > 2, dependencies.size() = 2, cyclic dependencies =
    // true, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeThreeAndCyclicDependenciesOfSizeTwo_thenShouldReturnTheProjectsInAValidOrder() {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependency2 = new AbstractMap.SimpleEntry<>(project2Name, project1Name);
        dependencies = Set.of(dependency1, dependency2);

        // When, then.
        thenThrownBy(() -> buildOrder.buildOrder(projects, dependencies))
                .isInstanceOf(NoValidBuildOrderException.class);
    }

    // Covers: projects.size() > 2, dependencies.size() > 2, cyclic dependencies =
    // true, max number a project appears as a dependee = 1, max number a project
    // appears as a dependent = 1.
    @Test
    void givenProjectsOfSizeThreeAndCyclicDependenciesOfSizeThree_thenShouldReturnTheProjectsInAValidOrder() {
        // Given.
        projects = Set.of(project1Name, project2Name, project3Name);
        dependency1 = new AbstractMap.SimpleEntry<>(project1Name, project2Name);
        dependency2 = new AbstractMap.SimpleEntry<>(project2Name, project3Name);
        dependency3 = new AbstractMap.SimpleEntry<>(project3Name, project1Name);
        dependencies = Set.of(dependency1, dependency2, dependency3);

        // When, then.
        thenThrownBy(() -> buildOrder.buildOrder(projects, dependencies))
                .isInstanceOf(NoValidBuildOrderException.class);
    }

}
