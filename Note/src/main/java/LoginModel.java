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
import java.io.FileNotFoundException;

/**
 *
 * @author shinji
 */
public class LoginModel {
    
    DatabaseReference ref;
    
    public LoginModel() throws FileNotFoundException{
        ref = NoteGlobals.getUserReference();
        
        
        UserAccount user = new UserAccount("komagire@gmaicom","papapa");
        Gson gson = new Gson();
        String text = gson.toJson(user);
        
        System.out.println(text);        // 「hello」と出力
        
//        Object user = {"kode","ase"};
//        ref.child("fhaiohrlaljkdad").child("komagiregmaicom").setValue("papapa");
        
        
        
        
        
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
