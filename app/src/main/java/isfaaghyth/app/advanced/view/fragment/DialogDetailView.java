package isfaaghyth.app.advanced.view.fragment;

import isfaaghyth.app.advanced.models.dialogdetail.DialogDetailModelImp;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public interface DialogDetailView {
    void onSuccess(DialogDetailModelImp result);
    void onError(Throwable err);
}
