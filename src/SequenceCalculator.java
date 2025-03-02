import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SequenceCalculator {

    public static String stringInput(){
        String input="";
        File file=new File("file.txt");
        Scanner scanner=null;

        try {
            scanner=new Scanner(file);
            input=scanner.next();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please enter a number string:");
            scanner=new Scanner(System.in);
            input=scanner.next();

        }finally {
            if(scanner!=null){
                scanner.close();
            }
        }
        return input;
    }



    public static int computeSequence(String input){
        try {
            boolean isDigitOnly=input.chars().allMatch(Character::isDigit);
            if (input.length()<2 || !isDigitOnly){
                throw new IllegalArgumentException("Characters must be number and at least two characters long");
            }

            int sum=0;
            for (int i=0;i<input.length()-1;i++){
                sum+=Character.getNumericValue(input.charAt(i));
            }

            int lastDigit=Character.getNumericValue(input.charAt(input.length()-1));
            if (lastDigit==0){
                throw new ArithmeticException("Division by zero is not allowed.");
            }

            return sum/lastDigit;

        }catch (IllegalArgumentException | ArithmeticException e){
            e.printStackTrace();

            return -1;
        }
    }
}
