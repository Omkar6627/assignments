import java.util.Scanner;

public class q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int space =n/2;
        int star=1;
        for(int i=0;i<=n/2;i++){
            int x= space;
            int y= star;
          while(x >0){
              System.out.print("\t");
x--;
          }
          while(y>0){
              System.out.print("*\t");
              y--;
          }
          space--;
          star+=2;
          System.out.println();
        }
        space =1;
        star=n-2;
        for(int i=1;i<=n/2;i++){
            int x= space;
            int y= star;
            while(x >0){
                System.out.print("\t");
                x--;
            }
            while(y>0){
                System.out.print("*\t");
                y--;
            }
            space++;
            star-=2;
            System.out.println();
        }
    }
}