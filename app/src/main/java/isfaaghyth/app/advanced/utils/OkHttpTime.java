package isfaaghyth.app.advanced.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class OkHttpTime {

    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(1000L, TimeUnit.MILLISECONDS)
            .build();

}
