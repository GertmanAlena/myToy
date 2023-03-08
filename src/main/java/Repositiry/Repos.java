package Repositiry;

import GroupIterator.GroupIterator;
import Toys.Toy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repos implements Iterable<Toy> {
    int id = 0;
    private List<Toy> allToys = new ArrayList<>();

    public List<Toy> createToy(String name, int count, int weight){
        Toy t = new Toy(name, count, weight);
        t.setId(++id);
        System.out.println("id " + id + " name " + name + " count " + count + " weight " + weight);

        t.setProbability(weight);
        allToys.add(t);
//        for (Toy toy : allToys)
//            System.out.println(toy);
        return allToys;
    }

    @Override
    public Iterator<Toy> iterator() {
        return new GroupIterator(allToys);
    }


}
