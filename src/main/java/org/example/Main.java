package org.example;

import UI.ConUi;
import UI.ConsoleUI;
import Presenter.PresenterToy;
import Repositiry.Repos;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            ConUi cu = new ConsoleUI();
            Repos repos = new Repos();
            PresenterToy presenter = new PresenterToy(cu, repos);
            cu.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}