package Problems;

import Genetics.Gene;
import Genetics.Individual;
import Genetics.Population;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
    Generic algorithm in which individual has its fitness based
    on how many active genes it has
*/
public class Generic extends Population {

    @Override
    protected void computeFitnessScore() {
        for (Individual i : population) {
            Gene[] genes = i.getChromosome();
            int activeGenes = 0;
            for (Gene gene : genes) {
                if (gene.isActive())
                    activeGenes++;
            }
            i.setFitnessScore(activeGenes);
        }
    }

    //generate chromosomes for a new individual
    @Override
    public Individual generateIndividual(int chromosomeSize) {
        Gene[] genes = new Gene[chromosomeSize];
        for (int i = 0; i < chromosomeSize; i++)
            genes[i] = new Gene("Gene " + i, Math.random() < 0.5);
        return new Individual(genes);
    }
}
