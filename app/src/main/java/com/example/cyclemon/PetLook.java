package com.example.cyclemon;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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

public class PetLook extends AppCompatActivity {
    private Toolbar mToolbar;
    private FloatingActionButton fab;
    private ImageView userPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_look);

        userPet = (ImageView) findViewById(R.id.showPet);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(userPet);
        Glide.with(this).load(R.drawable.egg_cthulhu_animation).into(imageViewTarget);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(mToolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PetLook.this, OnARide.class));
            }
        });
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

            /*case R.id.go_pet:
                startActivity(new Intent(this, PetLook.class));
                return true;*/

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


    /**
     *
     * @param v
     */
    public void closePetLook(View v) {
        finish();
    }

    /**
     * Open statuses
     * @param v
     */
    public void openHealth(View v) {
        // open statuses
        LayoutInflater inflater = getLayoutInflater();

        View toastLayout = inflater.inflate(R.layout.my_toast,
                (ViewGroup) findViewById(R.id.toast_root_view));

        TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
        header.setText("Health");

        TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
        body.setText("Your pet is very healthy!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();
    }

    /**
     * Open statistics
     * @param v
     */
    public void openStats(View v) {
        // open statuses
        LayoutInflater inflater = getLayoutInflater();

        View toastLayout = inflater.inflate(R.layout.my_toast,
                (ViewGroup) findViewById(R.id.toast_root_view));

        TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
        header.setText("Stats");

        TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
        body.setText("This will show you stats like...\nHunger: 8/10\nBoredom: 5/10\nDirty: 10/10");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();
    }

    /**
     * Open food menu
     * @param v
     */
    public void openFood(View v) {
        // open food menu
        LayoutInflater inflater = getLayoutInflater();

        View toastLayout = inflater.inflate(R.layout.my_toast,
                (ViewGroup) findViewById(R.id.toast_root_view));

        TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
        header.setText("Food");

        TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
        body.setText("This will let you feed your pet and make it happy.");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();
    }

    /**
     * Open items page
     * @param v
     */
    public void openItems(View v) {
        // open items menu
        LayoutInflater inflater = getLayoutInflater();

        View toastLayout = inflater.inflate(R.layout.my_toast,
                (ViewGroup) findViewById(R.id.toast_root_view));

        TextView header = (TextView) toastLayout.findViewById(R.id.toast_header);
        header.setText("Items");

        TextView body = (TextView) toastLayout.findViewById(R.id.toast_body);
        body.setText("This will take you to your inventory. You will be able to equip your pet with a new look and to enter the shop.");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastLayout);
        toast.show();
    }
}
