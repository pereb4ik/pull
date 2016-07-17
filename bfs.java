import java.util.*;

public class bfs {
    /**
     * m - vertices(array of adjacency)
     * search the least way from vert a to vert b
     */
    static int bfs(int m[][], int a, int b) {
        int n = m.length;
        Queue<Integer> q = new LinkedList<>();
        /**
         * q - queue of vert
         */
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = -1;
        }
        dist[a] = 0;
        q.add(a);
        while (q.size() != 0) {
            int cur = q.remove();
            for (int i = 0; i < n; i++) {
                if (m[cur][i] == 1) {
                    if (dist[i] == 0) {
                        dist[i] = dist[cur] + 1;
                        q.add(i);
                    } else {
                        if (dist[i] > dist[cur] + 1) {
                            dist[i] = dist[cur] + 1;
                            q.add(i);
                        }
                    }
                }
            }
        }
        /**
         * if dist b == -1
         * way not
         */
        return dist[b];
    }
}