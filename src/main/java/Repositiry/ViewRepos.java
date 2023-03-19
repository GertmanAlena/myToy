package Repositiry;

import Toys.Toy;

import java.io.IOException;
import java.util.List;

public interface ViewRepos {

//    List<Toy> createToy(String name, int count, int weight) throws IOException, org.json.simple.parser.ParseException;

    List<Toy> createToy(String name, int count, int weight, String type) throws IOException, org.json.simple.parser.ParseException;

    int createId(List<Toy> allToys);

    List<Toy> load() throws IOException, org.json.simple.parser.ParseException;

    List<Toy> delToy(List<Toy> allToys) throws IOException;

    List<Toy> clearTheList(List<Toy> allToys) throws IOException;


}
