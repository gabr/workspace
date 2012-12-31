import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class App extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JTextArea notatnik;
	private JScrollPane scrollPane;
	private JButton bDodajUzytkownika;

	private PanelHasla panelHasla;

	public App()
	{
		setSize(400, 360);
		setTitle("Okna dialogowe");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		notatnik = new JTextArea();
		notatnik.setWrapStyleWord(true);
		notatnik.setLineWrap(true);
		scrollPane = new JScrollPane(notatnik);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 400, 300);
		add(scrollPane);

		bDodajUzytkownika = new JButton("new user");
		bDodajUzytkownika.setBounds(5, 310, 100, 20);
		bDodajUzytkownika.addActionListener(this);
		add(bDodajUzytkownika);
	}

	public static void main(String[] args)
	{
		App app = new App();
		app.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (panelHasla == null)
			panelHasla = new PanelHasla(this);
		panelHasla.setVisible(true);
		panelHasla.setFocus();
		
		if (panelHasla.isOk())
		{
			notatnik.append("user: " + panelHasla.getUser());
			notatnik.append("\n");
			notatnik.append("pass: " + panelHasla.getPassword());
		}
		
	}

}

class PanelHasla extends JDialog implements ActionListener
{

	private static final long serialVersionUID = 2L;
	private JLabel lUser, lPass;
	private JTextField tUser;
	private JPasswordField tPass;
	private JButton bOk, bCancel;
	private boolean okData;

	public PanelHasla(JFrame owner)
	{
		super(owner, "Wprowadzanie hasła", true); // ostatni parametr ?!?
		// dialog modalny, czy niemodalny???
		// modalne blokują program dokóki się ich nie obsłuży

		setSize(250, 136);
		setLayout(null);

		lUser = new JLabel("user: ", JLabel.RIGHT);
		lUser.setBounds(35, 10, 50, 20);
		add(lUser);

		tUser = new JTextField();
		tUser.setBounds(95, 12, 100, 20);
		tUser.addActionListener(this);
		add(tUser);

		lPass = new JLabel("pass: ", JLabel.RIGHT);
		lPass.setBounds(35, 45, 50, 20);
		add(lPass);

		tPass = new JPasswordField();
		tPass.setBounds(95, 47, 100, 20);
		tPass.addActionListener(this);
		add(tPass);

		bOk = new JButton("OK");
		bOk.setBounds(20, 80, 100, 20);
		bOk.addActionListener(this);
		add(bOk);

		bCancel = new JButton("CANCEL");
		bCancel.setBounds(135, 80, 100, 20);
		bCancel.addActionListener(this);
		add(bCancel);
	}
	
	public String getUser()
	{
		return tUser.getText();
	}
	
	public String getPassword()
	{
		return new String(tPass.getPassword());
	}
	
	public boolean isOk()
	{
		return okData;
	}
	
	public void setFocus()
	{
		tUser.requestFocusInWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object s = e.getSource();
		if (s == bOk || s == tUser || s == tPass)
		{
			okData = true;
		} else if (s == bCancel)
		{
			okData = false;
		}
		
		this.setVisible(false);
	}

}
