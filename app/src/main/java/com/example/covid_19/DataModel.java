package com.example.covid_19;

import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DataModel extends MainActivity {


    TextView mNewConfirmedCountry;
    TextView mConfirmedCountry;
    TextView mNewDeathsCountry;
    TextView mDeathsCountry;
    TextView mNewRecoveredCountry;
    TextView mRecoveredCountry;


    String CountryName;

    String[] countriestab = new String[190];

    public void letsDoSomeNetworkingPOSTMAN(String url)  {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) { // import cz.msebera.android.httpclient.Header
                // called when response HTTP status is "200 OK"
                Log.d("COVID-19", "JSONPOSTMAN: " + response.toString());

                try {
                    for (int i = 0; i<190;i++)
                        countriestab[i] = response.getJSONArray("Countries").getJSONObject(i).getString("Country");
                    for (int i = 0; i<190;i++)
                        Log.d("Tab", "Tab names: " + countriestab[i]);

                    for (int i = 0; i<190;i++)
                    if (countriestab[i].equals(CountryName)) { //countriestab[i] == CountryName
                        String newConfirmedfromJSON = response.getJSONArray("Countries").getJSONObject(i).getString("NewConfirmed");
                        String newConfirmed = mNewConfirmedCountry.getText() + newConfirmedfromJSON;
                        mNewConfirmedCountry.setText(newConfirmed);

                        String ConfirmedfromJSON = response.getJSONArray("Countries").getJSONObject(i).getString("TotalConfirmed");
                        String Confirmed = mConfirmedCountry.getText() + ConfirmedfromJSON;
                        mConfirmedCountry.setText(Confirmed);

                        String newDeathsfromJSON = response.getJSONArray("Countries").getJSONObject(i).getString("NewDeaths");
                        String newDeaths = mNewDeathsCountry.getText() + newDeathsfromJSON;
                        mNewDeathsCountry.setText(newDeaths);

                        String DeathsfromJSON = response.getJSONArray("Countries").getJSONObject(i).getString("TotalDeaths");
                        String Deaths = mDeathsCountry.getText() + DeathsfromJSON;
                        mDeathsCountry.setText(Deaths);

                        String NewRecoveredfromJSON = response.getJSONArray("Countries").getJSONObject(i).getString("NewRecovered");
                        String newRecovered = mNewRecoveredCountry.getText() + NewRecoveredfromJSON;
                        mNewRecoveredCountry.setText(newRecovered);

                        String RecoveredfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("TotalRecovered");
                        String Recovered = mRecoveredCountry.getText() + RecoveredfromJSON;
                        mRecoveredCountry.setText(Recovered);
                    }
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
