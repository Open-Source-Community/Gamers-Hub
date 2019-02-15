package com.an.gamers.Signing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.an.gamers.MainActivity;
import com.an.gamers.R;


public class SignUp extends Fragment {
    Button Signup;
    EditText UserName,Password,Email;
    CheckBox Accepting;
    public SignUp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sign_up, container, false);
        Signup =view.findViewById(R.id.sign_up_signbtn);
        UserName=view.findViewById(R.id.sign_up_username);
        Password=view.findViewById(R.id.sign_in_password);
        Email=view.findViewById(R.id.sign_up_email);
        Accepting=view.findViewById(R.id.sign_up_accepting);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Email.getText().length()>0&&UserName.getText().length()>0&&Password.getText().length()>0){
                    if(Accepting.isChecked()){
                        SigningActivity activity=new SigningActivity();
                        activity.loadFragment(new Platform_Selector());
                    }
                    else {
                        Toast.makeText(SignUp.this.getContext(),"Please Accept Our Rights" ,Toast.LENGTH_SHORT ).show();
                    }
                }
                else {
                    Toast.makeText(SignUp.this.getContext(),"Please Fill All Required Data" ,Toast.LENGTH_SHORT ).show();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
