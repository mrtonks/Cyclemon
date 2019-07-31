package com.example.cyclemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AchievementsActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(mToolbar);
    }

    public void backHome(View view){
        startActivity(new Intent(this, HomeActivity.class));

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
            case R.id.go_home:
                startActivity(new Intent(this, HomeActivity.class));
                return true;

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
}
