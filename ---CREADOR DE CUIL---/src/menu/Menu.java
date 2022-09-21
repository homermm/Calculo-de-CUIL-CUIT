package menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuario;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField boxDNI;
	private JTextField boxCUIL;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Calculo de CUIL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boxDNI = new JTextField();
		boxDNI.setBounds(120, 31, 140, 20);
		contentPane.add(boxDNI);
		boxDNI.setColumns(10);
		
		JLabel textDNI = new JLabel("Documento:");
		textDNI.setBounds(124, 11, 136, 14);
		contentPane.add(textDNI);
		
		JLabel textCUIL = new JLabel("CUIL:");
		textCUIL.setBounds(124, 64, 136, 14);
		contentPane.add(textCUIL);
		
		boxCUIL = new JTextField();
		boxCUIL.setColumns(10);
		boxCUIL.setBounds(120, 87, 140, 20);
		contentPane.add(boxCUIL);
		
		
		JRadioButton butHombre = new JRadioButton("Hombre");
		buttonGroup.add(butHombre);
		butHombre.setSelected(true);
		butHombre.setBounds(5, 30, 109, 23);
		contentPane.add(butHombre);
		
		JRadioButton butMujer = new JRadioButton("Mujer");
		buttonGroup.add(butMujer);
		butMujer.setBounds(5, 60, 109, 23);
		contentPane.add(butMujer);
		
		JToggleButton butCalcular = new JToggleButton("Calcular");
		butCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char sexo='m';
				if(butMujer.isSelected()) {
					sexo='f';
				}
				Usuario user =new Usuario(boxDNI.getText(),sexo);
				boxCUIL.setText(user.getCuil());
			}
		});
		butCalcular.setBounds(303, 30, 121, 23);
		contentPane.add(butCalcular);
		
		JToggleButton butCerrar = new JToggleButton("Borrar");
		butCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boxCUIL.setText(null);
			}
		});
		butCerrar.setBounds(303, 86, 121, 23);
		contentPane.add(butCerrar);
	}
}
