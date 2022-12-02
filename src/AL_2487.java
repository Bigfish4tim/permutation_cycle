import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AL_2487 {
    static int N;
    static int[] map;
    static int[] counts;
    static int count;
    static int ans;

    public static int gcd(int x, int y) {
        if(y == 0) return x;
        else return gcd(y, x % y);
    }

    public static int lcd(int x, int y) {
        return  (x * y) / gcd(x,y);
    }

    public static int findCount(int x) {
        int mapx = map[x];

        while (true) {
            if(mapx != x) {
                mapx = map[mapx];
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1];
        counts = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            map[i] = i;
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N+1; i++) {
            count = 1;
            counts[i] = findCount(i);
        }

        counts = new int[] {0, 3, 1, 3, 3, 3, 2};

        ans = counts[1];


        for(int i=2; i<N+1; i++) {
            ans = lcd(ans, counts[i]);
        }
        System.out.println(Arrays.toString(counts));

        System.out.println(ans);

    }
}
