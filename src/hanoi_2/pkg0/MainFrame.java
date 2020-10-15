package hanoi_2.pkg0;


import Juego.VentanaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Clase MainFrame
 * @author James Gramajo
 */
public class MainFrame extends JFrame implements ActionListener, ChangeListener {

    private JLabel labelNroDiscos;
    private JLabel labelInformacion;
    public static JLabel labelContador;
    private JSpinner spinnerNroDiscos;
    private JButton botonIniciar;
    private JButton botonVolver;
    private Dibujo dibujo;

    public MainFrame() {
        super("Hanoi | Mate Computo 2 Ing. Diego Orozco");
        configurarVentana();
        inicializarComponentes();
        this.setVisible(true);
    }

    private void configurarVentana() {
        this.setSize(700, 440);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {

        JPanel panelInferior = new JPanel();

        labelNroDiscos = new JLabel("Formula:(2^n -1) Numero de discos");
        panelInferior.add(labelNroDiscos);

        spinnerNroDiscos = new JSpinner(new SpinnerNumberModel(5, 1, 5, 1));
        spinnerNroDiscos.addChangeListener(this);
        panelInferior.add(spinnerNroDiscos);

        botonIniciar = new JButton("Comenzar");
        botonIniciar.addActionListener(this);
        panelInferior.add(botonIniciar);
        
        botonVolver = new JButton("Volver");
        botonVolver.addActionListener(        
                
        new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
           Regresar();
           
        }
        });
        panelInferior.add(botonVolver);
        

        labelInformacion = new JLabel("Solucion Completa");
        labelInformacion.setForeground(Color.GREEN);
        labelInformacion.setVisible(false);
        panelInferior.add(labelInformacion);
        
        labelContador= new JLabel("Contador: ");
        labelContador.setForeground(Color.red);
        labelContador.setVisible(true);
        panelInferior.add(labelContador);

        add(panelInferior, BorderLayout.SOUTH);
        dibujo = new Dibujo(5, this);
        add(dibujo, BorderLayout.CENTER);        

    }

    public void actionPerformed(ActionEvent e) {
        if (botonIniciar.getText().equals("Pausar")) {
            dibujo.pausarAnimacion();
            botonIniciar.setText("Continuar");
        } else {
            if (botonIniciar.getText().equals("Simular otra vez")) {
                dibujo = new Dibujo(Integer.parseInt(spinnerNroDiscos.getValue().toString()), this);
                add(dibujo, BorderLayout.CENTER);
                botonIniciar.setText("Empezar");
                labelInformacion.setVisible(false);
                this.setVisible(true);
            } else {
                dibujo.iniciarAnimacion();
                botonIniciar.setText("Pausar");
            }
        }
    }

    public void stateChanged(ChangeEvent e) {
        dibujo.pausarAnimacion();
        botonIniciar.setText("Empezar");
        labelInformacion.setVisible(false);
        dibujo = new Dibujo(Integer.parseInt(spinnerNroDiscos.getValue().toString()), this);
        add(dibujo, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void resolucionCompletada() {
        botonIniciar.setText("Empezar otra vez");
        labelInformacion.setVisible(true);
    }
    
    public void Regresar(){
        VentanaPrincipal inicial = new VentanaPrincipal();
        this.setVisible(false);
        inicial.setVisible(true);
    }
    
}
