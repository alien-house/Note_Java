/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTree;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.AbstractDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author shinji
 */
public class NoteController {
    private NoteView myView;
    private NoteModel myModel;
    private DefaultMutableTreeNode root;
    TreePath pathForLocation;
    private TreePath path;
    
    public NoteController(NoteView myView, NoteModel myModel){
        this.myView = myView;
        this.myModel = myModel;
        this.myView.addLoadDataListener(new loaddataListner());
        this.myView.addSaveDataListener(new savedataListner());
        this.myView.addNewNoteListener(new newnoteListner());
        this.myView.addSelectTreeListener(new selecttreeListner());
        this.myView.addDocListener(new DocListener());
        this.myView.addMouseListener(new MyMouseListener());
        this.myView.addDeleteTreeListListener(new DeleteListener());
        
        this.myView.setListTree(this.myModel.getTextList());
    }
    
    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(root != null){
                //==========
//                myView.removeListTree();
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(root.toString());
                System.out.println("childNode:" + childNode);
                JTree tree = myView.getJTree();
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

                if(node != null && node.getParent() != null){
                    System.out.println("nodeは" + node + "です");
            //      root.remove(node);
                    DefaultTreeModel model = myView.getModel();
            //      node.removeFromParent();
                    tree.setSelectionPath(null);
                    model.removeNodeFromParent(node);
                    model.reload();
                }
            //================
    

//                    myView.removeListTree((root.getParent().getIndex(root)));
                
//                DefaultMutableTreeNode n = new DefaultMutableTreeNode();
//                JTree tree = myView.getJTree();
//                
//                DefaultTreeModel model = myView.getModel();
//                TreePath[] paths = tree.getSelectionPaths();
//                for (TreePath path : paths) {
//                    System.out.println("path:"+path);
//                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
//                
//                    System.out.println("node:"+node);
//                        model.removeNodeFromParent(node);
////                        System.out.println("@_@");
////                    if (node.getParent() != null) {
////                        model.removeNodeFromParent(node);
////                        System.out.println("*_-");
////                        System.out.println(node.toString());
////                        myModel.deleteTextData(node.toString());
////                    }
//                }
//                
                
//                    System.out.println("pressed:" + root.getParent().getIndex(root));
//                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(root.toString());
//                    System.out.println("childNode:" + childNode);
//                    root.remove(root.getParent().getIndex(root));
//                    root.remove(childNode);
//                    myModel.deleteTextData(root.toString());
//                    root.add(n);
//                    tree.repaint();
//                    tree.updateUI();
            }
        }
        
    }

    private class MyMouseListener extends MouseAdapter implements MouseListener{
        
        @Override
        public void mousePressed(MouseEvent arg0) {
            System.out.println("=======");
            System.out.println(arg0.getButton());
            if(arg0.getButton() == MouseEvent.BUTTON3){
                JTree tree = myView.getJTree();
                path = tree.getPathForLocation(arg0.getPoint().x, arg0.getPoint().y);
                pathForLocation = tree.getPathForLocation(arg0.getPoint().x, arg0.getPoint().y);
                if(pathForLocation != null){
                    root = (DefaultMutableTreeNode) pathForLocation.getLastPathComponent();
                } else{
                    root = null;
                }

            }
            super.mousePressed(arg0);
        }
    }

    
    private class DocListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            if (e instanceof AbstractDocument.DefaultDocumentEvent) {
                String str = myView.getTextString();
                if(root != null){
                    myModel.setTextDataToList(root.getParent().getIndex(root), str);
                    Boolean isSaved = myModel.saveTextData(root.toString(), str);
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
            root = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
//            System.out.println(node.getParent().getIndex(node));
//            System.out.println("You selected " + node);
//            
            String txt = myModel.getTextData(root.getParent().getIndex(root));
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
            
            if(root != null){
                Boolean isSaved = myModel.saveTextData(root.toString(), str);
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
