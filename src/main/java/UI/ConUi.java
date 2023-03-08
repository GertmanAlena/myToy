package UI;

import Presenter.PresenterToy;

public interface ConUi {

    void start() throws Exception;
    String getName(); int getCount() throws Exception; int getWidth();
    void SetPresenterToy(PresenterToy presenter);
}
