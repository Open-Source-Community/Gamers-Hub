package com.an.gamers.Model_Classes;

public class Game {
    private String mID;
    private String mName;
    private String mDescreption;
    private String mPlatform;
    private String mPhoto;
    private String mWebsite;
    private String GroupId;
    private int mRate;
    private int mUsersNum;
    private static int mCurrentUsers;
    public Game()
    {
    }

    public Game(String mID, String mName, String mDescreption, String mPlatform, String mPhoto, String mWebsite, String groupId) {
        this.mID = mID;
        this.mName = mName;
        this.mDescreption = mDescreption;
        this.mPlatform = mPlatform;
        this.mPhoto = mPhoto;
        this.mWebsite = mWebsite;
        GroupId = groupId;
        mCurrentUsers=0;
        mRate=0;
        mUsersNum=0;
    }
    public void udatecureentusers()
    {
        mCurrentUsers=mCurrentUsers+1;
        ratecalc();
    }

    public void setmUsersNum(int mUsersNum) {
        this.mUsersNum = mUsersNum;


    }
    private void ratecalc()
    {
        float div=(mCurrentUsers/mUsersNum);
        mRate=(int)div*100;
    }
    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescreption() {
        return mDescreption;
    }

    public void setmDescreption(String mDescreption) {
        this.mDescreption = mDescreption;
    }

    public String getmPlatform() {
        return mPlatform;
    }

    public void setmPlatform(String mPlatform) {
        this.mPlatform = mPlatform;
    }

    public String getmPhoto() {
        return mPhoto;
    }

    public void setmPhoto(String mPhoto) {
        this.mPhoto = mPhoto;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public void setmWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }
}
