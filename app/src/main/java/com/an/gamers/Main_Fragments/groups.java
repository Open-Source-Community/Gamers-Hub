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
import android.widget.TextView;

import com.an.gamers.Model_Classes.Group;
import com.an.gamers.R;

import java.util.ArrayList;
import java.util.List;

public class groups extends Fragment {
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private ArrayList<Group> groups;

    public groups() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        groups = new ArrayList<>();
        groups.add(new Group("GTA V Group"));
        groups.add(new Group("Pubg Group"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groups, container, false);
        recyclerView = view.findViewById(R.id.groups_recycler);
        adapter = new RecycleAdapter(this.getActivity(), groups);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }

    class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
        Context context;
        private List<Group> groupList;

        void setGroups(List<Group> groups) {
            this.groupList = groups;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;

            MyViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.Group_card_img);
                name = view.findViewById(R.id.Group_card_name);
            }
        }

        RecycleAdapter(Context mainActivityContacts, ArrayList<Group> groups) {
            this.groupList = groups;
            this.context = mainActivityContacts;
        }

        @Override
        public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.groupcard, parent, false);
           /* itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    groups.this.startActivity(new Intent(groups.this.getContext(), Group_Main.class));
                    groups.this.getActivity().finish();
                }
            });*/
            return new RecycleAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final RecycleAdapter.MyViewHolder holder, int position) {
            Group group = groupList.get(position);
            holder.name.setText(group.getmName());//prototype
            holder.image.setImageResource(R.drawable.osc_logo);
        }

        @Override
        public int getItemCount() {
            return groupList.size();
        }
    }
}
