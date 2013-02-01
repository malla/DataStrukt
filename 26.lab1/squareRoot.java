// TDA416 Madeleine Appert and Isabelle Frölich Group 26

import static java.lang.Math.*;

public class squareRoot {
	static double answer = 0;

	static double binarySqrt(double sqr, double eps) {
		double low = 0;
		double high = 0;
		
		//If value is smaller than one throw exception
		if(sqr<0){
			throw new IllegalArgumentException("Number bust be larger than 0");
		}
		//Since we call help with a low and high value already known we start by initializing them 
		double start = pow((((sqr - 1) / 2) + 1), 2);
		if (start < sqr) {
			low = (((sqr - 1) / 2) + 1);
			high = sqr;
		} else {
			low = 0;
			high = (((sqr - 1) / 2) + 1);
		}

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
		} else if (temp > sqr - eps && temp < sqr + eps) {
			answer = ((high-low)/2)+low;
		}

		System.out.println(answer);

		return answer;
	}

}
