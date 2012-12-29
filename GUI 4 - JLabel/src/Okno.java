import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Okno extends JFrame implements ActionListener {

	private JButton bPodajDate;
	private JButton bWyjscie;
	JLabel lWyswietlDate;

	public Okno() {
		setSize(300, 200);
		setTitle("okno");

		setLayout(null);

		bPodajDate = new JButton("Podaj datę");
		bPodajDate.setBounds(5, 5, 125, 30);
		bPodajDate.addActionListener(this);
		add(bPodajDate);

		bWyjscie = new JButton("Wyjście");
		bWyjscie.setBounds(190, 150, 100, 25);
		add(bWyjscie);
		bWyjscie.addActionListener(this);

		lWyswietlDate = new JLabel("Data: ");
		lWyswietlDate.setBounds(5, 100, 290, 30);
		lWyswietlDate.setBackground(Color.BLACK);
		lWyswietlDate.setForeground(new Color(124, 25, 23));
		lWyswietlDate.setFont(new Font("SansSerif", Font.BOLD, 14));
		add(lWyswietlDate);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object zrodlo = arg0.getSource();

		if (zrodlo == bPodajDate) {
			lWyswietlDate.setText("Data: " + (new Date()).toString());
		} else if (zrodlo == bWyjscie) {
			this.dispose();
		}

	}

	public static void main(String[] args) {
		Okno okienko = new Okno();
		okienko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okienko.setVisible(true);
	}

}
