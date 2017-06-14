/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author shinji
 */
public class NoteView extends JFrame {
    
    private JPanel controlPanel;
    private JButton loadButton = new JButton("Load Data");
    private JButton writeButton = new JButton("Write Data");
    private JTextArea txtArea = new JTextArea(10,20);
    private JTree tree;
    private DefaultTreeModel model;
    private DefaultMutableTreeNode root;

    
    public NoteView(){
        
        this.setTitle("Note");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
//        model.insertNodeInto(new DefaultMutableTreeNode("another_child"), root, root.getChildCount());
        setFrame();
    }


    
    public void setFrame(){
        
        String[] treedata = {""};
        tree = new JTree(treedata);
        model = (DefaultTreeModel)tree.getModel();
        root = (DefaultMutableTreeNode) model.getRoot();
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setView(tree);
        scrollPane.setPreferredSize(new Dimension(180, 120));
        
        this.setLayout(new GridBagLayout());// set LayoutManager
        GridBagConstraints gbc = new GridBagConstraints();
        Border eBorder = BorderFactory.createEtchedBorder();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        gbc.weightx = 0.1;
        gbc.weighty = 1;
        //left
        JPanel panelLeft = new JPanel();
        panelLeft.setBorder(BorderFactory.createTitledBorder(eBorder, "List"));
        gbc.gridx = 0; //リーディングエッジを含むセルを指定
        gbc.gridy = 0; //上部にセルを指定
        gbc.gridwidth = 1; // 1 行のセル数を指定
        gbc.gridheight = 2; // 1 列のセル数を指定
//        gbc.weightx = gbc.weighty = 20; //余分の水平スペースを分配する方法を指定
        panelLeft.add(tree);
        add(panelLeft, gbc);
        
        gbc.weightx = 0.6;
        //center : editor
        JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder(eBorder, "70pct"));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
//        gbc.weightx = gbc.weighty = 30;
        add(panel1, gbc); // add compoenet to the COntentPane
        panel1.add(txtArea);

        gbc.weightx = 0.3;
        //right : preview
        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder(eBorder, "20pct"));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = /*gbc.gridheight = */1;
        gbc.gridheight = 2;
//        gbc.weightx = /*gbc.weighty = */20;
        //コンポーネントの外側のパディング、つまりコンポーネントとその表示領域の端までの領域の最小値を指定します。
        gbc.insets = new Insets(2, 2, 2, 2);
        add(panel3, gbc);


//        pack();
        setVisible(true); // important
    }
    
    public void addLoadDataListener(ActionListener listenerforLoadButton){
        loadButton.addActionListener(listenerforLoadButton);
    }
    
    public void addSaveDataListener(ActionListener listenerforSaveButton){
        writeButton.addActionListener(listenerforSaveButton);
    }
    
    public void setListTree(String txt){
    }
    public void addListTree(String txt){
        root.add(new DefaultMutableTreeNode("another_child"));
        model.reload();
    }

}
