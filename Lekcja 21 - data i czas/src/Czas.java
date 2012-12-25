import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Czas {
	
	public static void main(String[] args){
		
		
		// liczba milisekund od 1 stycznia 1970r
		// System.currentTimeMillis()/(1000*3600*24*365.5)
		System.out.println(System.currentTimeMillis());
		
		long t1 = System.currentTimeMillis();
		
		for(int i = 0; i < 1E6 ; i++){
			double x = Math.pow(Math.random(), Math.random());
		}
		
		long t2 = System.currentTimeMillis();
		System.out.println((t2-t1)/1000.0);
		
		Date dzis = new Date();
		System.out.println(dzis);
		System.out.printf("%tc\n", dzis);
		System.out.printf("%tc", new Date());
		
		GregorianCalendar data = new GregorianCalendar();
		System.out.printf("\n%tc\n", data);
		System.out.println(data.get(GregorianCalendar.DAY_OF_WEEK));
		System.out.println(data.get(Calendar.YEAR));
		
		data.set(2012, 0, 1);
		// UWAGA! miesiące liczone są od ZERA
		// można zrobić tak:
		// ... = new GregorianCalendar(1992, Calendar.MARCH, 3);
		GregorianCalendar urodziny = new GregorianCalendar(1992, 2, 3);
		if(data.before(urodziny)) System.out.println("Jest czas kupic prezent");
		
		urodziny.set(Calendar.YEAR, 2012);
		if(data.before(urodziny)) System.out.println("Jest czas kupic PREZENT");
		
		data = new GregorianCalendar();
	}

}
