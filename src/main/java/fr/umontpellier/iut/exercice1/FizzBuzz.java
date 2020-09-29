package fr.umontpellier.iut.exercice1;

public class FizzBuzz {

    public String getValue(int i){
        String str = "";
        if (i % 3 == 0)
            str += "Fizz";
        if (i % 5 == 0)
            str += "Buzz";
        if (str.length() == 0)
            str = Integer.toString(i);
        return str;
    }

    public String[] computeList(int n){
        String[] str_l = new String[n];
        for (int i = 0 ; i < n; i++){
            str_l[i] = getValue(i+1);
        }
        return str_l;
    }
}
