import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CelsiusToFahrenheit extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lCel;
	private JLabel lFah;
	private JTextField tCel;
	private JTextField tFah;
	private JButton bKonwert;
	private double tempCel;
	private double tempFah;
	private Font fontDefault;
	private ButtonGroup bgRozmiar;
	private JRadioButton rbCelToFah, rbFahToCel;

	public CelsiusToFahrenheit() {

		tempCel = tempFah = 0.0;

		setSize(335, 215);
		setTitle("Celsius --> Fahrenheit");
		setLayout(null);

		lCel = new JLabel("Stopnie Celsiusza:");
		lCel.setBounds(25, 25, 175, 25);
		add(lCel);

		tCel = new JTextField("");
		tCel.setBounds(225, 25, 80, 25);
		tCel.addActionListener(this);
		tCel.setToolTipText("Wprowadz temperature w stopniach Celsiusza");
		add(tCel);
		fontDefault = tCel.getFont();

		lFah = new JLabel("Fahrenheit: ");
		lFah.setBounds(25, 60, 175, 25);
		add(lFah);

		tFah = new JTextField("");
		tFah.setBounds(225, 60, 80, 25);
		tFah.setFocusable(false);
		add(tFah);

		bKonwert = new JButton("Konwertuj");
		bKonwert.setBounds(75, 105, 175, 25);
		bKonwert.addActionListener(this);
		add(bKonwert);

		bgRozmiar = new ButtonGroup();
		rbCelToFah = new JRadioButton("Cel -> Fah", true);
		rbCelToFah.setBounds(50, 150, 100, 20);
		bgRozmiar.add(rbCelToFah);
		add(rbCelToFah);
		rbCelToFah.addActionListener(this);

		rbFahToCel = new JRadioButton("Fah -> Cel", true);
		rbFahToCel.setBounds(175, 150, 100, 20);
		bgRozmiar.add(rbFahToCel);
		add(rbFahToCel);
		rbFahToCel.addActionListener(this);

	}

	public static void main(String[] args) {
		CelsiusToFahrenheit okno = new CelsiusToFahrenheit();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object zrodlo = e.getSource();

		if (zrodlo == bKonwert || zrodlo == tCel) {
			try {
				
				if(rbCelToFah.isSelected()){
					tempCel = Double.parseDouble(tCel.getText());
					tempFah = 32.0 + (9.0 / 5.0) * tempCel;
					tempFah = (Math.round(tempFah * 100)) / 100.0;
					tFah.setText(String.valueOf(tempFah));
				} else {
					tempFah = Double.parseDouble(tFah.getText());
					tempCel = (tempFah - 32.0) * (5.0/9.0);
					tempCel = (Math.round(tempCel * 100)) / 100.0;
					tCel.setText(String.valueOf(tempCel));
				}

			} catch (NumberFormatException e1) {
				if(rbCelToFah.isSelected())
					tCel.setText("Podaj liczbę");
				else
					tFah.setText("Podaj liczbe");
			}
		} else if(zrodlo == rbCelToFah) {
			tCel.setFocusable(true);
			tFah.setFocusable(false);
		} else if(zrodlo == rbFahToCel){
			tCel.setFocusable(false);
			tFah.setFocusable(true);
		}
	}
}
