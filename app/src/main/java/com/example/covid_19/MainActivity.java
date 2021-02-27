package com.example.covid_19;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {


    private String mInfectedName;
    private String mDeceasedName;
    private String mRecoveredName;
    private String mActiveCaseName;
    private String mDailyQuarantineName;

//    protected String ConfirmedName, NewDeathsName, DeathsName, NewRecoveredName, RecoveredName, NewConfirmedName;



    final String BASE_URL_POLAND = "https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true";
    final String BASE_URL_AZERBAIJAN = "https://api.apify.com/v2/key-value-stores/ThmCW2NVnrLa0tVp5/records/LATEST?disableRedirect=true";
    final String BASE_URL_SUMMARY = "https://api.covid19api.com/summary";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById


        // VARIABLES FOR APIFY

        //POlAND
        // VARIABLES
        LinearLayout mPolandLinearLayout = findViewById(R.id.PolandLinearLayout);
        TextView mActiveCasePoland = findViewById(R.id.activeCasePoland);
        TextView mInfectedPoland = findViewById(R.id.infectedPoland);
        TextView mDeceasedPoland = findViewById(R.id.deceasedPoland);
        TextView mRecoveredPoland = findViewById(R.id.recoveredPoland);
        TextView mDailyQuarantinePoland = findViewById(R.id.dailyQuarantinePoland);
        TextView mUpdatePoland = findViewById(R.id.updatePoland);


        //AZERBAIJAN
        LinearLayout mAzerbaijanLinearLayout = findViewById(R.id.AzerbaijanLinearLayout);
        TextView mActiveCaseAzerbaijan = null;
        TextView mInfectedAzerbaijan = findViewById(R.id.infectedAzerbaijan);
        TextView mDeceasedAzerbaijan = findViewById(R.id.deceasedAzerbaijan);
        TextView mRecoveredAzerbaijan = findViewById(R.id.recoveredAzerbaijan);
        TextView mDailyQuarantineAzerbaijan = null;
        TextView mUpdateAzerbaijan = findViewById(R.id.updateAzerbaijan);


        //STRINGS for apify
        mInfectedName = getString(R.string.infected_string);
        mDeceasedName = getString(R.string.deceased_string);
        mRecoveredName = getString(R.string.recovered_string);
        mActiveCaseName = getString(R.string.active_case_string);
        mDailyQuarantineName = getString(R.string.daily_quarantine_string);


        // VARIABLES FOR POSTMAN

        //GERMANY
        DataModel Germany = new DataModel();
        Germany.CountryName = "Germany";
        Germany.mNewConfirmedCountry = findViewById(R.id.newConfirmedGermany);
        Germany.mConfirmedCountry = findViewById(R.id.confirmedGermany);
        Germany.mNewDeathsCountry = findViewById(R.id.newDeathsGermany);
        Germany.mDeathsCountry = findViewById(R.id.deathsGermany);
        Germany.mNewRecoveredCountry = findViewById(R.id.newRecoveredGermany);
        Germany.mRecoveredCountry = findViewById(R.id.recoveredGermany);

        // HELLO JSON FOR APIFY

        letsDoSomeNetworking(BASE_URL_POLAND, mInfectedPoland, mDeceasedPoland, mRecoveredPoland,
                mActiveCasePoland, mDailyQuarantinePoland, mUpdatePoland);
        letsDoSomeNetworking(BASE_URL_AZERBAIJAN, mInfectedAzerbaijan, mDeceasedAzerbaijan,
                mRecoveredAzerbaijan, mActiveCaseAzerbaijan, mDailyQuarantinePoland, mUpdateAzerbaijan);


        // TODO: HELLO JSON FOR POSTMAN
        Germany.letsDoSomeNetworkingPOSTMAN(BASE_URL_SUMMARY);




        // POLAND LINEAR LAYOUT CLICKED
        mPolandLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    //  JSON FROM APIFY
    private void letsDoSomeNetworking(String url, final TextView mInfectedCountry,
                                            final TextView mDeceasedCountry,
                                            final TextView mRecoveredCountry,
                                            final TextView mActiveCaseCountry,
                                            final TextView mDailyQuarantineCountry,
                                            final TextView mUpdateCountry) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) { // import cz.msebera.android.httpclient.Header
                // called when response HTTP status is "200 OK"
                Log.d("COVID-19", "JSON: " + response.toString());

                try {
                    String infected = mInfectedName +  response.getString("infected");
                    mInfectedCountry.setText(infected);

                    String deceased = mDeceasedName + response.getString("deceased");
                    mDeceasedCountry.setText(deceased);

                    String recovered = mRecoveredName + response.getString("recovered");
                    mRecoveredCountry.setText( recovered);

                    String activeCase = mActiveCaseName + response.getString("activeCase");
                    mActiveCaseCountry.setText(activeCase);

                    String dailyQuarantine = mDailyQuarantineName + response.getString("dailyQuarantine");
                    mDailyQuarantineCountry.setText(dailyQuarantine);

                    String Update = response.getString("lastUpdatedAtSource");
                    mUpdateCountry.setText(Update);



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

    // TODO: JSON FROM DOCUMENTER.GETPOSTMAN.COM :: link API: https://api.covid19api.com/live/country/name_of_country

//    private void letsDoSomeNetworkingPOSTMAN(String url, final TextView mNewConfirmedCountry,
//                                                final TextView mConfirmedCountry, final TextView mNewDeathsCountry,
//                                                final TextView mDeathsCountry, final TextView mNewRecoveredCountry,
//                                                final TextView mRecoveredCountry) {
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(url, new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) { // import cz.msebera.android.httpclient.Header
//                // called when response HTTP status is "200 OK"
//                Log.d("COVID-19", "JSONPOSTMAN: " + response.toString());
//
//                try {
//
//
//                    String newConfirmedfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("NewConfirmed");
//                    String newConfirmed = getNewConfirmedName + newConfirmedfromJSON;
//                    mNewConfirmedCountry.setText(newConfirmed);
//
//                    String ConfirmedfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("TotalConfirmed");
//                    String Confirmed = getConfirmedName + ConfirmedfromJSON;
//                    mConfirmedCountry.setText(Confirmed);
//
//                    String newDeathsfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("NewDeaths");
//                    String newDeaths = getNewDeathsName + newDeathsfromJSON;
//                    mNewDeathsCountry.setText(newDeaths);
//
//                    String DeathsfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("TotalDeaths");
//                    String Deaths = getDeathsName + DeathsfromJSON;
//                    mDeathsCountry.setText(Deaths);
//
//                    String NewRecoveredfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("NewRecovered");
//                    String newRecovered = getNewRecoveredName + NewRecoveredfromJSON;
//                    mNewRecoveredCountry.setText(newRecovered);
//
//                    String RecoveredfromJSON = response.getJSONArray("Countries").getJSONObject(63).getString("TotalRecovered");
//                    String Recovered = getRecoveredName + RecoveredfromJSON;
//                    mRecoveredCountry.setText(Recovered);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
//                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
//                Log.d("COVID-19", "Request fail! Status code: " + statusCode);
//                Log.d("COVID-19", "Fail response: " + response);
//                Log.e("ERROR", e.toString());
//
//            }
//        });
//    }




}