import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int m = arr.length;
        int[] data = new int[m];
        int[] index = new int[m+1];
        int[] visited = new int[m+1];
        for(int k = 0 ; k < m; k++){
            data[k] = Integer.valueOf(arr[k]);
            index[data[k]] = k + 1;
        }
        int ans = 0;
        for(int k = 0 ; k < m; k++){
            int t = data[k];
            if(visited[t] == 1){
                continue;
            }
            visited[t] = 1;
            int p = index[t];
            while(t != p){
                visited[p] = 1;
                p = index[p];
                ans++;
            }
        }
        System.out.println(ans);

    }
}


