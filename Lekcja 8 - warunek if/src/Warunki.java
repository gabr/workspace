
public class Warunki {
	
	public static void iks(int x){
		if(x == 10){
			System.out.println(x+" wynosi dokładnie dziesięć");
		} else if (x < 10){
			System.out.println(x+" jest mniejszy od dziesięciu");
		} else System.out.println(x+" jest większy od dziesięciu");
	}
	
	public static void main(String args[]){
		
		iks(10);
		iks(5);
		iks(11);
		
		int x = 7;
		System.out.println("\n"+x+" jest "+((x==0)?"równy zero":
			(x<0)?"mniejszy od zera":"większy od zera"));
		
	}

}
