import java.util.Scanner;

public class q20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

     int space =n/2;
     int star =1;
        for(int i = 0;i<n/2;i++)
        {     int x= space;
            int y= star;
           while(x>0){
               System.out.print("\t");
               x--;
           }
            while(y>0){
                if(y==star|| y==1)
                System.out.print("*\t");
                else  System.out.print("\t");
                y--;
            }

         space--;
            star+=2;
            System.out.println();
        }
        space =0;
        star= n;
        for(int i = 0;i<n/2+1;i++)
        {     int x= space;
            int y= star;
            while(x>0){
                System.out.print("\t");
                x--;
            }
            while(y>0){
                if(y==star|| y==1)
                    System.out.print("*\t");
                else  System.out.print("\t");
                y--;
            }

            space++;
            star-=2;
            System.out.println();
        }
    }
}