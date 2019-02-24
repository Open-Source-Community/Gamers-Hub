package com.an.gamers.Main_Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.an.gamers.Model_Classes.Post;
import com.an.gamers.R;

import java.util.ArrayList;
import java.util.List;

public class feed extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private ArrayList<Post> Postslist;
    public feed() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Postslist =new ArrayList<>();
        Postslist.add(new Post("Post1","1","OSC Welcomed You","14 feb","123"));
        Postslist.add(new Post("Post2","1","OSC Welcomed You","14 feb","123"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_feed, container, false);
        recyclerView = view.findViewById(R.id.feed_recycler);
        adapter = new RecycleAdapter(this.getActivity(), Postslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }
    class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
        Context context;
        private List<Post> postslist;
        void setPlatforms(List<Post> platformlist) {
            this.postslist = platformlist;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name,date,group_name;
            MultiAutoCompleteTextView content;

            MyViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.Post_card_img);
                name = view.findViewById(R.id.Post_card_name);
                date = view.findViewById(R.id.Post_card_date);
                group_name = view.findViewById(R.id.Post_card_groupname);
                content = view.findViewById(R.id.Post_card_postcontent);
            }
        }
        RecycleAdapter(Context mainActivityContacts, ArrayList<Post> posts) {
            this.postslist = posts;
            this.context = mainActivityContacts;
        }
        @Override
        public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.postcard, parent, false);
            return new RecycleAdapter.MyViewHolder(itemView);
        }
        @Override
        public void onBindViewHolder(final RecycleAdapter.MyViewHolder holder, int position) {
            Post post = postslist.get(position);
           // holder.name.setText(Adminstration.musers.get(post.getUserid()).getmUserName());//for real database
            holder.name.setText(post.getUserid());//prototype
            holder.image.setImageResource(R.drawable.osc_logo);
            holder.content.setText(post.getmContent());
            holder.group_name.setText(post.getmGroupid());
            holder.date.setText(post.getmDate());
        }
        @Override
        public int getItemCount() {
            return postslist.size();
        }
    }
}
