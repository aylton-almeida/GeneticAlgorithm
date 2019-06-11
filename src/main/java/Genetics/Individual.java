package Genetics;

import java.util.concurrent.atomic.AtomicInteger;

public class Individual {
    private static AtomicInteger nextId = new AtomicInteger();
    private int id;
    private Gene[] chromosome;
    private int fitnessScore;

    public Individual(Gene[] chromosome) {
        setChromosome(chromosome);
        id = nextId.incrementAndGet();
    }

    public Individual(Gene[] chromosome, int id, int fitnessScore) {
        setChromosome(chromosome);
        this.id = id;
        setFitnessScore(fitnessScore);
    }

    public int getId() {
        return id;
    }

    public Gene[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(Gene[] chromosome) {
        this.chromosome = chromosome;
    }

    public int getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(int fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(id).append("] - {");
        for (Gene g : chromosome)
            stringBuilder.append(g.isActive()).append("|");
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("} - ").append(this.fitnessScore);
        return stringBuilder.toString();
    }
}
