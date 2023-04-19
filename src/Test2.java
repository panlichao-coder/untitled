import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        long a = 0L;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] tmp = new int[m];
        int[] start = new int[m];
        int[] end = new int[m];
        for(int i = 0; i < m;i++){
            tmp[i] = sc.nextInt();
        }
        for(int i = 0; i < m;i++){
            start[i] = sc.nextInt();
        }
        for(int i = 0; i < m;i++){
            end[i] = sc.nextInt();
        }
        for(int i = 0; i < m;i++){
            int tmp1 = tmp[i];
            int start1 = start[i];
            int end1 = end[i];
            if(tmp1 == 1){
                int res = 0;
                for(int j = start1 - 1; j < end1;j++){
                    res += arr[j];
                }
                System.out.print(res + " ");
            }
            if(tmp1 == 0){
                arr[start1 - 1] = end1;
            }
        }

    }
}
