package Genetics;

import java.util.ArrayList;
import java.util.List;

public abstract class Population {
    protected List<Individual> population = new ArrayList<Individual>();

    /*
        Gives each individual a fitness score, the probability
        that an individual will be selected for reprodution
        is based on tis fitness score
    */
    protected abstract void setFitnessScore();

    /*
        The selection phase is when the fittest individuals are
        selected to breed and pass their genes to the next generation.
        Two pairs of individuals(parents) are selected base on their
        fitness scores
    */
    protected abstract void selection();


    /*
        Crossover is the most significant phase in a genetic algorithm.
        For each pair of parents a crossover point is chosen at random.
        Offspring are created by exchangin the genes of parents among themselves
        until the crossover point is reached.
        At the end the new offspring are added to the population
    */
    protected abstract void crossover();

    /*
        In each offspring formed, there is a low random probability that a
        mutation occurs. Which means that some of the genes are flipped.
    */
    protected abstract void mutation();

}
