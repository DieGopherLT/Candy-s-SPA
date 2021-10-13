package candy.s.spa;

import java.awt.Color;
import java.awt.Component;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ghost_Red
 */
public class Ventas extends javax.swing.JFrame {
    private static com.mysql.jdbc.Connection cnx = null;
    private DefaultTableModel datos,datos_2;
    private JScrollPane sc;
    private Statement s;
    private int level;
    private String nombre;
    private float total=0;
    private DefaultListModel listNombre;
    private DefaultListModel listPrecio;
    private ArrayList lstId = new ArrayList();
    public Ventas(int level,String nombre)throws SQLException, ClassNotFoundException {
        this.level=level;
        this.nombre=nombre;
        Toolkit tk=Toolkit.getDefaultToolkit();
        setLocation(new Point((tk.getScreenSize().width-getSize().width)/7,(tk.getScreenSize().height-getSize().height)/5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(Color.decode("#96EBF2")); 
        datos = new DefaultTableModel();
        datos_2 = new DefaultTableModel();
        listNombre = new DefaultListModel();
        listPrecio = new DefaultListModel();
        initComponents();
        txtIdC.setEditable(false);
        txtCita.setEditable(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        datos.addColumn("id Nota de Venta");
        datos.addColumn("idCita");
        datos.addColumn ("Fecha");
        datos.addColumn ("Estado");        
        datos.addColumn ("idCliente");
        datos.addColumn ("Nombre");
        datos.addColumn ("Apellido");
        datos.addColumn ("idServicio");
        datos.addColumn ("Nombre");        
        datos.addColumn ("Precio"); 
        //
        datos_2.addColumn("idProducto");
        datos_2.addColumn("Nombre");
        datos_2.addColumn ("Marca");
        datos_2.addColumn ("Costo");        
        datos_2.addColumn ("Precio");
        datos_2.addColumn ("Descripción");
        datos_2.addColumn ("Tipo");        
        datos_2.addColumn ("Categoria");
        datos_2.addColumn ("idInsumo");
        datos_2.addColumn ("Cantidad"); 
        //
        Class.forName("com.mysql.jdbc.Driver");
        //cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/ladywaifu","root","1234ab");
        cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/candy's_spa","root","");
        s = cnx.createStatement();
        this.setLayout(null);
        this.setVisible(true);        
        int j=3;
        ResultSet rs = s.executeQuery("select * from notas_venta INNER JOIN (select idCita,idCliente,idServicio from citas) citas ON notas_venta.idCita=citas.idCita INNER JOIN (select idCliente,nombre,apellido from clientes)clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre,precio from servicios) servicios ON citas.idServicio=servicios.idServicio");
        while (rs.next()){
            Object [] fila = new Object[13];
            for (int i=0;i<13;i++){
                if(i==5||i==6||i==7){}
                else if(i>7){
                    fila[i-j]=rs.getObject(i+1); 
                }
                else{
                    fila[i] = rs.getObject(i+1);
                }
            }
            datos.addRow(fila); 
        }
        ResultSet rs_1 = s.executeQuery("select * from productos LEFT JOIN tipo_producto ON productos.idTipo_producto=tipo_producto.idTipo_producto INNER JOIN insumos ON productos.idProducto=insumos.idProducto");
        while (rs_1.next()){
            Object [] fila = new Object[12];
            for (int i=0;i<12;i++){
                if(i==7||i==9){}
                else if(i==8){
                    fila[i-1] = rs_1.getObject(i+1); 
                }
                else if(i>9){
                    fila[i-2] = rs_1.getObject(i+1);
                }
                else{
                    fila[i] = rs_1.getObject(i+1); 
                }
            } 
            datos_2.addRow(fila); 
        }        
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        lblCLientes3 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        txtIdC = new javax.swing.JTextField();
        txtCita = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblNombre4 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNombre6 = new javax.swing.JLabel();
        lblNombre5 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(datos);
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNombre9 = new javax.swing.JLabel();
        lblNombre11 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblNombre10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstNombre = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstPrecio = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable(datos_2);
        btnAgregar = new javax.swing.JButton();
        txtAgregar = new javax.swing.JTextField();
        lblNombre7 = new javax.swing.JLabel();
        btnPagar = new javax.swing.JButton();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/Ventas.png"))); // NOI18N

        lblCLientes3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCLientes3.setText("NOTAS DE VENTA");

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCLientes3)
                .addGap(307, 307, 307)
                .addComponent(jLabel1)
                .addGap(44, 44, 44))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCLientes3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        txtIdC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCActionPerformed(evt);
            }
        });

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        lblNombre4.setText("id Nota de venta:");

        lblCliente.setText("idCita:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/Buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre6.setText("Fecha:");

        lblNombre5.setText("id Nota de venta:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblNombre4)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblNombre5)
                        .addGap(18, 18, 18))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(lblNombre6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCita, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtBuscar)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre5))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre4))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCliente))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre6))))
                .addContainerGap(85, Short.MAX_VALUE))
        );

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombre9.setText("Total de Compra:");

        lblNombre11.setText("MXN   IVA incluido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre9)
                .addGap(31, 31, 31)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombre11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblNombre9))
                    .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombre10.setText("LISTA DE COMPRAS:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombre10)
                .addGap(90, 90, 90))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre10)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(lstNombre);

        jScrollPane4.setViewportView(lstPrecio);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Precio:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane3.setViewportView(tblProductos);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/guardar.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgregarActionPerformed(evt);
            }
        });

        lblNombre7.setText("idProducto:");

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/candy/s/spa/img/Ventas.png"))); // NOI18N
        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAgregar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModificar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnSalir)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lblNombre7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
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
             Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }*/
    }//GEN-LAST:event_mnuProductosActionPerformed

    private void mnuVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuVentasMouseClicked
         /*try {
             new Ventas().setVisible(true);
         } catch (SQLException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
         }*/
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
        String estado="";
        String idCita="";
        try{
          PreparedStatement consulta = cnx.prepareStatement("select * from notas_venta where idNota_venta='"+cad+"'");    
          String idC="";
          ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                idC=resultado.getString("idNota_venta");
                btnEliminar.setEnabled(true);
                btnModificar.setEnabled(true);
                txtIdC.setText(resultado.getString("idNota_venta")); 
                txtCita.setText(resultado.getString("idCita"));
                txtFecha.setText(resultado.getString("fecha"));
                idCita=getTxtCita().getText();
                estado=resultado.getString("estado");
            }
            if(idC!=""){
                if(estado.equals("NO PAGADO")){
                    PreparedStatement consult = cnx.prepareStatement("select * from citas INNER JOIN (select idServicio,nombre,precio from servicios) servicios ON citas.idServicio=servicios.idServicio where idCita='"+idCita+"'");
                    ResultSet result = consult.executeQuery();
                    if(result!=null){
                        while(result.next()){
                           lstNombre.setModel(listNombre);
                           listNombre.addElement(result.getString("nombre"));
                           lstPrecio.setModel(listPrecio);
                           listPrecio.addElement(result.getString("precio"));
                           total=total+Float.parseFloat(result.getString("precio"));
                           lblTotal.setText(String.valueOf(total));
                        }
                    }
                }
                else{
                    Component btn_Option = null;
                    int select = JOptionPane.showOptionDialog(btn_Option,"Está nota ya está pagada", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                    if(select==JOptionPane.OK_OPTION){}
                    txtIdC.setText(""); 
                    txtCita.setText("");
                    txtFecha.setText(""); 
                    txtBuscar.setEnabled(true);
                    btnBuscar.setEnabled(true);
                    txtCita.setEditable(false);
                    btnModificar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnSalir.setEnabled(true);                    
                }
            }
            else{
                Component btn_Option = null;
                int select = JOptionPane.showOptionDialog(btn_Option,"Error nota de venta inexistente", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                if(select==JOptionPane.OK_OPTION){}
                txtIdC.setText(""); 
                txtCita.setText("");
                txtFecha.setText(""); 
                txtBuscar.setEnabled(true);
                btnBuscar.setEnabled(true);
                txtCita.setEditable(false);
                btnModificar.setEnabled(false);
                btnEliminar.setEnabled(false);
                btnSalir.setEnabled(true);
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    String idC= getTxtIdC().getText();
     String tmp;
    
     tmp="delete from notas_venta where idNota_venta="+idC;
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
                    ResultSet res = s.executeQuery("select * from notas_venta INNER JOIN (select idCita,idCliente,idServicio from citas) citas ON notas_venta.idCita=citas.idCita INNER JOIN (select idCliente,nombre,apellido from clientes)clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre,precio from servicios) servicios ON citas.idServicio=servicios.idServicio");
                    while (res.next()){
                        Object [] fila = new Object[13];
                        for (int i=0;i<13;i++){
                            if(i==5||i==6||i==7){}
                            else if(i>7){
                                fila[i-j]=res.getObject(i+1); 
                            }
                            else{
                                fila[i] = res.getObject(i+1);
                            }
                        }
                        datos.addRow(fila); 
                    }
                    txtIdC.setText(""); 
                    txtCita.setText("");
                    txtFecha.setText("");
                    txtBuscar.setText("");
                    txtCita.setEditable(false);
                    lblCliente.setText("idCliente: ");
               }
               else{                
                   int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al eliminar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                   if(select==JOptionPane.OK_OPTION){
                   //System.exit(0);
                   }  
               }
            }
         } catch (SQLException ex) {
            Component btn_Option = null;
            int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al eliminar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            if(select==JOptionPane.OK_OPTION){
                   //System.exit(0);
            }  
         }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String idC= getTxtIdC().getText();
        String Nombre= getTxtCita().getText();//idCliente
        String fecha= getTxtTelefono().getText();//fecha
        String tmp;
        try{ 
            tmp="update notas_venta set fecha='"+fecha+"' where idNota_venta="+idC;
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
                    ResultSet res = s.executeQuery("select * from notas_venta INNER JOIN (select idCita,idCliente,idServicio from citas) citas ON notas_venta.idCita=citas.idCita INNER JOIN (select idCliente,nombre,apellido from clientes)clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre,precio from servicios) servicios ON citas.idServicio=servicios.idServicio");
                    while (res.next()){
                        Object [] fila = new Object[13];
                        for (int i=0;i<13;i++){
                            if(i==5||i==6||i==7){}
                            else if(i>7){
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
                    if(select==JOptionPane.OK_OPTION){}  
                }
             }
        }catch (SQLException ex) {  
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tbServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServiciosMouseClicked
        try {
            new Ventas(level,nombre).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
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

    private void txtIdCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCActionPerformed

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

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String idProducto= getTxtProducto().getText();//idCliente
        try{
          PreparedStatement consulta = cnx.prepareStatement("select idProducto,nombre,precio from productos where idProducto='"+idProducto+"'");
          ResultSet resultado = consulta.executeQuery();
          while(resultado.next()){
            listNombre.addElement(resultado.getString("nombre"));
            listPrecio.addElement(resultado.getString("precio"));
            lstId.add(resultado.getString("idProducto"));
            total=total+Float.parseFloat(resultado.getString("precio"));
            lblTotal.setText(String.valueOf(total));
          }
          if(resultado.first()==false){        
            ErrorMessage();
          }           
        }
        catch (SQLException ex) {
            ErrorMessage();
        }        

    }//GEN-LAST:event_btnAgregarActionPerformed
    private void ErrorMessage(){
        Component btn_Option = null;
        int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al agregar producto,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
        if(select==JOptionPane.OK_OPTION){}     
    }
    private void txtAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregarActionPerformed
    private void finalProcess(){
        try{
            Component btn_Option = null;
            int sele = JOptionPane.showOptionDialog(btn_Option,"¡Exito al Pagar!", "Exito", JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
            int a = datos.getRowCount()-1;
            for (int i = a; i >= 0; i--) {          
                datos.removeRow(datos.getRowCount()-1);
            }
            if(sele==JOptionPane.OK_OPTION){
                datos.fireTableStructureChanged();
                s = cnx.createStatement();
                int j=3; 
                ResultSet res = s.executeQuery("select * from notas_venta INNER JOIN (select idCita,idCliente,idServicio from citas) citas ON notas_venta.idCita=citas.idCita INNER JOIN (select idCliente,nombre,apellido from clientes)clientes ON citas.idCliente=clientes.idCliente INNER JOIN (select idServicio,nombre,precio from servicios) servicios ON citas.idServicio=servicios.idServicio");
                while (res.next()){
                    Object [] fila = new Object[13];
                    for (int i=0;i<13;i++){
                        if(i==5||i==6||i==7){}
                        else if(i>7){
                            fila[i-j]=res.getObject(i+1); 
                        }
                        else{
                            fila[i] = res.getObject(i+1);
                        }
                    }
                    datos.addRow(fila); 
                }
                datos_2.fireTableStructureChanged();
            }
            else{                
                int select = JOptionPane.showOptionDialog(btn_Option,"Fallo al actualizar,porfavor intentelo más tarde", "Error", JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[] {"De acuerdo"}, "De acuerdo");
                if(select==JOptionPane.OK_OPTION){}  
            }
        }catch (SQLException ex) {}
    }
    private Boolean updateInsumos(){
        String idC= getTxtIdC().getText();
        String tmp;
        Boolean res=false;
        String nombre="";
        int cantidad=0;
        try{
            for(int i = 1; i< lstNombre.getModel().getSize();i++){
                int idProducto=Integer.parseInt(lstId.get(i-1).toString());
                PreparedStatement consulta = cnx.prepareStatement("select cantidad from insumos where idProducto='"+idProducto+"'");
                ResultSet resultado = consulta.executeQuery();
                while(resultado.next()){
                    cantidad=Integer.parseInt(resultado.getString("cantidad"))-1;
                    if(cantidad>=0){
                        tmp="update insumos set cantidad='"+cantidad+"' where idProducto="+idProducto;
                        int rs_1=s.executeUpdate(tmp);
                        if(rs_1!=0){ 
                            res=true;
                        }   
                    }
                }                              
            }
            return res;
        }catch (SQLException ex) {
            return res;
        } 
    }
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        String idC= getTxtIdC().getText();
        String estado="PAGADO";
        String tmp;        
        try{ 
            tmp="update notas_venta set estado='"+estado+"' where idNota_venta="+idC;
            int rs=s.executeUpdate(tmp);
            String s2=String.valueOf(rs);  
            if(rs!=0){
                if(updateInsumos()==true){
                    finalProcess();
                }
            }
        }catch (SQLException ex) {}
    }//GEN-LAST:event_btnPagarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JMenuItem itemClientes;
    private javax.swing.JMenuItem itemMasajistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCLientes3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblNombre10;
    private javax.swing.JLabel lblNombre11;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre5;
    private javax.swing.JLabel lblNombre6;
    private javax.swing.JLabel lblNombre7;
    private javax.swing.JLabel lblNombre9;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<String> lstNombre;
    private javax.swing.JList<String> lstPrecio;
    private javax.swing.JMenuBar mBar1;
    private javax.swing.JMenu mnuCitas;
    private javax.swing.JMenu mnuPersonal;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuVentas;
    private java.awt.Panel panel1;
    private java.awt.Panel pnl1;
    private javax.swing.JTable tabla;
    private javax.swing.JMenu tbServicios;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtAgregar;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCita;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdC;
    // End of variables declaration//GEN-END:variables

   public JTextField getTxtBuscar(){
        return txtBuscar;
   }
   public JTextField getTxtIdC(){
        return txtIdC;
        //idNote_Ventas
   }
   public JTextField getTxtCita(){
        return txtCita;
        //idCliente
   }
   public JTextField getTxtTelefono(){
        return txtFecha;
   }
   public JTextField getTxtProducto(){
        return txtAgregar;
   }   
   public JLabel getTotal(){
       return lblTotal;
   }
}
