package Repositiry;

import Toys.Toy;

import java.io.*;
import java.util.List;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileCreate {
    private static final String filePath = "D:\\studies\\JAVA\\test_toy\\test.json";
    public static void write(List<Toy> toy) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        for (Toy t : toy)
//            System.out.println(".... " + t);
            mapper.writeValue(new File(filePath), t);
            System.out.println("json created!");
    }

    public static Toy read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("readValue " + mapper.readValue(new File(filePath), Toy.class));
//        return mapper.readValue(new File(filePath), Toy.class);
        return mapper.readValue(new File(filePath), Toy.class);
    }

}
