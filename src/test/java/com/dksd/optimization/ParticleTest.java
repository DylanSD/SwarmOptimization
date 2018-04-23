package com.dksd.optimization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the particle and how it flies through the search space.
 *
 * @author dscottdawkins
 */
public class ParticleTest {

    /** Class under test. */
    private Particle particle;

    /** Fitness function to evaluate the particles fitness. */
    private FitnessFunction ff;

    /** Sets up the test. */
    @Before
    public void setUp() throws Exception {
        ff = new FitnessFunctionParabolic();
        particle = new Particle(ff);
    }


    @Test
    public void initParticleTest() {
        double[] domain = new double[1];
        domain[0] = 1;
        for (int i = 0; i < 1000; i++) {//test lots of times
            particle.init(domain);
            if (Math.abs(particle.getGene().getValue(0)) > domain[0]) {
                Assert.fail("Particle initialization value cannot be outside the set domain [-1,1]");
            }
        }
    }

    @Test
    public void particleShouldSeeGbestOnFirstStepTest() {
        double[] domain = new double[1];
        domain[0] = 1;
        Particle gbest = new Particle(ff);
        gbest.init(domain);
        gbest.getGene().setValue(0, 0.0);//Set to optimal value
        particle.update(gbest.getGene());

        //Should have converged here to zero as that gives the smallest fitness value.
        Assert.assertEquals(0, particle.getGene().getValue(0), 0.0001);
        Assert.assertEquals(0, particle.getFitness(), 0.0001);
    }
}