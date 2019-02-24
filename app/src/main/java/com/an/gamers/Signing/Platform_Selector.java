package com.an.gamers.Signing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.an.gamers.AdminstrationLayouts.Adminstration;
import com.an.gamers.Model_Classes.Platform;
import com.an.gamers.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Platform_Selector extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private EditText searchbox;
    private Button searchBtn,nxtBtn,backBtn;
    private ArrayList<Platform> Platformslist;
    public Platform_Selector() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Platformslist=new ArrayList<>();
        Platformslist.add(new Platform("plat1","Nintendo","photo","Group 123"));
        Platformslist.add(new Platform("plat2","PC","photo","Group 124"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_platform__selector, container, false);
        recyclerView = view.findViewById(R.id.Platform_selector_recycler);
        searchBtn =view.findViewById(R.id.Platform_selector_searchbtn);
        searchbox=view.findViewById(R.id.Platform_selector_searchbox);
        nxtBtn=view.findViewById(R.id.Platform_selector_nextbtn);
        backBtn=view.findViewById(R.id.Platform_selector_backbtn);
        adapter = new RecycleAdapter(this.getActivity(), Platformslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        searchbox.addTextChangedListener(
                new TextWatcher() {
                    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
                    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    private Timer timer = new Timer();
                    private final long DELAY = 500; // milliseconds

                    @Override
                    public void afterTextChanged(final Editable s) {
                        timer.cancel();
                        timer = new Timer();
                        timer.schedule(
                                new TimerTask() {
                                    @Override
                                    public void run() {
                                        if(!searchresult(searchbox.getText().toString().trim().toUpperCase()).isEmpty()){
                                            adapter.setPlatforms(searchresult(searchbox.getText().toString().trim().toUpperCase()));
                                            recyclerView.setAdapter(adapter);
                                        }
                                    }
                                },
                                DELAY
                        );
                    }
                }
        );
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!searchresult(searchbox.getText().toString().trim().toUpperCase()).isEmpty()){
                    adapter.setPlatforms(searchresult(searchbox.getText().toString().trim().toUpperCase()));
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(Platform_Selector.this.getContext(), "Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SigningActivity activity=new SigningActivity();
                activity.loadFragment(new Game_Selector());
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SigningActivity activity=new SigningActivity();
                activity.loadFragment(new SignUp());
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    public ArrayList<Platform> searchresult(String search){
        ArrayList<Platform>platforms=new ArrayList<>();
        for(Platform s:Platformslist){
            if(s.getmName().contains(search)){
                platforms.add(s);
            }
        }
        return platforms;

    }
    class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
        Context context;
        private List<Platform> platformlist;
        void setPlatforms(List<Platform> platformlist) {
            this.platformlist = platformlist;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image,check;
            TextView name;

            MyViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.platform_card_img);
                check=view.findViewById(R.id.platform_card_checked);
                name = view.findViewById(R.id.platform_card_name);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(check.getVisibility()==View.INVISIBLE) {
                            check.setVisibility(View.VISIBLE);
                            for (Platform p:platformlist) {
                             if(p.getmName().equals(name.getText().toString()))
                                 Adminstration.currentuser.addPlatform(p.getmID());
                            }
                        }
                        else if (check.getVisibility()==View.VISIBLE){
                            check.setVisibility(View.INVISIBLE);
                            for (Platform p:platformlist) {
                                if(p.getmName().equals(name.getText().toString()))
                                    Adminstration.currentuser.removePlatform(p.getmID());
                            }
                        }
                    }
                });
            }
        }
        RecycleAdapter(Context mainActivityContacts, ArrayList<Platform> platformsList) {
            this.platformlist = platformsList;
            this.context = mainActivityContacts;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.platform_card, parent, false);
            return new MyViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            Platform platform = platformlist.get(position);
            holder.name.setText(platform.getmName());
            holder.image.setImageResource(R.drawable.osc_logo);
        }
        @Override
        public int getItemCount() {
            return platformlist.size();
        }
    }
}
