package isfaaghyth.app.advanced.presenter.dialogdetail;

import isfaaghyth.app.advanced.models.dialogdetail.DialogDetailModelImp;
import rx.Observable;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public interface DialogDetailPresenter {
    Observable<DialogDetailModelImp> getResult(String id);
}
