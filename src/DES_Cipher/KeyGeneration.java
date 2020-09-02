package DES_Cipher;

import static DES_Cipher.DES.input;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/* @author Mahmoud Esmat
 */
public class KeyGeneration {

    static Scanner input;

    //public static void main(String[] args) throws FileNotFoundException {
    public static void KeyGeneration(File keyFile, File keysFile) throws FileNotFoundException {
        //PrintWriter output = new PrintWriter(new File("My text files/Keys.txt"));
        PrintWriter output = new PrintWriter(keysFile);

        //input = new Scanner(new File("My text files/K.txt"));
        input = new Scanner(keyFile);
        int[] k = new int[64];

        String k_bin = Converter.hexToBin(input.next());
        input.close();
        for (int i = 0; i < k_bin.length(); i++) {
            k[i] = k_bin.charAt(i) - '0';
        }      
        System.out.println("k_bin = " + k_bin);
        int[] newK_1 = PC_1(k);

        int[] C0 = new int[28];
        int[] D0 = new int[28];

        for (int i = 0; i < 28; i++) {
            C0[i] = newK_1[i];
            D0[i] = newK_1[i + 28];
        }

        int[] C_r = new int[28];
        int[] D_r = new int[28];
        int[] k_r = new int[56];

        C_r = C0.clone();
        D_r = D0.clone();

        int j;
        for (int r = 1; r <= 16; r++) {
            if (r == 1 || r == 2 || r == 9 || r == 16) {
                j = 1;
            } else {
                j = 2;
            }

            C_r = circular_left_shift(C_r, j);
            D_r = circular_left_shift(D_r, j);
            
            String s1 = ""; String s2= "";
            for (int i = 0; i < 28; i++) {
            s1 += C_r[i];
            s2 += D_r[i];
            }
            System.out.println("C" + r + " = " + s1);
            System.out.println("D" + r + " = " + s2);
            for (int i = 0; i < 28; i++) {
                k_r[i] = C_r[i];
                k_r[i + 28] = D_r[i];
            }
            int[] newK_r_2 = PC_2(k_r);
            
            String k_rr = "";
            
            for (int i = 0; i < 48; i++) {
                k_rr += newK_r_2[i];
                System.out.print(newK_r_2[i] + " ");
            }
            System.out.println();
            output.println(Converter.binToHex(k_rr));
            
        }
        output.close();
    }

    public static int[] PC_1(int[] k) throws FileNotFoundException {
        int[][] PC_1 = new int[8][7];

        input = new Scanner(new File("My text files/PC_1.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    PC_1[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newK = new int[56];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                newK[i * 7 + j] = k[(PC_1[i][j] - 1)];
            }
        }

        return newK;
    }

    public static int[] PC_2(int[] k_r) throws FileNotFoundException {
        int[][] PC_2 = new int[6][8];

        input = new Scanner(new File("My text files/PC_2.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 8; j++) {
                    PC_2[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newK = new int[48];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                newK[i * 8 + j] = k_r[(PC_2[i][j] - 1)];
            }
        }

        return newK;
    }

    public static int[] circular_left_shift(int a[], int j) {
        int b[] = new int[a.length];
        int index;
        for (int i = 0; i < a.length; i++) {
            index = (i - j) % a.length;
            if (index < 0) {
                index += a.length;
            }
            b[index] = a[i];
        }
        return b;
    }
}

/*K1 = 000110 110000 001011 101111 111111 000111 000001 110010

For the other keys we have

K2 = 011110 011010 111011 011001 110110 111100 100111 100101
K3 = 010101 011111 110010 001010 010000 101100 111110 011001
K4 = 011100 101010 110111 010110 110110 110011 010100 011101
K5 = 011111 001110 110000 000111 111010 110101 001110 101000
K6 = 011000 111010 010100 111110 010100 000111 101100 101111
K7 = 111011 001000 010010 110111 111101 100001 100010 111100
K8 = 111101 111000 101000 111010 110000 010011 101111 111011
K9 = 111000 001101 101111 101011 111011 011110 011110 000001
K10 = 101100 011111 001101 000111 101110 100100 011001 001111
K11 = 001000 010101 111111 010011 110111 101101 001110 000110
K12 = 011101 010111 000111 110101 100101 000110 011111 101001
K13 = 100101 111100 010111 010001 111110 101011 101001 000001
K14 = 010111 110100 001110 110111 111100 101110 011100 111010
K15 = 101111 111001 000110 001101 001111 010011 111100 001010
K16 = 110010 110011 110110 001011 000011 100001 011111 110101*/
//K+ = 1111000 0110011 0010101 0101111 0101010 1011001 1001111 0001111 
//K = 00010011 00110100 01010111 01111001 10011011 10111100 11011111 11110001 
//C0 = 1111000 0110011 0010101 0101111
//D0 = 0101010 1011001 1001111 0001111
