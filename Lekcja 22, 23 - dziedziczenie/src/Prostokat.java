
public class Prostokat {
	
	private double a;
	private double b;
	
	public Prostokat(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public Prostokat(){
		this(1, 2);
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
				", obwód: "+this.obwod()+", pole: "+this.pole();
	}

}
