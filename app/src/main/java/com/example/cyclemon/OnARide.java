package com.example.cyclemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class OnARide extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_ride);

        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView3);
        Glide.with(this).load(R.drawable.bike_grass_animation).into(imageViewTarget);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        GlideDrawableImageViewTarget imageViewTarget2 = new GlideDrawableImageViewTarget(imageView4);
        Glide.with(this).load(R.drawable.egg_cthulhu_animation).into(imageViewTarget2);

        mToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(mToolbar);
    }

    /**
     * Close activity
     * @param v
     */
    public void closeRide(View v) {
        finish();
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
