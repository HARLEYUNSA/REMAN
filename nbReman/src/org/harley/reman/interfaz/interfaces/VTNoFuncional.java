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
import org.harley.reman.interfaz.utilitario.ToolsInterface;
import org.harley.reman.sistema.Sistema;

/**
 *
 * @author User
 */
public class VTNoFuncional extends javax.swing.JInternalFrame {

    Sistema sysReman;
    TreePath dirTree;
    JFrame padre;
    MouseListener ml = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Se obtiene el path para esa fila. Con el path podemos obtener
            // los nodos.
            if (e.getButton() == MouseEvent.BUTTON3) {
                dirTree = treeRnf.getPathForLocation(e.getX(), e.getY());
                treeRnf.setSelectionPath(dirTree);
                if (dirTree != null) {
                    switch (dirTree.getLastPathComponent().toString()) {
                        case "Documento de Req no Funcional":
                            break;
                        case "Req no Funcional":
                            menuDocRnf.show(e.getComponent(), e.getX(), e.getY() + 10);
                            break;
                        default:
                            menuRnf.show(e.getComponent(), e.getX(), e.getY() + 10);
                            break;
                    }
                }
            }
        }
    };

    public VTNoFuncional(JFrame padre, Sistema sysReman, JTree tree) {
        initComponents();
        this.padre = padre;
        this.sysReman = sysReman;
        treeRnf.setModel(tree.getModel());
        treeRnf.addMouseListener(ml);
    }

    public VTNoFuncional(JFrame padre, Sistema sysReman) {
        initComponents();
        this.padre = padre;
        this.sysReman = sysReman;
        treeRnf.addMouseListener(ml);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuDocRnf = new javax.swing.JPopupMenu();
        menuDocRnfItem1 = new javax.swing.JMenuItem();
        menuRnf = new javax.swing.JPopupMenu();
        menuRnfItem1 = new javax.swing.JMenuItem();
        menuRnfItem2 = new javax.swing.JMenuItem();
        menuRnfItem3 = new javax.swing.JMenuItem();
        scrollTree = new javax.swing.JScrollPane();
        treeRnf = new javax.swing.JTree();

        menuDocRnfItem1.setText("Crear Req no Funcional");
        menuDocRnfItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDocRnfItem1ActionPerformed(evt);
            }
        });
        menuDocRnf.add(menuDocRnfItem1);

        menuRnfItem1.setText("Modificar");
        menuRnfItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRnfItem1ActionPerformed(evt);
            }
        });
        menuRnf.add(menuRnfItem1);

        menuRnfItem2.setText("Eliminar");
        menuRnfItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRnfItem2ActionPerformed(evt);
            }
        });
        menuRnf.add(menuRnfItem2);

        menuRnfItem3.setText("Restaurar");
        menuRnfItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRnfItem3ActionPerformed(evt);
            }
        });
        menuRnf.add(menuRnfItem3);

        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(250, 322));

        treeRnf.setBackground(new java.awt.Color(217, 221, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Documento de la Educción");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Educción");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("EDU 0001");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeRnf.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scrollTree.setViewportView(treeRnf);

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

    private void menuDocRnfItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDocRnfItem1ActionPerformed
        //NUEVO REQ NO FUNCIONAL
        VCNoFuncional VNoFun = new VCNoFuncional(padre, sysReman);
        if (VNoFun.getLoadIsCorrect()) {
            VNoFun.setVisible(true);
        } else {
            ToolsInterface.msjError(padre, "Error al cargar los actores del proyecto!");
        }
        if (VNoFun.createSuccessful()) {
            actualizarJTree();
        } 
    }//GEN-LAST:event_menuDocRnfItem1ActionPerformed

    private void menuRnfItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRnfItem1ActionPerformed
        //MODIFICAR REQ NO FUNCIONAL
    }//GEN-LAST:event_menuRnfItem1ActionPerformed

    private void menuRnfItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRnfItem2ActionPerformed
        //ELIMINAR REQ NO FUNCIONAL
        int resp = JOptionPane.showConfirmDialog(null, "Eliminar Educción", "Alerta!", JOptionPane.YES_NO_OPTION);
    }//GEN-LAST:event_menuRnfItem2ActionPerformed

    private void menuRnfItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRnfItem3ActionPerformed
        //RESTAURAR REQ NO FUNCIONAL
    }//GEN-LAST:event_menuRnfItem3ActionPerformed

    public void actualizarJTree(){
        JTree model = ToolsInterface.generateJTreeBook("Documento de Req no Funcional", "Req no Funcional", sysReman.getDirPrincipal() + "\\src\\rnf");
        treeRnf.setModel(model.getModel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu menuDocRnf;
    private javax.swing.JMenuItem menuDocRnfItem1;
    private javax.swing.JPopupMenu menuRnf;
    private javax.swing.JMenuItem menuRnfItem1;
    private javax.swing.JMenuItem menuRnfItem2;
    private javax.swing.JMenuItem menuRnfItem3;
    private javax.swing.JScrollPane scrollTree;
    private javax.swing.JTree treeRnf;
    // End of variables declaration//GEN-END:variables
}
