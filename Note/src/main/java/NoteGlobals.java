
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
    public static DatabaseReference ref;
    
    public static DatabaseReference getFireReference() throws FileNotFoundException{
        if(ref != null){
            return ref;
        }else{
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setServiceAccount(new FileInputStream(FIREBASE_JSON))
                    .setDatabaseUrl(NoteGlobals.FIREBASE_URL)
                    .build();

            FirebaseApp.initializeApp(options);
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            ref = database.getReference("posts");
            return ref;
        }
    }
    
}
