/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DES_Cipher;

import java.math.BigInteger;

/**
 *
 * @author Mahmoud Esmat
 */
public class Converter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        int x ,y = 5;
//        System.out.print(x + " " + y);
//        System.out.println("toDecimal({1,1, 0, 1}) = " + toDecimal(new int[]{ 0,1,0,1,0,1,0,0,0,0,0,0,1,1,1,1,
//            0,0,0,0,1,0,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,1}));
        System.out.println(hexToBin("0f1571c947d9e859"));
        String s = hexToBin("0f1571c947d9e859");
        System.out.println(binToHex(s) + " --" + s.length());
        System.out.println("toDecimal({1,1, 0, 1}) = " + Integer.parseInt("13", 16));

        int[] b = toBinary(13);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }

    public static int toDecimal(int[] b) {
        int decimal = 0;
        for (int i = b.length - 1, j = 0; i >= 0; i--, j++) {
            decimal = decimal + (b[i] * (int) Math.pow(2, j));
        }
        return decimal;
    }

    public static int[] toBinary(int d) {
        int[] value = {0, 0, 0, 0};
        int i = 3;
        while (d != 0) {
            int single = d % 2;
            if (single == 0) {
                value[i] = 0;
            } else {
                value[i] = 1;
            }
            i--;
            d = d / 2;
        }
        return value;

    }

    public static String binToHex(String s) {
        String r;
        String result = "";
        for (int i = 0; i < s.length(); i += 4) 
            result += new BigInteger(s.substring(i, i + 4), 2).toString(16);
        return result;
    }
    
    public static String hexToBin(String s) {
        String r;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            r = new BigInteger(s.charAt(i) + "", 16).toString(2);
        while (r.length() != 4) {
            r = "0" + r;
        }
        result +=r;
        }
        return result;
    }
}
