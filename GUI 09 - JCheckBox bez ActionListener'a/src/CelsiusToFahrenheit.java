import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JCheckBox cbDuze;
	private Font fontFah;

	public CelsiusToFahrenheit() {

		tempCel = tempFah = 0.0;

		setSize(335, 185);
		setTitle("Celsius --> Fahrenheit");
		setLayout(null);

		lCel = new JLabel("Stopnie Celsiusza:");
		lCel.setBounds(25, 25, 175, 25);
		add(lCel);

		tCel = new JTextField("");
		tCel.setBounds(225, 25, 80, 25);
		tCel.addActionListener(this);
		tCel.setToolTipText("Podaj temperature w stopniach Celsjusza");
		add(tCel);

		lFah = new JLabel("Fahrenheit: ");
		lFah.setBounds(25, 60, 175, 25);
		add(lFah);

		tFah = new JTextField("");
		tFah.setBounds(225, 60, 80, 25);
		tFah.setFocusable(false);
		add(tFah);
		fontFah = tFah.getFont();

		bKonwert = new JButton("Konwertuj");
		bKonwert.setBounds(25, 115, 120, 25);
		bKonwert.addActionListener(this);
		add(bKonwert);

		cbDuze = new JCheckBox("Wielkie litery");
		cbDuze.setBounds(200, 115, 120, 25);
		add(cbDuze);

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
				tempCel = Double.parseDouble(tCel.getText());
				tempFah = 32.0 + (9.0 / 5.0) * tempCel;
				tempFah = (Math.round(tempFah * 100)) / 100.0;
				tFah.setText(String.valueOf(tempFah));
				
				if (cbDuze.isSelected()) {
					tFah.setFont(new Font("SansSerif", Font.BOLD, 13));
					tCel.setFont(new Font("SansSerif", Font.BOLD, 13));
				} else {
					tCel.setFont(fontFah);
					tFah.setFont(fontFah);
				}

			} catch (NumberFormatException e1) {
				tCel.setText("Podaj liczbę");
			}
		}
	}
}
