/*
 * @(#)PopupMenuTest.java  1.0  13 February 2005
 *
 * Copyright (c) 2004 Werner Randelshofer
 * Staldenmattweg 2, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * The copyright of this software is owned by Werner Randelshofer. 
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * Werner Randelshofer. For details see accompanying license terms. 
 */

package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.plaf.*;
import javax.swing.border.*;
import ch.randelshofer.quaqua.*;
/**
 * PopupMenuTest.
 *
 * @author  Werner Randelshofer
 * @version 1.0  13 February 2005  Created.
 */
public class PopupMenuTest extends javax.swing.JPanel {
    private JPopupMenu popupMenu;
    
    /** Creates new form. */
    public PopupMenuTest() {
        initComponents();
        
        ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println(evt);
            }
        };
        
        JPopupMenu pm = new JPopupMenu();
        JMenu m;
        JMenuItem mi;
        JCheckBoxMenuItem cbmi;
        JRadioButtonMenuItem crmi;
        mi = new JMenuItem("Menu Item 1");
        mi.addActionListener(a);
        pm.add(mi);
        mi = new JMenuItem("Menu Item 2");
        mi.addActionListener(a);
        pm.add(mi);
        mi = new JMenuItem("Menu Item 3");
        mi.addActionListener(a);
        pm.add(mi);
        
        m = new JMenu("Menu 1");
        mi = new JMenuItem("Menu Item 1.1");
        mi.addActionListener(a);
        m.add(mi);
        mi = new JMenuItem("Menu Item 1.2");
        mi.addActionListener(a);
        m.add(mi);
        pm.add(m);
        
        pm.addSeparator();
        cbmi = new JCheckBoxMenuItem("Checkbox Menu Item");
        pm.add(cbmi);
        
        pm.addSeparator();
        ButtonGroup group = new ButtonGroup();
        crmi = new JRadioButtonMenuItem("Radio Menu Item 1");
        crmi.setSelected(true);
        group.add(crmi);
        pm.add(crmi);
        
        crmi = new JRadioButtonMenuItem("Radio Menu Item 2");
        group.add(crmi);
        pm.add(crmi);
        popupMenu = pm;
        
        /*
        //setComponentPopupMenu(pm);
        //jLabel1.setComponentPopupMenu(pm);
        JButton button = new JButton("Hi");
        // button.setComponentPopupMenu(pm);
        button.setInheritsPopupMenu(true);
        add(button, BorderLayout.SOUTH);
         */
        MouseAdapter popper1 = new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    showPopupMenu(evt);
                }
            }
            public void mouseReleased(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    showPopupMenu(evt);
                }
            }
            protected void showPopupMenu(MouseEvent evt) {
                popupMenu.show((Component) evt.getSource(), evt.getX(), evt.getY());
            }
            
        };
        
        popupLabel1.addMouseListener(popper1);
        popupField.addMouseListener(popper1);
        
        MouseAdapter popper2 = new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    showPopupMenu(evt);
                }
            }
            public void mouseReleased(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    showPopupMenu(evt);
                }
            }
            protected void showPopupMenu(MouseEvent evt) {
                Dimension ps = popupMenu.getPreferredSize();
                popupMenu.show(popupLabel2, 
                        evt.getX() - ps.width / 2, 
                        evt.getY() - ps.height / 2);
            }
            
        };
        
        popupLabel2.addMouseListener(popper2);
    }
    
    
    public static void main(String args[]) {
        //UIManager.put("PopupMenu.border", new BorderUIResource.EmptyBorderUIResource(4,0,4,0));
        
        try {
            UIManager.setLookAndFeel(QuaquaManager.getLookAndFeelClassName());
            //   UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame("PopupMenuTest: "+UIManager.getLookAndFeel().getName());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new PopupMenuTest());
        f.pack();
        f.setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        popupLabel1 = new javax.swing.JLabel();
        popupLabel2 = new javax.swing.JLabel();
        popupField = new javax.swing.JTextField();
        noteLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        popupLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        popupLabel1.setText("<html>Open a popup menu here, which is having its top left corner under the mouse pointer.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(popupLabel1, gridBagConstraints);

        popupLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        popupLabel2.setText("<html>Open a popup menu here which, is being centered unter the mouse pointer.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(popupLabel2, gridBagConstraints);

        popupField.setText("Open a popup menu over this entry field.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(popupField, gridBagConstraints);

        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noteLabel.setText("<html>There are two ways to use a popup menu: <ul><li>Ctrl+Click to open the popup menu followed by a Click to choose a menu item.</li><li>Ctrl+Mouse Press to open the popup menu followed by a Mouse Release to choose a menu item</li></ul>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        add(noteLabel, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel noteLabel;
    private javax.swing.JTextField popupField;
    private javax.swing.JLabel popupLabel1;
    private javax.swing.JLabel popupLabel2;
    // End of variables declaration//GEN-END:variables
    
}
