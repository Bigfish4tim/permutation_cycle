import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AL_2487 {
    static int N;
    static int[] map;
    static int[] counts;
    static int ans;
    static boolean[] visit;

    public static int gcd(int x, int y) {
        if(y == 0) return x;
        else return gcd(y, x % y);
    }

    public static int lcd(int x, int y) {
        return  (x * y) / gcd(x,y);
    }

    public static int findCount(int x) {
        int mapx = map[x];
        int count = 1;

        while (true) {
            if(x == mapx)
                return count;
            visit[mapx] = true;
            mapx = map[mapx];
            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        counts = new int[N+1];
        visit = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            map[i] = i;
            map[i] = Integer.parseInt(st.nextToken());
        }

        ans = 1;
        for(int i=1; i<N+1; i++) {
            if(visit[i]) continue;
            ans = lcd(ans, findCount(i));
        }

        System.out.println(ans);

    }
}
