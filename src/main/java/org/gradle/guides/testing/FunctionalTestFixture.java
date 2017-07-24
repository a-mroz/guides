package org.gradle.guides.testing;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;

import java.io.File;

public interface FunctionalTestFixture {

    /**
     * Initializes fixture. Needs to be called before any other operations.
     */
    void initialize();

    /**
     * Tears down fixture. To be called after fixture is not needed anymore.
     */
    void tearDown();

    /**
     * Returns the {@link org.gradle.testkit.runner.GradleRunner} instance used to execute build.
     *
     * @return The Gradle runner instance
     */
    GradleRunner getGradleRunner();

    /**
     * Executes build for provided arguments and expects it finish successfully.
     *
     * @param arguments Arguments
     * @return Build result
     */
    BuildResult succeeds(String... arguments);

    /**
     * Executes build for provided arguments and expects it fail.
     *
     * @param arguments Arguments
     * @return Build result
     */
    BuildResult fails(String... arguments);

    /**
     * Returns the root directory for a test.
     *
     * @return Root test directory
     */
    File getTestDirectory();

    /**
     * Create a new file with the given path.
     *
     * @param path Path
     * @return The created file
     */
    File file(String path);

    /**
     * Create a new directory with the given path.
     *
     * @param path Path
     * @return The created directory
     */
    File dir(String... path);

    /**
     * Creates build file if it doesn't exist yet and returns it.
     *
     * @return The build file
     */
    File getBuildFile();

    /**
     * Creates settings file if it doesn't exist yet and returns it.
     *
     * @return The build file
     */
    File getSettingsFile();
}
