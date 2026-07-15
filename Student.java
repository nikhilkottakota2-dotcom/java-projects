import java.util.Scanner;
class Student_details{
    int number;
    String name;
    String mobileNumber;
}

public class Student{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 2) {
            System.out.println("Enter the function you want to:");
            System.out.println("1. Add Student");
            System.out.println("2. Exit");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter how many students you want to add: ");
                    int n = sc.nextInt();
                    sc.nextLine(); // consume newline
                    Student_details[] students = new Student_details[n];

                    for (int i = 0; i < students.length; i++) {
                        students[i] = new Student_details();
                        System.out.println("------Enter Student " + (i + 1) + " details------");

                        System.out.print("Enter name of the student: ");
                        students[i].name = sc.nextLine();

                        System.out.print("Enter the roll number of the student: ");
                        students[i].number = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.print("Enter the mobile number of the student: ");
                        students[i].mobileNumber = sc.nextLine();
                        
                        System.out.println("------Student added succesfully------");
                    }
                    break;

                case 2:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}
