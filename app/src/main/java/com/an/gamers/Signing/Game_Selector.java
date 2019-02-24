package com.an.gamers.Signing;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.an.gamers.AdminstrationLayouts.Adminstration;
import com.an.gamers.Model_Classes.Game;
import com.an.gamers.R;

import java.util.ArrayList;
import java.util.List;

public class Game_Selector extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private EditText searchbox;
    private Button searchBtn;
    private ArrayList<Game> Gameslist;
    public Game_Selector() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gameslist=new ArrayList<>();
        Gameslist.add(new Game("game1","Pubg","Mobile Game","Mobile"
                ,R.drawable.pubg_mobile,"www.pubg.com","group24"));
        Gameslist.add(new Game("game2","Medal Of Honor","PC Game","PC",
                R.drawable.medal_of_honor,"www.moh.com","group25"));
        Gameslist.add(new Game("game3","Need For Speed","PlayStation 4 Game","PS4",
                R.drawable.nfs_ps4,"www.nfs.com","group25"));
        Gameslist.add(new Game("game4","Grand Theft Auto V","PlayStation 3 Game","PS3",
                R.drawable.gtav_ps3,"www.gtav.com","group25"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_game__selector, container, false);
        recyclerView = view.findViewById(R.id.Game_selector_recycler);
        searchBtn =view.findViewById(R.id.Game_selector_searchbtn);
        searchbox=view.findViewById(R.id.Game_selector_searchbox);
        adapter = new RecycleAdapter(this.getActivity(), Gameslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!searchresult(searchbox.getText().toString().trim().toUpperCase()).isEmpty()){
                    adapter.setPlatforms(searchresult(searchbox.getText().toString().trim().toUpperCase()));
                    recyclerView.setAdapter(adapter);
                }
                else{
                    Toast.makeText(Game_Selector.this.getContext(), "Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    public ArrayList<Game> searchresult(String search){
        ArrayList<Game>games=new ArrayList<>();
        for(Game s:Gameslist){
            if(s.getmName().contains(search)){
                games.add(s);
            }
        }
        return games;

    }
    class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
        Context context;
        private List<Game> gamesList;
        void setPlatforms(List<Game> gameList) {
            this.gamesList = gameList;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image,check;
            TextView name,platform;

            MyViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.game_card_img);
                check=view.findViewById(R.id.game_card_checked);
                name = view.findViewById(R.id.game_card_name);
                platform=view.findViewById(R.id.game_card_platform);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(check.getVisibility()==View.INVISIBLE) {
                            check.setVisibility(View.VISIBLE);
                            for (Game g:gamesList) {
                                if(g.getmName().equals(name.getText().toString()))
                                    Adminstration.currentuser.addGame(g.getmID());
                            }
                        }
                        else if (check.getVisibility()==View.VISIBLE){
                            check.setVisibility(View.INVISIBLE);
                            for (Game p:gamesList) {
                                if(p.getmName().equals(name.getText().toString()))
                                    Adminstration.currentuser.removeGame(p.getmID());
                            }
                        }
                    }
                });
            }
        }
        RecycleAdapter(Context mainActivityContacts, ArrayList<Game> platformsList) {
            this.gamesList = platformsList;
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
            Game game = gamesList.get(position);
            holder.name.setText(game.getmName());
            holder.image.setImageResource(game.getmPhoto());
            holder.platform.setText(game.getmPlatform());
        }
        @Override
        public int getItemCount() {
            return gamesList.size();
        }
    }
}
