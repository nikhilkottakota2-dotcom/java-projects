import java.util.Scanner;
public class Matadd{
    public static void main(String[]args){
        int a[][] = new int[3][3];
        int b[][] = new int[3][3];
        int c[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        System.out.println("Enter elemnts of matrix A:");
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Elements of Matrix B:");
        
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                b[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j]+"\t");
            }
            System.out.println();
        }
        sc.close();

    }
}