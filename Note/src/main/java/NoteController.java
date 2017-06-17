/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author shinji
 */
public class NoteController {
    private NoteView myView;
    private NoteModel myModel;
    private DefaultMutableTreeNode node;
    
    public NoteController(NoteView myView, NoteModel myModel){
        this.myView = myView;
        this.myModel = myModel;
        this.myView.addLoadDataListener(new loaddataListner());
        this.myView.addSaveDataListener(new savedataListner());
        this.myView.addNewNoteListener(new newnoteListner());
        this.myView.addSelectTreeListener(new selecttreeListner());
        this.myView.addDocListener(new DocListener());
        
        this.myView.setListTree(this.myModel.getTextList());
    }
    
    
    private class DocListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (e instanceof AbstractDocument.DefaultDocumentEvent) {
                String str = myView.getTextString();
                if(node != null){
                    myModel.setTextDataToList(node.getParent().getIndex(node), str);
                    Boolean isSaved = myModel.saveTextData(node.toString(), str);
                }
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {}
        @Override
        public void changedUpdate(DocumentEvent e) {}
    }   
    
    class selecttreeListner implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            Object treeSource = e.getSource();
            node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
//            System.out.println(node.getParent().getIndex(node));
//            System.out.println("You selected " + node);
//            
            String txt = myModel.getTextData(node.getParent().getIndex(node));
            myView.setTextData(txt);
        }
        
    }
    
    class newnoteListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int num = myModel.comparePostListTitle("new Post");
            System.out.println("@@@@@@"+num);
            String fileName = "new Post";
            if(num > 0){
                fileName += num;
            }
            myModel.addListData(fileName, "");
            myView.addListTree(fileName);
//            myView.setListTree(myModel.getTextList());
        }
        
    }
    
    class savedataListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(".../");
            String str = myView.getTextString();
            
            if(node != null){
                Boolean isSaved = myModel.saveTextData(node.toString(), str);
            }
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
