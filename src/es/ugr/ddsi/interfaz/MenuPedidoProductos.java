package es.ugr.ddsi.interfaz;

import es.ugr.ddsi.model.Producto;
import es.ugr.ddsi.MainFestival;
import es.ugr.ddsi.model.Ubicacion;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuPedidoProductos extends javax.swing.JFrame {

    private final MainFestival festival;
    private ArrayList<Producto> productos;
    
    /**
     * Creates new form MenuPedidoProductos
     * @param festival
     */
    public MenuPedidoProductos(MainFestival festival) {
        this.festival = festival;
        
        try {
            PreparedStatement stm = festival.getConnection().prepareStatement("SELECT * FROM PRODUCTO");
            ResultSet rs = stm.executeQuery();
            
            productos = new ArrayList<>();
            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getInt("coste")
                ));
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxProductos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        fieldCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldFecha = new javax.swing.JTextField();
        botonPedidoProducto = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Crea un pedido de productos");

        jLabel2.setText("Nombre del pedido");

        labelNombre.setText("nombre");

        jLabel3.setText("Producto");

        comboBoxProductos.setModel(
            new javax.swing.DefaultComboBoxModel<>(
                productos.stream()
                .map(Producto::getNombre)
                .toArray(String[]::new)
            )
        );

        jLabel4.setText("Cantidad");

        fieldCantidad.setText("5");
        fieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCantidadActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha");

        fieldFecha.setText("21/11/2019");
        fieldFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFechaActionPerformed(evt);
            }
        });

        botonPedidoProducto.setBackground(new java.awt.Color(0, 204, 204));
        botonPedidoProducto.setText("Realizar pedido");
        botonPedidoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidoProductoActionPerformed(evt);
            }
        });

        botonVolver.setBackground(new java.awt.Color(255, 51, 51));
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonPedidoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(labelNombre)
                    .addComponent(comboBoxProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fieldCantidad)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldFecha)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonVolver)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(fieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonPedidoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCantidadActionPerformed

    private void fieldFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldFechaActionPerformed

    private void botonPedidoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidoProductoActionPerformed
        String cantidadStr = fieldCantidad.getText();
        cantidadStr = cantidadStr.replace(".", "");
        cantidadStr = cantidadStr.replace(",", "");
        int cantidad = -1;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce un número válido como cantidad", "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.err.println(ex);
        }
        if (cantidad < 1) {
            JOptionPane.showMessageDialog(this, "No puedes pedir menos de un producto", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int chosenIndex = comboBoxProductos.getSelectedIndex();
        if (chosenIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un producto", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Producto producto = productos.get(chosenIndex);
        if (producto == null) {
            JOptionPane.showMessageDialog(this, "No se ha podido determinar la ubicación seleccionada", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String strFecha = fieldFecha.getText();
        LocalDate date;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
            date = LocalDate.parse(strFecha, formatter);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce una fecha válida en formato 21/11/2019", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
         
            CallableStatement stm = festival.getConnection().prepareCall("{call CrearPedidoProductos(?, ?, ?, ?)}");
            stm.setString(1, labelNombre.getText());
            stm.setInt(2, producto.getId());
            stm.setInt(3, cantidad);
            stm.setTimestamp(4, Timestamp.valueOf(date.atStartOfDay()));
            
            stm.execute();

            festival.getConnection().commit();
            
            JOptionPane.showMessageDialog(this, "Se ha realizado el pedido", "Pedido realizado", JOptionPane.INFORMATION_MESSAGE);
            java.awt.EventQueue.invokeLater(() -> {
                this.setVisible(false);
            }); 
        } catch (SQLException ex) {
            System.err.println(ex);
            JOptionPane.showMessageDialog(this, ex.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonPedidoProductoActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            this.setVisible(false);
        });
    }//GEN-LAST:event_botonVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonPedidoProducto;
    private javax.swing.JButton botonVolver;
    private javax.swing.JComboBox<String> comboBoxProductos;
    private javax.swing.JTextField fieldCantidad;
    private javax.swing.JTextField fieldFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField labelNombre;
    // End of variables declaration//GEN-END:variables
}
