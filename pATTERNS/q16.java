import java.util.Scanner;

public class q16 {
    public static void main(String []args){
        Scanner sc =new Scanner (System.in);
        int n= sc.nextInt();
        int space =n-1;
        int temp =n;


        for(int i=0;i<n;i++){ int x =space;
            int y=temp;


            while(x>0){
                System.out.print("\t");
                x--;
            }
            while(y>0) {
                System.out.print("*\t");
                y--;
            }

            space-=1;
            temp--;
            System.out.println();
        }

        space =1;
        temp=2;

        for(int i=0;i<n;i++){ int x =space;
            int y=temp;


            while(x>0){
                System.out.print("\t");
                x--;
            }
            while(y>0) {
                System.out.print("*\t");
                y--;
            }

            space++;
            temp++;
            System.out.println();
        }
    }
}
