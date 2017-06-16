/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author shinji
 */
public class NoteController {
    private NoteView myView;
    private NoteModel myModel;
    
    public NoteController(NoteView myView, NoteModel myModel){
        this.myView = myView;
        this.myModel = myModel;
        this.myView.addLoadDataListener(new loaddataListner());
        this.myView.addSaveDataListener(new savedataListner());
        this.myView.addSelectTreeListener(new selecttreeListner());
        this.myView.setListTree(this.myModel.getTextList());
    }
    
    
    class selecttreeListner implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            Object treeSource = e.getSource();
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
            System.out.println(node.getParent().getIndex(node));
            System.out.println("You selected " + node);
            
            String txt = myModel.getTextData(node.getParent().getIndex(node));
            myView.setTextData(txt);
        }
        
    }
    
    
    class savedataListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(".../");
//            String str = theView.getTextString();
//            Boolean isSaved = theModel.setTextData("newFile_re.txt",str);
//            System.out.println("😅");
//            System.out.println(isSaved);
        }
    }

    class loaddataListner implements ActionListener{

        @Override
        //Called just after the user performs an action.
        public void actionPerformed(ActionEvent e) {
            System.out.println("@_@");
//            String result = theModel.getTextData("newFile.txt");
//
//            theView.setTextSringLoad(result);
        }
    }
}
