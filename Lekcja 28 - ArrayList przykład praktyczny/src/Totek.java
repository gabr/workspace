import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Totek {
	
	public static int[] losuj(int k, int n){
		Random crazy = new Random();
		ArrayList<Integer> pula = new ArrayList<Integer>(n);
		int[] wylosowane = new int[k];
		
		for(int i=1; i<=n; i++)
			pula.add(i);
		
		for(int j=0; j<k; j++)
		{
			int index = crazy.nextInt(n--);
			wylosowane[j] = pula.get(index);
			pula.remove(index);
		}
		
		return wylosowane;
		
	}
	
	public static void main(String[] args){
		
		int[] losowanie = losuj(50, 66);
		
		System.out.println(Arrays.toString(losowanie)); 
		
	}

}
