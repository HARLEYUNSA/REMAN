package org.harley.reman.interfaz.interfaces;

import java.beans.PropertyVetoException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.harley.reman.interfaz.utilitario.ToolsInterface;
import org.harley.reman.sistema.Sistema;

/**
 *
 * @author Joel Mendoza
 */
public class VPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VPincipal
     */
    VTElicitacion venEli;
    VTEduccion venEdu;
    VTOrganizacion venOrg;
    VTEspecificacion venEsp;
    VTNoFuncional venNoFun;
    Sistema sysReman;

    public VPrincipal(Sistema sysReman) {

        //pantalla
        getContentPane().setBackground(new java.awt.Color(119, 148, 171));
        initComponents();
        this.setLocationRelativeTo(null);

        //agregando pantalla de inicio(ayuda)
        VODocumento nuevo = new VODocumento();
        DeskPanel1.add(nuevo);
        try {
            nuevo.setMaximum(true);
        } catch (PropertyVetoException ex) {
        }
        nuevo.show();

        //inicializacion de Sistema
        this.sysReman = sysReman;
        venEdu = new VTEduccion(this,this.sysReman);
        venEli = new VTElicitacion(this,this.sysReman);
        venEsp = new VTEspecificacion(this,this.sysReman);
        venNoFun = new VTNoFuncional(this,this.sysReman);
        venOrg = new VTOrganizacion(this,this.sysReman);

        DeskPanel2.add(venEli);
        DeskPanel2.add(venEdu);
        DeskPanel2.add(venOrg);
        DeskPanel2.add(venEsp);
        DeskPanel2.add(venNoFun);
        actualizarJTrees();

        //ayudas graficas
        btnVPAbrir.setToolTipText("Abrir");
        btnVPAyuda.setToolTipText("Ayuda");
        btnVPEduccion.setToolTipText("Agregar Educcion");
        btnVPElicitacion.setToolTipText("Agregar Elicitacion");
        btnVPEspecialista.setToolTipText("Agregar Especialista");
        btnVPEspecificiacion.setToolTipText("Agregar Especificacion");
        btnVPExportar.setToolTipText("Exportar Libro");
        btnVPFuente.setToolTipText("Agregar Fuente");
        btnVPImportar.setToolTipText("Importar Libro");
        btnVPNoFuncional.setToolTipText("Agregar No Funcional");
        btnVPNuevo.setToolTipText("Nuevo Proyecto");
        btnVPOrganizacion.setToolTipText("Agregar Organizacion");
        btnVPVersionar.setToolTipText("Versionar Libro");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ExportarFile = new javax.swing.JFileChooser();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        herramientasReman = new javax.swing.JToolBar();
        btnVPNuevo = new javax.swing.JButton();
        btnVPAbrir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnVPVersionar = new javax.swing.JButton();
        btnVPImportar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnVPFuente = new javax.swing.JButton();
        btnVPEspecialista = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnVPOrganizacion = new javax.swing.JButton();
        btnVPEduccion = new javax.swing.JButton();
        btnVPElicitacion = new javax.swing.JButton();
        btnVPEspecificiacion = new javax.swing.JButton();
        btnVPNoFuncional = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnVPExportar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnVPAyuda = new javax.swing.JButton();
        LibrosReman = new javax.swing.JToolBar();
        btnOrganizacion = new javax.swing.JButton();
        btnEduccion = new javax.swing.JButton();
        btnElicitacion = new javax.swing.JButton();
        btnEspecificacion = new javax.swing.JButton();
        btnNoFuncional = new javax.swing.JButton();
        DeskPanel1 = new javax.swing.JDesktopPane();
        DeskPanel2 = new javax.swing.JDesktopPane();
        menuReman = new javax.swing.JMenuBar();
        mnVPArchivo = new javax.swing.JMenu();
        mnArchivo_Nuevo = new javax.swing.JMenuItem();
        mnArchivo_Abrir = new javax.swing.JMenuItem();
        mnArchivo_Salir = new javax.swing.JMenuItem();
        mnVPEditar = new javax.swing.JMenu();
        mnVPVer = new javax.swing.JMenu();
        mnVPHerramienta = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnVPVentana = new javax.swing.JMenu();
        mnVPAyuda = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        ExportarFile.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        ExportarFile.setDialogTitle("Seleccione");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REMAN 1.3.0 - Gestor de Requerimientos");
        setBackground(new java.awt.Color(119, 148, 171));

        herramientasReman.setBackground(new java.awt.Color(203, 210, 228));
        herramientasReman.setFloatable(false);
        herramientasReman.setRollover(true);
        herramientasReman.setMaximumSize(new java.awt.Dimension(300, 37));
        herramientasReman.setPreferredSize(new java.awt.Dimension(210, 35));

        btnVPNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/1. iconoNuevo.png"))); // NOI18N
        btnVPNuevo.setFocusable(false);
        btnVPNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPNuevo.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPNuevo.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPNuevo.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPNuevoActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPNuevo);

        btnVPAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/2. iconoAbrir.png"))); // NOI18N
        btnVPAbrir.setFocusable(false);
        btnVPAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPAbrir.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPAbrir.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPAbrir.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPAbrirActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPAbrir);
        herramientasReman.add(jSeparator1);

        btnVPVersionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/4. iconoVersionar.png"))); // NOI18N
        btnVPVersionar.setFocusable(false);
        btnVPVersionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPVersionar.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPVersionar.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPVersionar.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPVersionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPVersionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPVersionarActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPVersionar);

        btnVPImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/iconoImportarLibro.png"))); // NOI18N
        btnVPImportar.setToolTipText("");
        btnVPImportar.setFocusable(false);
        btnVPImportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPImportar.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPImportar.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPImportar.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPImportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPImportarActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPImportar);
        herramientasReman.add(jSeparator3);

        btnVPFuente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/6. iconoAgregarFuente.png"))); // NOI18N
        btnVPFuente.setFocusable(false);
        btnVPFuente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPFuente.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPFuente.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPFuente.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPFuente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPFuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPFuenteActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPFuente);

        btnVPEspecialista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/5. iconoAgregarEspecialista.png"))); // NOI18N
        btnVPEspecialista.setFocusable(false);
        btnVPEspecialista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPEspecialista.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPEspecialista.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPEspecialista.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPEspecialista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPEspecialista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPEspecialistaActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPEspecialista);
        herramientasReman.add(jSeparator4);

        btnVPOrganizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/7. iconoAgregarOrganizacion.png"))); // NOI18N
        btnVPOrganizacion.setFocusable(false);
        btnVPOrganizacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPOrganizacion.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPOrganizacion.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPOrganizacion.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPOrganizacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPOrganizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPOrganizacionActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPOrganizacion);

        btnVPEduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/8. iconoAgregarEduccion.png"))); // NOI18N
        btnVPEduccion.setFocusable(false);
        btnVPEduccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPEduccion.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPEduccion.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPEduccion.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPEduccion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPEduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPEduccionActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPEduccion);

        btnVPElicitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/9. iconoAgregarElicitacion.png"))); // NOI18N
        btnVPElicitacion.setFocusable(false);
        btnVPElicitacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPElicitacion.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPElicitacion.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPElicitacion.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPElicitacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPElicitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPElicitacionActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPElicitacion);

        btnVPEspecificiacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/10. iconoAgregarEspecificacion.png"))); // NOI18N
        btnVPEspecificiacion.setFocusable(false);
        btnVPEspecificiacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPEspecificiacion.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPEspecificiacion.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPEspecificiacion.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPEspecificiacion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPEspecificiacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPEspecificiacionActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPEspecificiacion);

        btnVPNoFuncional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/iconoAgregarRequisitoNoFuncional.png"))); // NOI18N
        btnVPNoFuncional.setFocusable(false);
        btnVPNoFuncional.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPNoFuncional.setMaximumSize(new java.awt.Dimension(33, 33));
        btnVPNoFuncional.setMinimumSize(new java.awt.Dimension(33, 33));
        btnVPNoFuncional.setPreferredSize(new java.awt.Dimension(33, 33));
        btnVPNoFuncional.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPNoFuncional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPNoFuncionalActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPNoFuncional);
        herramientasReman.add(jSeparator7);

        btnVPExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/11. iconoExportarDocumento.png"))); // NOI18N
        btnVPExportar.setFocusable(false);
        btnVPExportar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPExportar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVPExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVPExportarActionPerformed(evt);
            }
        });
        herramientasReman.add(btnVPExportar);
        herramientasReman.add(jSeparator5);

        btnVPAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/13. iconoAyuda.png"))); // NOI18N
        btnVPAyuda.setFocusable(false);
        btnVPAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVPAyuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        herramientasReman.add(btnVPAyuda);

        LibrosReman.setBackground(new java.awt.Color(203, 210, 228));
        LibrosReman.setFloatable(false);
        LibrosReman.setRollover(true);
        LibrosReman.setMaximumSize(new java.awt.Dimension(210, 53));
        LibrosReman.setMinimumSize(new java.awt.Dimension(210, 53));
        LibrosReman.setPreferredSize(new java.awt.Dimension(210, 53));

        btnOrganizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/libroOrganizacion.png"))); // NOI18N
        btnOrganizacion.setMaximumSize(new java.awt.Dimension(50, 50));
        btnOrganizacion.setMinimumSize(new java.awt.Dimension(5, 5));
        btnOrganizacion.setPreferredSize(new java.awt.Dimension(50, 50));
        btnOrganizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrganizacionActionPerformed(evt);
            }
        });
        LibrosReman.add(btnOrganizacion);

        btnEduccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/libroEduccion.png"))); // NOI18N
        btnEduccion.setMaximumSize(new java.awt.Dimension(50, 50));
        btnEduccion.setMinimumSize(new java.awt.Dimension(50, 50));
        btnEduccion.setPreferredSize(new java.awt.Dimension(50, 50));
        btnEduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEduccionActionPerformed(evt);
            }
        });
        LibrosReman.add(btnEduccion);

        btnElicitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/libroElicitacion.png"))); // NOI18N
        btnElicitacion.setMaximumSize(new java.awt.Dimension(50, 50));
        btnElicitacion.setMinimumSize(new java.awt.Dimension(50, 50));
        btnElicitacion.setPreferredSize(new java.awt.Dimension(50, 50));
        btnElicitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElicitacionActionPerformed(evt);
            }
        });
        LibrosReman.add(btnElicitacion);

        btnEspecificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/libroEspecificacion.png"))); // NOI18N
        btnEspecificacion.setMaximumSize(new java.awt.Dimension(50, 50));
        btnEspecificacion.setMinimumSize(new java.awt.Dimension(50, 50));
        btnEspecificacion.setPreferredSize(new java.awt.Dimension(50, 50));
        btnEspecificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspecificacionActionPerformed(evt);
            }
        });
        LibrosReman.add(btnEspecificacion);

        btnNoFuncional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/harley/reman/interfaz/iconos/libroRequisitosNoFuncionales.png"))); // NOI18N
        btnNoFuncional.setFocusable(false);
        btnNoFuncional.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNoFuncional.setMaximumSize(new java.awt.Dimension(50, 50));
        btnNoFuncional.setMinimumSize(new java.awt.Dimension(50, 50));
        btnNoFuncional.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNoFuncional.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNoFuncional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoFuncionalActionPerformed(evt);
            }
        });
        LibrosReman.add(btnNoFuncional);

        DeskPanel1.setBackground(new java.awt.Color(119, 148, 171));

        javax.swing.GroupLayout DeskPanel1Layout = new javax.swing.GroupLayout(DeskPanel1);
        DeskPanel1.setLayout(DeskPanel1Layout);
        DeskPanel1Layout.setHorizontalGroup(
            DeskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        DeskPanel1Layout.setVerticalGroup(
            DeskPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        DeskPanel2.setBackground(new java.awt.Color(119, 148, 171));

        javax.swing.GroupLayout DeskPanel2Layout = new javax.swing.GroupLayout(DeskPanel2);
        DeskPanel2.setLayout(DeskPanel2Layout);
        DeskPanel2Layout.setHorizontalGroup(
            DeskPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        DeskPanel2Layout.setVerticalGroup(
            DeskPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );

        mnVPArchivo.setText("Archivo");

        mnArchivo_Nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnArchivo_Nuevo.setText("Nuevo");
        mnArchivo_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivo_NuevoActionPerformed(evt);
            }
        });
        mnVPArchivo.add(mnArchivo_Nuevo);

        mnArchivo_Abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnArchivo_Abrir.setText("Abrir");
        mnArchivo_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivo_AbrirActionPerformed(evt);
            }
        });
        mnVPArchivo.add(mnArchivo_Abrir);

        mnArchivo_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnArchivo_Salir.setText("Salir");
        mnArchivo_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnArchivo_SalirActionPerformed(evt);
            }
        });
        mnVPArchivo.add(mnArchivo_Salir);

        menuReman.add(mnVPArchivo);

        mnVPEditar.setText("Editar");
        menuReman.add(mnVPEditar);

        mnVPVer.setText("Ver");
        menuReman.add(mnVPVer);

        mnVPHerramienta.setText("Herramientas");

        jMenuItem7.setText("Versionar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnVPHerramienta.add(jMenuItem7);

        menuReman.add(mnVPHerramienta);

        mnVPVentana.setText("Ventana");
        menuReman.add(mnVPVentana);

        mnVPAyuda.setText("Ayuda");

        jMenuItem5.setText("Manual Usuario");
        mnVPAyuda.add(jMenuItem5);

        jMenuItem6.setText("Acerca de ...");
        mnVPAyuda.add(jMenuItem6);

        menuReman.add(mnVPAyuda);

        setJMenuBar(menuReman);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(herramientasReman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DeskPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LibrosReman, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeskPanel1)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(herramientasReman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LibrosReman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeskPanel2))
                    .addComponent(DeskPanel1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnArchivo_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivo_NuevoActionPerformed
        VProyecto VNProyect = new VProyecto(this, sysReman);
        VNProyect.setVisible(true);
        if (VNProyect.createSuccessful()) {
            actualizarJTrees();
        }
    }//GEN-LAST:event_mnArchivo_NuevoActionPerformed

    private void mnArchivo_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivo_AbrirActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Reman", "rem");
        ExportarFile.setFileFilter(filtro);
        int opt = ExportarFile.showOpenDialog(this);
        String direccion = "";
        if (opt == JFileChooser.APPROVE_OPTION) {
            direccion = ExportarFile.getSelectedFile().getParent();
            sysReman.setDirPrincipal(direccion);
            sysReman.setStateReman(direccion);
            actualizarJTrees();
        }
    }//GEN-LAST:event_mnArchivo_AbrirActionPerformed

    private void mnArchivo_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnArchivo_SalirActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Esta Seguro de Salir de REMAN?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_mnArchivo_SalirActionPerformed

    private void btnVPNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        VProyecto VNProyect = new VProyecto(this, sysReman);
        VNProyect.setVisible(true);
        if (VNProyect.createSuccessful()) {
            actualizarJTrees();
        }
    }

    private void btnVPVersionarActionPerformed(java.awt.event.ActionEvent evt) {
        //VERSIONAR UN LIBRO
        VOLVersionar VLib = new VOLVersionar(this, sysReman);
        if(VLib.getLoadIsCorrect()){
            VLib.setVisible(true);
        }else{
            ToolsInterface.msjError(this,"Error al cargar los actores especialistas!");
        }
    }

    private void btnVPEspecialistaActionPerformed(java.awt.event.ActionEvent evt) {
        //CREAR ESPECIALISTA
        VCEspecialista VEsp = new VCEspecialista(this, sysReman);
        if(VEsp.getLoadIsCorrect()){
            VEsp.setVisible(true);
        }else{
            ToolsInterface.msjError(this,"Error al cargar las Organizaciones!");
        }
        if(VEsp.createSuccessful()){
            venOrg.actualizarJTree();
        }
    }

    private void btnVPOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {
        //NUEVA ORGANIZACION
        VCOrganizacion VOrg = new VCOrganizacion(this, sysReman);
        VOrg.setVisible(true);
        if(VOrg.createSuccessful()){
            venOrg.actualizarJTree();
        }
    }

    private void btnVPFuenteActionPerformed(java.awt.event.ActionEvent evt) {
        //CREAR FUENTE
        VCFuente VFue = new VCFuente(this, sysReman);
        if(VFue.getLoadIsCorrect()){
            VFue.setVisible(true);
        }else{
            ToolsInterface.msjError(this, "Error al cargar las Organizaciones!");
        }
        if(VFue.createSuccessful()){
            venOrg.actualizarJTree();
        }
    }

    private void btnVPEduccionActionPerformed(java.awt.event.ActionEvent evt) {
        //NUEVA EDUCCION
        VCEduccion VEdu = new VCEduccion(this, sysReman);
        if (VEdu.getLoadIsCorrect()) {
            VEdu.setVisible(true);
        } else {
            ToolsInterface.msjError(this, "Error al cargar los actores del proyecto!");
        }
        if (VEdu.createSuccessful()) {
            venEdu.actualizarJTree();
        } 
    }

    private void btnVPElicitacionActionPerformed(java.awt.event.ActionEvent evt) {
        VCElicitacion ventanaEl = new VCElicitacion();
        ventanaEl.setVisible(true);
    }

    private void btnVPEspecificiacionActionPerformed(java.awt.event.ActionEvent evt) {
        VCEspecificacion ventanaEs = new VCEspecificacion();
        ventanaEs.setVisible(true);
    }

    private void btnOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {     
        venOrg.setVisible(true);
        venEdu.setVisible(false);
        venEsp.setVisible(false);
        venEli.setVisible(false);
        venNoFun.setVisible(false);
    }

    private void btnEduccionActionPerformed(java.awt.event.ActionEvent evt) {
        venEdu.setVisible(true);
        venOrg.setVisible(false);
        venEsp.setVisible(false);
        venEli.setVisible(false);
        venNoFun.setVisible(false);
    }

    private void btnElicitacionActionPerformed(java.awt.event.ActionEvent evt) {
        venEli.setVisible(true);
        venOrg.setVisible(false);
        venEdu.setVisible(false);
        venEsp.setVisible(false);
        venNoFun.setVisible(false);
    }

    private void btnEspecificacionActionPerformed(java.awt.event.ActionEvent evt) {
        venEsp.setVisible(true);
        venOrg.setVisible(false);
        venEdu.setVisible(false);
        venEli.setVisible(false);
        venNoFun.setVisible(false);
    }

    private void btnVPAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Reman", "rem");
        ExportarFile.setFileFilter(filtro);
        int opt = ExportarFile.showOpenDialog(this);
        String direccion = "";
        if (opt == JFileChooser.APPROVE_OPTION) {
            direccion = ExportarFile.getSelectedFile().getParent();
            sysReman.setDirPrincipal(direccion);
            sysReman.setStateReman(direccion);
            actualizarJTrees();
        }
    }

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        this.btnVPVersionarActionPerformed(evt);
    }

    private void btnNoFuncionalActionPerformed(java.awt.event.ActionEvent evt) {
        venNoFun.setVisible(true);
        venEli.setVisible(false);
        venOrg.setVisible(false);
        venEdu.setVisible(false);
        venEsp.setVisible(false);
    }

    private void btnVPNoFuncionalActionPerformed(java.awt.event.ActionEvent evt) {
        VCNoFuncional ventanaNF = new VCNoFuncional();
        ventanaNF.setVisible(true);
    }

    private void btnVPImportarActionPerformed(java.awt.event.ActionEvent evt) {
        //RESTAURAR UN LIBRO
        VOLRestaurar VLib = new VOLRestaurar(this, sysReman);
        VLib.setVisible(true);
  
    }

    private void btnVPExportarActionPerformed(java.awt.event.ActionEvent evt) {
        VOExportar VExp = new VOExportar(this, sysReman);
        VExp.setVisible(true);
    }

    private void actualizarJTrees() {
        venEdu.actualizarJTree();
        venEli.actualizarJTree();
        venEsp.actualizarJTree();
        venNoFun.actualizarJTree();
        venOrg.actualizarJTree();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DeskPanel1;
    private javax.swing.JDesktopPane DeskPanel2;
    private javax.swing.JFileChooser ExportarFile;
    private javax.swing.JToolBar LibrosReman;
    private javax.swing.JButton btnEduccion;
    private javax.swing.JButton btnElicitacion;
    private javax.swing.JButton btnEspecificacion;
    private javax.swing.JButton btnNoFuncional;
    private javax.swing.JButton btnOrganizacion;
    private javax.swing.JButton btnVPAbrir;
    private javax.swing.JButton btnVPAyuda;
    private javax.swing.JButton btnVPEduccion;
    private javax.swing.JButton btnVPElicitacion;
    private javax.swing.JButton btnVPEspecialista;
    private javax.swing.JButton btnVPEspecificiacion;
    private javax.swing.JButton btnVPExportar;
    private javax.swing.JButton btnVPFuente;
    private javax.swing.JButton btnVPImportar;
    private javax.swing.JButton btnVPNoFuncional;
    private javax.swing.JButton btnVPNuevo;
    private javax.swing.JButton btnVPOrganizacion;
    private javax.swing.JButton btnVPVersionar;
    private javax.swing.JToolBar herramientasReman;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JMenuBar menuReman;
    private javax.swing.JMenuItem mnArchivo_Abrir;
    private javax.swing.JMenuItem mnArchivo_Nuevo;
    private javax.swing.JMenuItem mnArchivo_Salir;
    private javax.swing.JMenu mnVPArchivo;
    private javax.swing.JMenu mnVPAyuda;
    private javax.swing.JMenu mnVPEditar;
    private javax.swing.JMenu mnVPHerramienta;
    private javax.swing.JMenu mnVPVentana;
    private javax.swing.JMenu mnVPVer;
    // End of variables declaration//GEN-END:variables
}
