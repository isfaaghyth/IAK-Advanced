package isfaaghyth.app.advanced.view.main;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.advanced.R;
import isfaaghyth.app.advanced.base.BaseActivity;
import isfaaghyth.app.advanced.models.DataBean;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends BaseActivity {

    private final String TAG = "MainActivity";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }
}
