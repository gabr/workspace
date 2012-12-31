import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Pass extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private JPasswordField pHaslo;

	public Pass()
	{
		setSize(280, 120);
		setTitle("Password");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pHaslo = new JPasswordField();
		pHaslo.setBounds(50, 50, 150, 20);
		pHaslo.addActionListener(this);
		pHaslo.setEchoChar('#');
		add(pHaslo);
	}

	public static void main(String[] args)
	{
		Pass app = new Pass();
		app.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
//		JOptionPane.showMessageDialog(this,
//				"pass: " + String.valueOf(pHaslo.getPassword()));

		JOptionPane.showMessageDialog(this,
				"pass: " + new String(pHaslo.getPassword()));
	
	}

}
