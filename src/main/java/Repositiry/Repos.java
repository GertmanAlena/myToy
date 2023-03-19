package Repositiry;

import GroupIterator.GroupIterator;
import Toys.Toy;

import java.io.IOException;
import java.util.*;

public class Repos implements Iterable<Toy>, ViewRepos {
    /**
     * @allToys лист всех игрушек
     * @playableToys лист игрушек для игры
     */
    private List<Toy> allToys = new ArrayList<>();
    private List<Toy> playableToys = new ArrayList<>();
    JsonFileCreate jsonFileCreate = new JsonFileCreate();
    public Integer winId;

    /**
     * метод создания игрушки
     * @param name имя игрушки
     * @param count количество игрушек
     * @param weight вес игрушки
     * @param type тип игрушки
     * @allToys лист всех игрушек
     */
    @Override
    public List<Toy> createToy(String name, int count, int weight, String type){

        allToys = jsonFileCreate.read();

        if (allToys != null) {
            for (Toy t : allToys) {
                System.out.println(t);
            }
            Toy t = new Toy(name, count, weight, type);
            t.setId(createId(allToys));
//            t.setType(createType(allToys));
            t.setProbability(weight);
            allToys.add(t);
            return allToys;
        } else {
            List<Toy> allToys = new ArrayList<>();
            Toy t = new Toy(name, count, weight, type);
            t.setProbability(weight);
            t.setId(0);
//            t.setType(createType(allToys));
            allToys.add(t);
            System.out.println("t " + t);
            return allToys;
        }
    }
    @Override
    public int createId(List<Toy> allToys) {
        int i = 0;
        for (; i < allToys.size(); i++) {
            if (allToys.get(i).getId() == i){
                System.out.println("--");
            }
            else if (i == allToys.size()-1) {
                return i+1;
            }
            else {
                return i;
            }
        }
        return i;
    }

    /**
     * метод загрузки из файла
     * @return
     * @throws IOException
     * @throws org.json.simple.parser.ParseException
     */
    @Override
    public List<Toy> load() throws IOException, org.json.simple.parser.ParseException {
        allToys = jsonFileCreate.read();
        if (allToys.size() == 0){
            System.out.println("Список пуст, заполни его игрушками");
        }
        if (allToys != null) {
            for (Toy t : allToys) {
                System.out.println(t);
            }
        }
        return allToys;
    }

    /**
     * метод удаления игрушки
     * @param allToys лист всех игрушек
     * @return @param allToys лист всех игрушек
     * @throws IOException
     */
    @Override
    public List<Toy> delToy(List<Toy> allToys) throws IOException {
        String nameToy = " ";
        System.out.println("\033[1;32m выбери игрушку, которую нужно удалить и напиши её ID \033[0m");
        Scanner scan = new Scanner(System.in);
        for (Toy toy: allToys) {
            System.out.println("если нужно удалить игрушку " + "<" + "\033[1;34m"+toy.getName()+"\033[0m" + "> " +
                    " " + "нажми цифру " + "\033[1;31m"+toy.getId()+"\033[0m");
        }
        Integer key = scan.nextInt();

        for (int i = 0; i < allToys.size(); i++) {
            if (allToys.get(i).getId() == key) {
                System.out.println("--- " + allToys.get(i));
                nameToy = allToys.get(i).getName();
                allToys.remove(allToys.get(i));

            }
        }
        System.out.println("Удалили " + nameToy);
        return allToys;
    }

    /**
     * метод удаления всех игрушек
     * @param allToys список всех игрушек
     * @return allToys пустой лист
     * @throws IOException
     */
    @Override
    public List<Toy> clearTheList(List<Toy> allToys) throws IOException {
        allToys.clear();
        System.out.println("Удалили все игрушки!!!...");
        return allToys;
    }

    /**
     *
     * @param allToys лист всех игрушек
     * @param typeNumber тип игрушки для формирования листа
     */
    public int giveaway(List<Toy> allToys, String typeNumber){
        for(Toy t : allToys){
            if (Objects.equals(t.getType(), typeNumber)){
                playableToys.add(t);}
        }
        System.out.println("Список разыгрываемых игрушек! ");
        for(Toy play: playableToys){
            System.out.println(play);
        }
        return playableToys.size();
    }

    /**
     * метод розыгрыша
     * @param num берём игрушку из листа @playableToys под этим номером
     * после определения выигранной игрушки, очищаем лист @playableToys
     * удаляем игрушку из общего листа
     * возвращаем лист всех игрушек
     */
    public List<Toy> play(Integer num){
        String win = playableToys.get(num-1).getName();
        System.out.println("Выйграли " + win);
        winId = playableToys.get(num-1).getId();
        for (int i = 0; i < allToys.size(); i++) {
            if (allToys.get(i).getId() == winId) {
                allToys.remove(allToys.get(i));
            }
        }
        playableToys.clear();
        return allToys;
    }

    @Override
    public Iterator<Toy> iterator() {
        return new GroupIterator(allToys);
    }
}
