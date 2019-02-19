package com.an.gamers.AdminstrationLayouts;

import com.an.gamers.Model_Classes.Game;
import com.an.gamers.Model_Classes.Group;
import com.an.gamers.Model_Classes.Platform;
import com.an.gamers.Model_Classes.Post;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Adminstration
{
    //User currectuser;
    private Map gamelist = new HashMap();
    private Map platfromlist = new HashMap();
    private Map postlist = new HashMap();
    private DatabaseReference databaseroot;

    Adminstration(){
        databaseroot =FirebaseDatabase.getInstance().getReference();
    }
    public void user_addgame(Game addedgame, String user_id){
        databaseroot.child(user_id);

    };
    public void user_addpost(Game addedgame,String user_id){

    };
    public void user_addplatform(Game addedgame,String user_id){

    };
    public void create_group(Game groupgame){
        Group added = new Group();
        //create group id
        //added.setname(groupgame.getname+" community");


    }
    public Post getbyid_post(String search_id){
        Post post=new Post();
        if(postlist.containsKey(search_id))
            post =(Post) postlist.get(search_id);
        return post;
    }
    public Game getbyid_game(String search_id){
        Game game=new Game();
        if(gamelist.containsKey(search_id))
            game =(Game) gamelist.get(search_id);
        return game;
    }
    public Platform getbyid_platform(String search_id){
        Platform plat=new Platform();
        if(platfromlist.containsKey(search_id))
            plat =(Platform) platfromlist.get(search_id);
        return plat;
    }
}
