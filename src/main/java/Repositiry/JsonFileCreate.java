package Repositiry;

import Toys.Toy;

import java.io.*;
import java.util.List;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

public class JsonFileCreate {
    private static final String filePath = "D:\\studies\\JAVA\\test_toy\\test.json";
    public static void write(List<Toy> toy) throws IOException {
        File f = new File("D:\\studies\\JAVA\\test_toy\\test.json");
        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(f, toy);
        for (Toy t : toy){
//            System.out.println(".... " + t);
            mapper.writeValue(f, t);}
        System.out.println("json created!");
//        for (Toy t : toy)
//            System.out.println(".... " + t);

    }

    public static Toy read() {

        try {
          ObjectMapper mapper = new ObjectMapper();
//        System.out.println("readValue " + mapper.readValue(new File(filePath), Toy.class));
//        return mapper.readValue(new File(filePath), Toy.class);
//            return mapper.readValue(new File (filePath), Toy.class);
            return mapper.readValue(new File (filePath), Toy.class);

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
