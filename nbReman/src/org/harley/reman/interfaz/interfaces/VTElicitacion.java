/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.harley.reman.interfaz.interfaces;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
import org.harley.reman.sistema.Sistema;

/**
 *
 * @author User
 */
public class VTElicitacion extends javax.swing.JInternalFrame {

    Sistema sysReman;
    TreePath dirTree;
    JFrame padre;
    MouseListener ml = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Se obtiene el path para esa fila. Con el path podemos obtener
            // los nodos.
            if (e.getButton() == MouseEvent.BUTTON3) {
                dirTree = treeEli.getPathForLocation(e.getX(), e.getY());
                treeEli.setSelectionPath(dirTree);
                if (dirTree != null) {
                    switch (dirTree.getLastPathComponent().toString()) {
                        case "Documento de Elicitación":
                            break;
                        case "Elicitación":
                            menuDocEli.show(e.getComponent(), e.getX(), e.getY() + 10);
                            break;
                        default:
                            menuEli.show(e.getComponent(), e.getX(), e.getY() + 10);
                            break;
                    }
                }
            }
        }
    };

    public VTElicitacion(JFrame padre, Sistema sysReman, JTree tree) {
        initComponents();
        this.padre = padre;
        this.sysReman = sysReman;
        treeEli.setModel(tree.getModel());
        treeEli.addMouseListener(ml);
    }
    
    public VTElicitacion(JFrame padre, Sistema sysReman) {
        initComponents();
        this.padre = padre;
        this.sysReman = sysReman;
        treeEli.addMouseListener(ml);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuDocEli = new javax.swing.JPopupMenu();
        menuDocEliItem1 = new javax.swing.JMenuItem();
        menuEli = new javax.swing.JPopupMenu();
        menuEliItem1 = new javax.swing.JMenuItem();
        menuEliItem2 = new javax.swing.JMenuItem();
        menuEliItem3 = new javax.swing.JMenuItem();
        scrollTree = new javax.swing.JScrollPane();
        treeEli = new javax.swing.JTree();

        menuDocEliItem1.setText("Crear Elicitación");
        menuDocEliItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDocEliItem1ActionPerformed(evt);
            }
        });
        menuDocEli.add(menuDocEliItem1);

        menuEliItem1.setText("Modificar");
        menuEliItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliItem1ActionPerformed(evt);
            }
        });
        menuEli.add(menuEliItem1);

        menuEliItem2.setText("Eliminar");
        menuEliItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliItem2ActionPerformed(evt);
            }
        });
        menuEli.add(menuEliItem2);

        menuEliItem3.setText("Restaurar");
        menuEliItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliItem3ActionPerformed(evt);
            }
        });
        menuEli.add(menuEliItem3);

        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(250, 322));

        treeEli.setBackground(new java.awt.Color(217, 221, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Documento de la Educción");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Educción");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("EDU 0001");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeEli.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scrollTree.setViewportView(treeEli);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTree, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTree, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuDocEliItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDocEliItem1ActionPerformed
        //NUEVA EDUCCION
        
    }//GEN-LAST:event_menuDocEliItem1ActionPerformed

    private void menuEliItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliItem1ActionPerformed
        //MODIFICAR EDUCCION
    }//GEN-LAST:event_menuEliItem1ActionPerformed

    private void menuEliItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliItem2ActionPerformed
        //ELIMINAR
        int resp = JOptionPane.showConfirmDialog(null, "Eliminar Elicitación", "Alerta!", JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_menuEliItem2ActionPerformed

    private void menuEliItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliItem3ActionPerformed
        //RESTAURAR
    }//GEN-LAST:event_menuEliItem3ActionPerformed

    public void actualizar(JTree tree){
        treeEli.setModel(tree.getModel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu menuDocEli;
    private javax.swing.JMenuItem menuDocEliItem1;
    private javax.swing.JPopupMenu menuEli;
    private javax.swing.JMenuItem menuEliItem1;
    private javax.swing.JMenuItem menuEliItem2;
    private javax.swing.JMenuItem menuEliItem3;
    private javax.swing.JScrollPane scrollTree;
    private javax.swing.JTree treeEli;
    // End of variables declaration//GEN-END:variables
}
