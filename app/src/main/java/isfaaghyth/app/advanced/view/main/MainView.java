package isfaaghyth.app.advanced.view.main;

import isfaaghyth.app.advanced.models.main.MainModelImp;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public interface MainView {
    void onSuccess(MainModelImp result);
    void onError(Throwable err);
}
