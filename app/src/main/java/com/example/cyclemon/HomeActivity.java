package com.example.cyclemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private TextView userLevel;
    private ProgressBar userProgress;
    private ImageView userPet;
    private FloatingActionButton fab;

    private MissionAdapter mMissionAdapter;
    private RecyclerView recyclerView;
    private List<Mission> missionList;
    private Toolbar mToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userPet = (ImageView) findViewById(R.id.showPet);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(userPet);
        Glide.with(this).load(R.drawable.egg_cthulhu_animation).into(imageViewTarget);

        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(mToolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, OnARide.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.missionRec);

        missionList = new ArrayList<>();
        mMissionAdapter = new MissionAdapter(this, missionList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mMissionAdapter);

        prepMissions();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        LayoutInflater inflater = getLayoutInflater();
        View toastLayout = inflater.inflate(R.layout.my_toast,
                (ViewGroup) findViewById(R.id.toast_root_view));
        TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
        TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
        Toast toast = new Toast(getApplicationContext());

        switch (item.getItemId()){
            /*case R.id.go_home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;*/

            case R.id.go_pet:
                startActivity(new Intent(this, PetLook.class));
                return true;

            case R.id.go_shop:
                // Go Shops
                // startActivity(new Intent(this, HomeActivity.class));
                header.setText("Shop");
                body.setText("This will open the shop.");


                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toastLayout);
                toast.show();
                return true;

            case R.id.go_settings:
                // Settings
                header.setText("Settings");
                body.setText("This will open the settings.");

                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(toastLayout);
                toast.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goToPetView(View view){
        startActivity(new Intent(this, PetLook.class));
    }

    public void prepMissions(){
        Mission m1 = new Mission("5k Traveled", 500, 350, 50);
        missionList.add(m1);
        Mission m2 = new Mission("Reach 2k 5 days in a row", 5, 1, 80);
        missionList.add(m2);
        Mission m3 = new Mission("Ride your bike every day for a week", 7, 6, 100);
        missionList.add(m3);
        Mission m4 = new Mission("Daily reward: Get going reach 1k", 100, 58, 50);
        missionList.add(m4);
        Mission m5 = new Mission("Daily reward: Get going reach 1k", 100, 58, 50);
        missionList.add(m5);
        Mission m6 = new Mission("Daily reward: Get going reach 1k", 100, 58, 50);
        missionList.add(m6);
        Mission m7 = new Mission("Daily reward: Get going reach 1k", 100, 58, 50);
        missionList.add(m7);

        mMissionAdapter.notifyDataSetChanged();
    }

}
