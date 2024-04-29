import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Vista {
    // Declarar la variable de Ventana
    MiVentana miVentana;
    // Declara la variable del Cuadro de Diálogo
    MiDialogo miDialogo;

    // Constructor
    public Vista() {
        // Crear un objeto Ventana
        miVentana = new MiVentana("Aplicación de Catálogo - MVC");
        miVentana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // miVentana.setVisible(true);
    }
}

class MiVentana extends JFrame {
    // Atributos del menú
    JMenuItem mnuArcActualizar;
    JMenuItem mnuArcSalir;
    JMenuItem mnuAyuAcercaDe;

    public MiVentana(String titulo) {
        super(titulo);

        // Establecer menu
        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        // Crear menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic('A');

        // Crear opciones del menú
        mnuArcActualizar = new JMenuItem("Actualizar...");
        mnuArcActualizar.setMnemonic('c');
        mnuArcSalir = new JMenuItem("Salir");
        mnuArcSalir.setMnemonic('S');

        // Agregar opciones al menú de archivo
        menuArchivo.add(mnuArcActualizar);
        menuArchivo.addSeparator();
        menuArchivo.add(mnuArcSalir);

        // Agregar el menú Archivo a la barra de menu
        barraMenu.add(menuArchivo);

        // Crear menú Archivo
        JMenu menuAyuda = new JMenu("Ayuda");
        menuAyuda.setMnemonic('u');

        // Crear opciones del menú
        mnuAyuAcercaDe = new JMenuItem("Acerca de...");
        mnuAyuAcercaDe.setMnemonic('A');

        // Agregar opciones al menú de ayuda
        menuAyuda.add(mnuAyuAcercaDe);

        // Agregar el menú Archivo a la barra de menu
        barraMenu.add(menuAyuda);

        setSize(600, 400);
    }
}

// Clase MiDialogo para catálogo de trabajadores
class MiDialogo extends JDialog {
    MiPanel miPanel;

    // Constructor
    public MiDialogo(JFrame padre, String titulo) {
        super(padre, titulo);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Agregar panel al cuadro de diálogo
        miPanel = new MiPanel();
        add(miPanel);

        setSize(500, 350);
        setResizable(false);
        // setVisible(true);
    }

    // Clase interna personalizada MiPanel
    class MiPanel extends JPanel {
        // Declarar componentes del panel de navegación
        JButton btnPrimero;
        JButton btnAnterior;
        JTextField txtClave;
        JTextField txtTotalRegistros;
        JButton btnSiguiente;
        JButton btnUltimo;

        // Declarar componentes del panel de datos generales
        JTextField txtNombre;
        JRadioButton rbtMasculino;
        JRadioButton rbtFemenino;
        JSpinner spnEdad;
        JComboBox<String> cmbDepartamento;
        JComboBox<String> cmbTurnoLaboral;
        JCheckBox chkLectura;
        JCheckBox chkDeportes;
        JCheckBox chkCines;
        JCheckBox chkTeatros;
        JCheckBox chkJuegosDeSalon;
        JCheckBox chkConciertos;
        JCheckBox chkOtros;
        JTextField txtEspecificar;
        JCheckBox chkActivo;

        // Declarar componentes del panel de botones de acción
        JButton btnNuevo;
        JButton btnModificar;
        JButton btnGuardar;
        JButton btnCancelar;
        JButton btnSalir;

        // Constructor para crear los componentes del cuadro de diálogo
        public MiPanel() {
            // Establecer administrador de esquema de tipo borde
            setLayout(new BorderLayout());

            // Panel de Navegación
            btnPrimero = new JButton("Primero");
            btnPrimero.setMnemonic('P');
            btnAnterior = new JButton("Anterior");
            btnAnterior.setMnemonic('A');
            JLabel etClave = new JLabel("Clave:");
            txtClave = new JTextField(3);
            JLabel etDe = new JLabel( "de" );
            txtTotalRegistros = new JTextField(3);
            btnSiguiente = new JButton("Siguiente");
            btnSiguiente.setMnemonic('i');
            btnUltimo = new JButton("Ultimo");
            btnUltimo.setMnemonic('U');

            JPanel panelNavegacion = new JPanel();
            panelNavegacion.add(btnPrimero);
            panelNavegacion.add(btnAnterior);
            panelNavegacion.add(etClave);
            panelNavegacion.add(txtClave);
            panelNavegacion.add(etDe);
            panelNavegacion.add(txtTotalRegistros);
            panelNavegacion.add(btnSiguiente);
            panelNavegacion.add(btnUltimo);

            // Panel de Datos Generales
            JLabel etNombre = new JLabel("Nombre:");
            txtNombre = new JTextField(30);
            JLabel etGenero = new JLabel("Genero:");
            rbtMasculino = new JRadioButton("Masculino", true);
            rbtFemenino = new JRadioButton("Femenino");
            // Grupo de botones para hacer a los RadioButton mutuamente excluyentes
            ButtonGroup bg = new ButtonGroup();
            bg.add(rbtMasculino);
            bg.add(rbtFemenino);

            JLabel etEdad = new JLabel("Edad:");
            // Crear modelo numérico para JSpinner
            SpinnerNumberModel snm = new SpinnerNumberModel(0, 0, 100, 1);
            spnEdad = new JSpinner(snm);
            JLabel etDepartamento = new JLabel("Departamento:");
            // Arreglo de opciones para el combobox departamento
            String[] opcionesDepartamentos = { "Finanzas", "Administración", "Producción", "Vigilancia" };
            cmbDepartamento = new JComboBox<String>(opcionesDepartamentos);
            JLabel etTurnoLaboral = new JLabel("Turno Laboral:");
            // Arreglo de opciones para el combobox turnolaboral
            String[] opcionesTurnoLaboral = { "Matutino", "Vespertino", "Nocturno" };
            cmbTurnoLaboral = new JComboBox<String>(opcionesTurnoLaboral);
            // JLabel etActividades = new JLabel("Actividades");
            chkLectura = new JCheckBox("Lectura");
            chkDeportes = new JCheckBox("Deportes");
            chkCines = new JCheckBox("Cines");
            chkTeatros = new JCheckBox("Teatros");
            chkJuegosDeSalon = new JCheckBox("Juegos de Salón");
            chkConciertos = new JCheckBox("Conciertos");
            chkOtros = new JCheckBox("Otros");
            JLabel etEspecificar = new JLabel("Especificar");
            txtEspecificar = new JTextField(10);
            JLabel etEstatus = new JLabel("Estatus:");
            chkActivo = new JCheckBox("Activo");

            // Panel para contener los componentes
            JPanel panelGeneral = new JPanel();

            FlowLayout esquemaSimple = new FlowLayout(FlowLayout.LEFT);
            panelGeneral.setLayout(esquemaSimple);

            panelGeneral.add(Box.createHorizontalStrut(2000));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etNombre);
            panelGeneral.add(txtNombre);
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etGenero);
            panelGeneral.add(rbtMasculino);
            panelGeneral.add(rbtFemenino);
            panelGeneral.add(Box.createHorizontalStrut(65));
            panelGeneral.add(etEdad);
            panelGeneral.add(spnEdad);
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etDepartamento);
            panelGeneral.add(cmbDepartamento);
            panelGeneral.add(etTurnoLaboral);
            panelGeneral.add(cmbTurnoLaboral);
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(Box.createHorizontalStrut(40));
            // Panel para agrupar los chkbox de actividades
            JPanel panelActividades = new JPanel();
            panelGeneral.add(panelActividades);
            GridLayout esquemaCuadricula = new GridLayout(3, 3);
            panelActividades.setLayout(esquemaCuadricula);
            // Borde Negro con título
            Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK);
            TitledBorder bordeTitulo = BorderFactory.createTitledBorder(bordeNegro,
                    "Actividades Recreativas");
            panelActividades.setBorder(bordeTitulo);

            panelActividades.add(chkLectura);
            panelActividades.add(chkDeportes);
            panelActividades.add(chkCines);
            panelActividades.add(chkTeatros);
            panelActividades.add(chkJuegosDeSalon);
            panelActividades.add(chkConciertos);
            panelActividades.add(chkOtros);
            panelActividades.add(etEspecificar);
            panelActividades.add(txtEspecificar);

            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(Box.createHorizontalStrut(40));
            panelGeneral.add(etEstatus);
            panelGeneral.add(chkActivo);

            // Botones de acción
            btnNuevo = new JButton("Nuevo");
            btnNuevo.setMnemonic('N');
            btnModificar = new JButton("Modificar");
            btnModificar.setMnemonic('M');
            btnGuardar = new JButton("Guardar");
            btnGuardar.setMnemonic('G');
            btnCancelar = new JButton("Cancelar");
            btnCancelar.setMnemonic('C');
            btnSalir = new JButton("Salir");
            btnSalir.setMnemonic('S');

            // Panel para contener los botones
            JPanel panelBotones = new JPanel();
            panelBotones.add(btnNuevo);
            panelBotones.add(btnModificar);
            panelBotones.add(btnGuardar);
            panelBotones.add(btnCancelar);
            panelBotones.add(btnSalir);

            // Agregar panel de navegación en la parte Norte del cuadro de diálogo
            add(panelNavegacion, BorderLayout.NORTH);
            // Agregar panel de datos generales en la parte Central del cuadro de diálogo
            add(panelGeneral, BorderLayout.CENTER);
            // Agregar panel botones en la parte Sur del cuadro de diálogo
            add(panelBotones, BorderLayout.SOUTH);
        }
    }
}