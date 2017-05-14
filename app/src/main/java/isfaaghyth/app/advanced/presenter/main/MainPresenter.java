package isfaaghyth.app.advanced.presenter.main;

import isfaaghyth.app.advanced.models.main.MainModelImp;
import rx.Observable;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public interface MainPresenter {
    Observable<MainModelImp> getResult();
}
