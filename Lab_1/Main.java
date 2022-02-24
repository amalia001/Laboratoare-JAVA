import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        //Display on the screen the message "Hello World!". Run the application.
        System.out.println("Hello, world!");

        //Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript",
        // "PHP", "Swift", "Java"}
        String[] languages=new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        System.out.println(Arrays.toString(languages));

        //Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
        int n=(int) (Math.random()*1_000_000);
        System.out.println(n);

        //multiply n by 3;
        n=n*3;

        //  add the binary number 10101 to the result;
        int decimal=Integer.parseInt("10101" ,2);
        n=n+decimal;

        //  add the hexadecimal number FF to the result;
        int hexadecimal=Integer.parseInt("FF" ,16);
        n=n+hexadecimal;

        //  multiply the result by 6;
        int result=n*6;
        System.out.println(result);

       // Compute the sum of the digits in the result obtained in the previous step. This is the new result.
        // While the new result has more than one digit, continue to sum the digits of the result.
        int sum=0;
            while(result!=0){
                sum=sum+result%10;
                result/=10;
            }
            System.out.println(sum);
            result=sum;
            sum=0;
            while(result>0){
                sum=sum+result%10;
                result=result/10;
        }
        System.out.println(sum);

        //Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].
        System.out.println("Willy-nilly, this semester I will learn" + languages[sum]);

    }
}




