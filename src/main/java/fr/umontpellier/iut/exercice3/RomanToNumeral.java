package fr.umontpellier.iut.exercice3;

public class RomanToNumeral {



    // separate strings
    // indexOf(String str, int fromIndex), 	lastIndexOf(String str, int fromIndex), contains​(CharSequence s)

    // I	V	X	L	C	D	M
    // 1	5	10	50	100	500	1000

    //    d'abord les chiffres des milliers (à l'aide uniquement de M)
    //    puis les chiffres des centaines (à l'aide uniquement de C,D,M)
    //    puis les chiffres des dizaines (à l'aide uniquement de X,L,C)
    //    puis les chiffres des unités (à l'aide uniquement de I,V,X)

    static int getNumeral(String str) {
        String s = str + " ";

        int index = 0;
        int value = 0;

        // fonction s.charAt(index++) == 'M' qui renvoie OK -> index++, KO ou out of range -> -1

        if (s == null || s.length() == 0)
            return 0;

        while (s.charAt(index) == 'M') {
            value += 1000;
            index++;
//            if (index >= s.length())
//                return value;
        }

        switch (s.charAt(index)) {
//            Pénible de vérifier à chaque fois qu'on n'est pas à la fin de la chaine
//            Supposer pour simplifier que la chaine fini par un caractere autre que IVXDCLM ?
            case 'C':
                index ++;
                switch (s.charAt(index)){
                    case 'M': //900
                        index++;
                        value += 900;
                        break;
                    case 'C':
                        index++;
                        value += 200;
                        while (s.charAt(index) == 'C') {
                            value += 100;
                            index++;
                        }
//                        TODO : Vérifier qu'on n'a pas CCCC
                        break;
                    case 'D': //400
                        index++;
                        value += 400;
                        break;
                    default:
                        value += 100;
                        break;
                }
                break;
            case 'D':
                index++;
                value += 500;
                while (s.charAt(index) == 'C') {
                    index++;
                    value += 100;
                }
//                else {
//                    throw new RuntimeException("Mauvais format romain");
//                }
                break;
            default:
                break;
        }

        switch (s.charAt(index)) {
//            Pénible de vérifier à chaque fois qu'on n'est pas à la fin de la chaine
//            Supposer pour simplifier que la chaine fini par un caractere autre que IVXDCLM ?
            case 'X':
                index ++;
                switch (s.charAt(index)){
                    case 'C': //90
                        index++;
                        value += 90;
                        break;
                    case 'X':
                        index++;
                        value += 20;
                        while (s.charAt(index) == 'X') {
                            value += 10;
                            index++;
                        }
//                        TODO : Vérifier qu'on n'a pas CCCC
                        break;
                    case 'L': //40
                        index++;
                        value += 40;
                        break;
                    default:
                        value += 10;
                        break;
                }
                break;
            case 'L':
                index++;
                value += 50;
                while (s.charAt(index) == 'X') {
                    index++;
                    value += 10;
                }
//                else {
//                    throw new RuntimeException("Mauvais format romain");
//                }
                break;
            default:
                break;
        }

        switch (s.charAt(index)) {
//            Pénible de vérifier à chaque fois qu'on n'est pas à la fin de la chaine
//            Supposer pour simplifier que la chaine fini par un caractere autre que IVXDCLM ?
            case 'I':
                index ++;
                switch (s.charAt(index)){
                    case 'X': //9
                        index++;
                        value += 9;
                        break;
                    case 'I':
                        index++;
                        value += 2;
                        while (s.charAt(index) == 'I') {
                            value += 1;
                            index++;
                        }
//                        TODO : Vérifier qu'on n'a pas CCCC
                        break;
                    case 'V': //4
                        index++;
                        value += 4;
                        break;
                    default:
                        value += 1;
                        break;
                }
                break;
            case 'V':
                index++;
                value += 5;
                while (s.charAt(index) == 'I') {
                    index++;
                    value += 1;
                }
//                else {
//                    throw new RuntimeException("Mauvais format romain");
//                }
                break;
            default:
                break;
        }

        return value;
    }

    // I	V	X	L	C	D	M
    // 1	5	10	50	100	500	1000

    public static void main(String[] args) {
        String s = "MMMLX";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "LX";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "VIII";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "MCM";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "MDC";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "MCD";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "MCMXC";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "MDCLX";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

        s = "MCDXL";
        System.out.println(s + " : " + Integer.toString(getNumeral(s)));

//        System.out.println(Integer.toString(getNumeral("MLXIII")) + "\n");
//        System.out.println(Integer.toString(getNumeral("XXXIV")) + "\n");
    }
}
