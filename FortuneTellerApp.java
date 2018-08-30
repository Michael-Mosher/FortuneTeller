package src.test.java;
import java.util.*;
import java.lang.reflect.*;
import java.text.NumberFormat;

public class FortuneTellerApp {
	
	private static Object[] aAnswers = new Object[6];
	private final static String[] methods = new String[] {
	      "FirstName",
	      "LastName",
	      "Age",
	      "BirthMonth",
	      "Color",
	      "SiblingQty"
	};

	public static void main(String[] args) {
		final FortuneTellerIntake oEsmeralda = new FortuneTellerIntake();
		final Scanner oInputStream = new Scanner(System.in);
		// mutable holder of stream input
		String sInput;
		// mutable holder of confirmation
		boolean bConfirmed = false;
		// strings of prefixes
		final String sPromptMethod = "prompt";
		final String sIsSufficientInputMethod = "isSufficientInput";
		final String sParseRawMethod = "parseRaw";
		final String sSetMethod = "set";
		final String sConfirmMethod = "confirm";
		// temporary string to hold the concatenated prefix + suffix
		String sMethodName = "";
		// mutable string for confirmation input
		String sConfirmationInput;
		// Class object for this class to generate Methods for dynamic method invocation
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
		
			// The holder for Method of dynamically generated method names
			Method oTempMethod;
			// mutable confirmation Method obj
			Method oConfirmationMethod;
			// mutable prompt Method obj
			Method oPromptMethod;
			
			System.out.println("Mdm. Esmeralda is ready to see you. Before supplying your fortune she will need to know your heart and soul. Please answer the following:");
			// cycle through action suffixes
			for(String sCurrentSuffix : FortuneTellerApp.methods) {
				bConfirmed = false;
					// First, prompt for initial input for each input type
					sMethodName = sPromptMethod + sCurrentSuffix;
					Class[] aArgTypes = new Class[0];
					oPromptMethod = oClass.getDeclaredMethod(sMethodName, aArgTypes);
					oPromptMethod.invoke(oEsmeralda, null);
					sInput = oInputStream.nextLine();
					// prepare to test the input
					sMethodName = sIsSufficientInputMethod + sCurrentSuffix;
					oTempMethod = oClass.getDeclaredMethod(sMethodName, String.class);
					// loop the answers until is sufficient for prompt and has been confirmed
					while (!((Boolean)oTempMethod.invoke(oEsmeralda, sInput)).booleanValue() || !bConfirmed){
						if(((Boolean)oTempMethod.invoke(oEsmeralda, sInput)).booleanValue()) {
							sMethodName = sConfirmMethod + sCurrentSuffix;
							oConfirmationMethod = oClass.getDeclaredMethod(sMethodName, String.class, String.class, String.class);
							oConfirmationMethod.invoke(oEsmeralda, sInput, sCurrentSuffix, sParseRawMethod);
							sConfirmationInput = oInputStream.nextLine();
							if(sConfirmationInput.toLowerCase().matches("y") || sConfirmationInput.toLowerCase().matches("yes")){
								bConfirmed = true;
							} else {
								oPromptMethod.invoke(oEsmeralda, null);
								bConfirmed = false;
								sInput = oInputStream.nextLine();
							}
	//						bConfirmed = .valueOf();
						} else if("help".matches(sInput.toLowerCase()) && sCurrentSuffix.matches("Color")) {
							oEsmeralda.promptHelpColor();
							oPromptMethod.invoke(oEsmeralda, null);
							sInput = oInputStream.nextLine();
						} else if("quit".matches(sInput.toLowerCase())) {
							FortuneTellerApp.processQuit();
						} else {
							oPromptMethod.invoke(oEsmeralda, null);
							sInput = oInputStream.nextLine();
						}
					}
					sMethodName = sParseRawMethod + sCurrentSuffix;
					oTempMethod = oClass.getDeclaredMethod(sMethodName, String.class);
					FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex(sCurrentSuffix)] = oTempMethod.invoke(oEsmeralda, sInput);
			}
		}
		catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
		System.out.println("...");
		String sFortune = FortuneTellerApp.getFortune();
		try {
			for(String piece : sFortune.split("[ ]+")) {
				long lMilliSecondsBase = 100L;
				long lMilliSecondsFinal = lMilliSecondsBase * piece.length();
				Thread.sleep(lMilliSecondsFinal);
				System.out.print(" " + piece);
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static String getFirstName()
	{
		return ((Optional<String>)FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex("FirstName")]).orElse("");
	}
	
	private static String getLastName()
	{
		return ((Optional<String>)FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex("LastName")]).orElse("");
	}
	
	private static short getAge()
	{
		return ((Optional<Short>)FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex("Age")]).orElse(Short.valueOf((short) -1));
	}	
	
	private static short getBirthMonth()
	{
		return ((Optional<Short>)FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex("BirthMonth")]
				).orElse(Short.valueOf((short) -1));
	}
	
	private static short getSiblingQty()
	{
		return ((Optional<Short>)FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex("SiblingQty")]
				).orElse((short)-1);
	}
	
	private static String getColor()
	{
		return ((Optional<String>)FortuneTellerApp.aAnswers[FortuneTellerApp.getAnswerIndex("Color")]).orElse("");
	}
	
	private static short getRetirementYears()
	{
//		Retirement Years
//
//		The user�s number of years until retirement will be based on whether the user�s age is odd or even.
//
//		(condition) If the user�s age is�	(example) then the user will retire in�
//		odd	14 years
//		even	12 years
		short answer;
		return (answer = FortuneTellerApp.getAge()%2==0 ? (short)50 : (short)100);
	}
	
	private static String getVacationHomeLocation()
	{
//		Vacation Home Location
//
//		The location of the user�s vacation home will be based on how many siblings the user has. If the user enters a number less than zero, give the user a bad location!
//
//		(condition) If the user�s number of siblings is�	(example) then the user�s vacation home will be in�
//		0	Boca Raton, FL
//		1	Nassau, Bahamas
//		2	Ponta Negra,Brazil
//		3	Portland, Oregon
//		greater than three	Baton Rouge, LA
//		less than zero	Chernobyl, Ukraine
		String answer = "";
		short test = FortuneTellerApp.getSiblingQty();
			if(test ==0) {
				answer = "Paris";
				}else if(test==1) {
				answer = "London";
				}else if(test== 2) {
				answer = "Miami";
				}else if(test== 3) {
				answer = "Sao Paolo";
				}else if(test>3) {
				answer = "Kuala Lumpur";
				}else if(test<0) {
				answer = "Antartica";
				}
		return answer;
	}
	
	private static String getTransportationMode()
	{
//		Mode of Transporation
//
//		The user�s mode of transportation will determined by the user�s favorite color.
//
//		(condition) If the user�s favorite color is�	(example) then the user�s mode of transportation will be�
//		red	Maserati
//		orange	stallion
//		yellow	chariot
//		green	taxi
//		blue	rickshaw
//		indigo	motor scooter
//		violet	flying saucer
		String answer;
		switch(FortuneTellerApp.getColor().toLowerCase()) {
		case "red":
			answer = "electric scooter";
			break;
		case "orange":
			answer = "Segway";
			break;
		case "yellow":
			answer = "bicycle";
			break;
		case "green":
			answer = "longboard";
			break;
		case "blue":
			answer = "Tesla";
			break;
		case "indigo":
			answer = "Boring tunnel";
			break;
		case "violet":
			answer = "kite";
			break;
			default:answer = "";break;
		}
		return answer;
	}
	
	private static String getBankBalance()
	{
//		Bank Balance
//		The user�s bank balance at retirement will be based on the user�s birth month. If the user enters something other than 1-12 for birth month, the user�s balance will be $0.00.
//
//		(condition) If the user�s birth month is�	(example) The user�s balance will be�
//		1-4	$256,000.76
//		5-8	$3,687,105.42
//		9-12	$86.23
//		anything else	$0.00
		NumberFormat oFormatConverter = NumberFormat.getCurrencyInstance(Locale.US);
		int intermittent_answer = 0;
		short birth_month = FortuneTellerApp.getBirthMonth();
		if(1<=birth_month && birth_month<=4) {
			intermittent_answer = 123456;
		} else if (5<=birth_month && birth_month<=8) {
			intermittent_answer = 456789;
		} else if(9<=birth_month && birth_month<=12) {
			intermittent_answer = 789000;
		}
		return oFormatConverter.format((double)intermittent_answer);
	}
	
	
	private static void processQuit()
	{
		System.exit(0);
	}
	
	private static int getAnswerIndex(String sSuffix)
	{
		for(int i = 0; FortuneTellerApp.methods.length > i; i++) {
			if(sSuffix.matches(FortuneTellerApp.methods[i])) {
				return i;
			}
		}
		return -1;
	}
	
	private static String getFortune()
	{
//		Display the user�s fortune in this format:
//
//			*[First Name]* *[Last Name]* will retire in *[# of years]* with *[bank balance]* in the bank,
//			a vacation home in *[location]*, and travel by *[mode of transporation]*.
//			Your program should be able to process input whether a user enters capital or lowercase letters.
		return String.format("*%s* *%s* will retire in *%d* years with *%s* in the bank, " + 
				"a vacation home in *%s*, and travel by *%s*.", FortuneTellerApp.getFirstName(), FortuneTellerApp.getLastName(),
				FortuneTellerApp.getRetirementYears(), FortuneTellerApp.getBankBalance(), FortuneTellerApp.getVacationHomeLocation(),
				FortuneTellerApp.getTransportationMode());
	}

}
