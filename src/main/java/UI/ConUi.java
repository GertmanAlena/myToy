package UI;

import Presenter.PresenterToy;

public interface ConUi {

    void start() throws Exception;
    String getName(); int getCount() throws Exception;

//    String createType(List<Toy> allToys);

    String createType(Integer num);

    Integer RandNam(Integer num);

    int getWidth();
    void SetPresenterToy(PresenterToy presenter);
}
