
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shinji
 */
public class LoginController {
    private LoginView myView;
    private LoginModel myModel;
    
    public LoginController(LoginView myView, LoginModel myModel){
        this.myView = myView;
        this.myModel = myModel;
//        this.myView.addLoginListener(new loginListner());
//        this.myView.addRegisterListener(new registerListner());
    }
    
    class loginListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("@_@");
//                if(name.equals(logEmailTextField.getText())){
//                    System.out.println("match");
//                    String passText = new String(logPassTextField.getPassword());
//                    if(passText.equals(pw)){
//                        System.out.println("(⊙◞౪◟⊙)"+passText);
//                    }
//                }else{
//                    System.out.println("mismatch");
//                }
            System.out.println("；；；_；");
        }
    }
    class registerListner implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("_@.....");
//                if(name.equals(logEmailTextField.getText())){
//                    System.out.println("match");
//                    String passText = new String(logPassTextField.getPassword());
//                    if(passText.equals(pw)){
//                        System.out.println("(⊙◞౪◟⊙)"+passText);
//                    }
//                }else{
//                    System.out.println("mismatch");
//                }
        }
    }
}
