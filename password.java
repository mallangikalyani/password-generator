import java.util.*;
public class PasswordGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIALS = "~!@#$%^&*()";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Include special characters? (yes/no): ");
        boolean useSpecials = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean useNumbers = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.println("\nGenerated Password: " + generatePassword(length, useSpecials, useNumbers));
        scanner.close();
    }
    public static String generatePassword(int length, boolean useSpecials, boolean useNumbers) {
        if (length < 3) throw new IllegalArgumentException("Password length must be at least 3.");

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        
        for (int i = 1; i < length - 2; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        
        password.append(useNumbers ? NUMBERS.charAt(random.nextInt(NUMBERS.length())) 
                                  : CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        
        password.append(useSpecials ? SPECIALS.charAt(random.nextInt(SPECIALS.length())) 
                                   : CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        return password.toString();
    }
}