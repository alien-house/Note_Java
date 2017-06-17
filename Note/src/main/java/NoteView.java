/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.AbstractDocument.DefaultDocumentEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author shinji
 */
public class NoteView extends JFrame {
    
    private JPanel controlPanel;
    private JButton loadButton = new JButton("Load Data");
    private JButton writeButton = new JButton("Write Data");
    private JButton newNoteButton = new JButton("New Note");
    private JTextArea txtArea = new JTextArea(5,5);
    private JTree tree;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode root;
    ArrayList<String> titleList = new ArrayList<String>();
    int gameHeight;
    
    public NoteView(){
        
//        Toolkit tk = Toolkit.getDefaultToolkit();  
//        int xSize = ((int) tk.getScreenSize().getWidth());  
//        int ySize = ((int) tk.getScreenSize().getHeight()); 
//        int gameHeight = (int) (Math.round(ySize * 0.80));
//        txtArea.setBounds(0, 0, 10, ySize);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setMargin(new Insets(10, 10, 10, 10));
//        txtArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.setTitle("Note");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 700, 600);
        JPanel centerPanel = new JPanel();
        this.getContentPane().setLayout(new BorderLayout(5, 5));
//        this.setLayout(new BorderLayout(5, 5));
        centerPanel.setBackground(Color.DARK_GRAY);
        add(centerPanel, BorderLayout.CENTER);
        
        makeTree();
        
        setGridFrameLeft();
        setGridFrameCenter();
    }
    
    
    public void setGridFrameLeft(){
        
        // Left
        JPanel compPanel = new JPanel();
        compPanel.setBackground(new Color(240, 240, 240));
        
//        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5)); 
        JPanel panel = new JPanel(); 
        panel.add(tree);
        compPanel.add(panel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newNoteButton);
        
        JPanel leftPanel = new JPanel(new BorderLayout(5, 5));
        leftPanel.add(compPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.PAGE_END);
        add(leftPanel, BorderLayout.LINE_START);
        
    }
    public void setGridFrameCenter(){
        
        JPanel compPanel = new JPanel();
        JPanel panel = new JPanel(new GridLayout(1, 1, 5, 5)); 
        panel.add(txtArea);
        compPanel.add(panel);
        compPanel.setBackground(Color.DARK_GRAY);
        panel.setBackground(Color.DARK_GRAY);
        
        
        JPanel centerPanel = new JPanel(new BorderLayout(50, 50));
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.add(compPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
        
    }
    
    
    
    public void setFrame(){
        
        makeTree();
        
        this.setLayout(new GridBagLayout());// set LayoutManager
        GridBagConstraints gbc = new GridBagConstraints();
        Border eBorder = BorderFactory.createEtchedBorder();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(2, 2, 2, 2);
        
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        
        JPanel panelLeft = new JPanel();
        panelLeft.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
        gbc.gridx = 0; //リーディングエッジを含むセルを指定
        gbc.gridy = 0; //上部にセルを指定
        gbc.gridwidth = 1; // 1 行のセル数を指定
        gbc.gridheight = 2; // 1 列のセル数を指定
        panelLeft.add(tree);
        add(panelLeft, gbc);
        
        gbc.weightx = 0.6;
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        add(panel1, gbc); // add compoenet to the COntentPane
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
//        panel1.add(txtArea);
//        panel1.add(writeButton);
        
            JPanel pCenter = new JPanel();
            pCenter.setLayout(new GridLayout(2,0));

            pCenter.add(txtArea);
            pCenter.add(writeButton);
            panel1.add(pCenter, BorderLayout.CENTER);
//        getContentPane().add(pCenter, BorderLayout.CENTER);


        gbc.weightx = 0.3;
        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder(eBorder, ""));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = /*gbc.gridheight = */1;
        gbc.gridheight = 2;
        add(panel3, gbc);
        setVisible(true);
        
    }
    
    public void makeTree(){
        String[] treedata = {};
        tree = new JTree(treedata);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setBackgroundSelectionColor(Color.DARK_GRAY);
        renderer.setBackgroundNonSelectionColor(new Color(240, 240, 240));

        tree.setCellRenderer(renderer);
        tree.setBackground(new Color(240, 240, 240));
        
        model = (DefaultTreeModel)tree.getModel();
        root = (DefaultMutableTreeNode) model.getRoot();
        
        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setBackground(new Color(240, 240, 240));
        scrollPane.getViewport().setView(tree);
        scrollPane.setPreferredSize(new Dimension(120, gameHeight));
    }
    
    
    public void addSelectTreeListener(TreeSelectionListener listenerforTree){
        tree.addTreeSelectionListener(listenerforTree);
    }
    
    public void addLoadDataListener(ActionListener listenerforLoadButton){
        loadButton.addActionListener(listenerforLoadButton);
    }
    
    public void addSaveDataListener(ActionListener listenerforSaveButton){
        writeButton.addActionListener(listenerforSaveButton);
    }
    
    public void addNewNoteListener(ActionListener listenerforNewButton){
        newNoteButton.addActionListener(listenerforNewButton);
    }
    
    public void addDocListener(DocumentListener listenerforSaveDocment){
        txtArea.getDocument().addDocumentListener(listenerforSaveDocment);
    }
    
    public void setListTree(ArrayList al){
        for (Object item: al){
            addListTree(((Posts)item).title);
        }
    }
    
    public void setTextData(String txt){
        txtArea.setText(txt);
    }
    
    public void addListTree(String txt){
        root.add(new DefaultMutableTreeNode(txt));
        model.reload();
    }

    public ArrayList getListTree(){
        return this.titleList;
    }
    
    public String getTextString(){
        return txtArea.getText();
    }
    
   
    
}
