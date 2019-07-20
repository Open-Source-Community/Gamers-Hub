package com.an.gamers;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.List;

public class Group_Main extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private ArrayList<Post> Postslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group__main);
        Postslist = new ArrayList<>();
        Postslist.add(new Post("Post1", "Ahmed", "OSC is an OpenSource Community", "14 feb 2019", "GR170"));
        Postslist.add(new Post("Post2", "Mai", "OSC Welcomed You", "14 feb 2019", "GR204"));
        recyclerView = findViewById(R.id.Group_main_recycler);
        adapter = new RecycleAdapter(this, Postslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
        Context context;
        private List<Post> postslist;

        void setPosts(List<Post> postList) {
            this.postslist = postList;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name, date, group_name;
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
