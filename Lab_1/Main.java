import java.util.Arrays;

public class Main {
    public static void main(String[] args){
    long startTime=System.nanoTime();
    compulsory();
    homework(args);
    long endTime=System.nanoTime();
    long totalTime=endTime-startTime;
    System.out.println("Time in nanosecs: " + totalTime);    //afisez timpul in nanosecunde
    }

    public static void compulsory(){
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
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }

    public static void homework(String[] args) {
        //Let n, p be two integers and C1,...,Cm a set of letters (the alphabet), all given as a command line arguments. Validate the arguments!
        int n, p;
        if (args.length < 3) {     //verific daca s-au dat cel putin 3 argumente
            System.out.println(
                    "Usage: number, number, one or more characters");
            System.exit(-1);
        }

            n = Integer.parseInt(args[0]);
            p = Integer.parseInt(args[1]);     //validez primele 2 argumente care sunt de tip int
            int m = args.length - 2;           //lungimea alfabetului = nr de argumente - primele 2
            char alphabet[] = new char[m];
            for (int i = 0; i < m; i++) {
                alphabet[i] = args[i + 2].charAt(0);    //iau primul caracter din ifecare argument dat incepand cu al 3lea
            }
            System.out.println("Alfabetul: ");
            System.out.println(Arrays.toString(alphabet));

        //Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.

        String[] words=new String[n];
        for(int i=0;i<n;i++)
        {
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<p;j++){
                int index=(int) (Math.random()*m);
                sb.append(alphabet[index]);          //creez un cuvant random folosind alfabetul dat
            }
            words[i]=(sb.toString());
        }
        System.out.println("Cuvintele: ");
        for (int k = 0; k < words.length;k++)
        {
            System.out.print(words[k] + " ");
        }

        System.out.println();
        System.out.println("Matricea: ");
        //Create a boolean n x n matrix, representing the adjacency relation of the words.
        int[][] matrice=new int[n][n];
        for(int i=0;i<n;i++){
            matrice[i][i]=1;
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<p;k++)
                    if(isNeighbour(words[i], words[j])==1)   //daca functia ce verifica daca 2 stringuri sunt "vecini" returneaza 1, atunci in matrice pe pozitia i,j pun 1, altfel 0
                        matrice[i][j]=1;
                else  matrice[i][j]=0;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrice[i][j]);
            }
            System.out.println();
        }

        //Create a data structure (using arrays) that stores the neighbours of each word.
        for(int i=0;i<n;i++){
            String[]vecini=new String[n];
            int index=0;
            for(int j=0;j<n;j++)
            {
                if(isNeighbour(words[i], words[j])==1 && i!=j)   //folosing functia isNeighbour, verific care sunt vecinii fiecarui cuvant si ii pun intr-un vector
                {vecini[index]=words[j]; index++;}
            }
            System.out.print(words[i]+" - vecini : ");
            for(int k=0;k< vecini.length;k++)
            {
                if(vecini[k]!=null)
                System.out.print(vecini[k]+" ");   //afisez vecinii fiecarui cuvant

            }
            System.out.println();
        }

        //For larger n display the running time of the application in nanoseconds.
        //long endTime = System.nanoTime();
        //System.out.println("Running time: " + endTime);

    }

    public static int isNeighbour(String s1, String s2){  //functie care verifica daca 2 stringuri sunt vecine
        for(int i=0;i<s1.length();i++) {
            for(int j=0;j<s2.length();j++)
                if((s1.charAt(i)==s2.charAt(j)))          //daca gasim cel putin 1 caracter comun in cele 2 cuvinte, returnam 1
                    return 1;
        }
        return 0;                                         //daca for-ul s-a terminat si nu am gasit niciun caracter identic in cele 2 stringuri, returnam 0
        }

};





