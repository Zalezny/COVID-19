package com.example.covid_19;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class PolandRegionActivity extends AppCompatActivity {

    final String URL_POLAND_REGION = "https://api.apify.com/v2/key-value-stores/3Po6TV7wTht4vIEid/records/LATEST?disableRedirect=true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poland_region);

        //MAZOWIECKIE
        PolandRegionDataModel Mazowieckie = new PolandRegionDataModel();
        Mazowieckie.RegionName = "mazowieckie";
        Mazowieckie.mInfectedRegion = findViewById(R.id.infectedMazowieckie);
        Mazowieckie.mDeceasedRegion = findViewById(R.id.deceasedMazowieckie);
        Mazowieckie.mQuarantineRegion = findViewById(R.id.quarantineMazowieckie);
        Mazowieckie.mRecoveredRegion = findViewById(R.id.recoveredMazowieckie);
        Mazowieckie.mTestedRegion = findViewById(R.id.testedMazowieckie);
        Mazowieckie.mTestedPosRegion = findViewById(R.id.testedPositiveMazowieckie);
        Mazowieckie.mTestedNegRegion = findViewById(R.id.testedNegativeMazowieckie);

        //MALOPOLSKIE

        PolandRegionDataModel Malopolskie = new PolandRegionDataModel();
        Malopolskie.RegionName = "małopolskie";
        Malopolskie.mInfectedRegion = findViewById(R.id.infectedMalopolskie);
        Malopolskie.mDeceasedRegion = findViewById(R.id.deceasedMalopolskie);
        Malopolskie.mQuarantineRegion = findViewById(R.id.quarantineMalopolskie);
        Malopolskie.mRecoveredRegion = findViewById(R.id.recoveredMalopolskie);
        Malopolskie.mTestedRegion = findViewById(R.id.testedMalopolskie);
        Malopolskie.mTestedPosRegion = findViewById(R.id.testedPositiveMalopolskie);
        Malopolskie.mTestedNegRegion = findViewById(R.id.testedNegativeMalopolskie);

        // POMORSKIE

        PolandRegionDataModel Pomorskie = new PolandRegionDataModel();
        Pomorskie.RegionName = "pomorskie";
        Pomorskie.mInfectedRegion = findViewById(R.id.infectedPomorskie);
        Pomorskie.mDeceasedRegion = findViewById(R.id.deceasedPomorskie);
        Pomorskie.mQuarantineRegion = findViewById(R.id.quarantinePomorskie);
        Pomorskie.mRecoveredRegion = findViewById(R.id.recoveredPomorskie);
        Pomorskie.mTestedRegion = findViewById(R.id.testedPomorskie);
        Pomorskie.mTestedPosRegion = findViewById(R.id.testedPositivePomorskie);
        Pomorskie.mTestedNegRegion = findViewById(R.id.testedNegativePomorskie);

        // Slaskie

        PolandRegionDataModel Slaskie = new PolandRegionDataModel();
        Slaskie.RegionName = "śląskie";
        Slaskie.mInfectedRegion = findViewById(R.id.infectedSlaskie);
        Slaskie.mDeceasedRegion = findViewById(R.id.deceasedSlaskie);
        Slaskie.mQuarantineRegion = findViewById(R.id.quarantineSlaskie);
        Slaskie.mRecoveredRegion = findViewById(R.id.recoveredSlaskie);
        Slaskie.mTestedRegion = findViewById(R.id.testedSlaskie);
        Slaskie.mTestedPosRegion = findViewById(R.id.testedPositiveSlaskie);
        Slaskie.mTestedNegRegion = findViewById(R.id.testedNegativeSlaskie);

        // Kujawsko-Pomorskie

        PolandRegionDataModel KujawskoPomorskie = new PolandRegionDataModel();
        KujawskoPomorskie.RegionName = "kujawsko-pomorskie";
        KujawskoPomorskie.mInfectedRegion = findViewById(R.id.infectedKujawskoPomorskie);
        KujawskoPomorskie.mDeceasedRegion = findViewById(R.id.deceasedKujawskoPomorskie);
        KujawskoPomorskie.mQuarantineRegion = findViewById(R.id.quarantineKujawskoPomorskie);
        KujawskoPomorskie.mRecoveredRegion = findViewById(R.id.recoveredKujawskoPomorskie);
        KujawskoPomorskie.mTestedRegion = findViewById(R.id.testedKujawskoPomorskie);
        KujawskoPomorskie.mTestedPosRegion = findViewById(R.id.testedPositiveKujawskoPomorskie);
        KujawskoPomorskie.mTestedNegRegion = findViewById(R.id.testedNegativeKujawskoPomorskie);

        // WIELKOPOLSKA

        PolandRegionDataModel Wielkopolskie = new PolandRegionDataModel();
        Wielkopolskie.RegionName = "wielkopolskie";
        Wielkopolskie.mInfectedRegion = findViewById(R.id.infectedWielkopolskie);
        Wielkopolskie.mDeceasedRegion = findViewById(R.id.deceasedWielkopolskie);
        Wielkopolskie.mQuarantineRegion = findViewById(R.id.quarantineWielkopolskie);
        Wielkopolskie.mRecoveredRegion = findViewById(R.id.recoveredWielkopolskie);
        Wielkopolskie.mTestedRegion = findViewById(R.id.testedWielkopolskie);
        Wielkopolskie.mTestedPosRegion = findViewById(R.id.testedPositiveWielkopolskie);
        Wielkopolskie.mTestedNegRegion = findViewById(R.id.testedNegativeWielkopolskie);

        // WARMINSKO-MAZURSKIE

        PolandRegionDataModel WarminskoMazurskie = new PolandRegionDataModel();
        WarminskoMazurskie.RegionName = "warmińsko-mazurskie";
        WarminskoMazurskie.mInfectedRegion = findViewById(R.id.infectedWarminskoMazurskie);
        WarminskoMazurskie.mDeceasedRegion = findViewById(R.id.deceasedWarminskoMazurskie);
        WarminskoMazurskie.mQuarantineRegion = findViewById(R.id.quarantineWarminskoMazurskie);
        WarminskoMazurskie.mRecoveredRegion = findViewById(R.id.recoveredWarminskoMazurskie);
        WarminskoMazurskie.mTestedRegion = findViewById(R.id.testedWarminskoMazurskie);
        WarminskoMazurskie.mTestedPosRegion = findViewById(R.id.testedPositiveWarminskoMazurskie);
        WarminskoMazurskie.mTestedNegRegion = findViewById(R.id.testedNegativeWarminskoMazurskie);

        // LODZKIE

        PolandRegionDataModel Lodzkie = new PolandRegionDataModel();
        Lodzkie.RegionName = "łódzkie";
        Lodzkie.mInfectedRegion = findViewById(R.id.infectedLodzkie);
        Lodzkie.mDeceasedRegion = findViewById(R.id.deceasedLodzkie);
        Lodzkie.mQuarantineRegion = findViewById(R.id.quarantineLodzkie);
        Lodzkie.mRecoveredRegion = findViewById(R.id.recoveredLodzkie);
        Lodzkie.mTestedRegion = findViewById(R.id.testedLodzkie);
        Lodzkie.mTestedPosRegion = findViewById(R.id.testedPositiveLodzkie);
        Lodzkie.mTestedNegRegion = findViewById(R.id.testedNegativeLodzkie);

        // DOLNOSLASKIE

        PolandRegionDataModel Dolnoslaskie = new PolandRegionDataModel();
        Dolnoslaskie.RegionName = "dolnośląskie";
        Dolnoslaskie.mInfectedRegion = findViewById(R.id.infectedDolnoslaskie);
        Dolnoslaskie.mDeceasedRegion = findViewById(R.id.deceasedDolnoslaskie);
        Dolnoslaskie.mQuarantineRegion = findViewById(R.id.quarantineDolnoslaskie);
        Dolnoslaskie.mRecoveredRegion = findViewById(R.id.recoveredDolnoslaskie);
        Dolnoslaskie.mTestedRegion = findViewById(R.id.testedDolnoslaskie);
        Dolnoslaskie.mTestedPosRegion = findViewById(R.id.testedPositiveDolnoslaskie);
        Dolnoslaskie.mTestedNegRegion = findViewById(R.id.testedNegativeDolnoslaskie);

        // PODKARPACKIE

        PolandRegionDataModel Podkarpackie = new PolandRegionDataModel();
        Podkarpackie.RegionName = "podkarpackie";
        Podkarpackie.mInfectedRegion = findViewById(R.id.infectedPodkarpackie);
        Podkarpackie.mDeceasedRegion = findViewById(R.id.deceasedPodkarpackie);
        Podkarpackie.mQuarantineRegion = findViewById(R.id.quarantinePodkarpackie);
        Podkarpackie.mRecoveredRegion = findViewById(R.id.recoveredPodkarpackie);
        Podkarpackie.mTestedRegion = findViewById(R.id.testedPodkarpackie);
        Podkarpackie.mTestedPosRegion = findViewById(R.id.testedPositivePodkarpackie);
        Podkarpackie.mTestedNegRegion = findViewById(R.id.testedNegativePodkarpackie);

        // LUBELSKIE

        PolandRegionDataModel Lubelskie = new PolandRegionDataModel();
        Lubelskie.RegionName = "lubelskie";
        Lubelskie.mInfectedRegion = findViewById(R.id.infectedLubelskie);
        Lubelskie.mDeceasedRegion = findViewById(R.id.deceasedLubelskie);
        Lubelskie.mQuarantineRegion = findViewById(R.id.quarantineLubelskie);
        Lubelskie.mRecoveredRegion = findViewById(R.id.recoveredLubelskie);
        Lubelskie.mTestedRegion = findViewById(R.id.testedLubelskie);
        Lubelskie.mTestedPosRegion = findViewById(R.id.testedPositiveLubelskie);
        Lubelskie.mTestedNegRegion = findViewById(R.id.testedNegativeLubelskie);

        // ZACHODNIOPOMORSKIE

        PolandRegionDataModel Zachodniopomorskie = new PolandRegionDataModel();
        Zachodniopomorskie.RegionName = "zachodniopomorskie";
        Zachodniopomorskie.mInfectedRegion = findViewById(R.id.infectedZachodniopomorskie);
        Zachodniopomorskie.mDeceasedRegion = findViewById(R.id.deceasedZachodniopomorskie);
        Zachodniopomorskie.mQuarantineRegion = findViewById(R.id.quarantineZachodniopomorskie);
        Zachodniopomorskie.mRecoveredRegion = findViewById(R.id.recoveredZachodniopomorskie);
        Zachodniopomorskie.mTestedRegion = findViewById(R.id.testedZachodniopomorskie);
        Zachodniopomorskie.mTestedPosRegion = findViewById(R.id.testedPositiveZachodniopomorskie);
        Zachodniopomorskie.mTestedNegRegion = findViewById(R.id.testedNegativeZachodniopomorskie);

        // PODLASKIE
        PolandRegionDataModel Podlaskie = new PolandRegionDataModel();
        Podlaskie.RegionName = "podlaskie";
        Podlaskie.mInfectedRegion = findViewById(R.id.infectedPodlaskie);
        Podlaskie.mDeceasedRegion = findViewById(R.id.deceasedPodlaskie);
        Podlaskie.mQuarantineRegion = findViewById(R.id.quarantinePodlaskie);
        Podlaskie.mRecoveredRegion = findViewById(R.id.recoveredPodlaskie);
        Podlaskie.mTestedRegion = findViewById(R.id.testedPodlaskie);
        Podlaskie.mTestedPosRegion = findViewById(R.id.testedPositivePodlaskie);
        Podlaskie.mTestedNegRegion = findViewById(R.id.testedNegativePodlaskie);

        // LUBUSKIE

        PolandRegionDataModel Lubuskie = new PolandRegionDataModel();
        Lubuskie.RegionName = "lubuskie";
        Lubuskie.mInfectedRegion = findViewById(R.id.infectedLubuskie);
        Lubuskie.mDeceasedRegion = findViewById(R.id.deceasedLubuskie);
        Lubuskie.mQuarantineRegion = findViewById(R.id.quarantineLubuskie);
        Lubuskie.mRecoveredRegion = findViewById(R.id.recoveredLubuskie);
        Lubuskie.mTestedRegion = findViewById(R.id.testedLubuskie);
        Lubuskie.mTestedPosRegion = findViewById(R.id.testedPositiveLubuskie);
        Lubuskie.mTestedNegRegion = findViewById(R.id.testedNegativeLubuskie);

        // OPOLSKIE

        PolandRegionDataModel Opolskie = new PolandRegionDataModel();
        Opolskie.RegionName = "opolskie";
        Opolskie.mInfectedRegion = findViewById(R.id.infectedOpolskie);
        Opolskie.mDeceasedRegion = findViewById(R.id.deceasedOpolskie);
        Opolskie.mQuarantineRegion = findViewById(R.id.quarantineOpolskie);
        Opolskie.mRecoveredRegion = findViewById(R.id.recoveredOpolskie);
        Opolskie.mTestedRegion = findViewById(R.id.testedOpolskie);
        Opolskie.mTestedPosRegion = findViewById(R.id.testedPositiveOpolskie);
        Opolskie.mTestedNegRegion = findViewById(R.id.testedNegativeOpolskie);

        // SWIETOKRZYSKIE

        PolandRegionDataModel Swietokrzyskie = new PolandRegionDataModel();
        Swietokrzyskie.RegionName = "świętokrzyskie";
        Swietokrzyskie.mInfectedRegion = findViewById(R.id.infectedSwietokrzyskie);
        Swietokrzyskie.mDeceasedRegion = findViewById(R.id.deceasedSwietokrzyskie);
        Swietokrzyskie.mQuarantineRegion = findViewById(R.id.quarantineSwietokrzyskie);
        Swietokrzyskie.mRecoveredRegion = findViewById(R.id.recoveredSwietokrzyskie);
        Swietokrzyskie.mTestedRegion = findViewById(R.id.testedSwietokrzyskie);
        Swietokrzyskie.mTestedPosRegion = findViewById(R.id.testedPositiveSwietokrzyskie);
        Swietokrzyskie.mTestedNegRegion = findViewById(R.id.testedNegativeSwietokrzyskie);


        // JSON

        Mazowieckie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Malopolskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Pomorskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Zachodniopomorskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Lubelskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Lubuskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Opolskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        WarminskoMazurskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Lodzkie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Wielkopolskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Podlaskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Slaskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Podkarpackie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Dolnoslaskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        Swietokrzyskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);
        KujawskoPomorskie.letsDoSomeNetworkingAPIFY(URL_POLAND_REGION);





    }
}