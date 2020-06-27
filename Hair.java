package Hair;
import java.util.*;

public class Hair{
	static Random r = new Random();
	public static double meanLife = 4.5;/**mean life of a hair*/
	public static double sigmaLife = 0.4;/**stdev of life of a hair*/
	public static double rate = 12; /**growth rate in cm per year*/
	double age, length, lifeExp;
	boolean alive;
	
	/**creates a new hair*/
	public Hair() {
		age = 0;
		length = 0;
		lifeExp = Math.max(r.nextGaussian()*sigmaLife + meanLife, 0);
		alive = true;
	}

	/**gets age
 * 	@return double, age*/
	public double getAge() {
		return age;
	}

	/**gets length of hair
 *      @return double, length*/
        public double getLength() {
                return length;
        }

	 /**gets expected life of hair
 *      @return double, lifeExp*/
        public double getLifeExp() {
                return lifeExp;
        }

	/**cuts a hair to a certain length
 * 	@param goalLength double, the goal length, must be smaller than length
 * 	@return void*/
	public void cut(double goalLength) {
		if (goalLength >= 0 && goalLength <= length) {
			length = goalLength;
		}
	}

	/**grows a hair after a certain time
 *      @param t double, time elapsed
 *      @return void*/
        public void grow(double t) {
        	if (t >= 0) {
			double growTime = Math.min(t, lifeExp - age);/**actual time of growth!*/
                	length = length + rate*growTime;
			age = Math.min(lifeExp, age + t);
			if (age == lifeExp) {
				alive = false;/**hair dies!*/
			}
        	}
	}

	/**checks if a hair is alive
 * 	@return boolean, alive */
	public boolean isAlive() {
		return alive;
	}
}
