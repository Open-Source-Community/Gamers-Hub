package com.an.gamers.AdminstrationLayouts;

import android.support.annotation.NonNull;

import com.an.gamers.Model_Classes.Game;
import com.an.gamers.Model_Classes.Group;
import com.an.gamers.Model_Classes.Platform;
import com.an.gamers.Model_Classes.Post;
import com.an.gamers.Model_Classes.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adminstration {
    public static User currentuser=new User();
    public static Map<String,Group> mGroups =new HashMap<>();
    public static Map<String,Platform> mPlateforms=new HashMap<>();
    public static Map<String,Post> mPosts=new HashMap<>();
    public static Map<String,User> musers=new HashMap<>();
    public static Map<String,Game> mGames=new HashMap<>();
    private DatabaseReference databaseRef;
    private final String users_s= "users";
    private final String groups_s="groups";
    private final String games_s= "games";
    private final String posts_s= "posts";
    private final String platform_s= "platforms";
    public void Adduser(User newuser) {
        databaseRef= FirebaseDatabase.getInstance().getReference(users_s);
        databaseRef.child(newuser.getmId_user()).setValue(newuser);
    }
    public void AddGame(Game newGame) {
        databaseRef= FirebaseDatabase.getInstance().getReference(games_s);
        databaseRef.child(newGame.getGroupId()).setValue(newGame);
        //add game shold create a group and call addgroup()
    }
    public void AddPlateform(Platform newPlatform) {
        databaseRef= FirebaseDatabase.getInstance().getReference(platform_s);
        databaseRef.child(newPlatform.getmGroupId()).setValue(newPlatform);
    }
    public void AddPost(Post newPost) {
        databaseRef= FirebaseDatabase.getInstance().getReference(posts_s);
        databaseRef.child(newPost.getmId()).setValue(newPost);
    }
    public void AddGroup(Group newGroup) {
        databaseRef= FirebaseDatabase.getInstance().getReference(groups_s);
        databaseRef.child(newGroup.getmID()).setValue(newGroup);
    }
    //Onstart bta3et login
    public void RetriveUsers() {
        databaseRef= FirebaseDatabase.getInstance().getReference(users_s);
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot usersnap:dataSnapshot.getChildren())
                {
                    User user=usersnap.getValue(User.class);
                    musers.put(user.getmId_user(),user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //Onstart bta3et el games
    public void RetriveGames() {
        databaseRef= FirebaseDatabase.getInstance().getReference(games_s);
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot gamesnap:dataSnapshot.getChildren())
                {
                    Game game=gamesnap.getValue(Game.class);
                    mGames.put(game.getmID(),game);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //Onstart bt3et el plateforms
    public void RetrivePlateforms() {
        databaseRef= FirebaseDatabase.getInstance().getReference(platform_s);
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot platformsnap:dataSnapshot.getChildren())
                {
                    Platform platform =platformsnap.getValue(Platform.class);
                    mPlateforms.put(platform.getmID(), platform);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //Onstart bta3et el com.an.gamers.Model_Classes.Group Or Newsfeed(Home)
    public void RetrivePosts(){
        databaseRef= FirebaseDatabase.getInstance().getReference(posts_s);
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postsnap:dataSnapshot.getChildren())
                {
                    Post post=postsnap.getValue(Post.class);
                    mPosts.put(post.getmId(),post);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    //Onstart Plateforms and Games
    public void RetriveGroups() {
        databaseRef= FirebaseDatabase.getInstance().getReference(groups_s);
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot groupsnap:dataSnapshot.getChildren())
                {
                    Group group=groupsnap.getValue(Group.class);
                    mGroups.put(group.getmID(),group);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Edituser(User updateuser) {
        databaseRef= FirebaseDatabase.getInstance().getReference(users_s).child(updateuser.getmId_user());
        databaseRef.setValue(updateuser);
    }
    public void Editgame(Game updategame){
        databaseRef= FirebaseDatabase.getInstance().getReference(games_s).child(updategame.getmID());
        databaseRef.setValue(updategame);
    }
    public void EditPlateform(Platform updateplatform) {
        databaseRef= FirebaseDatabase.getInstance().getReference(platform_s).child(updateplatform.getmID());
        databaseRef.setValue(updateplatform);
    }
    public void Editgroup(Group updategroup)    {
        databaseRef= FirebaseDatabase.getInstance().getReference(groups_s).child(updategroup.getmID());
        databaseRef.setValue(updategroup);
    }
    public void Editpost(Post updatepost) {
        databaseRef= FirebaseDatabase.getInstance().getReference(posts_s).child(updatepost.getmId());
        databaseRef.setValue(updatepost);
    }

    public void deleteuser(String userid) {
        databaseRef= FirebaseDatabase.getInstance().getReference(users_s).child(userid);
        databaseRef.removeValue();
    }
    public void deleteplatform(String platformid) {
        databaseRef= FirebaseDatabase.getInstance().getReference(platform_s).child(platformid);
        databaseRef.removeValue();
    }
    public void deletegroup(String groupid) {
        databaseRef= FirebaseDatabase.getInstance().getReference(groups_s).child(groupid);
        databaseRef.removeValue();
    }
    public void deletepost(String postid) {
        databaseRef= FirebaseDatabase.getInstance().getReference(posts_s).child(postid);
        databaseRef.removeValue();
    }
    public void deletegame(String gameid) {
        databaseRef= FirebaseDatabase.getInstance().getReference(games_s).child(gameid);
        databaseRef.removeValue();
    }
    public boolean login(String username,String password) {
        List<User> userlist = new ArrayList<User>(musers.values());
        for(User user:userlist)
        {
            if((user.getmUserName().equals(username) || user.getmEmail().equals(username))&&user.getmPassword().equals(password))
            {
                currentuser=user;
                return true;
            }

        }
        return false;
    }

    public void user_addgame(final Game addedgame, String user_id){
        databaseRef = FirebaseDatabase.getInstance().getReference(users_s).child(user_id);
        databaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User temp = dataSnapshot.getValue(User.class);
                List<String> favgames = temp.getmFav_Games();
                favgames.add(addedgame.getmID());
                temp.setmFav_Games(favgames);
                databaseRef.setValue(temp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void user_addpost(Post addedpost, String user_id){
        //addes post to a user and a group
        //add post to list of posts in user using its id
        String groupid = addedpost.getmGroupid();
        databaseRef = FirebaseDatabase.getInstance().getReference(posts_s);
        final DatabaseReference group_ref = FirebaseDatabase.getInstance().getReference(groups_s).child(groupid);
        final DatabaseReference user_ref = FirebaseDatabase.getInstance().getReference(users_s).child(user_id);

        //add post to db posts
        DatabaseReference post_ref =  databaseRef.push();//pushes an empty and creates a key for it
        final String key = post_ref.getKey();
        databaseRef.child(key).setValue(addedpost);//fill it with the new post
        //update user post list
        user_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //add post to list of posts in the group using its id
                User temp = dataSnapshot.getValue(User.class);
                List<String> posts = temp.getlPostsid();
                posts.add(key);
                temp.setlPostsid(posts);
                user_ref.setValue(temp);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //update group post list
        group_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //add post to list of posts in the group using its id
                Group temp = dataSnapshot.getValue(Group.class);
                List<String> posts = temp.getlPostsid();
                posts.add(key);
                temp.setlPostsid(posts);
                group_ref.setValue(temp);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void user_addplatform(Platform addedplat, String user_id){
        //add platform to user's fav platform list
        //databaseroot.child("user").child(user_id).child("favplats").push(addedplat.getid());
        databaseRef = FirebaseDatabase.getInstance().getReference(platform_s);
        DatabaseReference plat_ref =  databaseRef.push();//pushes an empty and creates a key for it
        final String key = plat_ref.getKey();
        databaseRef.child(key).setValue(addedplat);//fill it with the new post
    }
    public Post getbyid_post(String search_id){
        Post post=new Post();
        if(mPosts.containsKey(search_id))
            post = mPosts.get(search_id);
        return post;
    }
    public Game getbyid_game(String search_id){
        Game game=new Game();
        if(mGames.containsKey(search_id))
            game = mGames.get(search_id);
        return game;
    }
    public Platform getbyid_platform(String search_id){
        Platform plat=new Platform();
        if(mPlateforms.containsKey(search_id))
            plat = mPlateforms.get(search_id);
        return plat;
    }

}
