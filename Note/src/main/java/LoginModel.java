/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.tasks.OnCompleteListener;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author shinji
 */
public class LoginModel {
    
    DatabaseReference ref;
    LinkedHashMap<String, String> userList;
            
    public LoginModel() throws FileNotFoundException{
//        UserAccount user = new UserAccount("komagire@gmaicom","papapa");
//        Gson gson = new Gson();
//        String text = gson.toJson(user);
        
        ref = NoteGlobals.getUserReference();
        
        ref.orderByKey().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot ds, String string) {
//                System.out.println(ds.getKey());
//                System.out.println(ds.getValue());
                NoteGlobals.setUserData(ds.getKey(),ds.getValue());
//              
//                System.out.println(ds);
            }
            @Override
            public void onChildChanged(DataSnapshot ds, String string) {
                }

            @Override
            public void onChildRemoved(DataSnapshot ds) {
                }

            @Override
            public void onChildMoved(DataSnapshot ds, String string) {
                }

            @Override
            public void onCancelled(DatabaseError de) {
                }
        });
        
        
//        ref.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
////                System.out.println(dataSnapshot.getValue());
//                Gson gsons = new Gson();
////                NoteGlobals.setUserData(new HashMap<String, Object>((Map<? extends String, ? extends Object>) dataSnapshot.getValue()));
////                Map<String, Object> map1 = new HashMap<String, Object>((Map<? extends String, ? extends Object>) dataSnapshot.getValue()); 
//////                HashMap<String, Object> hashmap = dataSnapshot.getValue();
//////                HashMap<String, Object> hashmap = new HashMap<String, Object>( dataSnapshot.getValue());
//////                Map<String, Object> map = new HashMap( dataSnapshot.getValue());
////                
////                System.out.println("user number"+ map1.size());
////                map1.forEach((x,y)-> {
//////                    System.out.println("key : " + x + " , value : " + y);
//////                    System.out.println(y.getClass());
////
////                    userList = new LinkedHashMap<String, String>( (Map<? extends String, ? extends String>) y);
////                    userList.forEach((x2,y2)-> {
//////                        System.out.println("key2 : " + x2 + " , value2 : " + y2);
////                    });
////                });
//                
////                JsonElement json = gson.fromJson(dataSnapshot.getValue(), JsonElement.class);
////                String result = gsons.toJson(dataSnapshot.getValue());
////                System.out.println(result);
////                gsons.fromJson(dataSnapshot.getValue());
////                Gson gsons = dataSnapshot.getValue();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // ...
//            }
//        });
        
        
//        System.out.println(text);        // 「hello」と出力
        
//        Object user = {"kode","ase"};
//        ref.child("user1").child("email").setValue("komagire@gmai.com");
//        ref.child("user1").child("pass").setValue("papapa");
//        
//        ref.child("user2").child("email").setValue("mousiwakenai@gmai.com");
//        ref.child("user2").child("pass").setValue("ooo");
        
//        ref.child("user3").child("email").setValue("kokokokok@gmai.com");
//        ref.child("user3").child("pass").setValue("dafae");
//        
//        ref.child("user4").child("email").setValue("wajoiyr@gmai.com");
//        ref.child("user4").child("pass").setValue("dafae");
//        
//        ref.child("user5").child("email").setValue("loiyd@gmai.com");
//        ref.child("user5").child("pass").setValue("dafae");
        
        
//        firebase.auth().signInWithEmailAndPassword(email, password).catch(function(error) {
//            // Handle Errors here.
//            var errorCode = error.code;
//            var errorMessage = error.message;
//            // ...
//        });
//        mAuth.createUser

//        ref.createUser("harry@foo.com", "badPassword", new Firebase.ValueResultHandler<Map<String, Object>>() {
//
//            public void onSuccess(Map<String, Object> result) {
//                System.out.println("New account with uid: " + result.get("uid"));
//            }
//
//            public void onError(FirebaseError firebaseError) {
//                // there was an error
//            }
//        });
    }
    
    
    
}
