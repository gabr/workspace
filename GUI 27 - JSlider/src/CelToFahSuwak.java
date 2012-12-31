import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CelToFahSuwak extends JFrame implements ChangeListener
{

	private static final long serialVersionUID = 1L;
	private JSlider sCel, sFah;
	private JLabel lCel, lFah;
	private int tempCel, tempFah;

	public CelToFahSuwak()
	{
		setSize(500, 300);
		setTitle("Cel --> Fah");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sCel = new JSlider(-30, 100, 0);
		sCel.setBounds(50, 50, 300, 50);
		sCel.setMajorTickSpacing(20);
		sCel.setMinorTickSpacing(5);
		sCel.setPaintTicks(true);
		sCel.setPaintLabels(true);
		sCel.addChangeListener(this);
		add(sCel);
		
		sFah = new JSlider(0, 212, 32);
		sFah.setBounds(50, 150, 300, 50);
		sFah.setMajorTickSpacing(20);
		sFah.setMinorTickSpacing(5);
		sFah.setPaintTicks(true);
		sFah.setPaintLabels(true);
		sFah.setEnabled(false);
		add(sFah);
		
		lCel = new JLabel("Celsius: 0");
		lCel.setBounds(380, 50 ,300, 50);
		add(lCel);

		lFah = new JLabel("Fahrenheit: 32");
		lFah.setBounds(380, 150 ,300, 50);
		add(lFah);
	}
	
	public static void main(String[] args)
	{
		CelToFahSuwak app = new CelToFahSuwak();
		app.setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		Object s = e.getSource();
		if(s == sCel){
			tempCel = sCel.getValue();
			lCel.setText("Celsius: " + tempCel);
			tempFah = (int) Math.round(32 + (9.0/5.0) * tempCel);
			sFah.setValue(tempFah);
			lFah.setText("Fahrenheit: " + tempFah);
		}
	}

}
