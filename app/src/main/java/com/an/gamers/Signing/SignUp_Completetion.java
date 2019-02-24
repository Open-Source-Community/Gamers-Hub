package com.an.gamers.Signing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.an.gamers.AdminstrationLayouts.Adminstration;
import com.an.gamers.MainActivity;
import com.an.gamers.R;

public class SignUp_Completetion extends AppCompatActivity {
    Button NXT_Button;
    TextView LayoutHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__completetion);
        loadFragment(new Platform_Selector());
        NXT_Button=findViewById(R.id.SignUp_Comp_nxtbtn);
        NXT_Button.setVisibility(View.VISIBLE);
        LayoutHeader=findViewById(R.id.SignUp_Comp_Header);
        NXT_Button.setEnabled(true);
            NXT_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Adminstration.currentuser.getmFav_Platforms().isEmpty()&&Adminstration.currentuser.getmFav_Games().isEmpty()){
                loadFragment(new Game_Selector());
                    LayoutHeader.setText("Games");
                }
                else if(!Adminstration.currentuser.getmFav_Platforms().isEmpty()&&!Adminstration.currentuser.getmFav_Games().isEmpty()){
                    SignUp_Completetion.this.startActivity(new Intent(SignUp_Completetion.this, MainActivity.class));
                    SignUp_Completetion.this.finish();
                }
                else
                    Toast.makeText(getBaseContext(),"You Should choose one PlatForm & one Game" ,Toast.LENGTH_SHORT ).show();
            }
            });

    }
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.SignUp_Comp_frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
