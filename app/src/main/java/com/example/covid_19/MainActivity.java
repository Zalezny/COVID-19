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
    // VARIABLES
    private LinearLayout mPolandLinearLayout, mAzerbaijanLinearLayout;
    private TextView mInfectedPoland, mDeceasedPoland, mRecoveredPoland, mActiveCasePoland,
            mDailyQuarantinePoland, mUpdatePoland;

    private String mInfectedName, mDeceasedName, mRecoveredName, mActiveCaseName,
            mDailyQuarantineName, mLastedUpdatedName;

    private TextView mInfectedAzerbaijan, mDeceasedAzerbaijan, mRecoveredAzerbaijan, mActiveCaseAzerbaijan,
            mDailyQuarantineAzerbaijan, mUpdateAzerbaijan;

    final String BASE_URL_POLAND = "https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true";
    final String BASE_URL_AZERBAIJAN = "https://api.apify.com/v2/key-value-stores/ThmCW2NVnrLa0tVp5/records/LATEST?disableRedirect=true";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById

        mPolandLinearLayout = findViewById(R.id.PolandLinearLayout);
        mActiveCasePoland = findViewById(R.id.activeCasePoland);
        mInfectedPoland = findViewById(R.id.infectedPoland);
        mDeceasedPoland = findViewById(R.id.deceasedPoland);
        mRecoveredPoland = findViewById(R.id.recoveredPoland);
        mDailyQuarantinePoland = findViewById(R.id.dailyQuarantinePoland);
        mUpdatePoland = findViewById(R.id.updatePoland);

        mAzerbaijanLinearLayout = findViewById(R.id.AzerbaijanLinearLayout);
        mActiveCaseAzerbaijan = findViewById(R.id.activeCaseAzerbaijan);
        mInfectedAzerbaijan = findViewById(R.id.infectedAzerbaijan);
        mDeceasedAzerbaijan = findViewById(R.id.deceasedAzerbaijan);
        mRecoveredAzerbaijan = findViewById(R.id.recoveredAzerbaijan);
        mDailyQuarantineAzerbaijan = findViewById(R.id.dailyQuarantineAzerbaijan);
        mUpdateAzerbaijan = findViewById(R.id.updateAzerbaijan);

        mInfectedName = getString(R.string.infected_string);
        mDeceasedName = getString(R.string.deceased_string);
        mRecoveredName = getString(R.string.recovered_string);
        mActiveCaseName = getString(R.string.active_case_string);
        mDailyQuarantineName = getString(R.string.daily_quarantine_string);
        mLastedUpdatedName = getString(R.string.lasted_updated_string);







        letsDoSomeNetworkingPoland(BASE_URL_POLAND);

        // POLAND LINEAR LAYOUT CLICKED
        mPolandLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    // TODO: OUR BEAUTY JSON GETTED FOR POLAND
    private void letsDoSomeNetworkingPoland(String url) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) { // import cz.msebera.android.httpclient.Header
                // called when response HTTP status is "200 OK"
                Log.d("COVID-19", "JSON: " + response.toString());

                try {
                    String infected = response.getString("infected");
                    mInfectedPoland.setText(mInfectedName + infected);

                    String deceased = response.getString("deceased");
                    mDeceasedPoland.setText(mDeceasedName + deceased);

                    String recovered = response.getString("recovered");
                    mRecoveredPoland.setText(mRecoveredName + recovered);

                    String activeCase = response.getString("activeCase");
                    mActiveCasePoland.setText(mActiveCaseName + activeCase);

                    String dailyQuarantine = response.getString("dailyQuarantine");
                    mDailyQuarantinePoland.setText(mDailyQuarantineName + dailyQuarantine);

                    String Update = response.getString("lastUpdatedAtSource");
                    mUpdatePoland.setText(mLastedUpdatedName + Update);



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