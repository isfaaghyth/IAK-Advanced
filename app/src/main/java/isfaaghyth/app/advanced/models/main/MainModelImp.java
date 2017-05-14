package isfaaghyth.app.advanced.models.main;

import java.util.ArrayList;

import isfaaghyth.app.advanced.utils.URLs;
import okhttp3.Request;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class MainModelImp implements MainModel {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public class Data {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override public Request build() {
        return new Request.Builder()
                .get()
                .url(URLs.getMainURL())
                .build();
    }
}
