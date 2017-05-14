package isfaaghyth.app.advanced.utils;

import isfaaghyth.app.advanced.BuildConfig;

/**
 * ---------------------------------
 * Created by isfaaghyth with <3
 * Everything in here: @isfaaghyth
 * ---------------------------------
 */

public class URLs {
    private static final String BASE_URL = BuildConfig.URI;
    private static final String DETAIL_URL = "/detail/";

    public static String getMainURL() {
        return BASE_URL;
    }

    public static String getDetailURL(String id) {
        return BASE_URL + DETAIL_URL + id;
    }
}
