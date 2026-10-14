import java.util.Scanner;
public class HillCipher {
    static int[][] key;
    static int n;
    public static String encrypt(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "");
        // Padding with X
        while (text.length() % n != 0) {
            text += "X";
        }
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < text.length(); i += n) {
            int[] plain = new int[n];
            int[] result = new int[n];
            for (int j = 0; j < n; j++) {
                plain[j] = text.charAt(i + j) - 'A';
            }
            for (int r = 0; r < n; r++) {
                int sum = 0;
                for (int c = 0; c < n; c++) {
                    sum += key[r][c] * plain[c];
                }
                result[r] = sum % 26;
            }
            for (int j = 0; j < n; j++) {
                cipher.append((char)(result[j] + 'A'));
            }
        }
        return cipher.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matrix Size (2 or 3 or 4...): ");
        n = sc.nextInt();
        key = new int[n][n];
        System.out.println("Enter Key Matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                key[i][j]=sc.nextInt();
            }
        }
        sc.nextLine();
        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();
        String cipher = encrypt(text);
        System.out.println("Cipher Text : " + cipher);
        sc.close();
    }
}
