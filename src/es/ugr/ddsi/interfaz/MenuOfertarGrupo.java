package es.ugr.ddsi.interfaz;

import es.ugr.ddsi.MainFestival;
import es.ugr.ddsi.model.Ubicacion;
import es.ugr.ddsi.model.Grupo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dani
 */
public class MenuOfertarGrupo extends javax.swing.JFrame {

    private final MainFestival festival;
    private final Grupo grupo;
    private ArrayList<Ubicacion> ubicaciones;
    
    /**
     * Creates new form OfertarGrupo
     * @param festival
     * @param grupo
     */
    public MenuOfertarGrupo(MainFestival festival, Grupo grupo) {
        this.festival = festival;
        this.grupo = grupo;
        
                
        try {
            PreparedStatement stm = festival.getConnection().prepareStatement("SELECT * FROM UBICACION");
            ResultSet rs = stm.executeQuery();
            
            ubicaciones = new ArrayList<>();
            while (rs.next()) {
                ubicaciones.add(new Ubicacion(
                        rs.getInt("id_ubicacion"),
                        rs.getString("nombre_ubicacion"),
                        rs.getString("nombre_oficial_ubicacion"),
                        rs.getString("url_ubicacion")
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

        fieldPrecioOferta = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxLocalizaciones = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        botonEnviarOferta = new javax.swing.JButton();
        jLabelTitle = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fieldPrecioOferta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel1.setText("Precio a ofertar");

        jComboBoxLocalizaciones.setModel(
            new javax.swing.DefaultComboBoxModel<>(
                ubicaciones.stream()
                .map(Ubicacion::getNombre)
                .toArray(String[]::new)
            ));

            jLabel2.setText("Ubicación a ofertar");

            botonEnviarOferta.setText("Enviar oferta");
            botonEnviarOferta.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botonEnviarOfertaActionPerformed(evt);
                }
            });

            jLabelTitle.setText("Creando oferta para " + grupo.getNombre());

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonEnviarOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitle)
                                        .addComponent(jLabel1)
                                        .addComponent(fieldPrecioOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBoxLocalizaciones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVolver)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabelTitle)
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldPrecioOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxLocalizaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(botonEnviarOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botonVolver)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            fieldPrecioOferta.setText(grupo.getCache().toString());

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarOfertaActionPerformed
        String precioOfrecidoStr = fieldPrecioOferta.getText();
        precioOfrecidoStr = precioOfrecidoStr.replace(".", "");
        precioOfrecidoStr = precioOfrecidoStr.replace(",", "");
        int precioOfrecido = -1;
        try {
            precioOfrecido = Integer.parseInt(precioOfrecidoStr);
        } catch (NumberFormatException ex) {
            System.err.println(ex);
        }
        if (precioOfrecido < 0) {
            JOptionPane.showMessageDialog(this, "No puedes proponer un precio menor a 0", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        int chosenIndex = jComboBoxLocalizaciones.getSelectedIndex();
        if (chosenIndex == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una ubicación", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Ubicacion ubicacion = ubicaciones.get(chosenIndex);
        if (ubicacion == null) {
            JOptionPane.showMessageDialog(this, "No se ha podido determinar la ubicación seleccionada", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            System.out.println("Voy a crear oferta");
            PreparedStatement stm = festival.getConnection().prepareStatement(""
                    + "INSERT INTO ofertas VALUES (?, ?, ?, ?, ?, ?)");
            stm.setInt(1, 3); //FIXME: ID DE OFERTA AUTOMÁTICA?
            stm.setString(2, grupo.getId());
            stm.setInt(3, precioOfrecido);
            stm.setInt(4, festival.getEdicionActual().getId_edicion());
            stm.setInt(5, ubicacion.getId());
            stm.setString(6, "SI");
            
            stm.executeUpdate();
            festival.getConnection().commit();
            System.out.println("creada");
            
            JOptionPane.showMessageDialog(this, "Se ha guardado la oferta", "Oferta guardada", JOptionPane.INFORMATION_MESSAGE);
            java.awt.EventQueue.invokeLater(() -> {
                this.setVisible(false);
            });
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_botonEnviarOfertaActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            this.setVisible(false);
        });
    }//GEN-LAST:event_botonVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviarOferta;
    private javax.swing.JButton botonVolver;
    private javax.swing.JFormattedTextField fieldPrecioOferta;
    private javax.swing.JComboBox<String> jComboBoxLocalizaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitle;
    // End of variables declaration//GEN-END:variables
}