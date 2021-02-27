package com.example.covid_19;

import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PolandRegionDataModel extends PolandRegionActivity {

    TextView mInfectedRegion;
    TextView mRecoveredRegion;
    TextView mDeceasedRegion;
    TextView mTestedRegion;
    TextView mQuarantineRegion;
    TextView mTestedPosRegion;
    TextView mTestedNegRegion;


    String RegionName;

    String[] regionstab = new String[16]; // StringTab of regions


    // JSON FROM APIFY:: link API source: https://apify.com/covid-19



    public void letsDoSomeNetworkingAPIFY(String url)  {

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) { // import cz.msebera.android.httpclient.Header
                // called when response HTTP status is "200 OK"
                Log.d("COVID-19", "JSONAPIFY Link: " + response.toString());

                try {
                    for (int i = 0; i<16;i++)
                        regionstab[i] = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("region");
                    for (int i = 0; i<16;i++)
                        Log.d("PolandRegionDataModel", "RegionTab names: " + regionstab[i]);

                    for (int i = 0; i<16;i++) {
                        if (regionstab[i].equals(RegionName))  //infectedByRegiontab[i] == RegionName
                        {
                            String infectedfromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("infectedCount");
                            String infected = mInfectedRegion.getText() + infectedfromJSON;
                            mInfectedRegion.setText(infected);

                            String recoveredfromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("recoveredCount");
                            String recovered = mRecoveredRegion.getText() + recoveredfromJSON;
                            mRecoveredRegion.setText(recovered);

                            String deceasedfromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("deceasedCount");
                            String deceased = mDeceasedRegion.getText() + deceasedfromJSON;
                            mDeceasedRegion.setText(deceased);

                            String testedfromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("testedCount");
                            String tested = mTestedRegion.getText() + testedfromJSON;
                            mTestedRegion.setText(tested);

                            String quarantinefromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("quarantineCount");
                            String quarantine = mQuarantineRegion.getText() + quarantinefromJSON;
                            mQuarantineRegion.setText(quarantine);

                            String testedPositivefromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("testedPositive");
                            String testedPositive = mTestedPosRegion.getText() + testedPositivefromJSON;
                            mTestedPosRegion.setText(testedPositive);

                            String testedNegativefromJSON = response.getJSONArray("infectedByRegion").getJSONObject(i).getString("testedNegative");
                            String testedNegative = mTestedNegRegion.getText() + testedNegativefromJSON;
                            mTestedNegRegion.setText(testedNegative);
                        }
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
