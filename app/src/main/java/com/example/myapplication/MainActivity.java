package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardBaseActivity;
import jp.co.rakuten.reward.rewardsdk.api.RakutenReward;
import android.content.Context;
import android.app.Activity;
import jp.co.rakuten.reward.rewardsdk.api.activity.RakutenRewardLifecycle;
import jp.co.rakuten.reward.rewardsdk.api.status.Status;
import jp.co.rakuten.reward.rewardsdk.api.listener.RakutenRewardListener;
import jp.co.rakuten.reward.rewardsdk.api.status.Status;
import jp.co.rakuten.reward.rewardsdk.api.data.RakutenRewardUser;
import jp.co.rakuten.reward.rewardsdk.api.data.MissionAchievementData;
import jp.co.rakuten.reward.rewardsdk.api.RakutenRewardAds;


//public class MainActivity extends RakutenRewardBaseActivity {
public class MainActivity extends AppCompatActivity implements RakutenRewardListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;


    public void onUserUpdated(RakutenRewardUser rakutenRewardUser) {

    }

    public void onUnclaimedAchievement(MissionAchievementData missionAchievementData) {

    }
    public void onSDKStateChanged(Status status) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        RakutenRewardLifecycle.onCreate(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RakutenRewardAds.initialize("anAuY28ucmFrdXRlbi5yZXdhcmQuYW5kcm9pZC1SVGlhQWhrV0J+NHVEVnY3QkNSdF96b2NYZ2cten5TSQ==");

//        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                final Activity activity = this;


        binding.fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                RakutenReward.getInstance().openPortal();
                Status s = RakutenReward.getInstance().getStatus();
                Context context = getApplicationContext();
                boolean success = RakutenReward.getInstance().openAdPortal(view.getContext());
                Snackbar.make(view, "Replace with your own action"+s, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        RakutenRewardLifecycle.onStart(this);
//    }
    @Override
    protected void onStart() {
        super.onStart();
        // Set Listener
        RakutenReward.getInstance().setListener(this);
        RakutenRewardLifecycle.onStart(this);
    }


    @Override
    public void onResume() {
        super.onResume();
        RakutenRewardLifecycle.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // ...
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // ...
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}