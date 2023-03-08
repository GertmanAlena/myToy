package UI;
import Presenter.PresenterToy;

import java.util.Scanner;
import java.util.function.Function;

public class ConsoleUI implements ConUi {
    private PresenterToy presenter;
    private static Scanner scanner;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void SetPresenterToy(PresenterToy presenter) {
        this.presenter = presenter;
    }
    @Override
    public void start() throws Exception {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.println("\033[1;34m***Выбирай, что будем делать***\033[0m");
                System.out.println("\033[1;34m1\033[0m - Добавить новую игрушку \033[1;34m2\033[0m - Начать розыгрыш " +
                        "\033[1;34m3\033[0m - Посмотреть список разыгрываемых игрушек" + "\n\033[1;35mДля выхода нажмите (0)\033[0m");
                String key = scan.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.createToy(getName(), getCount(), getWidth());
                    case "0":
                        System.exit(0);
                    case "3":
                        presenter.readToy();
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }
        }
    }

    @Override
    public String getName() {
        String name = input("Введите название игрушек : ", v -> v);
        return name;
    }
    @Override
    public int getCount() {
        Integer count = input("Введите количество поступивших игрушек : ", Integer::valueOf);
        return count;
    }

    @Override
    public int getWidth() {
        Integer count = input("Введите вес одной новой поступившей игрушки (кг) : ", Integer::valueOf);
        return count;

    }

    private static <T> T input(String message, Function<String, T> converter) {
        while (true) {
            try {
                System.out.println(message);
                return converter.apply(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Вероятно, вы ввели недопустимый формат данных ");
            }
        }
    }
}
