
package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
/**                                         README
 * If you wanna add new country, you must:
 * 1. Create object for class DataModel (LOOK EX. POLAND)
 * 2. Add Hello JSON for POSTMAN in correct places (LOOK HELLO JSON FOR POSTMAN)
 * and that is all
*/



public class MainActivity extends AppCompatActivity {

    final String BASE_URL_POLAND = "https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true";
    final String BASE_URL_AZERBAIJAN = "https://api.apify.com/v2/key-value-stores/ThmCW2NVnrLa0tVp5/records/LATEST?disableRedirect=true";
    final String BASE_URL_SUMMARY = "https://api.covid19api.com/summary";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***Code to join to JSON ***/

        //POlAND
        LinearLayout mPolandLinearLayout = findViewById(R.id.PolandLinearLayout);

        DataModel Poland = new DataModel();
        Poland.CountryName = "Poland";
        Poland.mNewConfirmedCountry = findViewById(R.id.newConfirmedPoland);
        Poland.mConfirmedCountry = findViewById(R.id.confirmedPoland);
        Poland.mNewDeathsCountry = findViewById(R.id.newDeathsPoland);
        Poland.mDeathsCountry = findViewById(R.id.deathsPoland);
        Poland.mNewRecoveredCountry = findViewById(R.id.newRecoveredPoland);
        Poland.mRecoveredCountry = findViewById(R.id.recoveredPoland);


        //AZERBAIJAN

        DataModel Azerbaijan = new DataModel();
        Azerbaijan.CountryName = "Azerbaijan";
        Azerbaijan.mNewConfirmedCountry = findViewById(R.id.newConfirmedAzerbaijan);
        Azerbaijan.mConfirmedCountry = findViewById(R.id.confirmedAzerbaijan);
        Azerbaijan.mNewDeathsCountry = findViewById(R.id.newDeathsAzerbaijan);
        Azerbaijan.mDeathsCountry = findViewById(R.id.deathsAzerbaijan);
        Azerbaijan.mNewRecoveredCountry = findViewById(R.id.newRecoveredAzerbaijan);
        Azerbaijan.mRecoveredCountry = findViewById(R.id.recoveredAzerbaijan);

        //GERMANY
        DataModel Germany = new DataModel();
        Germany.CountryName = "Germany";
        Germany.mNewConfirmedCountry = findViewById(R.id.newConfirmedGermany);
        Germany.mConfirmedCountry = findViewById(R.id.confirmedGermany);
        Germany.mNewDeathsCountry = findViewById(R.id.newDeathsGermany);
        Germany.mDeathsCountry = findViewById(R.id.deathsGermany);
        Germany.mNewRecoveredCountry = findViewById(R.id.newRecoveredGermany);
        Germany.mRecoveredCountry = findViewById(R.id.recoveredGermany);

        // TODO: HELLO JSON FOR POSTMAN
        Germany.letsDoSomeNetworkingPOSTMAN(BASE_URL_SUMMARY);
        Poland.letsDoSomeNetworkingPOSTMAN(BASE_URL_SUMMARY);
        Azerbaijan.letsDoSomeNetworkingPOSTMAN(BASE_URL_SUMMARY);

        /*** END CODE FOR JSON ***/

        /*** Building... ***/
        // TODO: POLAND LINEAR LAYOUT CLICKED
        mPolandLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPolandRegionActivity();

            }
        });

    }
    public void openPolandRegionActivity() {
        Intent intent = new Intent(this, PolandRegionActivity.class);
        startActivity(intent);

    }
}