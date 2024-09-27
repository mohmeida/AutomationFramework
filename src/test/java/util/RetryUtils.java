package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.system.cucumber.glue.helpers.BaseTest.takeScreenshot;

public class RetryUtils {

    private static final Logger logger = LoggerFactory.getLogger(RetryUtils.class);

    public static void doWithRetry(Runnable task, String taskDescription, int maxAttempts, long retryDelayMillis) {
        int attempt = 0;
        while (attempt < maxAttempts) {
            try {
                attempt++;
                logger.info("Attempting task: {} (Attempt {}/{})", taskDescription, attempt, maxAttempts);

                task.run(); // Execute the task

                // Capture screenshot after successful task
                takeScreenshot(taskDescription + "_Success");
                logger.info("Task '{}' completed successfully on attempt {}", taskDescription, attempt);

                return; // If the task succeeds, exit the function
            } catch (Exception e) {
                // Capture screenshot on failure
                takeScreenshot(taskDescription + "_Failed_Attempt_" + attempt);

                logger.error("Error occurred while performing '{}': {}", taskDescription, e.getMessage());

                if (attempt >= maxAttempts) {
                    logger.error("Max attempts reached for task '{}'. Failing the operation.", taskDescription);
                    throw e; // Re-throw the exception after max attempts
                }

                try {
                    Thread.sleep(retryDelayMillis); // Wait before retrying
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Restore the interrupted status
                    throw new RuntimeException("Task retry interrupted", ie);
                }
            }
        }
    }

}
