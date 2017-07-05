import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ex 
{
	public static void main(String[] args)
	{
		List<String> AL=new ArrayList<String>();
		AL.add("qap1");
		AL.add("qap2");
		AL.add("qap2");
		
		//Print all values from array list Using Iterator
		Iterator<String> ITRT=AL.iterator();
		while (ITRT.hasNext())
		{
			String val=ITRT.next();
			System.out.println(val);
		}
		
 	}
}
