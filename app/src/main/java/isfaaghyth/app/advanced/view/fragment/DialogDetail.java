package isfaaghyth.app.advanced.view.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.advanced.R;
import isfaaghyth.app.advanced.models.dialogdetail.DialogDetailModelImp;
import isfaaghyth.app.advanced.presenter.dialogdetail.DialogDetailPresenter;
import isfaaghyth.app.advanced.presenter.dialogdetail.DialogDetailPresenterImp;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class DialogDetail extends DialogFragment implements DialogDetailView {

    private final String TAG = "DialogDetail";

    @BindView(R.id.txt_name) TextView txtName;
    @BindView(R.id.txt_position) TextView txtPosition;

    private Subscription subscriber = new CompositeSubscription();

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_detail, null);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        String id = getArguments().getString("id");
        subscriber = new DialogDetailPresenterImp(this)
                        .getResult(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::onSuccess, this::onError);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        subscriber.unsubscribe();
    }

    @Override public void onSuccess(DialogDetailModelImp result) {
        txtName.setText(result.getData().getName());
        txtPosition.setText(result.getData().getPosition());
    }

    @Override public void onError(Throwable err) {
        Log.e(TAG, err.getMessage());
    }
}
