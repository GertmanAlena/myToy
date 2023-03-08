package Presenter;

import Repositiry.JsonFileCreate;
import Repositiry.Repos;
import UI.ConUi;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;


public class PresenterToy {

    JsonFileCreate jsonFileCreate = new JsonFileCreate();
    private final ConUi cu;
    private final Repos repos;

    public PresenterToy(ConUi cu, Repos repos) {
        this.cu = cu;
        this.repos = repos;
        cu.SetPresenterToy(this);
    }

    public void createToy(String name, int count, int weight) throws Exception {
        jsonFileCreate.write(repos.createToy(name, count, weight));

    }

    public void readToy() throws IOException, ParseException {
        jsonFileCreate.read();
        }


}
