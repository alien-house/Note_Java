
import java.io.FileNotFoundException;

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
    
    public static void main(String[] args) throws FileNotFoundException {
        
        NoteModel myModel = new NoteModel();
        NoteView myView = new NoteView();
        NoteController myController = new NoteController(myView, myModel);
        myView.setVisible(true);
        
        
//        System.out.println("whwywhwywhwywy");
        
        
        
    }
    
}
