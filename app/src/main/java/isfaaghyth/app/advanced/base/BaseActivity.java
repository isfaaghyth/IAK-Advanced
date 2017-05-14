package isfaaghyth.app.advanced.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class BaseActivity extends AppCompatActivity {

    protected Subscription subscriber = new CompositeSubscription();

    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }
}
