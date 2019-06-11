package Genetics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class Population {
    protected List<Individual> population = new ArrayList<>();
    private List<Individual> fittest = new ArrayList<>();
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
            System.out.println("Generation: " + this.generationCount + " Fittest: " + fittest.get(0));
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
    private void selection() {
        //Define k, that will decide how many individuals will stay
        int k = rnd.nextInt(population.size() / 2);

        //Select most fit individuals
        for (int i = 0; i < k; i++) {
            fittest.add(population.stream().max(Comparator.comparingInt(Individual::getFitnessScore)).get());
            population.remove(population.stream().max(Comparator.comparingInt(Individual::getFitnessScore)).get());
            population.remove(population.stream().min(Comparator.comparingInt(Individual::getFitnessScore)).get());
        }
    }


    /*
        Crossover is the most significant phase in a genetic algorithm.
        For each pair of parents a crossover point is chosen at random.
        Offspring are created by exchangin the genes of parents among themselves
        until the crossover point is reached.
        At the end the new offspring are added to the population
    */
    private void crossover() {
        //Select offSring
        int offSpring = rnd.nextInt(population.get(0).getChromosome().length);

        //Swap values among parents
        for (int i = 0; i < offSpring; i++) {
            Gene temp = fittest.get(0).getChromosome()[i];
            fittest.get(0).getChromosome()[i] = fittest.get(1).getChromosome()[i];
            fittest.get(1).getChromosome()[i] = temp;
        }
    }

    /*
        In each offspring formed, there is a low random probability that a
        mutation occurs. Which means that some of the genes are flipped.
    */
    private void mutation() {
        //Select a random mutation point
        int mutationPoint = rnd.nextInt(population.get(0).getChromosome().length);

        //Flip values at the mutation pint
        if (fittest.get(0).getChromosome()[mutationPoint].isActive())
            fittest.get(0).getChromosome()[mutationPoint].setActive(false);
        else
            fittest.get(0).getChromosome()[mutationPoint].setActive(true);

        mutationPoint = rnd.nextInt(population.get(0).getChromosome().length);

        if (fittest.get(1).getChromosome()[mutationPoint].isActive())
            fittest.get(1).getChromosome()[mutationPoint].setActive(false);
        else
            fittest.get(1).getChromosome()[mutationPoint].setActive(true);
    }

    /*
        Generate individuals that will be tested
    */
    protected abstract Individual generateIndividual(int chromosomeSize);
}
