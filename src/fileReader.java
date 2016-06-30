import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mgkan on 2016-06-30.
 */
public class fileReader {
	public static void main(String[] args)throws IOException{
		ArrayList<String> list = new ArrayList<>();
		Scanner s = new Scanner(new File("src/titanic.csv"));
		while (s.hasNextLine()){
			list.add(s.nextLine());
		}
		int tally=0;
		int gender=0;
		int class1=0;
		int class2=0;
		int underAge=0;
		int survived=0;
		int class1All=0;
		int class2All=0;
		int underAgeAll=0;
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			String[] parts = list.get(i).split(",");
			tally++;
			if(parts[2].equals("1")){
				class1All++;
			}
			if(parts[2].equals("2")){
				class2All++;
			}
			if(parts[6].length() < 3 && parts[6].length() > 0 && Double.parseDouble(parts[6])< 17){
				underAgeAll++;
			}
			if (list.get(i).contains("female")) {
				gender++;
			}
			if(parts[1].equals("1")){
			  survived++;
				if(parts[6].length() > 0 && Double.parseDouble(parts[6])< 17){
					underAge++;
				}
				if(parts[2].equals("1")){
					class1++;
				}
				if(parts[2].equals("2")){
					class2++;
				}
			}
		}
		System.out.println("");
		System.out.println("There were "+ (tally-1) +" passengers in Titanic");
		System.out.println("There were "+ gender + " females in Titanic");
		System.out.println("There were "+ (tally-gender-1) + " males in Titanic");
		System.out.println("The survival rate of anyone under 16 is "+ (((double)underAge/underAgeAll)*100) + "%");
		System.out.println("The survival rate of 1st class passenger is "+ (((double)class1/class1All)*100) + "%");
		System.out.println("The survival rate of 2nd class passenger is "+ (((double)class2/class2All)*100) + "%");
		System.out.println("The survival rate of 3rd class passenger is "+ ((((double)survived-class1-class2-1)/(tally-class1All-class2All-1))*100) + "%");
		System.out.println(class1);
		System.out.println(class1All);
	}
}
