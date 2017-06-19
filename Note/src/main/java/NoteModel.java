/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author shinji
 */
public class NoteModel {
    
    // Get a reference to our posts
    DatabaseReference ref;
//    private ArrayList<String> titleList = new ArrayList<String>();
    private ArrayList<Posts> postList = new ArrayList<Posts>();
    private Map<String, String> map = new HashMap<>();
    
    
    public NoteModel() throws FileNotFoundException{
        
//        // using Firebase 
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setServiceAccount(new FileInputStream(NoteGlobals.FIREBASE_JSON))
//                .setDatabaseUrl(NoteGlobals.FIREBASE_URL)
//                .build();
//
//        FirebaseApp.initializeApp(options);
//        database = FirebaseDatabase.getInstance();
//        ref = database.getReference("posts");
        ref = NoteGlobals.getFireReference();
        listenerRetrieveData();
        
    }
    
    public Boolean saveTextData(String key, String str){
        
        Boolean isSaved = false;
//        System.out.println(key);
//        System.out.println(str);
        ref.child(key).setValue(str);
        isSaved = true;
        
//        reference.child("key1").setValue("こんにちは！");
    
        return isSaved;    
    }
    
    public void deleteTextData(String key){
        ref.child(key).removeValue();
        
    }
    
    public String getTextData(int index){
        
        if(this.postList.get(index) == null){
            return "";
        }else{
            return this.postList.get(index).contents;
        }
        
    }
    
    public ArrayList getTextList(){
        return this.postList;
    }
    
    public void setTextDataToList(int index, String s){
        
        if(this.postList.get(index) != null){
            this.postList.get(index).contents = s;
        }
        
    }
    
    
    public void listenerRetrieveData(){
        
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                System.out.println(dataSnapshot.getKey());
//                System.out.println(dataSnapshot.getValue());
                Posts newPost = new Posts(dataSnapshot.getKey(),dataSnapshot.getValue().toString());
                postList.add(newPost);
                
//                map.put(dataSnapshot.getKey(),dataSnapshot.getValue());
//                titleList.add(dataSnapshot.getKey());
//                System.out.println(dataSnapshot.getValue());
//                Post newPost = dataSnapshot.getValue(Post.class);
//                System.out.println("Author: " + newPost.author);
//                System.out.println("Previous Post ID: " + prevChildKey);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }
    
    public void addListData(String key, String contents){
        Posts newPost = new Posts(key, contents);
        postList.add(newPost);
    }
    
    public int comparePostListTitle(String key){
        int num = 0;
        for(Posts item:postList){
            if(item.title.contains(key)){
                num++;
            }
        }
        return num;
    }
    
}
