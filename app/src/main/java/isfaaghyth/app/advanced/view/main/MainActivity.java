package isfaaghyth.app.advanced.view.main;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.advanced.R;
import isfaaghyth.app.advanced.adapter.ListAdapter;
import isfaaghyth.app.advanced.base.BaseActivity;
import isfaaghyth.app.advanced.holder.MainListHolder;
import isfaaghyth.app.advanced.models.DataBean;
import isfaaghyth.app.advanced.models.main.MainModelImp;
import isfaaghyth.app.advanced.presenter.main.MainPresenter;
import isfaaghyth.app.advanced.presenter.main.MainPresenterImp;
import isfaaghyth.app.advanced.view.fragment.DialogDetail;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends BaseActivity implements MainView {

    private final String TAG = "MainActivity";

    private MainPresenter mainPresenter;
    private ListAdapter adapter;

    @BindView(R.id.lst_employee) RecyclerView lstEmployee;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);
        mainPresenter = new MainPresenterImp(this);
        subscriber = mainPresenter.getResult()
                     .subscribeOn(Schedulers.io())
                     .observeOn(AndroidSchedulers.mainThread())
                     .subscribe(this::onSuccess, this::onError);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
    }

    @Override public void onSuccess(MainModelImp result) {
        lstEmployee.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ListAdapter<MainModelImp.Data, MainListHolder>(R.layout.item_list, MainListHolder.class, MainModelImp.Data.class, result.getData()) {
            @Override protected void bindView(MainListHolder holder, MainModelImp.Data model, final int position) {
                holder.bind(model.getName());
                holder.getItemEmployee().setOnClickListener(v -> {
                    DialogDetail detail = new DialogDetail();
                    Bundle bundle = new Bundle();
                    bundle.putString("id", String.valueOf(model.getId()));
                    detail.setArguments(bundle);
                    detail.show(getFragmentManager(), "Detail");
                });
            }
        };

        lstEmployee.setAdapter(adapter);
    }

    @Override public void onError(Throwable err) {
        Log.e(TAG, err.getMessage());
    }
}
