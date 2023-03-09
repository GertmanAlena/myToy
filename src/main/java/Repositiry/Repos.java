package Repositiry;

import GroupIterator.GroupIterator;
import Toys.Toy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Repos implements Iterable<Toy> {
    int id = 0;
    private List<Toy> allToys = new ArrayList<>();
    public static List<Toy> allToys2 = new ArrayList<>();

    public List<Toy> createToy(String name, int count, int weight) throws IOException {
        Toy t = new Toy(name, count, weight);
        t.setId(++id);
        t.setProbability(weight);
        allToys.add(t);
        for (Toy toy1 : allToys)
            System.out.println("добавили новую игрушку в лист " + toy1);

//        allToys2 = load();
//
//        for (Toy toy2: allToys2) {
//            Toy tRead = new Toy();
//            tRead.setId(toy2.getId());
//            tRead.setName(toy2.getName());
//            tRead.setCount(toy2.getCount());
//            tRead.setWeight(toy2.getWeight());
//            tRead.setProbability(toy2.getProbability());
//            System.out.println("tRead -- " + tRead);
//            allToys.add(tRead);
//        }
////        for (Toy toy3 : allToys)
////            System.out.println("toy 3 -- " + toy3);

        return allToys;
    }

    public List<Toy> load() {
        System.out.println("1 ..");
        allToys2 = Collections.singletonList(JsonFileCreate.read());

        for (Toy toy2: allToys2) {
            Toy tRead = new Toy();
            tRead.setId(toy2.getId());
            tRead.setName(toy2.getName());
            tRead.setCount(toy2.getCount());
            tRead.setWeight(toy2.getWeight());
            tRead.setProbability(toy2.getProbability());
            System.out.println("прочитали игрушку -- " + tRead);
            allToys.add(tRead);
        }
        for (Toy toy2 : allToys)
            System.out.println("добавили прочитанную в лист -- " + toy2);

        return allToys;

    }


    @Override
    public Iterator<Toy> iterator() {
        return new GroupIterator(allToys);
    }


}
