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
        Platformslist.add(new Platform("NINTENDO",R.drawable.nintendo));
        Platformslist.add(new Platform("PC",R.drawable.mouse));
        Platformslist.add(new Platform("PLAYSTATION 3",R.drawable.playstation3));
        Platformslist.add(new Platform("PLAYSTATION 4",R.drawable.playstation4));
        Platformslist.add(new Platform("WII",R.drawable.wii));
        Platformslist.add(new Platform("XBOX 360",R.drawable.xbox360));
        Platformslist.add(new Platform("XBOX ONE",R.drawable.xboxone));
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
        // Inflate the layout for this fragment
        return view;
    }
    public ArrayList<Platform> searchresult(String search){
        ArrayList<Platform>platforms=new ArrayList<>();
        for(Platform s:Platformslist){
            if(s.getName().contains(search)){
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
                image = view.findViewById(R.id.platform_img);
                check=view.findViewById(R.id.checked);
                name = view.findViewById(R.id.platform_name);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(check.getVisibility()==View.INVISIBLE) {
                            check.setVisibility(View.VISIBLE);
                        }
                        else if (check.getVisibility()==View.VISIBLE){
                            check.setVisibility(View.INVISIBLE);
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
            holder.name.setText(platform.getName());
            holder.image.setImageResource(platform.getImage());
        }
        @Override
        public int getItemCount() {
            return platformlist.size();
        }
    }
}
