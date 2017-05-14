package isfaaghyth.app.advanced.models.dialogdetail;

import isfaaghyth.app.advanced.utils.URLs;
import okhttp3.Request;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class DialogDetailModelImp implements DialogDetailModel {

    private Data data;

    public void setData(Data data) {this.data = data;}
    public Data getData() {return data;}

    public static class Data {
        private String name;
        private String position;

        public String getName() {return name;}

        public String getPosition() {return position;}

        public void setName(String name) {this.name = name;}

        public void setPosition(String position) {this.position = position;}
    }

    @Override public Request build(String id) {
        return new Request.Builder()
                .get()
                .url(URLs.getDetailURL(id))
                .build();
    }

}
