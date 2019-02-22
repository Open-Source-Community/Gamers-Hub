package com.an.gamers.Signing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.an.gamers.R;

import java.util.ArrayList;
import java.util.List;

public class Game_Selector extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private EditText searchbox;
    private Button searchButton;
    private ArrayList<Platform> Platformslist;
    public Game_Selector() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game__selector, container, false);
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
                    .inflate(R.layout.game_card, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
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
