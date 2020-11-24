/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaMenu;
import conexion.ConexionBD;
import controlador.PeliculaDAO;
import controlador.ProcedimientosAlma;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Pelicula;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author mabg
 */
public class Peliculas extends javax.swing.JFrame {
    static ResultSet rs;
    int cont;
    
    public Peliculas() {
        initComponents();
        cargarPeliculas();
        
    }

    public void cargarPeliculas(){
        DefaultTableModel modelo = (DefaultTableModel) tblPeliculas.getModel();
        modelo.setRowCount(0);
        rs = conexion.ConexionBD.Consulta("SELECT * FROM Peliculas");
        try {
            while (rs.next()){
                Vector v= new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getInt(6));
                modelo.addRow(v);
                tblPeliculas.setModel(modelo);
                
            }
        } catch (SQLException e) {
            
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeliculas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtPre = new javax.swing.JTextField();
        txtDir = new javax.swing.JTextField();
        cbCatg = new javax.swing.JComboBox<>();
        cbCla = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        btnG = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        tblPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Num. Película", "Nom. Película", "Categoría", "Clasificación", "Director(es)", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeliculasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeliculas);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Lista Películas");

        jLabel2.setText("Núm. Película:");

        jLabel3.setText("Nombre Película:");

        jLabel4.setText("Categoría:");

        jLabel5.setText("Clasificación:");

        jLabel6.setText("Nom. Director Película:");

        txtPre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPreKeyTyped(evt);
            }
        });

        cbCatg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opción...", "Aventura", "Accion", "Drama", "Suspenso", "Terror", "Comedia", "Ciencia Ficcion", "Romance", "Infantil", "Fantasia" }));

        cbCla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Opción....", "AA", "A", "B", "B15", "C", "D" }));

        jLabel7.setText("Precio:");

        btnG.setText("Guardar");
        btnG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGMouseClicked(evt);
            }
        });
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });

        btnM.setText("Modificar");
        btnM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMMouseClicked(evt);
            }
        });

        btnE.setText("Eliminar");
        btnE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEMouseClicked(evt);
            }
        });
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });

        btnB.setText("Buscar");
        btnB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBMouseClicked(evt);
            }
        });

        jButton1.setText("Generar Reporte");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnG)
                        .addGap(42, 42, 42)
                        .addComponent(btnE)
                        .addGap(27, 27, 27)
                        .addComponent(btnM)
                        .addGap(44, 44, 44)
                        .addComponent(btnB))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId)
                    .addComponent(txtNom)
                    .addComponent(cbCatg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDir)
                    .addComponent(txtPre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCatg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(cbCla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnG)
                    .addComponent(btnM)
                    .addComponent(btnE)
                    .addComponent(btnB))
                .addContainerGap())
        );

        jMenu1.setText("Menú");

        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Vistas");

        jMenuItem2.setText("Vistas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Graficar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });

        jMenuItem3.setText("Grafica Pastel");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGActionPerformed
        
    }//GEN-LAST:event_btnGActionPerformed

    private void btnGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGMouseClicked
       if(txtNom.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese los datos Correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            
        } else {
        try {
            rs =conexion.ConexionBD.Consulta("SELECT COUNT(nom_Pelicula) FROM Peliculas WHERE nom_Pelicula= '"+ txtNom.getText()+ "'");
            try {
                while(rs.next()){
                    cont = rs.getInt(1);
                }
                    
            } catch (SQLException e) {
            }
            if(cont >= 1){
                JOptionPane.showMessageDialog(this, "Esta Pelicula Ya esta en La BASE DE DATOS","Informacion",JOptionPane.INFORMATION_MESSAGE);
            } else{
                ProcedimientosAlma.EntradaPelis(txtNom.getText(), String.valueOf(cbCatg.getSelectedItem()), String.valueOf(cbCla.getSelectedItem()), txtDir.getText(),Integer.parseInt(txtPre.getText()));
                txtNom.setText("");
                cbCatg.setSelectedIndex(0);
                cbCla.setSelectedIndex(0);
                txtDir.setText("");
                txtPre.setText("");
                txtNom.requestFocus();
                cbCatg.requestFocus();
                cbCla.requestFocus();
                txtDir.requestFocus();
                txtPre.requestFocus();
                
                JOptionPane.showMessageDialog(this, "LOS DATOS SE REGISTRARON CORRECTAMENTE");
               
            }
        } catch (SQLException e) {
        }
       }
        cargarPeliculas();
    }//GEN-LAST:event_btnGMouseClicked

    private void tblPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeliculasMouseClicked
        // TODO add your handling code here:
        int select = tblPeliculas.rowAtPoint(evt.getPoint());
        txtId.setText(String.valueOf(tblPeliculas.getValueAt(select,0)));
        txtNom.setText(String.valueOf(tblPeliculas.getValueAt(select,1)));
        cbCatg.setSelectedItem(tblPeliculas.getValueAt(select, 3));
        cbCla.setSelectedItem(tblPeliculas.getValueAt(select, 4));
        txtDir.setText(String.valueOf(tblPeliculas.getValueAt(select,4)));
        txtPre.setText(String.valueOf(tblPeliculas.getValueAt(select,5)));
            
    }//GEN-LAST:event_tblPeliculasMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       Vistas v = new Vistas();
       v.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
     
    }//GEN-LAST:event_btnEActionPerformed

    private void btnEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEMouseClicked
       if(txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Seleccione Registro a eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
        int row = Integer.parseInt(txtId.getText());
        int opc = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar De forma Permanente Este Registro?","Pregunta",JOptionPane.YES_NO_CANCEL_OPTION);
        if(opc == JOptionPane.YES_OPTION){
            try {
                ProcedimientosAlma.EliminarPelis(row);
                txtId.setText("");
                txtNom.setText("");
                cbCatg.setSelectedIndex(0);
                cbCla.setSelectedIndex(0);
                txtDir.setText("");
                txtPre.setText("");
                txtNom.requestFocus();
                txtDir.requestFocus();
                txtPre.requestFocus();
                txtId.requestFocus();
            } catch (SQLException e) {
            }
        }
        }
        cargarPeliculas();
    }//GEN-LAST:event_btnEMouseClicked

    private void btnBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBMouseClicked
        // TODO add your handling code here:
        if(txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "PARA BUSCAR INGRESE NÚM pELICULA DATOS", "Error", JOptionPane.ERROR_MESSAGE);
            txtId.setText("");
            txtId.requestFocus();
        } else {
            try {
                String b;
                ProcedimientosAlma.BuscarPelicula(Integer.parseInt(txtId.getText()));
                b = txtId.getText();
                txtId.setText("");
                txtNom.setText("");
                txtDir.setText("");
                txtPre.setText("");
                txtId.requestFocus();
                txtNom.requestFocus();
                txtDir.requestFocus();
                txtPre.requestFocus();
                rs = conexion.ConexionBD.Consulta("select * from Peliculas");
                while(rs.next()){
                    if(rs.getString(1).equals(b)){
                        JOptionPane.showMessageDialog(null, "DATOS ENCONTRADOS");
                        txtId.setText(rs.getString(1));
                        txtNom.setText(rs.getString(2));
                        cbCatg.setSelectedItem(rs.getString(3));
                        cbCla.setSelectedItem(rs.getString(4));
                        txtDir.setText(rs.getString(5));
                        txtPre.setText(rs.getString(6));
                    }
                }
               JOptionPane.showMessageDialog(null, "DATOS NO ENCONTRADOS"); 
            }catch(SQLException e){
            }
            
        }
    }//GEN-LAST:event_btnBMouseClicked

    private void btnMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMMouseClicked
        // TODO add your handling code here:
         int Codigo=Integer.parseInt(txtId.getText());
        String nomp=txtNom.getText();
        String cat=String.valueOf(cbCatg.getSelectedItem());
        String clas=String.valueOf(cbCla.getSelectedItem());
        String dir=txtDir.getText();
        int pre =Integer.parseInt(txtPre.getText());
        ProcedimientosAlma.ModificarDatos(Codigo,nomp, cat, clas, dir, pre);
        cargarPeliculas();
    
       
    }//GEN-LAST:event_btnMMouseClicked

    private void txtPreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPreKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar(); 
        if(caracter < '0' || caracter > '9') {
            evt.consume();
            JOptionPane.showMessageDialog(getParent(), "SOLO SE ADMITEN NUMEROS", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_txtPreKeyTyped

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ConexionBD con = new ConexionBD();
        Connection conexion = con.getConnection();
        try {
            String ruta= System.getProperty("user.dir")+"/src/Reporte/RPeliculas.jasper";
            JasperReport jr = (JasperReport)JRLoader.loadObjectFromFile(ruta);
            JasperPrint pt = JasperFillManager.fillReport(ruta, null, conexion);
            JasperViewer jv = new JasperViewer(pt,false);
            jv.setVisible(true);
            jv.setDefaultCloseOperation(HIDE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Graficar gr = new Graficar();
        gr.setVisible(true);
        gr.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnG;
    private javax.swing.JButton btnM;
    private javax.swing.JComboBox<String> cbCatg;
    private javax.swing.JComboBox<String> cbCla;
    private javax.swing.JLabel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPeliculas;
    private javax.swing.JTextField txtDir;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPre;
    // End of variables declaration//GEN-END:variables
}
