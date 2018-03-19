import java.util.*;

public class dfs {
    boolean must = true;
    int color[];
    boolean used[];
    /**
     * edges - Array list of Array list of edges
     */
    void dfs(int v, ArrayList<ArrayList<Integer>> edges) {
        used[v] = true;
        for (int i = 0; i < edges.get(v).size(); i++) {
            if (used[edges.get(v).get(i)] == false) {
                color[edges.get(v).get(i)] = (color[v]) * (-1);
                dfs(edges.get(v).get(i), edges);
            } else {
                if (color[edges.get(v).get(i)] == color[v]) {
                    must = false;
                }
            }
        }
    }
    /**
     * dfs с прикрученной раскраской двудольного графа
     */
}
