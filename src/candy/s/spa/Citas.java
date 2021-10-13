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
import javax.swing.JComboBox;
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
public class Citas extends javax.swing.JFrame {
     private static com.mysql.jdbc.Connection cnx = null;
    private DefaultTableModel datos,datos_2,datos_3,datos_4;
    private JScrollPane sc;
    private Statement s;
    private int level;
    private String nombre; 
    public Citas(int level,String nombre)throws SQLException, ClassNotFoundException {
        this.level=level;
        this.nombre=nombre;
        Toolkit tk=Toolkit.getDefaultToolkit();
        setLocation(new Point((tk.getScreenSize().width-getSize().width)/12,(tk.getScreenSize().height-getSize().height)/5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#96EBF2")); 
        datos = new DefaultTableModel();
        datos_2= new DefaultTableModel();
        datos_3= new DefaultTableModel();
        datos_4= new DefaultTableModel();
        initComponents();
        txtIdC.setEditable(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnNuevo.setEnabled(false);       
        //CITAS
        datos.addColumn("idCita");
        datos.addColumn("Fecha");
        datos.addColumn("Hora");
        datos.addColumn("idEmpleado");
        datos.addColumn("Empleado");
        datos.addColumn("idCliente");
        datos.addColumn("Cliente");
        datos.addColumn("idServicio");
        datos.addColumn("Servicio");
        //SERVICIOS
        datos_2.addColumn("idServicio");
        datos_2.addColumn("Nombre");
        datos_2.addColumn ("Descripción");
        datos_2.addColumn ("Precio");          
        //CLIENTES
        datos_3.addColumn("idCliente");
        datos_3.addColumn("Nombre");
        datos_3.addColumn("Apellido");        
        datos_3.addColumn("Telefono");
        datos_3.addColumn("Correo");   
        //EMPLEADOS
        datos_4.addColumn("idEmpleado");
        datos_4.addColumn("Nombre");
        datos_4.addColumn("Apellido");
        datos_4.addColumn("Dirección");
        datos_4.addColumn("Teléfono");
        datos_4.addColumn("estado");
        datos_4.addColumn("correo");
        datos_4.addColumn("Contraseña");
        datos_4.addColumn("Nivel");
        datos_4.addColumn("Privilegio");        
        //
        Class.forName("com.mysql.jdbc.Driver");
        cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/candy's_spa","root","");
        s = cnx.createStatement();
        this.setLayout(null);
        this.setVisible(true);
        int j=3;
        ResultSet rs = s.executeQuery("select * from citas INNER JOIN (select idEmpleado,nombre from empleados) empleados ON citas.idEmpleado=empleados.idEmpleado INNER JOIN (select idCliente,nombre from clientes) clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre from servicios) servicios ON citas.idServicio=servicios.idServicio");
        while (rs.next()){
            Object [] fila = new Object[12];
            for (int i=0;i<12;i++){
                if(i==1||i==2||i==3){}
                else if(i>=4){
                    fila[i-j]=rs.getObject(i+1); 
                }
                else{
                    fila[i] = rs.getObject(i+1);
                }
            }
            datos.addRow(fila); 
        }
        ResultSet rs_1 = s.executeQuery("select * from servicios");
        while (rs_1.next()){
            Object [] fila = new Object[4];
            for (int i=0;i<4;i++)
                fila[i] = rs_1.getObject(i+1);
            datos_2.addRow(fila); 
        }   
        ResultSet rs_2 = s.executeQuery("select * from clientes");
        while (rs_2.next()){
            Object [] fila = new Object[5];
            for (int i=0;i<5;i++)
                fila[i] = rs_2.getObject(i+1);
            datos_3.addRow(fila); 
        }
        ResultSet rs_4 = s.executeQuery("select * from empleados LEFT JOIN tipo_empleado ON empleados.idTipo_empleado=tipo_empleado.idTipo_empleado");
        while (rs_4.next()){
            Object [] fila = new Object[11];
            for (int i=0;i<11;i++){
                if(i==9){}
                else if(i==10){
                    fila[i-1] = rs_4.getObject(i+1); 
                }
                else{
                    fila[i] = rs_4.getObject(i+1); 
                }
            } 
            datos_4.addRow(fila); 

        }        
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        lblMasajistas = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        lblNombre = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        lblMasajista = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblEspecialidad = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox<>();
        lblMasajista1 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        cbxEmpleado = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(datos);
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblEdad1 = new javax.swing.JLabel();
        txtFechaC = new javax.swing.JTextField();
        txtHoraC = new javax.swing.JTextField();
        lblEspecialidad1 = new javax.swing.JLabel();
        btnConsult = new javax.swing.JButton();
        lblMasajista3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable(datos_3);
        jScrollPane3 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable(datos_2);
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable(datos_4);
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
        lblMasajistas.setText("CITAS");

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

        lblNombre.setText("idCliente:");

        txtIdC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCActionPerformed(evt);
            }
        });

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        lblMasajista.setText("idCita:");
        lblMasajista.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajistaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblEdad.setText("Fecha:");

        lblEspecialidad.setText("Hora:");

        cbxServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxServicioActionPerformed(evt);
            }
        });

        lblMasajista1.setText("idServicio:");
        lblMasajista1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajista1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lblNombre1.setText("idEmpleado:");

        cbxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClienteActionPerformed(evt);
            }
        });

        cbxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMasajista)
                            .addComponent(lblNombre))
                        .addGap(31, 31, 31)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblNombre1)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(lblMasajista1)
                        .addGap(18, 18, 18)
                        .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEdad)
                            .addComponent(lblEspecialidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMasajista1))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEdad))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEspecialidad)))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMasajista)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblNombre)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(cbxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblEdad1.setText("Fecha:");

        txtHoraC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraCActionPerformed(evt);
            }
        });

        lblEspecialidad1.setText("Hora:");

        btnConsult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/Buscar.png"))); // NOI18N
        btnConsult.setText("Consultar disponibilidad");
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEdad1)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEspecialidad1)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaC)
                            .addComponent(txtHoraC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEspecialidad1)
                            .addComponent(txtHoraC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblEdad1)))
                .addGap(18, 18, 18)
                .addComponent(btnConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblMasajista3.setText("idCita:");
        lblMasajista3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblMasajista3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jScrollPane2.setViewportView(tblClientes);

        jScrollPane3.setViewportView(tblServicios);

        jScrollPane4.setViewportView(tblEmpleados);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMasajista3)
                                .addGap(18, 18, 18)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnGuardar)
                            .addComponent(btnNuevo)
                            .addComponent(btnEliminar)
                            .addComponent(btnSalir))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMasajista3))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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
        
         try {
             this.setVisible(false);
             new Clientes(level,nombre).setVisible(true);
             //Clientes u= new Masajistas();
         } catch (SQLException ex) {
             Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
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
        int cad= Integer.parseInt(getTxtBuscar().getText());
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        try{
          PreparedStatement consulta = cnx.prepareStatement("select *from citas where idCita='"+cad+"'");
          //consulta.setInt(1, idCliente);
          ResultSet resultado = consulta.executeQuery();
          while(resultado.next()){
             txtIdC.setText(resultado.getString("idCita")); 
             cbxEmpleado.addItem(resultado.getString("idEmpleado"));
             cbxCliente.addItem(resultado.getString("idCliente"));
             cbxServicio.addItem(resultado.getString("idServicio"));           
             txtFecha.setText(resultado.getString("fecha"));
             txtHora.setText(resultado.getString("hora"));

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
        try {
             txtIdC.setText("");
             cbxEmpleado.removeAllItems();
             cbxCliente.removeAllItems();
             cbxServicio.removeAllItems();
             txtFecha.setText("");
             txtHora.setText("");
             txtBuscar.setEnabled(false);
             btnModificar.setEnabled(false);
             btnEliminar.setEnabled(false);
             btnNuevo.setEnabled(false);
             btnBuscar.setEnabled(false);
             btnGuardar.setEnabled(true);
             ResultSet rs_1 = s.executeQuery("select idServicio from servicios");
             while (rs_1.next()){
                cbxServicio.addItem(rs_1.getString("idServicio"));
             }
             ResultSet rs_2 = s.executeQuery("select idEmpleado from empleados");
             while (rs_2.next()){
                cbxEmpleado.addItem(rs_2.getString("idEmpleado"));
             }
             ResultSet rs_3 = s.executeQuery("select idCliente from clientes");
             while (rs_3.next()){
                cbxCliente.addItem(rs_3.getString("idCliente"));         
             }
        } catch (SQLException ex){}
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String idC= getTxtIdC().getText(); 
        String empleado= getTxtEmpleado().getSelectedItem().toString();
        String cliente=getTxtCliente().getSelectedItem().toString();
        String servicio=getTxtServicio().getSelectedItem().toString();
        String fecha= getTxtFecha().getText();
        String hora= getTxtHora().getText();
        String estado="NO PAGADO";
        String tmp;
        try{ 
            tmp="insert into citas (idEmpleado,idServicio,idCliente,fecha,hora) values ('"+empleado+"','"+servicio+"','"+cliente+"','"+fecha+"','"+hora+"')";
            int rs=s.executeUpdate(tmp,Statement.RETURN_GENERATED_KEYS);
            String s2=String.valueOf(rs); 
            if(rs!=0){
                String date=fecha+" "+hora;
                tmp="insert into notas_venta (idCita,fecha,estado) values ('"+rs+"','"+date+"','"+estado+"')";
                int rs_1=s.executeUpdate(tmp,Statement.RETURN_GENERATED_KEYS);
                if(rs_1!=0){
                    txtIdC.setText(""); 
                    txtFecha.setText("");
                    txtHora.setText("");
                    cbxEmpleado.removeAllItems();
                    cbxCliente.removeAllItems();
                    cbxServicio.removeAllItems();               
                    txtBuscar.setEnabled(true);
                    btnBuscar.setEnabled(true);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnNuevo.setEnabled(false);
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
                         int j=3;
                         ResultSet res = s.executeQuery("select * from citas INNER JOIN (select idEmpleado,nombre from empleados) empleados ON citas.idEmpleado=empleados.idEmpleado INNER JOIN (select idCliente,nombre from clientes) clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre from servicios) servicios ON citas.idServicio=servicios.idServicio");
                         while (res.next()){
                             Object [] fila = new Object[12];
                             for (int i=0;i<12;i++){
                                 if(i==1||i==2||i==3){}
                                 else if(i>=4){
                                     fila[i-j]=res.getObject(i+1); 
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
                Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    int idM= Integer.parseInt(getTxtIdC().getText());
     String tmp;
     tmp="delete from citas where idCita="+idM;
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
                    int j=3;
                    ResultSet res = s.executeQuery("select * from citas INNER JOIN (select idEmpleado,nombre from empleados) empleados ON citas.idEmpleado=empleados.idEmpleado INNER JOIN (select idCliente,nombre from clientes) clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre from servicios) servicios ON citas.idServicio=servicios.idServicio");
                    while (res.next()){
                        Object [] fila = new Object[12];
                        for (int i=0;i<12;i++){
                            if(i==1||i==2||i==3){}
                            else if(i>=4){
                                fila[i-j]=res.getObject(i+1); 
                            }
                            else{
                                fila[i] = res.getObject(i+1);
                            }
                        }
                        datos.addRow(fila); 
                    }
                    txtIdC.setText(""); 
                    cbxEmpleado.removeAllItems();
                    cbxCliente.removeAllItems();
                    cbxServicio.removeAllItems();               
                    txtFecha.setText("");
                    txtHora.setText("");
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
        String empleado= getTxtEmpleado().getName();
        String cliente=getTxtCliente().getName();
        String servicio=getTxtServicio().getName();
        String fecha= getTxtFecha().getText();
        String hora= getTxtHora().getText();

        String tmp;
        try{ 
            tmp="update empleados set idServicio='"+servicio+"',fecha='"+fecha+"',hora='"+hora+"' where idCita="+idC;
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
                    int j=3;
                    ResultSet res = s.executeQuery("select * from citas INNER JOIN (select idEmpleado,nombre from empleados) empleados ON citas.idEmpleado=empleados.idEmpleado INNER JOIN (select idCliente,nombre from clientes) clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre from servicios) servicios ON citas.idServicio=servicios.idServicio");
                    while (res.next()){
                        Object [] fila = new Object[12];
                        for (int i=0;i<12;i++){
                            if(i==1||i==2||i==3){}
                            else if(i>=4){
                                fila[i-j]=res.getObject(i+1); 
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
                    if(select==JOptionPane.OK_OPTION){ }  
                }
             }
        }catch (SQLException ex) {  
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
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

    private void lblMasajista1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblMasajista1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMasajista1AncestorAdded

    private void cbxServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxServicioActionPerformed

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

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void txtHoraCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraCActionPerformed

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
        String fecha=getTxtFechaC().getText();
        String hora=getTxtHoraC().getText();
        try{
          PreparedStatement consulta = cnx.prepareStatement("select *from citas where fecha='"+fecha+"'and hora='"+hora+"'");
          ResultSet resultado = consulta.executeQuery();
          while(resultado.next()){
            Component btn_Option = null;
            int select = JOptionPane.showOptionDialog(btn_Option,"Horario no Disponible", "mensaje", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(select==JOptionPane.OK_OPTION){} 
          }
          if(resultado.first()==false){
            Component btn_Option = null;
            btnNuevo.setEnabled(true);        
            int select = JOptionPane.showOptionDialog(btn_Option,"Horario disponible", "Mensaje", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(select==JOptionPane.OK_OPTION){} 
          }          
        }
        catch (SQLException ex) {
            Component btn_Option = null;
            int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al consultar disponibilidad,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(select==JOptionPane.OK_OPTION){} 
        } 
        
    }//GEN-LAST:event_btnConsultActionPerformed

    private void lblMasajista3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblMasajista3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMasajista3AncestorAdded

    private void cbxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClienteActionPerformed

    private void cbxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEmpleadoActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxEmpleado;
    private javax.swing.JComboBox<String> cbxServicio;
    private javax.swing.JMenuItem itemClientes;
    private javax.swing.JMenuItem itemMasajistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEdad1;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblEspecialidad1;
    private javax.swing.JLabel lblMasajista;
    private javax.swing.JLabel lblMasajista1;
    private javax.swing.JLabel lblMasajista3;
    private javax.swing.JLabel lblMasajistas;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JMenuBar mBar1;
    private javax.swing.JMenu mnuCitas;
    private javax.swing.JMenu mnuPersonal;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuVentas;
    private java.awt.Panel panel1;
    private java.awt.Panel pnl1;
    private javax.swing.JTable tabla;
    private javax.swing.JMenu tbServicios;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTable tblServicios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaC;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtHoraC;
    private javax.swing.JTextField txtIdC;
    // End of variables declaration//GEN-END:variables

   public JTextField getTxtBuscar(){
        return txtBuscar;
   }
   public JTextField getTxtIdC(){
        return txtIdC;
   }
   public JComboBox getTxtCliente(){
        return cbxCliente;
   }
   public JComboBox getTxtEmpleado(){
        return cbxEmpleado;
   }
    public JComboBox getTxtServicio(){
        return cbxServicio;
   }
   public JTextField getTxtFecha(){
        return txtFecha;
   }
   public JTextField getTxtHora(){
        return txtHora;
   }
   public JTextField getTxtFechaC(){
        return txtFechaC;
   }
   public JTextField getTxtHoraC(){
        return txtHoraC;
   }   
}
