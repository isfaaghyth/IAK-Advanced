package isfaaghyth.app.advanced.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.advanced.R;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class MainListHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_employee) LinearLayout itemEmployee;
    @BindView(R.id.txt_name) TextView txtName;

    public MainListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public LinearLayout getItemEmployee() {
        return itemEmployee;
    }

    public void bind(String name) {
        txtName.setText(name);
    }

}
