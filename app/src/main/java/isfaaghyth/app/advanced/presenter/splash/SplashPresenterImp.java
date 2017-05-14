package isfaaghyth.app.advanced.presenter.splash;

import android.os.Handler;

import isfaaghyth.app.advanced.view.splash.SplashView;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class SplashPresenterImp implements SplashPresenter {

    SplashView view;

    public SplashPresenterImp(SplashView view) {
        this.view = view;
    }

    @Override public void waitSplash(int duration) {
        new Handler().postDelayed(() -> {
            view.showAlert();
            view.openMain();
        }, duration);
    }
}
