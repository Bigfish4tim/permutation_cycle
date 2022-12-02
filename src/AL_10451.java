import java.io.*;
import java.util.*;

public class AL_10451 {
    static int T;
    static int N;
    static int[] map;
    static int count;

    public static int find(int x) {
        if(map[x] == x) return x;

        return find(map[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x==y) {
            count++;
        } else if(x>y) {
            map[x] = y;
        } else {
            map[y] = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N+1];
            count = 0;

            for(int j=1; j<N+1; j++) {
                map[j] = j;
            }

            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                int b = Integer.parseInt(st.nextToken());
                union(j, b);
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
