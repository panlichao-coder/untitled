import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Test{
    public static void radixSort(int[] arr){
        //获取arr中的最大数max，根据max的位数确定排序次数
        //获取arr中的最小数min，数组全体减去min来消除负数的影响
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i : arr) {
            if(max<i) max=i;
            if(min>i) min=i;
        }
        //把数组中所有数都减去min，去除负数
        for (int i = 0; i < arr.length; i++) {
            arr[i]-=min;
        }
        //max相应地也减去min，根据max找出基数排序需要的次数
        max-=min;
        int count=0;
        while(max!=0){
            count++;
            max/=10;
        }
        //0-9十个数字，准备十个桶
        int[] bucket[]=new int[10][arr.length];
        int n=1;
        //总共要进行count次排序
        while(count>0){
            //elementcount[i]用于统计存放余数为i的桶中元素个数，每次循环都重置为0
            int elementcount[]=new int[10];
            //将数组中的数,先除以n，再对10取余，根据余数依次放入相应的桶中
            for(int i=0;i<arr.length;i++){
                int digit=arr[i]/n%10;
                bucket[digit][elementcount[digit]]=arr[i];
                elementcount[digit]++;
            }
            //把木桶中的数重新放回数组
            int index=0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j <elementcount[i]; j++) {
                    arr[index++]=bucket[i][j];
                }
            }
            count--;
            n*=10;
        }
        //之前数组全体减去min，排序完成记得加回来
        for (int i = 0; i < arr.length; i++) {
            arr[i]+=min;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length;i++){
            arr[i] = sc.nextInt();
        }
        radixSort(arr);
        int sum = 0;
        for(int i = 0;i < arr.length-1;i++){
            sum += Math.abs(arr[i] - arr[i+1]);

        }
        System.out.println(sum);

    }
}

