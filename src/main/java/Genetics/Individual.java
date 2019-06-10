package Genetics;

public class Individual {
    private Gene[] chromosome;
    private int fitnessScore;

    public Individual(int geneNumber){
        generateChromosomes(geneNumber);
    }

    public Individual(Gene[] chromosome){
        setChromosome(chromosome);
    }

    public Gene[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(Gene[] chromosome) {
        this.chromosome = chromosome;
    }

    public void generateChromosomes(int geneNumber) {
        this.chromosome = new Gene[geneNumber];
        for (int i = 0; i < geneNumber; i++)
            chromosome[i] = new Gene("Gene " + i, Math.random() < 0.5);

    }

    public int getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(int fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    @Override
    public String toString(){
        return
    }
}
