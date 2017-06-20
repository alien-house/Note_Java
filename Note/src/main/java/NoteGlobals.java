
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shinji
 */
public class NoteGlobals {
    
    public static String FIREBASE_JSON = "/Users/shinji/Mydata/personalmarketing/english/canada/school/CICCC/subject/202/Note/javafinalproject-eaa83-firebase-adminsdk-fb4es-75ae0e7d75.json";
    public static String FIREBASE_URL = "https://javafinalproject-eaa83.firebaseio.com";
    public static FirebaseDatabase database;
    public static DatabaseReference postRef = null;
    public static DatabaseReference userRef = null;
    public static LinkedHashMap<String, Object> userList = new LinkedHashMap<>();
    
    public static DatabaseReference getPostReference(String userID){
        if(postRef != null){
            return postRef;
        }else{
            if(database == null){
                try{
                    createFireDatabase();
                }catch(FileNotFoundException e){
                    System.out.println("no database");
                }
            }
            postRef = database.getReference("posts").child(userID);
            return postRef;
        }
    }
    public static FirebaseAuth getFirebaseAuth(){
        FirebaseAuth defaultAuth = FirebaseAuth.getInstance();
        return defaultAuth;
    }
    
    public static DatabaseReference getUserReference(){
        if(userRef != null){
            return userRef;
        }else{
            if(database == null){
                try{
                    createFireDatabase();
                }catch(FileNotFoundException e){
                    System.out.println("no database");
                }
            }
            userRef = database.getReference("user");
            return userRef;
        }
        
    }
    public static void setUserData(String key, Object obj){
        userList.put(key,obj);
//        userList = new LinkedHashMap<String, Object>(map); 
        
//        userList.forEach((x,y)-> {
//               System.out.println("key: : " + x + " , value: : " + y);
//        });

    }
    public static LinkedHashMap getUserData(){
        return userList;
    }
    
    
    private static void createFireDatabase() throws FileNotFoundException{
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(new FileInputStream(FIREBASE_JSON))
                .setDatabaseUrl(NoteGlobals.FIREBASE_URL)
                .build();

        FirebaseApp.initializeApp(options);
        database = FirebaseDatabase.getInstance();
    }
    
}
