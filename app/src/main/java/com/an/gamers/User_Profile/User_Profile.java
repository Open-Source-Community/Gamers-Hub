package com.an.gamers.User_Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.an.gamers.Main_Fragments.chat;
import com.an.gamers.Main_Fragments.feed;
import com.an.gamers.R;

public class User_Profile extends AppCompatActivity {
    ImageButton EditePhoto,EditBtn;
    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        EditePhoto = findViewById(R.id.user_profile_editphoto);
        EditBtn = findViewById(R.id.user_profile_edit);
        EditePhoto.setEnabled(false);
        navigation=findViewById(R.id.user_profile_navbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!EditePhoto.isShown()){
                    EditePhoto.setVisibility(View.VISIBLE);
                    EditePhoto.setEnabled(true);
                }
                else{
                    EditePhoto.setVisibility(View.INVISIBLE);
                    EditePhoto.setEnabled(false);
                }
            }
        });
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new feed());

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()  {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.user_profile_game:
                    fragment = new feed();
                    loadFragment(fragment);
                    return true;
                case R.id.user_profile_platform:
                    fragment = new chat();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
