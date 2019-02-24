package com.an.gamers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.an.gamers.Main_Fragments.chat;
import com.an.gamers.Main_Fragments.feed;
import com.an.gamers.Main_Fragments.groups;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.Util;

public class MainActivity extends AppCompatActivity {
    private BoomMenuButton bmb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BoomMenuButton bmb1 = findViewById(R.id.bmb);
        bmb1.setNormalColor(R.color.osc_color);
        for (int i = 0; i < bmb1.getPiecePlaceEnum().pieceNumber(); i++)
            bmb1.addBuilder(new TextInsideCircleButton.Builder()
                    .isRound(false)
                    .shadowCornerRadius(Util.dp2px(10))
                    .buttonCornerRadius(Util.dp2px(10))
                    .normalImageRes(R.drawable.ic_person_24dp)
                    .normalTextRes(R.string.hello_blank_fragment));
        BottomNavigationView navigation = findViewById(R.id.main_navbar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new TopNavigationBehavior());
        loadFragment(new feed());

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()  {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.feed_icn:
                    fragment = new feed();
                    loadFragment(fragment);
                    return true;
                case R.id.chat_icn:
                    fragment = new chat();
                    loadFragment(fragment);
                    return true;
                case R.id.groups_icn:
                    fragment = new groups();
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
