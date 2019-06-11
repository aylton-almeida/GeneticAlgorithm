package Genetics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class Population {
    protected List<Individual> population = new ArrayList<>();
    private Individual[] fittest = new Individual[2];
    private int generationCount = 1;
    private Random rnd = new Random();

    /*
        Starts the demo tests
    */
    public void startDemo(int populationSize, int chromosomeSize, int numberGenerations) {
        //Generate the individuals inside the population
        for (int i = 0; i < populationSize; i++)
            population.add(generateIndividual(chromosomeSize));

        //Calculate the fitnessScore for each individual
        this.computeFitnessScore();
        for (int i = 0; i < numberGenerations; i++) {
            selection();
            crossover();
            if (rnd.nextInt() % 7 < 5)
                mutation();
            computeFitnessScore();
            System.out.println("Generation: " + this.generationCount + " Fittest: " + fittest[0]);
            generationCount++;
        }
    }

    /*
        Gives each individual a fitness score, the probability
        that an individual will be selected for reprodution
        is based on tis fitness score
    */
    protected abstract void computeFitnessScore();

    /*
        The selection phase is when the fittest individuals are
        selected to breed and pass their genes to the next generation.
        Two pairs of individuals(parents) are selected base on their
        fitness scores
    */
    protected void selection() {
        //Select most fit individuals
        fittest[0] = population.stream().max(Comparator.comparingInt(Individual::getFitnessScore)).get();
        fittest[1] = population.stream().filter(individual -> !individual.equals(fittest[0])).max(Comparator.comparingInt(Individual::getFitnessScore)).get();
    }


    /*
        Crossover is the most significant phase in a genetic algorithm.
        For each pair of parents a crossover point is chosen at random.
        Offspring are created by exchangin the genes of parents among themselves
        until the crossover point is reached.
        At the end the new offspring are added to the population
    */
    protected void crossover() {
        //Select offSring
        int offSpring = rnd.nextInt(population.get(0).getChromosome().length);

        //Swap values among parents
        for (int i = 0; i < offSpring; i++) {
            Gene temp = fittest[0].getChromosome()[i];
            fittest[0].getChromosome()[i] = fittest[1].getChromosome()[i];
            fittest[1].getChromosome()[i] = temp;
        }
    }

    /*
        In each offspring formed, there is a low random probability that a
        mutation occurs. Which means that some of the genes are flipped.
    */
    protected void mutation() {
        //Select a random mutation point
        int mutationPoint = rnd.nextInt(population.get(0).getChromosome().length);

        //Flip values at the mutation pint
        if (fittest[0].getChromosome()[mutationPoint].isActive())
            fittest[0].getChromosome()[mutationPoint].setActive(false);
        else
            fittest[0].getChromosome()[mutationPoint].setActive(true);

        mutationPoint = rnd.nextInt(population.get(0).getChromosome().length);

        if (fittest[1].getChromosome()[mutationPoint].isActive())
            fittest[1].getChromosome()[mutationPoint].setActive(false);
        else
            fittest[1].getChromosome()[mutationPoint].setActive(true);
    }

    /*
        Generate individuals that will be tested
    */
    protected abstract Individual generateIndividual(int chromosomeSize);
}
