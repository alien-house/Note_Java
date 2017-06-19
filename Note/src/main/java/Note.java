
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shinji
 */
public class Note {
    
    public static void main(String[] args) {
                    
        LoginModel loginModel;
        try {
            loginModel = new LoginModel();
            LoginView loginView = new LoginView();
            loginView.start();
            LoginController loginController = new LoginController(loginView, loginModel);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NoteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//
//        NoteModel myModel = new NoteModel();
//        NoteView myView = new NoteView();
//        NoteController myController = new NoteController(myView, myModel);
//        myView.setVisible(true);


//
//        LoginView frame = new LoginView();
//        frame.start();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
        
        
//        System.out.println("whwywhwywhwywy");
        
        
        
    }
    
}
