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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ghost_Red
 */
public class productos extends javax.swing.JFrame {
    private static com.mysql.jdbc.Connection cnx = null;
    private DefaultTableModel datos;
    private JScrollPane sc;
    private Statement s;
    private int level;
    private String nombre; 
    public productos(int level,String nombre)throws SQLException, ClassNotFoundException {
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
        datos.addColumn("idProducto");
        datos.addColumn("Nombre");
        datos.addColumn ("Marca");
        datos.addColumn ("Costo");        
        datos.addColumn ("Precio");
        datos.addColumn ("Descripción");
        datos.addColumn ("Tipo");        
        datos.addColumn ("Categoria");
        datos.addColumn ("idInsumo");
        datos.addColumn ("Cantidad");        
        //
        Class.forName("com.mysql.jdbc.Driver");
        //cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/ladywaifu","root","1234ab");
        cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/candy's_spa","root","");
        s = cnx.createStatement();
        this.setLayout(null);
        this.setVisible(true);
        ResultSet rs = s.executeQuery("select * from productos LEFT JOIN tipo_producto ON productos.idTipo_producto=tipo_producto.idTipo_producto INNER JOIN insumos ON productos.idProducto=insumos.idProducto");
        while (rs.next()){
            Object [] fila = new Object[12];
            for (int i=0;i<12;i++){
                if(i==7||i==9){}
                else if(i==8){
                    fila[i-1] = rs.getObject(i+1); 
                }
                else if(i>9){
                    fila[i-2] = rs.getObject(i+1);
                }
                else{
                    fila[i] = rs.getObject(i+1); 
                }
            } 
            datos.addRow(fila); 
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        lblCLientes1 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        lblNombre = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblTelefono1 = new javax.swing.JLabel();
        lblEmai1 = new javax.swing.JLabel();
        lblNombre3 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblEmai2 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        lblTelefono2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtADes = new javax.swing.JTextArea();
        txtCantidad = new javax.swing.JTextField();
        lblNombre2 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        txtidInsumo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(datos);
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblNombre4 = new javax.swing.JLabel();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/productos.png"))); // NOI18N

        lblCLientes1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCLientes1.setText("PRODUCTOS");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCLientes1)
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addGap(44, 44, 44))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCLientes1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        lblNombre.setText("Nombre:");

        txtIdC.setEnabled(false);
        txtIdC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCActionPerformed(evt);
            }
        });

        lblNombre1.setText("IdProducto:");

        lblTelefono1.setText("Costo:");

        lblEmai1.setText("Precio:");

        lblNombre3.setText("Marca:");

        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        lblEmai2.setText("Categoria:");

        lblTelefono2.setText("Descripción:");

        txtADes.setColumns(20);
        txtADes.setRows(5);
        jScrollPane2.setViewportView(txtADes);

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        lblNombre2.setText("IdInsumo:");

        lblNombre5.setText("Cantidad:");

        txtidInsumo.setEnabled(false);
        txtidInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidInsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre1)
                    .addComponent(lblNombre)
                    .addComponent(lblTelefono1)
                    .addComponent(lblEmai1))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdC, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio))
                .addGap(29, 29, 29)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblNombre3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblEmai2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblTelefono2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre2)
                    .addComponent(lblNombre5))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidInsumo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre3)
                            .addComponent(lblNombre2)
                            .addComponent(txtidInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(lblTelefono2))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNombre5)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmai2)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre1))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono1)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmai1))))
                .addContainerGap(31, Short.MAX_VALUE))
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

        lblNombre4.setText("Nombre:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNombre4)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre4))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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
             Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
         } 
    }//GEN-LAST:event_itemMasajistasActionPerformed

    private void itemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientesActionPerformed
         try {
             this.setVisible(false);
             new Clientes(level,nombre).setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_itemClientesActionPerformed

    private void mnuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuProductosMouseClicked
        //new Productos().setVisible(true);
    }//GEN-LAST:event_mnuProductosMouseClicked

    private void mnuProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProductosActionPerformed
         /*try {
             new Productos().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }*/
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
        PreparedStatement consulta = cnx.prepareStatement("select * from productos INNER JOIN insumos ON productos.idProducto=insumos.idProducto where nombre='"+cad+"'");
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            txtIdC.setText(resultado.getString("idProducto")); 
            txtNombre.setText(resultado.getString("nombre"));
            txtMarca.setText(resultado.getString("marca"));
            txtTelefono.setText(resultado.getString("costo"));
            txtPrecio.setText(resultado.getString("precio"));
            txtADes.setText(resultado.getString("descripcion"));
            txtCategoria.setText(resultado.getString("idTipo_producto"));
            txtidInsumo.setText(resultado.getString("idInsumo"));
            txtCantidad.setText(resultado.getString("cantidad"));
        }
      }
      catch (SQLException ex) {
        Component btn_Option = null;
        int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al Buscar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
        if(select==JOptionPane.OK_OPTION){} 
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
        txtTelefono.setText("");
        txtPrecio.setText("");
        txtMarca.setText("");
        txtADes.setText("");
        txtCategoria.setText("");
        txtidInsumo.setText("");
        txtCantidad.setText("");        
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
        String costo= getTxtCosto().getText();
        String precio= getTxtPrecio().getText();
        String marca=getTxtMarca().getText();
        String descripcion=getTxtDescripcion().getText();
        int categoria=Integer.parseInt(getTxtCategoria().getText());
        int idInsumo=Integer.parseInt(getTxtidInsumo().getText());
        int cantidad=Integer.parseInt(getTxtCantidad().getText());
        String tmp;
        try{ 
            tmp="insert into productos (nombre,marca,costo,precio,descripcion,idTipo_producto) values ('"+Nombre+"','"+marca+"','"+costo+"','"+precio+"','"+descripcion+"','"+categoria+"')";
             int rs=s.executeUpdate(tmp,Statement.RETURN_GENERATED_KEYS);
            String s2=String.valueOf(rs);  
             if(rs!=0){
                tmp="insert into insumos(idProducto,cantidad) values ('"+rs+"','"+cantidad+"')";
                int rs_1=s.executeUpdate(tmp,Statement.RETURN_GENERATED_KEYS);
                if(rs_1!=0){ 
                    txtIdC.setText(""); 
                    txtNombre.setText("");
                    txtTelefono.setText("");
                    txtPrecio.setText("");
                    txtMarca.setText("");
                    txtADes.setText("");
                    txtCategoria.setText("");
                    txtidInsumo.setText("");
                    txtCantidad.setText("");                     
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
                        ResultSet res = s.executeQuery("select * from productos LEFT JOIN tipo_producto ON productos.idTipo_producto=tipo_producto.idTipo_producto INNER JOIN insumos ON productos.idProducto=insumos.idProducto");
                        while (res.next()){
                            Object [] fila = new Object[12];
                            for (int i=0;i<12;i++){
                                if(i==7||i==9){}
                                else if(i==8){
                                    fila[i-1] = res.getObject(i+1); 
                                }
                                else if(i>9){
                                    fila[i-2] = res.getObject(i+1);
                                }
                                else{
                                    fila[i] = res.getObject(i+1); 
                                }
                            } 
                            datos.addRow(fila); 
                        }
                    } 
                }
             }
             else{
                Component btn_Option = null;
                int sele = JOptionPane.showOptionDialog(btn_Option,"Fallo al insertar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                if(sele==JOptionPane.OK_OPTION){}         
             }
        }catch(SQLException ex) {  
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String idC= getTxtIdC().getText();
        String tmp;
        tmp="delete from productos where idProducto="+idC;
        try {
            int rs=s.executeUpdate(tmp);
            String s2=String.valueOf(rs); 
            //datos.fireTableStructureChanged();
            if(rs!=0){
                tmp="delete from insumos where idProducto="+idC;
                int rs_1=s.executeUpdate(tmp);
                datos.fireTableStructureChanged();
                if(rs_1!=0){
                    Component btn_Option = null;
                    int sele = JOptionPane.showOptionDialog(btn_Option,"¡Exito al Eliminar!", "Exito", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                    if(sele==JOptionPane.OK_OPTION){
                        int a = datos.getRowCount()-1;
                        for (int i = a; i >= 0; i--) {          
                            datos.removeRow(datos.getRowCount()-1);
                        }
                        s = cnx.createStatement();
                        ResultSet res = s.executeQuery("select * from productos LEFT JOIN tipo_producto ON productos.idTipo_producto=tipo_producto.idTipo_producto INNER JOIN insumos ON productos.idProducto=insumos.idProducto");
                        while (res.next()){
                            Object [] fila = new Object[12];
                            for (int i=0;i<12;i++){
                                if(i==7||i==9){}
                                else if(i==8){
                                    fila[i-1] = res.getObject(i+1); 
                                }
                                else if(i>9){
                                    fila[i-2] = res.getObject(i+1);
                                }
                                else{
                                    fila[i] = res.getObject(i+1); 
                                }
                            } 
                            datos.addRow(fila); 
                        }
                        txtIdC.setText(""); 
                        txtNombre.setText("");
                        txtTelefono.setText("");
                        txtPrecio.setText("");
                        txtMarca.setText("");
                        txtADes.setText("");
                        txtCategoria.setText("");
                        txtidInsumo.setText("");
                        txtCantidad.setText(""); 
                   }
                   else{                
                       int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al eliminar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                       if(select==JOptionPane.OK_OPTION){}  
                   }
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
        String costo= getTxtCosto().getText();
        String precio= getTxtPrecio().getText();
        String marca=getTxtMarca().getText();
        String descripcion=getTxtDescripcion().getText();
        int categoria=Integer.parseInt(getTxtCategoria().getText());
        int cantidad=Integer.parseInt(getTxtCantidad().getText());
        String tmp;
        try{ 
            tmp="update productos set nombre='"+Nombre+"',marca='"+marca+"',costo='"+costo+"',precio='"+precio+"',descripcion='"+descripcion+"',idTipo_producto='"+categoria+"' where idProducto="+idC;
            int rs=s.executeUpdate(tmp);
            String s2=String.valueOf(rs);  
            if(rs!=0){
                tmp="update insumos set cantidad='"+cantidad+"' where idProducto="+idC;
                int rs_1=s.executeUpdate(tmp);  
                if(rs_1!=0){                
                    Component btn_Option = null;
                    int sele = JOptionPane.showOptionDialog(btn_Option,"¡Exito al Actualizar!", "Exito", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                    int a = datos.getRowCount()-1;
                    for (int i = a; i >= 0; i--) {          
                        datos.removeRow(datos.getRowCount()-1);
                    }
                    if(sele==JOptionPane.OK_OPTION){
                        s = cnx.createStatement();
                        ResultSet res = s.executeQuery("select * from productos LEFT JOIN tipo_producto ON productos.idTipo_producto=tipo_producto.idTipo_producto INNER JOIN insumos ON productos.idProducto=insumos.idProducto");
                        while (res.next()){
                            Object [] fila = new Object[12];
                            for (int i=0;i<12;i++){
                                if(i==7||i==9){}
                                else if(i==8){
                                    fila[i-1] = res.getObject(i+1); 
                                }
                                else if(i>9){
                                    fila[i-2] = res.getObject(i+1);
                                }
                                else{
                                    fila[i] = res.getObject(i+1); 
                                }
                            } 
                            datos.addRow(fila); 
                        }
                    }
                    else{                
                        int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al actualizar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                        if(select==JOptionPane.OK_OPTION){}  
                    }
                }
             }
        }catch (SQLException ex) {  
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
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

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

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

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtidInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidInsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidInsumoActionPerformed



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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCLientes1;
    private javax.swing.JLabel lblEmai1;
    private javax.swing.JLabel lblEmai2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblNombre2;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblTelefono1;
    private javax.swing.JLabel lblTelefono2;
    private javax.swing.JMenuBar mBar1;
    private javax.swing.JMenu mnuCitas;
    private javax.swing.JMenu mnuPersonal;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuVentas;
    private java.awt.Panel panel1;
    private java.awt.Panel pnl1;
    private javax.swing.JTable tabla;
    private javax.swing.JMenu tbServicios;
    private javax.swing.JTextArea txtADes;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtIdC;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtidInsumo;
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
   public JTextField getTxtCosto(){
    return txtTelefono;
   } 
   public JTextField getTxtPrecio(){
    return txtPrecio;
   }
   public JTextField getTxtMarca(){
    return txtMarca;
   }
   public JTextArea getTxtDescripcion(){
    return txtADes;
   }  
   public JTextField getTxtCategoria(){
    return txtCategoria;
   }   
   public JTextField getTxtidInsumo(){
    return txtidInsumo;
   }
   public JTextField getTxtCantidad(){
    return txtCantidad;
   }
}
