/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import moduloPasajero.Pasaporte;

/**
 *
 * @author dell
 */
public class ManejadorDeTablaHistorial {
     public static void llenarTabla(ArrayList<Pasaporte> lispasaporte, JTable table) {
        DefaultTableModel modelo = new DefaultTableModel();
        table.setModel(modelo);
        //Anadir columnas
        modelo.addColumn("No. Pasaporte");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Nacionalidad");
        modelo.addColumn("Estado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Sexo");
        modelo.addColumn("Fecha de Vencimiento");
        modelo.addColumn("Fecha de Emision");
        modelo.addColumn("Pais Actual ");
        modelo.addColumn("Millas recoridas");
        for (Pasaporte pasaporte : lispasaporte) {
            modelo.addRow(new Object[]{pasaporte.getNoPasaporte(),pasaporte.getContrasella(),pasaporte.getNacionalidad(),pasaporte.getEstadoCivil(),
            pasaporte.getNombre(),pasaporte.getApellido(),pasaporte.getSexo(),pasaporte.getFechaVencimiento(),
            pasaporte.getFechaEmision(),pasaporte.getPaisActual(),pasaporte.getMillasrecoridas()});
        }
        
       
    }
    
}
