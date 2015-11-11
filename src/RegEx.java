import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	public static void main(String[] args) {
		
		Scanner inpt = new Scanner(System.in);
		String choice = "a";
		String menu = "a. Social Security Number\n"
				+ "b. US Phone number\n"
				+ "c. E-mail address\n"
				+ "d. Name on a class roster, assuming one or more middle initials - Last name, First name, MI\n"
				+ "e. Date in MM-DD-YYYY format\n"
				+ "f. House address - Street number, street name, abbreviation for road, street, boulevard or avenue\n"
				+ "g. City followed by state followed by zip as it should appear on a letter\n"
				+ "h. Military time, including seconds\n"
				+ "i. US Currency down to the penny (ex: $123,456,789.23)\n"
				+ "j. URL, including http:// (upper and lower case should be accepted)\n"
				+ "k. A password that contains at least 10 characters and includes at least one upper case character,\n"
				+ "   lower case character, digit, punctuation mark, and does not have more than\n"
				+ "   3 consecutive lower case characters\n"
				+ "l. All words containing an odd number of alphabetic characters, ending in \"ion\"\n"
				+ "q. quit";
		
		while(!choice.equals("q")){
			System.out.println(menu);
			choice = inpt.next();
			if(choice.equals("a")) Social(inpt.next().trim());
			if(choice.equals("b")) Phone(inpt.next().trim());
			if(choice.equals("c")) Email(inpt.next().trim());
			if(choice.equals("d")) Name(inpt.next().trim());
			if(choice.equals("e")) Date(inpt.next().trim());
			if(choice.equals("f")) Address(inpt.next().trim());
			if(choice.equals("g")) City(inpt.next().trim());
			if(choice.equals("h")) Time(inpt.next().trim());
			if(choice.equals("i")) Money(inpt.next().trim());
			if(choice.equals("j")) Url(inpt.next().trim());
			if(choice.equals("k")) Password(inpt.next().trim());
			if(choice.equals("l")) Word(inpt.next().trim());	
		}
		
		inpt.close();
	}

	private static void Word(String next) {
		String regex = "[(?:[^a]*a[^a]*a)*[^a]*a[^a]]+ion$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");		
	}

	private static void Password(String next) {
		String regex = "^((?=.*\\d)(?=.*!\\s)(?!.*[a-z]{3})(?=.*[a-z])(?=.*[A-Z])(?=.*['.,\":;?-!]).{10,})$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");
	}

	private static void Url(String next) {
		String regex = "^((https?:\\/\\/)?[\\w-]+(\\.[\\w-]+)+\\.?(:\\d+)?(\\/\\S*)?)$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");		
	}

	private static void Money(String next) {
		String regex = "^\\$[0-9]{1,3}(?:,?[0-9]{3})*\\.[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");		
	}

	private static void Time(String next) {
		String regex = "^([01]\\d|2[0-3]):?[0-5]\\d:?[0-5]\\d$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");		
	}

	private static void City(String next) {
		String regex = "^[\\w\\s]+,\\s\\w{2},\\s\\d{5}(-\\d{4})?$";
		Pattern pattern = Pattern.compile(regex.toLowerCase());
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");	
	}

	private static void Address(String next) {
		String regex = "^([1-9]+[0-9]{1,5})\\s([a-z].){0,1}\\s([1-9]{1}[0-9]{1,5}[st|nd|rd|th]{1}+)\\s([a-z]{2,}[.]{0,1})$";
		Pattern pattern = Pattern.compile(regex.toLowerCase());
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");	
	}

	private static void Date(String next) {
		String regex = "^(0[1-9]|1[012])[- \\/](0[1-9]|[12][0-9]|3[01])[- \\/]((?:19|20)\\d\\d)$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");	
	}

	private static void Name(String next) {
		String regex = "^(([a-z]+{1,}[-']{0,1}[a-z]+{1,}[.]{0,1})\\s){1,}";
		Pattern pattern = Pattern.compile(regex.toLowerCase());
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");	
	}

	private static void Email(String next) {
		String regex = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
		Pattern pattern = Pattern.compile(regex.toLowerCase());
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");		
	}

	private static void Phone(String next) {
		String regex = "1?\\s*\\W?\\s*([2-9][0-8][0-9])\\s*\\W?\\s*([2-9][0-9]{2})\\s*\\W?\\s*([0-9]{4})(\\se?x?t?(\\d*))?";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");
	}
     
	private static void Social(String next) {
		String regex = "^(?!(000|666|9))\\d{3}-(?!00)\\d{2}-(?!0000)\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(next);
        
        if(matcher.find()) System.out.println("Valid");
        else System.out.println("Invalid");	
	}

}
