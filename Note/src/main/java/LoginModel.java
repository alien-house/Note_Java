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
import java.io.FileNotFoundException;

/**
 *
 * @author shinji
 */
public class LoginModel {
    
    DatabaseReference ref;
    
    public LoginModel() throws FileNotFoundException{
        ref = NoteGlobals.getFireReference();
        
    }
    
}
