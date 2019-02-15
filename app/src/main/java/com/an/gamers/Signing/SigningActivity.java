package com.an.gamers.Signing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.an.gamers.R;

public class SigningActivity extends AppCompatActivity {
    Button signin,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing);
        loadFragment(new SignIn());
        signin=findViewById(R.id.sign_in_btn);
        signup=findViewById(R.id.sign_up_btn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup.setBackgroundResource(R.drawable.notactivebtn);
                signin.setBackgroundResource(R.drawable.activebtn);
                loadFragment(new SignIn());
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin.setBackgroundResource(R.drawable.notactivebtn);
                signup.setBackgroundResource(R.drawable.activebtn);
                loadFragment(new SignUp());
            }
        });
    }
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.signing_frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
