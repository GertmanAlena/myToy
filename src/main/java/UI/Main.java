package UI;

import Presenter.PresenterToy;
import Repositiry.Repos;

public class Main {
    public static void main(String[] args) throws Exception {
        ConUi cu = new ConsoleUI();
        Repos repos = new Repos();
        PresenterToy presenter = new PresenterToy(cu, repos);
        cu.start();

    }
}