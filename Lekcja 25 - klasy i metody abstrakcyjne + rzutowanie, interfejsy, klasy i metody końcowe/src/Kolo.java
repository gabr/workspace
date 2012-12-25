// klasa finalna, nie można jej rozszerzać
// ma dwie metody końcowe, których nie dałoby się nadpisać, gdyby
// klasa nie była typu final i dało się z niej dziedziczyć
public final class Kolo extends Figura{
	
	private double r;
	
	public Kolo(){
		this(1);
	}
	
	public Kolo(double r){
		this.r = r;
	}
	
	public Kolo(double r, String k){
		this(r, k, false);
	}
	
	public Kolo(double r, boolean w){
		this(r, "Czarny", w);
	}
	
	public Kolo(String k){
		this(k, false);
	}
	
	public Kolo(boolean w){
		this("Czarny", w);
	}
	
	public Kolo(String k, boolean w){
		super(k, w);
	}
	
	public Kolo(double r, String k, boolean w){
		super(k, w);
		this.r = r;
	}
	
	public final double obwod(){
		return 2*Math.PI*r;
	}
	
	public final double pole(){
		return Math.PI*Math.pow(r, 2);
	}
	
	public String toString(){
		return "Nazwa: "+getClass().getName()+"\n"
				+"r = "+r+", obwód: "+this.obwod()+", pole: "+this.pole()
				+", "+super.toString();
	}

}
