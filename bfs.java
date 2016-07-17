import java.util.*;

public class bfs {
    /**
     * m - vertices(array of adjacency)
     * search the least way from vert a to vert b
     */
    int bfs(int m[][], int a, int b) {
        int n = m.length;
        Queue<Integer> q = new LinkedList<>();
        int dist[] = new int[n];
        q.add(a);
        for (int i = 0; i < n; i++) {
            dist[i] = -2;
        }
        dist[a] = 0;
        while (q.size() != 0) {
            int cur = q.remove();
            for (int i = 0; i < n; i++) {
                if (m[cur][i] == 1) {
                    int t = i;
                    if (dist[t] == -2) {
                        dist[t] = dist[cur] + 1;
                        q.add(t);
                    } else {
                        if (dist[t] > dist[cur] + 1) {
                            dist[t] = dist[cur] + 1;
                            q.add(t);
                        }
                    }
                }
            }
        }
        if (dist[b] == -2) {
            return 0;
        } else {
            return dist[b];
        }
    }
}