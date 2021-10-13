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
public class Empleados extends javax.swing.JFrame {
     private static com.mysql.jdbc.Connection cnx = null;
    private DefaultTableModel datos;
    private JScrollPane sc;
    private Statement s;
    private int level;
    private String nombre;    
    public Empleados(int level,String nombre)throws SQLException, ClassNotFoundException {
        this.level=level;
        this.nombre=nombre;        
        Toolkit tk=Toolkit.getDefaultToolkit();
        setLocation(new Point((tk.getScreenSize().width-getSize().width)/7,(tk.getScreenSize().height-getSize().height)/5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#96EBF2")); 
        datos = new DefaultTableModel();
        initComponents();
        txtIdE.setEditable(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        datos.addColumn("idEmpleado");
        datos.addColumn("Nombre");
        datos.addColumn("Apellido");
        datos.addColumn("Dirección");
        datos.addColumn ("Teléfono");
        datos.addColumn ("estado");
        datos.addColumn ("correo");
        datos.addColumn ("Contraseña");
        datos.addColumn("Nivel");
        datos.addColumn ("Privilegio");
        Class.forName("com.mysql.jdbc.Driver");
        //cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/ladywaifu","root","1234ab");
        cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/candy's_spa","root","");
        s = cnx.createStatement();
        ResultSet rs = s.executeQuery("select * from empleados LEFT JOIN tipo_empleado ON empleados.idTipo_empleado=tipo_empleado.idTipo_empleado");
        while (rs.next()){
            Object [] fila = new Object[11];
            for (int i=0;i<11;i++){
                if(i==9){}
                else if(i==10){
                    fila[i-1] = rs.getObject(i+1); 
                }
                else{
                    fila[i] = rs.getObject(i+1); 
                }
            } 
            datos.addRow(fila); 

        }
        this.setLayout(null);
        this.setVisible(true);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        lblMasajistas = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        lblNombre = new javax.swing.JLabel();
        txtIdE = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApp = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        lblMasajista = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        lblMasajista1 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        lblEdad1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        lblEspecialidad1 = new javax.swing.JLabel();
        lblMasajista2 = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLevels = new javax.swing.JList<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(datos);
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblMasajista3 = new javax.swing.JLabel();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/empleados.png"))); // NOI18N

        lblMasajistas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMasajistas.setText("EMPLEADOS");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMasajistas)
                .addGap(387, 387, 387)
                .addComponent(jLabel1)
                .addGap(44, 44, 44))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMasajistas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNombre.setText("Nombre:");

        txtIdE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEActionPerformed(evt);
            }
        });

        lblMasajista.setText("idEmpleado:");
        lblMasajista.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajistaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblEdad.setText("Apellido:");

        lblEspecialidad.setText("Dirección:");

        lblMasajista1.setText("Teléfono:");
        lblMasajista1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajista1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        lblNombre1.setText("Estado:");

        lblEdad1.setText("Correo:");

        lblEspecialidad1.setText("Contraseña:");

        lblMasajista2.setText("Nivel:");
        lblMasajista2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajista2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLevelActionPerformed(evt);
            }
        });

        lstLevels.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "RELACIÓN DE NIVEL CON SU PRIVILEGIO", "", "1=Administrador", "2=Almacenista", "3=Recepcionista", "4=Masajista" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstLevels.setEnabled(false);
        jScrollPane2.setViewportView(lstLevels);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMasajista)
                    .addComponent(lblNombre)
                    .addComponent(lblEdad)
                    .addComponent(lblEspecialidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtApp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdE, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMasajista1)
                    .addComponent(lblNombre1)
                    .addComponent(lblEdad1)
                    .addComponent(lblEspecialidad1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblMasajista2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMasajista))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEdad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEspecialidad)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMasajista1)
                            .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMasajista2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNombre1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEdad1)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEspecialidad1)
                                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
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

        lblMasajista3.setText("Correo:");
        lblMasajista3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajista3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMasajista3)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblMasajista3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
        new inicio(level,nombre).setVisible(true);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void itemMasajistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMasajistasActionPerformed
         /*try {
             new Empleados().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Masajistas.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Masajistas.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }//GEN-LAST:event_itemMasajistasActionPerformed

    private void itemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClientesActionPerformed
        
         try {
             this.setVisible(false);
             new Clientes(level,nombre).setVisible(true);
             //Clientes u= new Masajistas();
         } catch (SQLException ex) {
             Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
         }
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
         /*try {
             new Productos().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Masajistas.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Masajistas.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(Masajistas.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Masajistas.class.getName()).log(Level.SEVERE, null, ex);
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
        PreparedStatement consulta = cnx.prepareStatement("select *from empleados where correo='"+cad+"'");
        //consulta.setInt(1, idCliente);
        ResultSet resultado = consulta.executeQuery();
        while(resultado.next()){
            txtIdE.setText(resultado.getString("idEmpleado")); 
            txtNombre.setText(resultado.getString("nombre"));
            txtApp.setText(resultado.getString("apellido"));
            txtDireccion.setText(resultado.getString("direccion"));
            txtTel.setText(resultado.getString("telefono"));
            txtEstado.setText(resultado.getString("estado"));
            txtCorreo.setText(resultado.getString("correo"));
            txtPass.setText(resultado.getString("password"));
            txtLevel.setText(resultado.getString("idTipo_empleado"));
            //resultado.getInt("nivel_de_prioridad"));
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

    private void txtIdEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtIdE.setText(""); 
        txtNombre.setText("");
        txtApp.setText("");
        txtDireccion.setText("");
        txtBuscar.setEnabled(false);
        txtTel.setText("");
        txtEstado.setText("");
        txtCorreo.setText("");
        txtPass.setText("");
        txtLevel.setText("");        
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed
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
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String idE= getTxtIdC().getText(); 
        String Nombre= getTxtNombre().getText();
        String app= getTxtEdad().getText();
        String direccion= getTxtDireccion().getText();
        String tel=getTxtTel().getText();
        String estado=getTxtEstado().getText();
        String correo=getTxtCorreo().getText();
        String password=MD5(getTxtPass().getText());
        int level=Integer.parseInt(getTxtLevel().getText());
        String tmp;
        if(level<5&&level>0){
            try{ 
                //consulta= cnx.prepareStatement("insert into clientes(nombre,apellido,telefono,direccion,email)values"+"("+Nombre+','+Apellido+','+Telefono+','+Direccion+','+Email+")");
                tmp="insert into empleados (nombre,apellido,direccion,telefono,estado,correo,password,idTipo_empleado) values ('"+Nombre+"','"+app+"','"+direccion+"','"+tel+"','"+estado+"','"+correo+"','"+password+"','"+level+"')";
                 int rs=s.executeUpdate(tmp);
                //s.executeUpdate(tmp);
                String s2=String.valueOf(rs);  
                 if(rs!=0){
                    txtIdE.setText(""); 
                    txtNombre.setText("");
                    txtDireccion.setText("");
                    txtApp.setText("");
                    txtTel.setText("");
                    txtEstado.setText("");
                    txtCorreo.setText("");
                    txtPass.setText("");
                    txtLevel.setText("");                    
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
                        ResultSet res = s.executeQuery("select * from empleados LEFT JOIN tipo_empleado ON empleados.idTipo_empleado=tipo_empleado.idTipo_empleado");
                        while (res.next()){
                            Object [] fila = new Object[11]; // Hay seis columnas en la tabla
                            for (int i=0;i<11;i++){
                                if(i==9){}
                                else if(i==10){
                                    fila[i-1] = res.getObject(i+1); 
                                }
                                else{
                                    fila[i] = res.getObject(i+1); 
                                }
                            } 
                            datos.addRow(fila); 
                        }                        
                    } 
                 }
                 else{
                    Component btn_Option = null;
                    int sele = JOptionPane.showOptionDialog(btn_Option,"Fallo al insertar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                    if(sele==JOptionPane.OK_OPTION){ }         
                 }
            }catch(SQLException ex) {  
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else{
          errorMessageLevel();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void errorMessageLevel(){
        Component btn_Option = null;
        int sele = JOptionPane.showOptionDialog(btn_Option,"Nivel no permitido, porfavor intente otro", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
        if(sele==JOptionPane.OK_OPTION){ }      
    }
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    String idE= getTxtIdC().getText();
     String tmp;
     tmp="delete from empleado where idEmpleado="+idE;
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
                    ResultSet res = s.executeQuery("select * from empleados LEFT JOIN tipo_empleado ON empleados.idTipo_empleado=tipo_empleado.idTipo_empleado");
                    while (res.next()){
                        Object [] fila = new Object[11]; // Hay seis columnas en la tabla
                        for (int i=0;i<11;i++){
                            if(i==9){}
                            else if(i==10){
                                fila[i-1] = res.getObject(i+1); 
                            }
                            else{
                                fila[i] = res.getObject(i+1); 
                            }
                        } 
                        datos.addRow(fila); 
                    } 
                    txtIdE.setText(""); 
                    txtNombre.setText("");
                    txtDireccion.setText("");
                    txtApp.setText("");                    
                    txtBuscar.setText("");
                    txtTel.setText("");
                    txtEstado.setText("");
                    txtCorreo.setText("");
                    txtPass.setText("");
                    txtLevel.setText(""); 
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
        String idE= getTxtIdC().getText(); 
        String Nombre= getTxtNombre().getText();
        String app= getTxtEdad().getText();
        String direccion= getTxtDireccion().getText();
        String tel=getTxtTel().getText();
        String estado=getTxtEstado().getText();
        String correo=getTxtCorreo().getText();
        String password=MD5(getTxtPass().getText());
        int level=Integer.parseInt(getTxtLevel().getText());
        String tmp;
        if(level<5&&level>0){
            try{ 
                tmp="update empleados set nombre='"+Nombre+"',apellido='"+app+"',direccion='"+direccion+"',telefono='"+tel+"',estado='"+estado+"',correo='"+correo+"',password='"+password+"',idTipo_empleado='"+level+"' where idEmpleado="+idE;
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
                        ResultSet res = s.executeQuery("select * from empleados LEFT JOIN tipo_empleado ON empleados.idTipo_empleado=tipo_empleado.idTipo_empleado");
                        while (res.next()){
                            Object [] fila = new Object[11]; // Hay seis columnas en la tabla
                            for (int i=0;i<11;i++){
                                if(i==9){}
                                else if(i==10){
                                    fila[i-1] = res.getObject(i+1); 
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
            }catch (SQLException ex) {  
                Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        else{
            errorMessageLevel();        
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

    private void lblMasajistaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblMasajistaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMasajistaAncestorAdded

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

    private void lblMasajista1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblMasajista1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMasajista1AncestorAdded

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void lblMasajista2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblMasajista2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMasajista2AncestorAdded

    private void txtLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLevelActionPerformed

    private void lblMasajista3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblMasajista3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMasajista3AncestorAdded



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
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdad1;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblEspecialidad1;
    private javax.swing.JLabel lblMasajista;
    private javax.swing.JLabel lblMasajista1;
    private javax.swing.JLabel lblMasajista2;
    private javax.swing.JLabel lblMasajista3;
    private javax.swing.JLabel lblMasajistas;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JList<String> lstLevels;
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
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdE;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables

   public JTextField getTxtBuscar(){
       return txtBuscar;
   }
   public JTextField getTxtIdC(){
       return txtIdE;
   }
   public JTextField getTxtNombre(){
       return txtNombre;
   }
   public JTextField getTxtEdad(){
       return txtApp;
   }
   public JTextField getTxtDireccion(){
       return txtDireccion;
   }
   public JTextField getTxtTel(){
       return txtTel;
   }
   public JTextField getTxtEstado(){
       return txtEstado;
   }
   public JTextField getTxtCorreo(){
       return txtCorreo;
   }
   public JTextField getTxtPass(){
       return txtPass;
   }
   public JTextField getTxtLevel(){
       return txtLevel;
   }
}
