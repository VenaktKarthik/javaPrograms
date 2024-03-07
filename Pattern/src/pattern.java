import java.util.Scanner;

public class pattern {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("   ");
            }
            for(int k=0;k<i;k++){
                System.out.print("*  ");
            }
            System.out.print("\n");
        }
    }
}