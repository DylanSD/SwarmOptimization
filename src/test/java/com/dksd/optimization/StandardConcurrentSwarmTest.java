package com.dksd.optimization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author dscottdawkins
 */
public class StandardConcurrentSwarmTest {

    private StandardConcurrentSwarm swarm;

    private FitnessFunction ff;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ff = new FitnessFunctionParabolic();
        swarm = new StandardConcurrentSwarm(ff, 1);
        swarm.setExecutorService(executorService);
    }

    @Test
    public void stepUntilConvergedTest() throws InterruptedException {
        boolean ans = swarm.step();
        Assert.assertFalse(ans);
        for (int i = 0;i < 1000 && !ans; i++) {
            ans = swarm.step();
        }
        Assert.assertTrue(ans);
    }
}