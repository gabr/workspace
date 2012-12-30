import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Menu extends JFrame implements ActionListener {

	JMenuBar menuBar;
	JMenu menuPlik, menuOpcje, menuNarzedzia, menuPomoc;
	JMenuItem menuPlikOtworz, menuPlikZapisz, menuPlikWyjscie;
	JMenuItem menuOpcjeOpcja1, menuOpcjeOpcja2;
	JMenuItem menuNarzedzia1, menuNarzedzia2;
	JMenuItem menuPomocOProgramie;
	JCheckBoxMenuItem checkBoxMenuOpcjeOpcja3;

	public Menu() {
		setSize(400, 100);
		setTitle("Menu");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuPlik = new JMenu("Plik");
		menuNarzedzia = new JMenu("Narzedzia");
		menuPomoc = new JMenu("Pomoc");

		menuPlikOtworz = new JMenuItem("Otworz", 'O');
		menuPlikZapisz = new JMenuItem("Zapisz", 'Z');
		menuPlikWyjscie = new JMenuItem("Wyjscie", 'W');
		menuPlikWyjscie.addActionListener(this);
		menuPlikWyjscie.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
		menuPlik.add(menuPlikOtworz);
		menuPlik.add(menuPlikZapisz);
		menuPlik.addSeparator();
		menuPlik.add(menuPlikWyjscie);

		menuNarzedzia1 = new JMenuItem("narzedzie 1", 'n');
		menuNarzedzia2 = new JMenuItem("narzedzie 2", 'a');

		menuOpcje = new JMenu("Opcje");
		menuOpcjeOpcja1 = new JMenuItem("opcja 1", 'p');
		menuOpcjeOpcja2 = new JMenuItem("opcja 2", 'c');
		checkBoxMenuOpcjeOpcja3 = new JCheckBoxMenuItem("opcja 3", true);
		checkBoxMenuOpcjeOpcja3.addActionListener(this);
		menuOpcje.add(menuOpcjeOpcja1);
		menuOpcje.add(menuOpcjeOpcja2);
		menuOpcje.add(checkBoxMenuOpcjeOpcja3);

		menuNarzedzia.add(menuNarzedzia1);
		menuNarzedzia.add(menuNarzedzia2);
		menuNarzedzia.add(menuOpcje);

		menuPomocOProgramie = new JMenuItem("O programie", 'r');
		menuPomocOProgramie.addActionListener(this);
		menuPomoc.add(menuPomocOProgramie);

		menuBar.add(menuPlik);
		menuBar.add(menuNarzedzia);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(menuPomoc);

		setJMenuBar(menuBar);

	}

	public static void main(String[] args) {
		Menu app = new Menu();
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if (s == menuPlikWyjscie)
			dispose();
		else if (s == checkBoxMenuOpcjeOpcja3)
			if (checkBoxMenuOpcjeOpcja3.isSelected())
				menuNarzedzia2.setEnabled(true);
			else
				menuNarzedzia2.setEnabled(false);
		else if (s == menuPomocOProgramie) {
			JOptionPane.showMessageDialog(this,
				"written by gabr\n program demonstruje użycie menu w javie");
		}

	}

}
