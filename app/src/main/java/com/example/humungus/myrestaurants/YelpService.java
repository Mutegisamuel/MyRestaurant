package com.example.humungus.myrestaurants;

import javax.security.auth.callback.Callback;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
/**
 * Created by humungus on 1/23/18.
 */

public class YelpService {

    public static void findRestaurants(String location, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();


        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue((okhttp3.Callback) callback);
    }

}
