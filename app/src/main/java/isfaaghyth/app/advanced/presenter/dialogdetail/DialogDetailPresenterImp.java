package isfaaghyth.app.advanced.presenter.dialogdetail;

import com.google.gson.Gson;

import isfaaghyth.app.advanced.models.dialogdetail.DialogDetailModel;
import isfaaghyth.app.advanced.models.dialogdetail.DialogDetailModelImp;
import isfaaghyth.app.advanced.utils.OkHttpTime;
import isfaaghyth.app.advanced.utils.RxOkhttp;
import isfaaghyth.app.advanced.view.fragment.DialogDetailView;
import okhttp3.Request;
import rx.Observable;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class DialogDetailPresenterImp implements DialogDetailPresenter {

    DialogDetailView view;
    DialogDetailModel model;

    public DialogDetailPresenterImp(DialogDetailView view) {
        model = new DialogDetailModelImp();
        this.view = view;
    }

    @Override public Observable<DialogDetailModelImp> getResult(String id) {
        Request request = model.build(id);
        return RxOkhttp.streamStrings(OkHttpTime.client, request).map(s ->
                new Gson().fromJson(s, DialogDetailModelImp.class)
        );
    }
}
