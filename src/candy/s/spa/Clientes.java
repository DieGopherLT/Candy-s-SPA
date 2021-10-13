package candy.s.spa;

import java.awt.Color;
import java.awt.Component;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ghost_Red
 */
public class Clientes extends javax.swing.JFrame {
     private static com.mysql.jdbc.Connection cnx = null;
    private DefaultTableModel datos;
    private JScrollPane sc;
    private Statement s;
    private int level;
    private String nombre; 
    public Clientes(int level,String nombre)throws SQLException, ClassNotFoundException {
        this.level=level;
        this.nombre=nombre;
        Toolkit tk=Toolkit.getDefaultToolkit();
        setLocation(new Point((tk.getScreenSize().width-getSize().width)/7,(tk.getScreenSize().height-getSize().height)/5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#96EBF2")); 
        datos = new DefaultTableModel();
        initComponents();
        txtIdC.setEditable(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        datos.addColumn("idCliente");
        datos.addColumn("Nombre");
        datos.addColumn("Apellido");        
        datos.addColumn ("Telefono");
        datos.addColumn ("Correo");        
        Class.forName("com.mysql.jdbc.Driver");
        //cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/ladywaifu","root","1234ab");
        cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/candy's_spa","root","");
        s = cnx.createStatement();
        ResultSet rs = s.executeQuery("select * from clientes");
        while (rs.next()){
            Object [] fila = new Object[5];
            for (int i=0;i<5;i++)
                fila[i] = rs.getObject(i+1);
            datos.addRow(fila); 
        }
        this.setLayout(null);
        this.setVisible(true);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new java.awt.Panel();
        lblCLientes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        lblCliente = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblEmai = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtApp = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(datos);
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblEmai1 = new javax.swing.JLabel();
        mBar1 = new javax.swing.JMenuBar();
        mnuPersonal = new javax.swing.JMenu();
        itemMasajistas = new javax.swing.JMenuItem();
        itemClientes = new javax.swing.JMenuItem();
        tbServicios = new javax.swing.JMenu();
        mnuProductos = new javax.swing.JMenu();
        mnuVentas = new javax.swing.JMenu();
        mnuCitas = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl1.setBackground(Color.decode("#77A2EC"));

        lblCLientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCLientes.setText("CLIENTES");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/clientes.png"))); // NOI18N

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCLientes)
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addGap(44, 44, 44))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCLientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        lblCliente.setText("IdCliente:");

        lblNombre.setText("Nombre:");

        lblTelefono.setText("Teléfono:");

        lblEmai.setText("Correo:");

        txtIdC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppActionPerformed(evt);
            }
        });

        lblNombre1.setText("Apellido:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdC))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefono)
                            .addComponent(lblNombre))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefono)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre1)
                    .addComponent(lblEmai))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail)
                    .addComponent(txtApp, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombre1)
                        .addComponent(txtApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEmai)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/nuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/modificar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/salir.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tabla);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/Buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        lblEmai1.setText("Correo:");

        mBar1.setBackground(new java.awt.Color(127, 255, 212));
        mBar1.setPreferredSize(new java.awt.Dimension(407, 27));

        mnuPersonal.setBackground(new java.awt.Color(255, 255, 51));
        mnuPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/personal.png"))); // NOI18N
        mnuPersonal.setText("PERSONAL");
        mnuPersonal.setPreferredSize(new java.awt.Dimension(150, 10));

        itemMasajistas.setText("EMPLEADOS");
        itemMasajistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMasajistasActionPerformed(evt);
            }
        });
        mnuPersonal.add(itemMasajistas);

        itemClientes.setText("CLIENTES");
        itemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClientesActionPerformed(evt);
            }
        });
        mnuPersonal.add(itemClientes);

        mBar1.add(mnuPersonal);

        tbServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/servicios.png"))); // NOI18N
        tbServicios.setText("SERVICIOS");
        tbServicios.setPreferredSize(new java.awt.Dimension(107, 10));
        tbServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServiciosMouseClicked(evt);
            }
        });
        tbServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbServiciosActionPerformed(evt);
            }
        });
        mBar1.add(tbServicios);

        mnuProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/productos.png"))); // NOI18N
        mnuProductos.setText("PRODUCTOS");
        mnuProductos.setPreferredSize(new java.awt.Dimension(150, 10));
        mnuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuProductosMouseClicked(evt);
            }
        });
        mnuProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProductosActionPerformed(evt);
            }
        });
        mBar1.add(mnuProductos);

        mnuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/Ventas.png"))); // NOI18N
        mnuVentas.setText("NOTAS DE VENTA");
        mnuVentas.setPreferredSize(new java.awt.Dimension(140, 10));
        mnuVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuVentasMouseClicked(evt);
            }
        });
        mnuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentasActionPerformed(evt);
            }
        });
        mBar1.add(mnuVentas);

        mnuCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/empleados.png"))); // NOI18N
        mnuCitas.setText("CITAS");
        mnuCitas.setPreferredSize(new java.awt.Dimension(140, 10));
        mnuCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCitasMouseClicked(evt);
            }
        });
        mnuCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCitasActionPerformed(evt);
            }
        });
        mBar1.add(mnuCitas);

        setJMenuBar(mBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(310, 310, 310)
                                .addComponent(lblEmai1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmai1))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        new inicio(level,nombre).setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void itemMasajistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMasajistasActionPerformed
         try {
             this.setVisible(false);
             new Empleados(level,nombre).setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } 
    }//GEN-LAST:event_itemMasajistasActionPerformed

    private void itemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientesActionPerformed
        //new Clientes().setVisible(true);
        //Clientes u= new Clientes();
    }//GEN-LAST:event_itemClientesActionPerformed

    private void mnuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuProductosMouseClicked
         try {
             this.setVisible(false);
             new productos(level,nombre).setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_mnuProductosMouseClicked

    private void mnuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProductosActionPerformed
         try {
             this.setVisible(false);
             new productos(level,nombre).setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_mnuProductosActionPerformed

    private void mnuVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuVentasMouseClicked
        try {
            this.setVisible(false);
            new Ventas(level,nombre).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuVentasMouseClicked

    private void mnuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentasActionPerformed
         /*try {
             new Ventas().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }//GEN-LAST:event_mnuVentasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String cad= getTxtBuscar().getText();
    btnEliminar.setEnabled(true);
    btnModificar.setEnabled(true);
    //txtIdC.setEditable(true);
    //public Tarea recuperarPorId(Connection conexion, int id_tarea) throws SQLException {
      //Tarea tarea = null;
      try{
        PreparedStatement consulta = cnx.prepareStatement("select *from clientes where correo='"+cad+"'");
        //consulta.setInt(1, idCliente);
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
           txtIdC.setText(resultado.getString("idCliente")); 
           txtNombre.setText(resultado.getString("nombre"));
           txtApp.setText(resultado.getString("apellido"));
           txtEmail.setText(resultado.getString("correo"));
           txtTelefono.setText(resultado.getString("telefono"));
        }
      }
      catch (SQLException ex) {
        Component btn_Option = null;
        int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al Buscar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
        if(select==JOptionPane.OK_OPTION){
            //System.exit(0);
        } 
      }
      
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtIdCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIdC.setText(""); 
        txtNombre.setText("");
        txtApp.setText("");
        txtTelefono.setText("");        
        txtEmail.setText("");
        txtBuscar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String idC= getTxtIdC().getText(); 
    String Nombre= getTxtNombre().getText();
    String Apellido=getTxtApp().getText();
    String Correo= getTxtCorreo().getText();
    String Telefono= getTxtTelefono().getText();
    String tmp;
    try{ 
        tmp="insert into clientes (nombre,apellido,telefono,correo) values ('"+Nombre+"','"+Apellido+"','"+Telefono+"','"+Correo+"')";
         int rs=s.executeUpdate(tmp);
        //s.executeUpdate(tmp);
        String s2=String.valueOf(rs);  
         if(rs!=0){
            txtIdC.setText(""); 
            txtNombre.setText("");
            txtEmail.setText("");
            txtTelefono.setText("");
            txtBuscar.setEnabled(true);
            btnBuscar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnSalir.setEnabled(true);
            Component btn_Option = null;
            int sele = JOptionPane.showOptionDialog(btn_Option,"¡Exito al insertar!", "Exito", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(sele==JOptionPane.OK_OPTION){
            int a = datos.getRowCount()-1;
                for (int i = a; i >= 0; i--) {          
                    datos.removeRow(datos.getRowCount()-1);
                }
                s = cnx.createStatement();
                ResultSet res = s.executeQuery("select * from clientes");
                while (res.next()){
                    Object [] fila = new Object[5];
                    for (int i=0;i<5;i++)
                        fila[i] = res.getObject(i+1);
                    datos.addRow(fila); 
                }
            } 
         }
         else{
            Component btn_Option = null;
            int sele = JOptionPane.showOptionDialog(btn_Option,"Fallo al insertar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(sele==JOptionPane.OK_OPTION){
                //System.exit(0);
            }         
         }
    }catch(SQLException ex) {  
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
     }          
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int idC=Integer.parseInt(getTxtIdC().getText());
    String tmp;
    tmp="delete from clientes where idCliente="+idC;
        try {
            int rs=s.executeUpdate(tmp);
            String s2=String.valueOf(rs); 
            datos.fireTableStructureChanged();
            if(rs!=0){
               Component btn_Option = null;
               int sele = JOptionPane.showOptionDialog(btn_Option,"¡Exito al Eliminar!", "Exito", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
               if(sele==JOptionPane.OK_OPTION){
                  int a = datos.getRowCount()-1;
                  for (int i = a; i >= 0; i--) {          
                    datos.removeRow(datos.getRowCount()-1);
                  }
                   s = cnx.createStatement();
                   ResultSet res = s.executeQuery("select * from clientes");
                    while (res.next()){
                        Object [] fila = new Object[5];
                        for (int i=0;i<5;i++)
                            fila[i] = res.getObject(i+1);
                        datos.addRow(fila); 
                    }
                    txtIdC.setText(""); 
                    txtNombre.setText("");
                    txtApp.setText("");                    
                    txtEmail.setText("");
                    txtTelefono.setText("");
                    txtBuscar.setText("");
               }
               else{                
                   int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al eliminar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                   if(select==JOptionPane.OK_OPTION){}  
               }
            }
         } catch (SQLException ex) {
            Component btn_Option = null;
            int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al eliminar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(select==JOptionPane.OK_OPTION){}  
         }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
    String idC= getTxtIdC().getText();
    String Nombre= getTxtNombre().getText();
    String Correo= getTxtCorreo().getText();
    String Telefono= getTxtTelefono().getText();
    String Apellido=getTxtApp().getText();    
    String tmp;
    try{ 
        tmp="update clientes set nombre='"+Nombre+"',correo='"+Correo+"',apellido='"+Apellido+"',telefono='"+Telefono+"' where idCliente="+idC;
        int rs=s.executeUpdate(tmp);
        String s2=String.valueOf(rs);  
         if(rs!=0){
            Component btn_Option = null;
            int sele = JOptionPane.showOptionDialog(btn_Option,"¡Exito al Actualizar!", "Exito", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            int a = datos.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                datos.removeRow(datos.getRowCount()-1);
            }
            if(sele==JOptionPane.OK_OPTION){
                //System.exit(0);;
                s = cnx.createStatement();
                ResultSet res = s.executeQuery("select * from clientes");
                while (res.next()){
                    Object [] fila = new Object[5];
                    for (int i=0;i<5;i++)
                         fila[i] = res.getObject(i+1);
                    datos.addRow(fila); 
                }
            }
            else{                
                int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al actualizar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                if(select==JOptionPane.OK_OPTION){}  
            }
         }
    }  catch (SQLException ex) {  
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }  
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tbServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServiciosMouseClicked
         try {
             this.setVisible(false);
             new Servicios(level,nombre).setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_tbServiciosMouseClicked

    private void tbServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbServiciosActionPerformed
        /*try {
            new Ventas().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_tbServiciosActionPerformed

    private void mnuCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCitasMouseClicked
        try {
            this.setVisible(false);
            new Citas(level,nombre).setVisible(true);
        } catch (SQLException ex) {
            //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuCitasMouseClicked

    private void mnuCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCitasActionPerformed
        try {
            this.setVisible(false);
            new Citas(level,nombre).setVisible(true);
        } catch (SQLException ex) {
            //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuCitasActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JMenuItem itemClientes;
    private javax.swing.JMenuItem itemMasajistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCLientes;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEmai;
    private javax.swing.JLabel lblEmai1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JMenuBar mBar1;
    private javax.swing.JMenu mnuCitas;
    private javax.swing.JMenu mnuPersonal;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuVentas;
    private java.awt.Panel panel1;
    private java.awt.Panel pnl1;
    private javax.swing.JTable tabla;
    private javax.swing.JMenu tbServicios;
    private javax.swing.JTextField txtApp;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdC;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

   public JTextField getTxtBuscar(){
        return txtBuscar;
   }
   public JTextField getTxtIdC(){
        return txtIdC;
   }
   public JTextField getTxtNombre(){
        return txtNombre;
   }
   public JTextField getTxtApp(){
        return txtApp;
   }   
   public JTextField getTxtTelefono(){
        return txtTelefono;
   }
   public JTextField getTxtCorreo(){
        return txtEmail;
   }
}
