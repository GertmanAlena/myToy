package UI;
import Presenter.PresenterToy;

import java.util.Scanner;
import java.util.function.Function;

public class ConsoleUI implements ConUi {
    private PresenterToy presenter;
    private static Scanner scanner;
    public Integer countToy = 0;

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
                        "\033[1;34m3\033[0m - Посмотреть список всех игрушек" + "\n" + "\033[1;34m4\033[0m - Удалить все игрушки " +
                        "\033[1;34m5\033[0m - Удалить выбранную игрушку" + "\n\033[1;35mДля выхода нажмите (0)\033[0m");
                String key = scan.next();
                System.out.print("\033[H\033[J");
                switch (key) {
                    case "1":
                        presenter.createToy(getName(), getCount(), getWidth(), createType(1));
                        break;
                    case "2":
                        countToy = presenter.giveaway(createType(2));
                        presenter.play(RandNam(countToy));
                        break;
                    case "0":
                        System.out.println("До скорых встреч!");
                        System.exit(0);
                        break;
                    case "3":
                        presenter.readToy();
                        break;
                    case "4":
                        presenter.clearTheList();
                        break;
                    case "5":
                        presenter.delToy();
                        break;
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

    /**
     * метод принимает введённое число и в первом случае вносим указанный тип игрушки
     * во втором случае, по выбранному типу разыгрываем игрушки
     * @param num тип игрушки, определяемый через switch
     */
    @Override
    public String createType(Integer num) {
        Scanner scan = new Scanner(System.in);
        if (num == 1){
            System.out.println("\033[1;33mКакого типа игрушка?\033[0m");
        }
        if (num == 2){
            System.out.println("\033[1;33mКакие игрушки будем разыгрывать?\033[0m");
        }
        System.out.println("\033[1;34m1\033[0m - Мягкая \033[1;34m2\033[0m -Пластмассовая " +
                "\033[1;34m3\033[0m - Резиновая" + "\n" + "\033[1;34m4\033[0m - Развивающая ");
        String key = scan.next();
        System.out.print("\033[H\033[J");
        switch (key) {
            case "1":
                key = "Мягкая";
                break;
            case "2":
                key = "Пластмассовая";
                break;
            case "3":
                key = "Резиновая";
                break;
            case "4":
                key = "Развивающая";
                break;
            default:
                System.out.println("Такой команды нет");
                break;
        }
        return key;
    }

    /**
     * метод для ввода числа игроком, по которому будет разыгрываться игрушка
     * @param num
     * @return
     */
    @Override
    public Integer RandNam(Integer num) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\033[1;33mВыбери число от 1 до" + num + "\033[0m");
        Integer number = scan.nextInt();
        System.out.print("\033[H\033[J");
        return number;
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
