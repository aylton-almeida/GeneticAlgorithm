package Problems;

import Genetics.Gene;
import Genetics.Individual;
import Genetics.Population;

import java.util.Random;

public class KnapsackProblem extends Population {
    Individual fittest;
    Individual secondFittest;
    int generationCount = 0;
    Random rnd = new Random();

    public void startDemo(int size, int sackSize){
        //Generate the individuals inside the population
        for (int i = 0; i < size; i++)
            super.population.add(new Individual(sackSize));

        //Calculate the fitnessScore for each individual
        this.setFitnessScore();

        population.forEach(System.out::println);
    }

    protected void setFitnessScore() {
        for (Individual i : population){
            Gene[] genes = i.getChromosome();
            int activeGenes = 0;
            for (Gene gene : genes) {
                if (gene.isActive())
                    activeGenes++;
            }
            i.setFitnessScore(activeGenes);
        }
    }

    protected void selection() {

    }

    protected void crossover() {

    }

    protected void mutation() {

    }
}
