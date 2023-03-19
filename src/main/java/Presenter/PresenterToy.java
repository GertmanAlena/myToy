package Presenter;

import Repositiry.JsonFileCreate;
import Repositiry.Repos;
import UI.ConUi;
import java.io.IOException;

public class PresenterToy {
    /**
     * @countToy переменная для получения количества разыгрываемых игрушек
     */
    JsonFileCreate jsonFileCreate = new JsonFileCreate();
    private final ConUi cu;
    private final Repos repos;
    public Integer countToy = 0;

    public PresenterToy(ConUi cu, Repos repos) {
        this.cu = cu;
        this.repos = repos;
        cu.SetPresenterToy(this);
    }

    /**
     * переходим в метод формирования игрушки и передаём параметры
     * @param name имя игрушки
     * @param count количество игрушек
     * @param weight вес игрушки
     * @param type тип игрушки
     */
    public void createToy (String name, int count, int weight, String type) throws IOException, org.json.simple.parser.ParseException {
        jsonFileCreate.write(repos.createToy(name, count, weight, type));
    }

    /**
     *
     * @param typeNumber тип игрушки, по которому формируется лист разыгрываемых игрушек
     * @countToy метод возвращает количество разыгрываемых игрушек
     */
    public Integer giveaway(String typeNumber) throws IOException, org.json.simple.parser.ParseException {
        countToy = repos.giveaway(repos.load(), typeNumber);
        return countToy;
    }
    public void clearTheList(){
        try{
            jsonFileCreate.write(repos.clearTheList(repos.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void play(Integer num) throws IOException {
        jsonFileCreate.write(repos.play(num));
    }

    /**
     * удаление игрушки
     */
    public void delToy(){
        try{
            jsonFileCreate.write(repos.delToy(repos.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void readToy() throws IOException, org.json.simple.parser.ParseException {
        repos.load();
        }


}
