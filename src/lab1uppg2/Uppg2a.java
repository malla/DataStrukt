//Group 26
//Madeleine Appert 891110-4845
//Isabelle Frölich 900831-2846

package lab1uppg2;
import static java.lang.Math.*;

public class Uppg2a {
	static double answer;

	public static void main(String args[]){
		double sqr = 1000;
		double eps = pow(10,-6);
		answer=Uppg2a.binarySqrt(sqr,eps);
		System.out.println("Answers is : "+ answer + "\nMath.sqrt say "+ Math.sqrt(sqr));
	}

	private static double binarySqrt(double sqr, double eps) {
		//If value is smaller than one throw exception
		if(sqr<0){
			throw new IllegalArgumentException("Number bust be larger than 0");
		}
		double low = 1;
		double high = sqr;
		return help(sqr, eps, low, high);
	}

	private static double help(double sqr, double eps, double low, double high) {

		double temp = pow(((high - low) / 2) + low, 2);
		//If value is not in the interval set by epsilon start the recursion
		if (temp < sqr - eps || temp > sqr + eps) {
			if (temp < sqr) {
				low = ((high - low) / 2) + low;
			} else {
				high = ((high - low) / 2) + low;
			}
			help(sqr, eps, low, high);

			//If value is in the interval set by epsilon we set the answer
		} else if (temp > (sqr-eps) && temp < (sqr+eps)) {
			answer = ((high-low)/2)+low;
		}
		return answer;
	}
}

