package isfaaghyth.app.advanced.presenter.main;

import com.google.gson.Gson;

import isfaaghyth.app.advanced.models.main.MainModel;
import isfaaghyth.app.advanced.models.main.MainModelImp;
import isfaaghyth.app.advanced.utils.OkHttpTime;
import isfaaghyth.app.advanced.utils.RxOkhttp;
import isfaaghyth.app.advanced.view.main.MainView;
import okhttp3.Request;
import rx.Observable;
import rx.functions.Func1;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class MainPresenterImp implements MainPresenter {

    MainModel model;
    MainView view;

    public MainPresenterImp(MainView view) {
        model = new MainModelImp();
        this.view = view;
    }

    @Override public Observable<MainModelImp> getResult() {
        Request request = model.build();
        return RxOkhttp.streamStrings(OkHttpTime.client, request).map(s ->
                new Gson().fromJson(s, MainModelImp.class)
        );
    }
}
