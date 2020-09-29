package fr.umontpellier.iut.exercice2;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    
    public List<Integer> computeFactors(int number) {

        if (number == 0)
            return new ArrayList<Integer>();

        List<Integer> factors = new ArrayList<Integer>();
        int nn = number;
        for (int i = 2; i <= nn; i++){
            while (number % i == 0) {
                factors.add(i);
                number = number / i;
            }
            if (number == 1)
                break;
        }
        return factors;
    }
}
