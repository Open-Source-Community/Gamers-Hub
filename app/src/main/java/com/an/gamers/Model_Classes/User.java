package com.an.gamers.Model_Classes;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User {
   private String mId_user;
   private String mUserName;
   private String mEmail;
   private String mPassword;
   private List<String> mFav_Platforms;
   private List<String> mFav_Games;
   private List<String> Groups;
   private String mPhoto;
   private List<String> lPostsid;
   private List<String> lReportid;
    public User()
    {
    }



    public User(String mId_user, String mUserName, String mEmail, String mPassword, List<String> mFav_Platforms, List<String> mFav_Games, List<String> groups, String mPhoto, List<String> lPostsid, List<String> lReportid) {
        this.mId_user = mId_user;
        this.mUserName = mUserName;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mFav_Platforms = mFav_Platforms;
        this.mFav_Games = mFav_Games;
        Groups = groups;
        this.mPhoto = mPhoto;
        this.lPostsid = lPostsid;
        this.lReportid = lReportid;
    }

    public List<String> getlPostsid() {
        return lPostsid;
    }

    public void setlPostsid(List<String> lPostsid) {
        this.lPostsid = lPostsid;
    }

    public List<String> getlReportid() {
        return lReportid;
    }

    public void setlReportid(List<String> lReportid) {
        this.lReportid = lReportid;
    }

    public String getmId_user() {
        return mId_user;
    }

    public void setmId_user(String mId_user) {
        this.mId_user = mId_user;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public List<String> getmFav_Platforms() {
        return mFav_Platforms;
    }

    public void setmFav_Platforms(List<String> mFav_Platforms) {
        this.mFav_Platforms = mFav_Platforms;
    }

    public List<String> getmFav_Games() {
        return mFav_Games;
    }

    public void setmFav_Games(List<String> mFav_Games) {
        this.mFav_Games = mFav_Games;
    }

    public List<String> getGroups() {
        return Groups;
    }

    public void setGroups(List<String> groups) {
        Groups = groups;
    }

    public String getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }
}
