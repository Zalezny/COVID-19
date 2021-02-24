package com.example.covid_19;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextViewResult = findViewById(R.id.text_view_result);

        final String BASE_URL = "https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true";

        letsDoSomeNetworking(BASE_URL);


    }

    private void letsDoSomeNetworking(String url) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) { // import cz.msebera.android.httpclient.Header
                // called when response HTTP status is "200 OK"
                Log.d("COVID-19", "JSON: " + response.toString());

                try {
                    String MyResponse = response.getString("data");
                    mTextViewResult.setText(MyResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("COVID-19", "Request fail! Status code: " + statusCode);
                Log.d("COVID-19", "Fail response: " + response);
                Log.e("ERROR", e.toString());

            }
        });
    }
}