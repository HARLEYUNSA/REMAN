package org.harley.reman.interfaz.interfaces;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.harley.reman.interfaz.utilitario.ToolsInterface;
import org.harley.reman.sistema.Historico;
import org.harley.reman.sistema.Paso;
import org.harley.reman.sistema.Sistema;
import org.harley.reman.sistema.ToolsSystem;

public class VEVersionarEsp extends JDialog {

    Sistema sysReman;
    ArrayList<Historico> historic;
    boolean flagOk;
    boolean flagLoadOk;
    String espCod;
    String espNom;
    String espEliCod;
    String espVer;
    String espFec;
    String espFueNom;
    String espFueCar;
    String espFueTip;
    String espEspNom;
    String espEspEsp;
    String espEspExp;
    String espEspCar;
    String espDep;
    String espDes;
    String espPre;
    String espPos;
    ArrayList<Paso> espExc;
    String espObs;;

    public VEVersionarEsp(JFrame padre, Sistema sysReman, String espCod, String espNom, String espEliCod, 
            String espVer, String espFec, String espFueNom, String espFueCar, 
            String espFueTip, String espEspNom, String espEspEsp, 
            String espEspExp, String espEspCar, String espDep, String espDes,
            String espPre, String espPos, ArrayList<Paso> espExc, 
            String espObs){ 
        super(padre, true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.sysReman = sysReman;
        this.espCod = espCod;
        this.espNom = espNom;
        this.espEliCod = espEliCod;
        this.espVer = espVer;
        this.espFec = espFec;
        this.espFueNom = espFueNom;
        this.espFueCar = espFueCar;
        this.espFueTip = espFueTip;
        this.espEspNom = espEspNom;
        this.espEspEsp = espEspEsp;
        this.espEspExp = espEspExp;
        this.espEspCar = espEspCar;
        this.espDep = espDep;
        this.espDes = espDes;
        this.espPre = espPre;
        this.espPos = espPos;
        this.espExc = espExc;
        this.espObs = espObs;
        
        try {
            historic = sysReman.getHist(Sistema.LIB_ESP, espCod);
            ToolsInterface.addItems2JComboBox(cmbVAutor, sysReman.getEspecialistaNombres());
            flagLoadOk = true;
        } catch (Exception e) {
            flagLoadOk = false;
        }

        try {
            ToolsInterface.putJTableHistorico(JTVersion, historic);
        } catch (Exception e) {
            //ToolsInterface.msjError(this, "- No se encontro historicos de libros de educcion.");
        }
    }

    public boolean getLoadIsCorrect() {
        return flagLoadOk && cmbVAutor.getItemCount() != 0;
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVVersion = new javax.swing.JTextField();
        cmbVAutor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRzcam = new javax.swing.JTextArea();
        dtEDFecha = new datechooser.beans.DateChooserCombo();
        btnVVersionar = new javax.swing.JButton();
        btnVCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTVersion = new javax.swing.JTable();
        txtTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Versionar");
        setResizable(false);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Versión"));
        jLayeredPane3.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Versión");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Autor");

        txtVVersion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cmbVAutor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Razon");

        txtRzcam.setColumns(20);
        txtRzcam.setRows(5);
        jScrollPane1.setViewportView(txtRzcam);

        dtEDFecha.setEnabled(false);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVVersion)
                    .addComponent(cmbVAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dtEDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtVVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(dtEDFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbVAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 99, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jLayeredPane3.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(txtVVersion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(cmbVAutor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(dtEDFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnVVersionar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVVersionar.setText("Versionar");
        btnVVersionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVVersionarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVVersionar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnVCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVCancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnVVersionar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos", jPanel1);

        txtTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTitle.setText("title");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVCancelarActionPerformed

    private void btnVVersionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVVersionarActionPerformed
        String version = txtVVersion.getText().trim();
        String fecha = dtEDFecha.getText().trim();
        String autor = (String) cmbVAutor.getSelectedItem();
        String rzcam = txtRzcam.getText();

        String lastVersion = "0.1";
        try {
            lastVersion = historic.get(historic.size() - 1).getVersion();
        } catch (Exception e) {
        }

        if (ToolsInterface.verificarVersion(version)) {
            if (ToolsSystem.CompararVersiones(version, lastVersion)) {
                versionar(version, fecha, autor, rzcam);
                ToolsInterface.msjInfo(this, "Operacion Exitosa", "La especificacion se versiono correctamente");
                flagOk = true;
                this.dispose();
            } else {
                ToolsInterface.msjError(this, "Utilice una version superior a la ultima desarrollada!");
            }
        } else {
            ToolsInterface.msjError(this, "Escriba correctamente la version!");
        }


    }//GEN-LAST:event_btnVVersionarActionPerformed

    private void actualizarJTable() {
        try {
            historic = sysReman.getHist(Sistema.LIB_ESP, espCod);
            ToolsInterface.putJTableHistorico(JTVersion, historic);
        } catch (Exception e) {
        }
    }

    private void versionar(String verVer, String verFec, String verEsp, String verRazCam) {
        sysReman.versionarEduccion(verVer, verFec, verEsp, verRazCam, espCod, 
                espNom, espVer, espFueTip, espObs, espFec, espFueNom, espFueCar,
                espFueTip, espEspNom, espEspEsp, espEspExp, espEspCar, espDes,
                espObs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTVersion;
    private javax.swing.JButton btnVCancelar;
    private javax.swing.JButton btnVVersionar;
    private javax.swing.JComboBox cmbVAutor;
    private datechooser.beans.DateChooserCombo dtEDFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txtRzcam;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JTextField txtVVersion;
    // End of variables declaration//GEN-END:variables
}
