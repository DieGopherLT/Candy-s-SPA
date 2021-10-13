package candy.s.spa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class window extends JFrame {
    private JLabel lblImg;
    private ImageIcon img;
    //private static Connection cnx = null;
    private static com.mysql.jdbc.Connection cnx = null;
    private DefaultTableModel datos;
    private JScrollPane sc;
    private Statement s;    
    public window()throws SQLException, ClassNotFoundException {
        super();
        Toolkit tk=Toolkit.getDefaultToolkit();
        setLocation(new Point((tk.getScreenSize().width-getSize().width)/2,(tk.getScreenSize().height-getSize().height)/2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#96EBF2"));        
        img = new ImageIcon(getClass().getResource("img/menu.png"));
        lblImg=new JLabel(img);
        lblImg.setSize(120,120);
        lblImg.setLocation(290,40);
        add(lblImg);
        Class.forName("com.mysql.jdbc.Driver");
        cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/candy's_spa","root","");
        s = cnx.createStatement();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("BIENVENIDO  ;)");
        jLabel1.setToolTipText("");

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        jLabel2.setText("Correo:");

        jLabel3.setText("Contraseña:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(133, 133, 133)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnIngresar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir))
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnSalir))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        btnIngresar.getAccessibleContext().setAccessibleName("btnIngresar");
        btnSalir.getAccessibleContext().setAccessibleName("btnRegistrarse");
        jLabel1.getAccessibleContext().setAccessibleName("lblTitle");
        jLabel2.getAccessibleContext().setAccessibleName("lblUsuario");
        jLabel3.getAccessibleContext().setAccessibleName("lblContraseña");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String MD5(String md5) {
       try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
              sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
           }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String cad=getTxtUser().getText();
        String cad2=getTxtPass().getText();
        int level=0;
        String estado="";
        String nombre="";
        if(cad.equals("")||cad2.equals("")){
            JOptionPane.showMessageDialog(null,"Error campos vacios!!","Fallo...",0);
               
        }
        else{
            String pass=MD5(cad2);
            try{
                PreparedStatement consulta = cnx.prepareStatement("select idTipo_empleado,estado,nombre from empleados where correo='"+cad+"' and password='"+pass+"'");
                //consulta.setInt(1, idCliente);
                ResultSet resultado = consulta.executeQuery();
                //System.out.println("Is: "+resultado.first());
                while(resultado.next()){                    
                    level=Integer.parseInt(resultado.getString("idTipo_empleado"));
                    estado=resultado.getString("estado");
                    nombre=resultado.getString("nombre");
                    if(estado.equals("Activo")){
                        new inicio(level,nombre).setVisible(true);
                        this.setVisible(false);
                    }
                }
                if(resultado.first()==false){
                    errorMessage();
                }
            }
            catch (SQLException ex) {
                errorMessage();
            }        
        }
    }//GEN-LAST:event_btnIngresarActionPerformed
    private void errorMessage(){
        Component btn_Option = null;
        int select = JOptionPane.showOptionDialog(btn_Option,"Error en usuario o contraseña!!", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
        if(select==JOptionPane.OK_OPTION){
        }     
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Component btn_Option = null;
        int sele = JOptionPane.showOptionDialog(btn_Option,"¿Salir?", "Exit", JOptionPane.YES_NO_OPTION, 	  JOptionPane.ERROR_MESSAGE, null, new Object[] {"Si", "No",}, "Si");
        if(sele==JOptionPane.YES_OPTION){
            try {
                cnx.close();
            } catch (SQLException ex) {
                Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
            
        } 
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new window().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
    public JTextField getTxtUser(){
    return txtUser;
    }
    public JTextField getTxtPass(){
    return txtPass;
    }
}
