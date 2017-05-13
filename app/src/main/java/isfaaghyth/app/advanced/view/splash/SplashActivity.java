package isfaaghyth.app.advanced.view.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import isfaaghyth.app.advanced.MainActivity;
import isfaaghyth.app.advanced.R;
import isfaaghyth.app.advanced.base.BaseActivity;
import isfaaghyth.app.advanced.presenter.splash.SplashPresenter;
import isfaaghyth.app.advanced.presenter.splash.SplashPresenterImp;

public class SplashActivity extends BaseActivity implements SplashView {

    SplashPresenter splashPresenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);
        splashPresenter = new SplashPresenterImp(this);
        splashPresenter.waitSplash(5000);
    }

    @Override public void showAlert() {
        showToast("Hai, selamat datang!");
    }

    @Override public void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
