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

/**
 *
 * @author shinji
 */
public class NoteModel {
    
    static String JSON_FILE_NAME = "/Users/shinji/Mydata/personalmarketing/english/canada/school/CICCC/subject/202/Note/javafinalproject-eaa83-firebase-adminsdk-fb4es-75ae0e7d75.json";
    static String URL = "https://javafinalproject-eaa83.firebaseio.com";
    
    // Get a reference to our posts
    final FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> titleList = new ArrayList<String>();
    
    
    public NoteModel() throws FileNotFoundException{
    
        // using Firebase 
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(new FileInputStream(JSON_FILE_NAME))
                .setDatabaseUrl(URL)
                .build();

        FirebaseApp.initializeApp(options);
        database = FirebaseDatabase.getInstance();
        listenerRetrieveData();
        
    }
    
    public Boolean saveTextData(String fileName, String str){
        
        Boolean isSaved = false;
        
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//
//        reference.child("key1").setValue("こんにちは！");
//        reference.child("key2").setValue("ファイアーベース");
//        reference.child("key3").setValue("よろしくお願いします！");
    
        return isSaved;    
    }
    
    
    public ArrayList getTextList(String fileName){
        ArrayList<String> titleList = new ArrayList<String>();
        
        return titleList;
    }
    
    public String getTextData(String fileName){
        String filecContents = "";
        ref = database.getReference("posts");
        
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
//                System.out.println(dataSnapshot.getKey());
//                System.out.println(dataSnapshot.getValue());
//                Post newPost = dataSnapshot.getValue(Post.class);
//                System.out.println("Author: " + newPost.author);
//                System.out.println("Title: " + newPost.title);
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

        return filecContents;
    }
    
    
    public void listenerRetrieveData(){
        
        ref = database.getReference("posts");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                titleList.add(dataSnapshot.getKey());
//                System.out.println(dataSnapshot.getKey());
//                System.out.println(dataSnapshot.getValue());
//                Post newPost = dataSnapshot.getValue(Post.class);
//                System.out.println("Author: " + newPost.author);
//                System.out.println("Title: " + newPost.title);
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
    
}
