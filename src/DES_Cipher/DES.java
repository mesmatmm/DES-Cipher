package DES_Cipher;

import static DES_Cipher.KeyGeneration.input;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.naming.BinaryRefAddr;

/**
 *
 * @author Mahmoud Esmat
 */
public class DES {

    static Scanner input;

    //public static void main(String[] args) throws FileNotFoundException {
    public static void DES(File keysFile, File inputFile, File outputFile) throws FileNotFoundException {
        // PrintWriter output = new PrintWriter(new File("My text files/C.txt"));
        PrintWriter output = new PrintWriter(outputFile);

//        PrintWriter output2 = new PrintWriter(new File("My text files/Reverse_keys.txt"));
        //input = new Scanner(new File("My text files/M.txt"));
        input = new Scanner(inputFile);
        int[] m = new int[64];
        String m_bin = Converter.hexToBin(input.next());
        input.close();
        for (int i = 0; i < m_bin.length(); i++) {
            m[i] = m_bin.charAt(i) - '0';
        }

        //input = new Scanner(new File("My text files/Keys.txt"));
        input = new Scanner(keysFile);
        int[] keys;
        String keys_bin = "";
        keys = new int[16 * 48];
        while (input.hasNext()) {
            keys_bin += Converter.hexToBin(input.nextLine());

        }
        input.close();
        for (int i = 0; i < keys_bin.length(); i++) {
            keys[i] = keys_bin.charAt(i) - '0';
        }

        int[] k1 = new int[48];
        int[] k2 = new int[48];
        int[] k3 = new int[48];
        int[] k4 = new int[48];
        int[] k5 = new int[48];
        int[] k6 = new int[48];
        int[] k7 = new int[48];
        int[] k8 = new int[48];
        int[] k9 = new int[48];
        int[] k10 = new int[48];
        int[] k11 = new int[48];
        int[] k12 = new int[48];
        int[] k13 = new int[48];
        int[] k14 = new int[48];
        int[] k15 = new int[48];
        int[] k16 = new int[48];

        for (int i = 0; i < 48; i++) {
            k1[i] = keys[i];
            k2[i] = keys[i + 48];
            k3[i] = keys[i + 48 * 2];
            k4[i] = keys[i + 48 * 3];
            k5[i] = keys[i + 48 * 4];
            k6[i] = keys[i + 48 * 5];
            k7[i] = keys[i + 48 * 6];
            k8[i] = keys[i + 48 * 7];
            k9[i] = keys[i + 48 * 8];
            k10[i] = keys[i + 48 * 9];
            k11[i] = keys[i + 48 * 10];
            k12[i] = keys[i + 48 * 11];
            k13[i] = keys[i + 48 * 12];
            k14[i] = keys[i + 48 * 13];
            k15[i] = keys[i + 48 * 14];
            k16[i] = keys[i + 48 * 15];
        }

        
        int[] newM = IP(m);

        int[] L0 = new int[32];
        int[] R0 = new int[32];

        for (int i = 0; i < 32; i++) {
            L0[i] = newM[i];
            R0[i] = newM[i + 32];
        }

        int[] temp = new int[32];

        for (int i = 1; i <= 16; i++) {

            for (int j = 0; j < 32; j++) {
                temp[j] = L0[j];
            }

            for (int j = 0; j < 32; j++) {
                L0[j] = R0[j];
            }

            if (i == 1) {
                int[] F_R_k = F(R0, k1);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }

            } else if (i == 2) {
                int[] F_R_k = F(R0, k2);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 3) {
                int[] F_R_k = F(R0, k3);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 4) {
                int[] F_R_k = F(R0, k4);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 5) {
                int[] F_R_k = F(R0, k5);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 6) {
                int[] F_R_k = F(R0, k6);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 7) {
                int[] F_R_k = F(R0, k7);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 8) {
                int[] F_R_k = F(R0, k8);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 9) {
                int[] F_R_k = F(R0, k9);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 10) {
                int[] F_R_k = F(R0, k10);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 11) {
                int[] F_R_k = F(R0, k11);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 12) {
                int[] F_R_k = F(R0, k12);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 13) {
                int[] F_R_k = F(R0, k13);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 14) {
                int[] F_R_k = F(R0, k14);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else if (i == 15) {
                int[] F_R_k = F(R0, k15);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            } else {
                int[] F_R_k = F(R0, k16);
                for (int j = 0; j < 32; j++) {
                    R0[j] = temp[j] ^ F_R_k[j];
                }
            }
        }

        int[] R16_conc_L16 = new int[64];
        for (int i = 0; i < 32; i++) {
            R16_conc_L16[i] = R0[i];
            R16_conc_L16[i + 32] = L0[i];
        }

        int[] C = IP_1(R16_conc_L16);

        String C_bin = "";
//        int decimal = toDecimal(C);
        for (int i = 0; i < 64; i++) {
            //s = Integer.toHexString(101);
            if (i % 8 == 0) {
                System.out.print("  ");
                //output.print("  ");
            }

            System.out.print(C[i] + " ");
            C_bin += C[i];

        }
        output.print(Converter.binToHex(C_bin));
        output.close();

    }

    public static int[] IP(int[] m) throws FileNotFoundException {
        int[][] IP = new int[8][8];

        input = new Scanner(new File("My text files/IP.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    IP[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newM = new int[64];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newM[i * 8 + j] = m[(IP[i][j] - 1)];
            }
        }

        return newM;
    }

    public static int[] F(int[] R, int[] k) throws FileNotFoundException {
        int[] newR = E(R);

        for (int i = 0; i < 48; i++) {
            newR[i] = newR[i] ^ k[i];
        }

        int[] newR_after_SBs = new int[32];
        for (int i = 1; i <= 8; i++) {
            int[] temp;
            if (i == 1) {
                temp = S1(new int[]{newR[0], newR[1], newR[2], newR[3], newR[4], newR[5]});
            } else if (i == 2) {
                temp = S2(new int[]{newR[6], newR[7], newR[8], newR[9], newR[10], newR[11]});
            } else if (i == 3) {
                temp = S3(new int[]{newR[12], newR[13], newR[14], newR[15], newR[16], newR[17]});
            } else if (i == 4) {
                temp = S4(new int[]{newR[18], newR[19], newR[20], newR[21], newR[22], newR[23]});
            } else if (i == 5) {
                temp = S5(new int[]{newR[24], newR[25], newR[26], newR[27], newR[28], newR[29]});
            } else if (i == 6) {
                temp = S6(new int[]{newR[30], newR[31], newR[32], newR[33], newR[34], newR[35]});
            } else if (i == 7) {
                temp = S7(new int[]{newR[36], newR[37], newR[38], newR[39], newR[40], newR[41]});
            } else {
                temp = S8(new int[]{newR[42], newR[43], newR[44], newR[45], newR[46], newR[47]});
            }

            for (int j = 0; j < 4; j++) {
                newR_after_SBs[(i - 1) * 4 + j] = temp[j];
            }
        }

        return P(newR_after_SBs);
    }

    public static int[] E(int[] R) throws FileNotFoundException {
        int[][] E = new int[8][6];

        input = new Scanner(new File("My text files/E.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 6; j++) {
                    E[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[48];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                newR[i * 6 + j] = R[(E[i][j] - 1)];
            }
        }

        return newR;
    }

    public static int[] S1(int[] R) throws FileNotFoundException {
        int[][] S1 = new int[4][16];

        input = new Scanner(new File("My text files/S1.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S1[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S1[row][column]);

        return newR;
    }

    public static int[] S2(int[] R) throws FileNotFoundException {
        int[][] S2 = new int[4][16];

        input = new Scanner(new File("My text files/S2.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S2[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S2[row][column]);

        return newR;
    }

    public static int[] S3(int[] R) throws FileNotFoundException {
        int[][] S3 = new int[4][16];

        input = new Scanner(new File("My text files/S3.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S3[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S3[row][column]);

        return newR;
    }

    public static int[] S4(int[] R) throws FileNotFoundException {
        int[][] S4 = new int[4][16];

        input = new Scanner(new File("My text files/S4.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S4[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S4[row][column]);

        return newR;
    }

    public static int[] S5(int[] R) throws FileNotFoundException {
        int[][] S5 = new int[4][16];

        input = new Scanner(new File("My text files/S5.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S5[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S5[row][column]);

        return newR;
    }

    public static int[] S6(int[] R) throws FileNotFoundException {
        int[][] S6 = new int[4][16];

        input = new Scanner(new File("My text files/S6.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S6[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S6[row][column]);

        return newR;
    }

    public static int[] S7(int[] R) throws FileNotFoundException {
        int[][] S7 = new int[4][16];

        input = new Scanner(new File("My text files/S7.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S7[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S7[row][column]);

        return newR;
    }

    public static int[] S8(int[] R) throws FileNotFoundException {
        int[][] S8 = new int[4][16];

        input = new Scanner(new File("My text files/S8.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 16; j++) {
                    S8[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[4];

        int row, column;
        row = toDecimal(new int[]{R[0], R[5]});
        column = toDecimal(new int[]{R[1], R[2], R[3], R[4]});

        newR = toBinary(S8[row][column]);

        return newR;
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

    public static int[] P(int[] R) throws FileNotFoundException {
        int[][] P = new int[4][8];

        input = new Scanner(new File("My text files/P.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    P[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newR = new int[32];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                newR[i * 8 + j] = R[(P[i][j] - 1)];
            }
        }

        return newR;
    }

    public static int[] IP_1(int[] m) throws FileNotFoundException {
        int[][] IP_1 = new int[8][8];

        input = new Scanner(new File("My text files/IP_1.txt"));
        while (input.hasNext()) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    IP_1[i][j] = input.nextInt();
                }
            }
        }
        input.close();

        int[] newM = new int[64];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newM[i * 8 + j] = m[(IP_1[i][j] - 1)];
            }
        }

        return newM;
    }
}

// IP-1 = 10000101 11101000 00010011 01010100 00001111 00001010 10110100 00000101
// R16L16 = 00001010 01001100 11011001 10010101 01000011 01000010 00110010 00110100
//L0 = 1100 1100 0000 0000 1100 1100 1111 1111 
//R0 = 1111 0000 1010 1010 1111 0000 1010 1010
//f(R0 , K1 ) = 0010 0011 0100 1010 1010 1001 1011 1011 
// ER0 =  011110 100001 010101 010101 011110 100001 010101 010101 
// S1(B1)S2(B2)S3(B3)S4(B4)S5(B5)S6(B6)S7(B7)S8(B8) = 0101 1100 1000 0010 1011 0101 1001 0111
// R1 == 1110 1111 0100 1010 0110 0101 0100 0100
//L1 = R0 = 1111 0000 1010 1010 1111 0000 1010 1010 
//C = 85E813540F0AB405.

