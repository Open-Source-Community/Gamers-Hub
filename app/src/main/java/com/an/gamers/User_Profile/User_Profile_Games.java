package com.an.gamers.User_Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.an.gamers.Model_Classes.Platform;
import com.an.gamers.R;

import java.util.ArrayList;
import java.util.List;

public class User_Profile_Games extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private ArrayList<Platform> Platformslist;
    public User_Profile_Games() {
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
        View view=inflater.inflate(R.layout.fragment_user__profile__games, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.User_Profile_gamerecycler);
        return view;
    }
    class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
        Context context;
        private List<Platform> platformlist;
        void setPlatforms(List<Platform> platformlist) {
            this.platformlist = platformlist;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;

            MyViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.game_card_img);
                name = view.findViewById(R.id.game_card_name);
            }
        }
        RecycleAdapter(Context mainActivityContacts, ArrayList<Platform> platformsList) {
            this.platformlist = platformsList;
            this.context = mainActivityContacts;
        }
        @Override
        public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.game_card, parent, false);
            return new RecycleAdapter.MyViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(final RecycleAdapter.MyViewHolder holder, int position) {
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
