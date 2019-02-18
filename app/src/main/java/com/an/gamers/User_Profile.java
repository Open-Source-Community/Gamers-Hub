package com.an.gamers;

import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class User_Profile extends AppCompatActivity {
ImageButton EditePhoto,EditBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        EditePhoto=findViewById(R.id.user_profile_editphoto);
        EditBtn=findViewById(R.id.user_profile_edit);
        EditePhoto.setEnabled(false);
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
    }
}
