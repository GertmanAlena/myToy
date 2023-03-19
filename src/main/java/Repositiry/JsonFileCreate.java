package Repositiry;

import Toys.Toy;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

public class JsonFileCreate {

    private static final String filePath = "D:\\studies\\JAVA\\test_toy\\test.json";

    public void write(List<Toy> allToys) throws IOException {
        File f = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(f, allToys);
    }
    public static ArrayList<Toy> read()  {
        ArrayList<Toy> allToy = null;
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st = br.readLine();
            String jsonFile = "";
            while (st != null) {
                jsonFile += st;
                st = br.readLine();
            }
            Gson gson = new Gson();
            Type secListType = new TypeToken<ArrayList<Toy>>() {
            }.getType();

            allToy = gson.fromJson(jsonFile, secListType);
            if (allToy != null) {
                System.out.println(allToy.size());

            }
            return allToy;
        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (JsonSyntaxException e) {
            System.out.println(e.getMessage());
            return allToy;
        }
    }

}

