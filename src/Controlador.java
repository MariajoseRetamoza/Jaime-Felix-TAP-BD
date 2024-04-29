import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controlador {
    Modelo miModelo;
    Vista miVista;

    public Controlador(Modelo miModelo, Vista miVista) {
        this.miModelo = miModelo;
        this.miVista = miVista;
    }

    public void iniciarVista() {
        // Oyente de elementos del menú
        MiOyente miOyente = new MiOyente();
        // Registrar oyente de eventos
        miVista.miVentana.mnuArcActualizar.addActionListener(miOyente);
        miVista.miVentana.mnuAyuAcercaDe.addActionListener(miOyente);
        miVista.miVentana.mnuArcSalir.addActionListener(miOyente);

        miVista.miVentana.setVisible(true);
    }

    // Clase interna para oyente de eventos
    class MiOyente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Preguntar cual de las tres opciones generó el evento
            String cual = e.getActionCommand();

            if (cual.equals("Actualizar...")) {
                // Mostrar el cuadro de diálogo
                miVista.miDialogo = new MiDialogo(miVista.miVentana, "Catálogo de Empleados");

                // Oyente de botones de acción
                OyenteBotonesAccion oba = new OyenteBotonesAccion();
                miVista.miDialogo.miPanel.btnSalir.addActionListener(oba);

                // Hacer diálogo modal y mostrar
                miVista.miDialogo.setModalityType(ModalityType.APPLICATION_MODAL);
                miVista.miDialogo.setVisible(true);

            } else if (cual.equals("Salir")) {
                // Preguntar si desea salir...
                int opcion = JOptionPane.showConfirmDialog(miVista.miVentana,
                        "¿Deseas salir?",
                        "Aplicación de Catálogo - MVC",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (opcion == JOptionPane.YES_OPTION)
                    miVista.miVentana.dispose();

            } else if (cual.equals("Acerca de..."))
                JOptionPane.showMessageDialog(miVista.miVentana,
                        "Catálogo - MVC\nAutor: Jaime A. Félix M.",
                        "Acerca de...",
                        JOptionPane.INFORMATION_MESSAGE);
        }

    }

    // Clase interna para oyentes de los botones de acción
    class OyenteBotonesAccion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Preguntar cual botón generó el evento
            String cual = e.getActionCommand();

            if (cual.equals("Nuevo")) {
            } else if (cual.equals("Modificar")) {
            } else if (cual.equals("Guardar")) {
            } else if (cual.equals("Cancelar")) {
            } else if (cual.equals("Salir")) {
                // Eliminar el cuadro de diálogo
                miVista.miDialogo.dispose();
            }

        }

    }
}
