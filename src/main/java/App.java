import Problems.Generic;
import Problems.KnapsackProblem.Item;
import Problems.KnapsackProblem.KnapsackProblem;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(100, 1.2));
        items.add(new Item(200, 2));
        items.add(new Item(300, 3.1));
        items.add(new Item(400, 4.2));
        items.add(new Item(500, 4.8));
        items.add(new Item(600, 5.9));
        items.add(new Item(700, 6.9));
        KnapsackProblem demo = new KnapsackProblem(11, items);
        demo.startDemo(16, items.size(), 40);


    }
}
