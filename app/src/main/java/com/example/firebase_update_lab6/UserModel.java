package com.example.firebase_update_lab6;

public class UserModel {
    private String mName;
    private String mEmail;


    public UserModel(String mName, String mEmail) {
        this.mName = mName;
        this.mEmail = mEmail;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
