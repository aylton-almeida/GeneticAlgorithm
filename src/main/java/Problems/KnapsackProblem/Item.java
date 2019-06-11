package Problems.KnapsackProblem;

import Genetics.Gene;

import java.util.concurrent.atomic.AtomicInteger;

public class Item extends Gene {
    private static AtomicInteger nextId = new AtomicInteger();
    private double value;
    private double weight;

    public Item(double value, double weight) {
        super(nextId.incrementAndGet() + "", false);
        setValue(value);
        setWeight(weight);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
