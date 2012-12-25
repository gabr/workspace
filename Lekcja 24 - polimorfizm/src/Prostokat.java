
public class Prostokat extends Figura{
	
	private double a;
	private double b;
	
	public Prostokat(){
		this(1, 2);
	}
	
	public Prostokat(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public Prostokat(double a, double b, String k){
		this(a, b, k, false);
	}
	
	public Prostokat(double a, double b, boolean w){
		this(a, b, "Czarny", w);
	}
	
	public Prostokat(String k, boolean w){
		this(1, 2, k, w);
	}
	
	public Prostokat(String k){
		this(1, 2, k, false);
	}
	
	public Prostokat(boolean w){
		this(1, 2, "Czarny", w);
	}
	
	public Prostokat(double a, double b, String k, boolean w){
		super(k, w);
		this.a = a;
		this.b = b;
	}
	
	public double pole(){
		return a*b;
	}
	
	public double obwod(){
		return 2*a + 2*b;
	}
	
	public String toString(){
		return "Nazwa: "+getClass().getName()+"\n"+
				"boki: "+a+", "+b+
				", obwód: "+this.obwod()+", pole: "+this.pole()+
				", "+super.toString();
	}

}
