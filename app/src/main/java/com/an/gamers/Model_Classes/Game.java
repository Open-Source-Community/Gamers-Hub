package com.an.gamers.Model_Classes;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.widget.ImageView;

public class Game
{
    private String game_id;
    private String game_name;
    private String game_platform;
    private float game_popularity;
    private String game_photo;
    private String game_description;
    private int game_numberofusers;

    public Game(){

    }
    public Game(final String inDBid) {
     //   fetch_from_db(inDBid);
    }

    public String getName(){return game_name;}
    public String getPlatform(){return game_platform;}
    public float getPopularity(){return game_popularity;}
    public void getImage(Context context, ImageView imageView) {
        Image game_image=null;
        //Picasso.get().load(game_photo).into(imageView);
    }
    public String getGame_description(){return game_description;}
    public String getImageLink() {
        return game_photo;
    }

/* public void push_to_database(){
        //push already filled game object to DB
        db = FirebaseDatabase.getInstance().getReference();
        db.child("game").setValue(this);
        //confirm push
    }
    public void fetch_from_db(String inDBid) {
        //get data from DB
        DatabaseReference db2 = db.child("game").child(inDBid).getRef();
        this.game_id=inDBid;
        db2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                Game tmp = dataSnapshot.getValue(Game.class);
                //fill containing game object
                Game.this.game_description = tmp.getGame_description();
                Game.this.game_name=tmp.getName();
                Game.this.game_photo=tmp.getImageLink();
                Game.this.game_platform=tmp.getPlatform();
                Game.this.game_popularity=tmp.getPopularity();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //fill above properties
    }*/
}
