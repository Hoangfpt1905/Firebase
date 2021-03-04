package com.example.firebase_update_lab6;

import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DbFirebaseHelper {

    private FirebaseDatabase mInstance; // lấy về ví dụ
    private DatabaseReference mResponse; // lấy về db
    private String USER_ID;


    public void createUser(String name, String email) {
        mInstance = FirebaseDatabase.getInstance();
        mResponse = mInstance.getReference("UserModel");
        if (TextUtils.isEmpty(USER_ID)) {
            USER_ID = mResponse.push().getKey();
        }
        UserModel userModel = new UserModel(name, email);
        mResponse.child(USER_ID).setValue(userModel); // insert du lieu

    }

    public void updateUser(String name, String email) {
        mInstance = FirebaseDatabase.getInstance();
        mResponse = mInstance.getReference("UserModel");
        if (!TextUtils.isEmpty(name))
            mResponse.child(USER_ID).child("name").setValue(name); // cap nhat truong du lieu name
        if (!TextUtils.isEmpty(email))
            mResponse.child(USER_ID).child("email").setValue(email); // cap nhat truong du lieu email

    }

    public void ursChangeListener(final TextView textView) {
        mResponse.child(USER_ID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.getValue(UserModel.class);
                textView.setText(userModel.getName() + ": " + userModel.getEmail());

                List<UserModel> mList = new ArrayList<>();
                for (DataSnapshot d : snapshot.getChildren()) {
                    UserModel userModel1 = snapshot.getValue(UserModel.class);
                    mList.add(userModel1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                textView.setText(error.getMessage());
            }
        });
    }

}
