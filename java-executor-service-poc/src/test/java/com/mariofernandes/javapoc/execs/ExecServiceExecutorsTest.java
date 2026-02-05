package com.mariofernandes.javapoc.execs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.ExecutorService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ExecServiceExecutorsTest {

    @Mock
    private ExecutorService executorService;

    @InjectMocks
    private ExecServiceExecutors execServiceExecutors;

    @BeforeEach
    void setup() {
        execServiceExecutors = Mockito.spy(ExecServiceExecutors.class);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test Operations of Executor Service: basicSingleThreadExecutor")
    void testBasicSingleThreadExecutor_Should() {
        try {
            var result = execServiceExecutors.basicSingleThreadExecutor();

            Assertions.assertTrue(result);
            Assertions.assertTrue(execServiceExecutors.getThreadName().startsWith("pool-"));
            Assertions.assertTrue(execServiceExecutors.getThreadName().endsWith("-thread-1"));
            verify(executorService, times(1)).isShutdown();
            verify(executorService, times(1)).shutdown();

        } catch (InterruptedException e) {
            Assertions.fail("The test was interrupted: " + e.getMessage());
        }
    }
}
