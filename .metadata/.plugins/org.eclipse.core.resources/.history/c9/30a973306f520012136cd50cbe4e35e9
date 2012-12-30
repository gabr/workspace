public class RownanieKwadratowe {
	
	private int a;
	private int b;
	private int c;
	
	public RownanieKwadratowe(){
		this(0,0,0);
	}
	
	public RownanieKwadratowe(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void setA(int a){
		this.a = a;
	}
	
	public void setB(int b){
		this.b = b;
	}
	
	public void setC(int c){
		this.c = c;
	}
	
	public String rozwiaz(){
		String rozwiazanie = "";
		double delta;
		delta = (b*b - 4*a*c);
		if(delta>0){
			delta=Math.sqrt(delta);
			double x1=(-b-delta)/(2*a);
			double x2=(-b+delta)/(2*a);
			x1 = Math.round(x1*100)/100.0;
			x2 = Math.round(x2*100)/100.0;
			rozwiazanie = "pierwiastki: "+x1+", "+x2;
		} else if(delta == 0) {
			delta=Math.sqrt(delta);
			double x0 = b/(2*a);
			x0 = Math.round(x0*100)/100.0;
			rozwiazanie = "pierwiastek: "+x0;
		} else rozwiazanie = "Brak pierwiastków rzeczywistych.";
		
		return rozwiazanie;
	}
	
	public String toString(){
		return "Równanie kwadratowe: "+a+"x^2 + "+b+"x + "+c;
	}

	public static void main(String[] args) {
		
		RownanieKwadratowe fodx = new RownanieKwadratowe(1, 4, -1);
		System.out.println(fodx.rozwiaz());

	}

}
