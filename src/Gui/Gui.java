package Gui;

import EntradaSalida.Almacenar;
import EntradaSalida.Graficas;
import TDA.Asistentes;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class Gui extends JFrame implements ActionListener {

    private JTextField textfield1, textfield2;
    private JLabel label1, label2, label3, label4;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6;
    private Container contenedor;
    private JCheckBox check1, check2;
    private JRadioButton rbtn1, rbtn2, rbtn3, rbtn4;
    private ButtonGroup grupoRBtn;
    private JTextArea area;

    private Almacenar lista;
    private JList listaNom;
    private DefaultListModel modelo;
    private JScrollPane scrollLista;
    private Asistentes asis;
    private Graficas graf;

    public Gui() {
        super("Captura Datos");
        lista = new Almacenar();
        inicio();
        setLayout(null);
        setSize(850, 290);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        //Componentes para nombre
        label1 = new JLabel("Nombre");
        label1.setBounds(40, 20, 100, 30);
        contenedor.add(label1);

        textfield1 = new JTextField();
        textfield1.setBounds(130, 20, 150, 30);
        contenedor.add(textfield1);

        //Componentes para edad
        label2 = new JLabel("Edad");
        label2.setBounds(40, 60, 100, 30);
        contenedor.add(label2);

        textfield2 = new JTextField();
        textfield2.setBounds(130, 60, 150, 30);
        contenedor.add(textfield2);

        //Componentes para sexo
        label3 = new JLabel("Sexo");
        label3.setBounds(40, 120, 120, 20);
        contenedor.add(label3);

        //check
        check1 = new JCheckBox("Masculino");
        check1.setBounds(130, 100, 100, 20);
        check1.addActionListener(this);
        add(check1);

        check2 = new JCheckBox("Femenino");
        check2.setBounds(130, 140, 90, 20);
        check2.addActionListener(this);
        add(check2);

        label4 = new JLabel("Estado Civil");
        label4.setBounds(40, 180, 120, 20);
        contenedor.add(label4);

        rbtn1 = new JRadioButton("Soltero");
        rbtn1.setBounds(40, 210, 70, 20);
        add(rbtn1);

        rbtn2 = new JRadioButton("Casado");
        rbtn2.setBounds(110, 210, 70, 20);
        add(rbtn2);

        rbtn3 = new JRadioButton("Divorciado");
        rbtn3.setBounds(180, 210, 90, 20);
        add(rbtn3);

        rbtn4 = new JRadioButton("Viudo");
        rbtn4.setBounds(270, 210, 60, 20);
        add(rbtn4);

        //Grupo para radio botones
        grupoRBtn = new ButtonGroup();
        grupoRBtn.add(rbtn1);
        grupoRBtn.add(rbtn2);
        grupoRBtn.add(rbtn3);
        grupoRBtn.add(rbtn4);

        //Lista Grafica de los asistentes
        listaNom = new JList();
        listaNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();

        //Crea una barra de desplazamiento vertical
        scrollLista = new JScrollPane();
        scrollLista.setBounds(520, 20, 280, 100);

        //Enlaza la barra de desplazamiento vertical a la lista
        scrollLista.setViewportView(listaNom);
        contenedor.add(scrollLista);

        //Componentes para total y Datos
        LineBorder borde = new LineBorder(Color.BLACK, 1, true);

        area = new JTextArea();
        area.setText("Numero de Registro: " + modelo.getSize()
                + "\nTotal De Hombres: " + lista.nAsisHombres() + "            Total De Mujeres: " + lista.nAsisMujeres()
                + "\nTotal De Mayores: " + lista.nAsisMayores() + "              Total De Menores: " + lista.nAsisMenores()
                + "\nTotal De Solteros: " + lista.nAsisSolteros() + "              Total De Casados: " + lista.nAsisCasados()
                + "\nTotal De Divorciados: " + lista.nAsisDivorciados() + "        Total De Viudos: " + lista.nAsisViudos()
                + "\n% de Hombres: %" + lista.porcentajeH() + "         % de Mujeres: %" + lista.porcentajeM());
        area.setEditable(false);
        area.setBorder(borde);
        area.setBounds(520, 130, 280, 100);
        contenedor.add(area);

        //Boton Añadir
        boton1 = new JButton("Añadir Asistente");
        boton1.setBounds(340, 20, 160, 20);
        contenedor.add(boton1);
        boton1.addActionListener(this);

        //Boton Eliminar
        boton2 = new JButton("Eliminar Asistente");
        boton2.setBounds(340, 58, 160, 20);
        contenedor.add(boton2);
        boton2.addActionListener(this);

        //Boton Eliminar todos
        boton3 = new JButton("Eliminar Todos");
        boton3.setBounds(340, 96, 160, 20);
        contenedor.add(boton3);
        boton3.addActionListener(this);

        //Boton Grafico Sexos
        boton4 = new JButton("Grafica De Sexos");
        boton4.setBounds(340, 134, 160, 20);
        contenedor.add(boton4);
        boton4.addActionListener(this);

        //Boton grafica estado civil
        boton5 = new JButton("Grafica Estado Civil");
        boton5.setBounds(340, 172, 160, 20);
        contenedor.add(boton5);
        boton5.addActionListener(this);

        //Boton Grafica Mayores y Menores
        boton6 = new JButton("Grafica Mayor ; Menor");
        boton6.setBounds(340, 210, 160, 20);
        contenedor.add(boton6);
        boton6.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            añadirAsistente();
            System.out.println("Alumno Añadido");
        } else if (e.getSource() == boton2) {
            eliminarAsistente(listaNom.getSelectedIndex());
            System.out.println("Alumno Eliminado");
        } else if (e.getSource() == boton3) {
            eliminarTodo();
            System.out.println("Alumnos Eliminados");
        } else if (e.getSource() == boton4) {
            graf = new Graficas();
            graf.graficaBarra(graf.crearDatosSexo((byte) lista.nAsisHombres(), (byte) lista.nAsisMujeres()));
        } else if (e.getSource() == boton5) {
            graf = new Graficas();
            graf.graficaBarras3D(graf.crearDatosEstC((byte) lista.nAsisSolteros(),
                    (byte) lista.nAsisCasados(), (byte) lista.nAsisDivorciados(), (byte) lista.nAsisViudos()));
        } else if (e.getSource() == boton6) {
            graf = new Graficas();
            graf.graficaBarra(graf.crearDatosMayorMenor((byte) lista.nAsisMayores(), (byte) lista.nAsisMenores()));
        }

        if (e.getSource() == check1) {
            check2.setSelected(false);
        }
        if (e.getSource() == check2) {
            check1.setSelected(false);
        }
    }

    private void añadirAsistente() {
        asis = new Asistentes(textfield1.getText(), Byte.parseByte(textfield2.getText()),
                validarSexo(), validarEstadoC());
        lista.añadir(asis);
        String cad = textfield1.getText() + " " + textfield2.getText() + " "
                + validarSexo() + " " + validarEstadoC();
        modelo.addElement(cad);
        listaNom.setModel(modelo);
        actualizarDatos();
        textfield1.setText("");
        textfield2.setText("");
    }

    private void eliminarAsistente(int indice) {
        if (indice >= 0) {
            modelo.remove(indice);
            lista.eliminar(indice);
            actualizarDatos();
        } else {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar Un elemento");
        }
    }

    private void eliminarTodo() {
        lista.eliminarTodo();
        modelo.clear();
        actualizarDatos();
    }

    public String validarSexo() {
        String datos = "";
        if (check1.isSelected()) {
            datos = "Masculino";
        }
        if (check2.isSelected()) {
            datos = "Femenino";
        }
        return datos;
    }

    public String validarEstadoC() {
        String estado = "";
        if (rbtn1.isSelected()) {
            estado = "Soltero";
        }
        if (rbtn2.isSelected()) {
            estado = "Casado";
        }
        if (rbtn3.isSelected()) {
            estado = "Divorciado";
        }
        if (rbtn4.isSelected()) {
            estado = "Viudo";
        }
        return estado;
    }

    public void actualizarDatos() {
        area.setText("Numero de Registro: " + modelo.getSize()
                + "\nTotal De Hombres: " + lista.nAsisHombres() + "            Total De Mujeres: " + lista.nAsisMujeres()
                + "\nTotal De Mayores: " + lista.nAsisMayores() + "              Total De Menores: " + lista.nAsisMenores()
                + "\nTotal De Solteros: " + lista.nAsisSolteros() + "              Total De Casados: " + lista.nAsisCasados()
                + "\nTotal De Divorciados: " + lista.nAsisDivorciados() + "        Total De Viudos: " + lista.nAsisViudos()
                + "\n% de Hombres: %" + String.format("%.1f", lista.porcentajeH()) + "          % de Mujeres: %"
                + String.format("%.1f", lista.porcentajeM()));

        check1.setSelected(false);
        check2.setSelected(false);

        grupoRBtn.clearSelection();
    }
}
