package com.dksd.optimization;

/**
 *
 * @author dscottdawkins
 */
public interface FitnessFunction {

   double calcFitness(Particle p);

   int getDimension();

   double[] getDomain();

}
