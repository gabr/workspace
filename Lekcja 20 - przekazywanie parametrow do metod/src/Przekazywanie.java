
public class Przekazywanie {
	
	public static void podwojenie(int x){
		x *= 2;
	}
	
	public static void podwojenie_tab(int[] t){
		for(int i = 0; i < t.length ; i++)
			t[i] *= 2;
	}
	
	public static double srednia(int... x){
		double s = 0.0;
		for(int var : x){
			s += var;
		}
		s /= x.length;
		return s;
	}
	
	public static void main(String[] args){
		int x = 10;
		podwojenie(x);
		System.out.println(x);
		
		int[] t = new int[1];
		t[0] = 10;
		podwojenie_tab(t);
		System.out.println(t[0]);
		
		System.out.println(srednia(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}

}
