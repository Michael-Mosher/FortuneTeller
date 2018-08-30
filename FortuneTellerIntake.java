package src.test.java;
//import org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import org.junit.Test;

public class FortuneTellerIntake {
	
	public FortuneTellerIntake()
	{
		super();
	}
	
	public void promptFirstName()
	{
		System.out.println("Your first name: ");
	}
	
	/**
	 * Will push to console confirmation of the intended submission.
	 * @param input
	 * @param sMethodSuffix The current task as String suffix.
	 * @param sMethodPrefix The prefix to the method that will parse a raw input string for the given suffix
	 */
	public void confirmFirstName(String input, String sMethodSuffix, String sMethodPrefix)
	{
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
			String s = sMethodPrefix + sMethodSuffix;
			Method m = oClass.getDeclaredMethod(s, String.class);
			Optional<String> test = Optional.ofNullable(String.valueOf(m.invoke(null, input)));
			String oOptionalOutput = test.orElse("");
			System.out.printf("The first name is %s. Is that corrrect? (yes or no)\n", String.join("",String.join("", oOptionalOutput.split("Optional\\[")).split("\\]"))); //oParsed.valueOf());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
	}
	
	public void promptLastName()
	{
		System.out.println("Your last name: ");
	}
	
	public void confirmLastName(String input, String sMethodSuffix, String sMethodPrefix)
	{
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
			String s = sMethodPrefix + sMethodSuffix;
			Method m = oClass.getDeclaredMethod(s, String.class);
			Optional<String> test = Optional.ofNullable(String.valueOf(m.invoke(null, input)));
			String oOptionalOutput = test.orElse("");
			System.out.printf(
					"The last name is %s. Is that corrrect? (yes or no)\n",
					String.join("",String.join("", oOptionalOutput.split("Optional\\[")).split("\\]"))
			);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
	}
	
	public void promptAge()
	{
		System.out.println("Your age: ");
	}
	
	public void confirmAge(String input, String sMethodSuffix, String sMethodPrefix)
	{
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
			String s = sMethodPrefix + sMethodSuffix;
			Method m = oClass.getDeclaredMethod(s, String.class);
			Optional<Short> test = (Optional<Short>)m.invoke(null, input); //((Optional<Short>)m.invoke(null, input)).orElse((short)-1);
			System.out.printf("The age is %d. Is that corrrect? (yes or no)\n", test.orElse((short)-1));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
	}
	
	public void promptBirthMonth()
	{
		System.out.println("Your birth month number, starting with 1 for January to 12 for December: ");
	}
	
	public void confirmBirthMonth(String input, String sMethodSuffix, String sMethodPrefix)
	{
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
			String s = sMethodPrefix + sMethodSuffix;
			Method m = oClass.getDeclaredMethod(s, String.class);
			Optional<Short> test = (Optional<Short>)m.invoke(null, input);
			System.out.printf("The birth month number is %d. Is that corrrect? (yes or no)\n", test.orElse((short)-1));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
	}
	
	public void promptColor()
	{
		System.out.println("What is your favorite ROYGBIV color: ");
	}
	
	public void confirmColor(String input, String sMethodSuffix, String sMethodPrefix)
	{
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
			String s = sMethodPrefix + sMethodSuffix;
			Method m = oClass.getDeclaredMethod(s, String.class);
			Optional<String> test = Optional.ofNullable(String.valueOf(m.invoke(null, input)));
			String oOptionalOutput = test.orElse("");
			System.out.printf(
					"The first name is %s. Is that corrrect? (yes or no)\n",
					String.join("",String.join("", oOptionalOutput.split("Optional\\[")).split("\\]"))
			);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
	}
	
	public void promptHelpColor()
	{
		/**
		 * What is your favorite ROYGBIV color?
 Help
 The ROYGBIV colors are red, orange, yellow, green, blue, indigo, violet.
 Help
 The ROYGBIV colors are red, orange, yellow, green, blue, indigo, violet.
 Blue
		 */
		System.out.println("The ROYGBIV colors are red, orange, yellow, green, blue, indigo, violet.");
	}
	
	public void promptSiblingQty()
	{
		System.out.println("Your number of siblings: ");
	}
	
	public void confirmSiblingQty(String input, String sMethodSuffix, String sMethodPrefix)
	{
		try {
			final Class<?> oClass = Class.forName("FortuneTeller");
			String s = sMethodPrefix + sMethodSuffix;
			Method m = oClass.getDeclaredMethod(s, String.class);
			Optional<Short> test = (Optional<Short>)m.invoke(null, input);
			System.out.printf("The number of siblings is %d. Is that corrrect? (yes or no)\n", test.orElse((short)-1));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(NoSuchMethodException eNoSuch) {
			eNoSuch.printStackTrace();
		} catch(InvocationTargetException eInvocationTargetException) {
			eInvocationTargetException.printStackTrace();
		} catch (IllegalAccessException eAccess) {
			eAccess.printStackTrace();
		}
	}
	
	public boolean isSufficientInputFirstName(String input)
	{
		return this.parseRawFirstName(input).orElse("").length()>0;
	}
	
	public Optional<String> parseRawFirstName(String input)
	{
		String payload = input.replaceAll("[^a-z'A-Z ]", "");
		if(payload.length()==0) {
			return java.util.Optional.ofNullable(null);
		}
		return java.util.Optional.ofNullable(payload);
	}
	
	public boolean isSufficientInputLastName(String input)
	{
		return this.parseRawLastName(input).orElse("").length() > 0;
	}
	
	public Optional<String> parseRawLastName(String input)
	{
		String payload = input.replaceAll("[^a-z'A-Z ]", "");
		if(payload.length()==0) {
			return java.util.Optional.ofNullable(null);
		}
		return java.util.Optional.ofNullable(payload);
	}
	
	public boolean isSufficientInputAge(String input)
	{
		return ((Optional<Short>)this.parseRawAge(input)).orElse((short)-1) > -1;
	}
	
	public Optional<Short> parseRawAge(String input)
	{
		String payload = input.replaceAll("[^0-9.]", "");
		if(payload.length()==0) {
			return java.util.Optional.ofNullable(null);
		}
		return java.util.Optional.ofNullable(FortuneTellerIntake.floatToShort(Float.parseFloat(payload)));
	}
	
	public boolean isSufficientInputBirthMonth(String input)
	{
		return this.parseRawBirthMonth(input).orElse(Short.valueOf((short) -1)) >0
				&& this.parseRawBirthMonth(input).orElse(Short.valueOf((short)-1)) < 13;
	}
	
	public Optional<Short> parseRawBirthMonth(String input)
	{
		String payload = input.replaceAll("[^0-9.]", "");
		if(payload.length()==0) {
			return java.util.Optional.ofNullable(null);
		}
		return java.util.Optional.ofNullable(FortuneTellerIntake.floatToShort(Float.parseFloat(payload)));
	}

	
	public boolean isSufficientInputColor(String input)
	{
		return this.parseRawColor(input).orElse("").toLowerCase().matches("red")
				|| this.parseRawColor(input).orElse("").toLowerCase().matches("orange")
				|| this.parseRawColor(input).orElse("").toLowerCase().matches("yellow")
				|| this.parseRawColor(input).orElse("").toLowerCase().matches("green")
				|| this.parseRawColor(input).orElse("").toLowerCase().matches("blue")
				|| this.parseRawColor(input).orElse("").toLowerCase().matches("indigo")
				|| this.parseRawColor(input).orElse("").toLowerCase().matches("violet");
	}
	
	public Optional<String> parseRawColor(String input)
	{
		String payload = input.replaceAll("[^a-z'A-Z ]", "");
		if(payload.length()==0) {
			return java.util.Optional.ofNullable(null);
		}
		return java.util.Optional.ofNullable(payload);
	}
	
	private boolean isSufficientInputSiblingQty(String input)
	{
		return this.parseRawSiblingQty(input).orElse((short)-1)>-1;
	}
	
	private Optional<Short> parseRawSiblingQty(String input)
	{
		String payload = input.replaceAll("[^0-9.]", "");
		if(payload.length()==0) {
			return java.util.Optional.ofNullable(null);
		}
		return java.util.Optional.ofNullable(FortuneTellerIntake.floatToShort(Float.parseFloat(payload)));
	}
	
	public static short floatToShort(float x) {
	  if (x < Short.MIN_VALUE) {
	    return Short.MIN_VALUE;
	  }
	  if (x > Short.MAX_VALUE) {
	    return Short.MAX_VALUE;
	  }
	  return (short) Math.round(x);
	}
	
}
