package isfaaghyth.app.advanced;

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
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    @BindView(R.id.txt_test) TextView txtTest;

    private Subscription subscriber = new CompositeSubscription();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prosesData();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }

    private void prosesData() {
        int[] datas = {1,2,3,4,5,6,7,8,9,10};

        Observable<int[]> dataku = Observable.just(datas);

        subscriber = dataku.map(angka -> {
            StringBuilder test = new StringBuilder();
            for (int i = 0; i < angka.length; i++) {
                if (angka[i] % 2 == 1) {
                    test.append(angka[i] + "\n");
                }
            }
            return test.toString();

        }).observeOn(Schedulers.io())
          .subscribeOn(AndroidSchedulers.mainThread())
          .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(String s) {
        txtTest.setText(s);
    }

    private void onError(Throwable err) {
        Log.e(TAG, err.getMessage());
    }
}
