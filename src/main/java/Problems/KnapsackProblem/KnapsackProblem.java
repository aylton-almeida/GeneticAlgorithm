package Problems.KnapsackProblem;

import Genetics.Gene;
import Genetics.Individual;
import Genetics.Population;

import java.util.List;

/*
    Algorithm with the purpose to solve the knapsack problem
*/
public class KnapsackProblem extends Population {
    private double capacity;
    private List<Item> itemList;

    public KnapsackProblem(double capacity, List<Item> itemList) {
        setCapacity(capacity);
        setItemList(itemList);
    }

    @Override
    protected void computeFitnessScore() {
        for (Individual i : population) {
            Gene[] genes = i.getChromosome();
            double totalWeight = 0;
            double pontuation = 0;
            for (Gene g : genes) {
                if (g.isActive()) {
                    totalWeight += ((Item) g).getWeight();
                    pontuation += ((Item) g).getValue();
                }
            }
            if (totalWeight > capacity)
                i.setFitnessScore(-1);
            else
                i.setFitnessScore((int) pontuation);
        }
    }

    //generate chromosomes for a new individual
    @Override
    public Individual generateIndividual(int chromosomeSize) {
        Gene[] genes = new Gene[itemList.size()];
        for (int i = 0; i < itemList.size(); i++)
            genes[i] = itemList.get(i);
        for (int i = 0; i < chromosomeSize; i++)
            genes[i].setActive(Math.random() < 0.5);
        return new Individual(genes);
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
}
