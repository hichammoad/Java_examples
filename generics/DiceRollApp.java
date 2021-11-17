
import java.awt.Color;
import java.util.Random;


/*
	Generic class Dice that represents a dice :)
*/
class Dice<T> {
	
		// To save dice values:
		private T[] values;
		
		// Get current value of a dice:
		// we can also save the currentPosition as int
		private T currentValue; 
		
		// get current value of the dice:
		public T getCurrentValue() {
			return currentValue;
		}
		
		public Dice(T[] values) {
			// we initialize our array and we copy the values of the dice to the array:
			// we can also use : this.values = Arrays.copyOf(values, values.length);
			this.values = (T[]) new Object[values.length];
			for(int i = 0; i<values.length; i++) {
				this.values[i] = values[i];
			}
		}
		
		
		// get random value from the dice:
		public T rollDice() {
			Random random = new Random(); //we can also use Math.random()
			currentValue = values[random.nextInt(values.length)];
			return(currentValue);
		}
		
		/*  
		 	Compare the current dice values with other dice's values:
			we consider that the order of inserting values == importance. example: A > B > C > D.
		    otherwise, we can implement the Comparable interface and use compateTo method.
		 */
		public int hasWin(T otherDiceVal) {
			
			if(currentValue.equals(otherDiceVal)) {
				return(0);
			}
			
			for(int i = 0; i<values.length; i++) {
				if(values[i].equals(currentValue)) {
					return(1);
				}
				if(values[i].equals(otherDiceVal)) {
					return(-1);
				}
			}
			return(0);
		}
}


public class DiceRollApp {
	
	public static void main(String[] args) {
		
		String [] stringValues  = {"HEAD", "TAIL"};
		Dice<String> stringDice = new Dice<String>(stringValues); 
		String result1 = stringDice.rollDice();
		System.out.println(result1);
		
		Integer [] intValues = {1,2,3,4,5,6};
		Dice<Integer> intDice = new Dice<Integer>(intValues); 
		Integer result2 = intDice.rollDice();
		System.out.println(result2.toString());
		
		
		Character [] charValues  = {'A', 'B', 'C', 'A', 'B', 'C'};
		Dice<Character> charDice = new Dice<Character>(charValues); 
		Character result3 = charDice.rollDice();
		System.out.println(result3);
		
		Color [] colorValues = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
		Dice<Color> coloredDice = new Dice<Color>(colorValues); 
		Color result4 = coloredDice.rollDice();
		System.out.println(result4.toString());

		Dice<Character> charDice1 = new Dice<Character>(charValues); 
		Dice<Character> charDice2 = new Dice<Character>(charValues); 
		Character r1 = charDice1.rollDice();
		Character r2 = charDice2.rollDice();
		
		System.out.println(result3);
		
		System.out.println("Dice 1 = "+r1);
		System.out.println("Dice 2 = "+r2);
		System.out.println("is one winner? answer : "+charDice1.hasWin(r2));
	}
}

