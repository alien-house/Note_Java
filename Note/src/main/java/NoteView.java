/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author shinji
 */
public class NoteView extends JFrame {
    
    
  static String JSON_FILE_NAME = "/Users/shinji/Mydata/personalmarketing/english/canada/school/CICCC/subject/202/Note/javafinalproject-eaa83-firebase-adminsdk-fb4es-75ae0e7d75.json";
  static String URL = "https://javafinalproject-eaa83.firebaseio.com";
    
    private JPanel controlPanel;
    private JButton loadButton = new JButton("Load Data");
    private JButton writeButton = new JButton("Write Data");
    private JTextArea txtArea = new JTextArea("",5,10);
    private JTree tree;
    
    public NoteView() throws FileNotFoundException{
        controlPanel = new JPanel();
        this.setTitle("Load Data");
        this.setLayout(new GridLayout(3, 3));
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("JavaDrive");
        DefaultTreeModel model = new DefaultTreeModel(root);

        DefaultMutableTreeNode swing = new DefaultMutableTreeNode("Swing");
        DefaultMutableTreeNode java2d = new DefaultMutableTreeNode("Java2D");
        DefaultMutableTreeNode java3d = new DefaultMutableTreeNode("Java3D");
        DefaultMutableTreeNode javamail = new DefaultMutableTreeNode("JavaMail");

        DefaultMutableTreeNode swingSub1 = new DefaultMutableTreeNode("JLabel");
        DefaultMutableTreeNode swingSub2 = new DefaultMutableTreeNode("JButton");
        DefaultMutableTreeNode swingSub3 = new DefaultMutableTreeNode("JTextField");

        swing.add(swingSub1);
        swing.add(swingSub2);
        swing.add(swingSub3);

        root.add(swing);
        root.add(java2d);
        root.add(java3d);
        root.add(javamail);

        tree = new JTree(model);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(tree);
        scrollPane.setPreferredSize(new Dimension(180, 120));
        
        
        
DefaultMutableTreeNode node = 
      (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

        model.nodeChanged(node);

        root.remove(java2d);
        model.reload();
        
        
//        GroupLayout layout = new GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//
//        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);
// 
//        layout.setHorizontalGroup(
//        layout.createSequentialGroup()
//        .addGroup(layout.createParallelGroup()
//            .addComponent(lblName)
//            .addComponent(lblAddress))
//        .addGroup(layout.createParallelGroup()
//            .addComponent(txtName)
//            .addComponent(txtAddress))
//        .addGroup(layout.createParallelGroup()
//            .addComponent(button1)
//            .addComponent(button2)));

        
        controlPanel.add(scrollPane);
        controlPanel.add(txtArea);
        controlPanel.add(writeButton);
        controlPanel.add(loadButton);
        this.add(controlPanel);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // using Firebase 
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setServiceAccount(new FileInputStream(JSON_FILE_NAME))
//                .setDatabaseUrl(URL)
//                .build();
//
//        FirebaseApp.initializeApp(options);
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//
//        reference.child("key1").setValue("こんにちは！");
//        reference.child("key2").setValue("ファイアーベース");
//        reference.child("key3").setValue("よろしくお願いします！");





    }
    
    public void addLoadDataListener(ActionListener listenerforLoadButton){
        loadButton.addActionListener(listenerforLoadButton);
    }
    
    public void addSaveDataListener(ActionListener listenerforSaveButton){
        writeButton.addActionListener(listenerforSaveButton);
    }
    
}
