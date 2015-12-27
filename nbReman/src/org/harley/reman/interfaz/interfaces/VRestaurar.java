package org.harley.reman.interfaz.interfaces;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.harley.reman.interfaz.utilitario.ToolsInterface;
import org.harley.reman.sistema.Historico;
import org.harley.reman.sistema.Sistema;

public class VRestaurar extends JDialog {

    Sistema sysReman;
    ArrayList<Historico> libEdu;
    ArrayList<Historico> libEli;
    ArrayList<Historico> libEsp;
    ArrayList<Historico> libRnf;
    boolean flagOk;

    public VRestaurar(JFrame padre, Sistema sysReman) {
        super(padre, true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.sysReman = sysReman;

        libEdu = sysReman.getHistLibEdu();
        libEli = sysReman.getHistLibEli();
        libEsp = sysReman.getHistLibEsp();
        libRnf = sysReman.getHistLibRnf();

        try {
            ToolsInterface.putJTableHistorico(JTVersion, libEdu);
        } catch (Exception e) {
            //ToolsInterface.msjError(this, "- No se encontro historicos de libros de educcion.");
        }

    }

    public boolean versionSuccessful() {
        return flagOk;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cmblib = new javax.swing.JComboBox();
        btnVGuardar = new javax.swing.JButton();
        btnVCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTVersion = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Versionar");
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Libro a Versionar");

        cmblib.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmblib.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Libro Educción", "Libro Elicitación", "Libro Especificación", "Libro Req no Funcional" }));
        cmblib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmblibActionPerformed(evt);
            }
        });

        btnVGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVGuardar.setText("Restaurar");
        btnVGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVGuardarActionPerformed(evt);
            }
        });

        btnVCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVCancelar.setText("Cancelar");
        btnVCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVCancelarActionPerformed(evt);
            }
        });

        JTVersion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JTVersion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Versión", "Fecha", "Autor", "Razon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(JTVersion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cmblib, 0, 249, Short.MAX_VALUE)
                        .addGap(301, 301, 301))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnVCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmblib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVCancelar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVCancelarActionPerformed

    private void btnVGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVGuardarActionPerformed
        int select = cmblib.getSelectedIndex();
        int numRow = JTVersion.getSelectedRow();
        String version;
        if (numRow != -1) {
            int resp = JOptionPane.showConfirmDialog(null, "Se perdera toda la informacion actual del libro a restaurar!", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                version = JTVersion.getValueAt(numRow, 0).toString();
                sysReman.restaurarLibro(select, version);
                ToolsInterface.msjInfo(this, "Operacion Exitosa", "Se recupero la version: " + version);
                this.dispose();
            }

        } else {
            ToolsInterface.msjError(this, "Seleccione una version!");
        }


    }//GEN-LAST:event_btnVGuardarActionPerformed

    private void cmblibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmblibActionPerformed
        switch (cmblib.getSelectedIndex()) {
            case EDU:
                try {
                    ToolsInterface.putJTableHistorico(JTVersion, libEdu);
                } catch (Exception e) {
                    //ToolsInterface.msjError(this, "- No se encontro historicos de libros de educcion.");
                }
                break;
            case ELI:
                try {
                    ToolsInterface.putJTableHistorico(JTVersion, libEli);
                } catch (Exception e) {
                    //ToolsInterface.msjError(this, "- No se encontro historicos de libros de elicitacion.");
                }
                break;
            case ESP:
                try {
                    ToolsInterface.putJTableHistorico(JTVersion, libEsp);
                } catch (Exception e) {
                    //ToolsInterface.msjError(this, "- No se encontro historicos de libros de especificacion de req.");
                }
                break;
            case RNF:
                try {
                    ToolsInterface.putJTableHistorico(JTVersion, libRnf);
                } catch (Exception e) {
                    //ToolsInterface.msjError(this, "- No se encontro historicos de libros de req no funcionales.");
                }
                break;
        }
    }//GEN-LAST:event_cmblibActionPerformed

    public static final int EDU = 0;
    public static final int ELI = 1;
    public static final int ESP = 2;
    public static final int RNF = 3;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTVersion;
    private javax.swing.JButton btnVCancelar;
    private javax.swing.JButton btnVGuardar;
    private javax.swing.JComboBox cmblib;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
