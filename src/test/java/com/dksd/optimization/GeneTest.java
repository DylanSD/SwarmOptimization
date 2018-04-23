package com.dksd.optimization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests genotype representation of the solution.
 *
 * @author dscottdawkins
 */
public class GeneTest {

    private Gene gene;

    @Before
    public void setUp() throws Exception {
        gene = new Gene(1);
    }

    @Test
    public void copyInto() {
        Gene newGene = new Gene(1);
        gene.setValue(0, -1);
        gene.copyInto(newGene);
        Assert.assertEquals(-1, newGene.getValue(0), 0.0001);
    }
}