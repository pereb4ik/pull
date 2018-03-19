static class lca {
        ArrayList<Integer>[] g;
        int parents[][];
        int timein[], timeout[];
        int n, root = 0, glub;

        lca(int n1, int parents1[], int glub1) {
            glub = glub1;
            n = n1;
            parents = new int[n][glub];
            timein = new int[n];
            timeout = new int[n];
            g = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                parents[i][0] = parents1[i];
            }
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                g[parents[i][0]].add(i);
            }
            dfs(root, 0);
        }

        int dfs(int v, int t) {
            t++;
            timein[v] = t;
            for (int i = 1; i < glub; i++) {
                parents[v][i] = parents[parents[v][i - 1]][i - 1];
            }
            for (int i = 0; i < g[v].size(); i++) {
                if (g[v].get(i) != root)
                    t = dfs(g[v].get(i), t);
            }
            t++;
            timeout[v] = t;
            return t;
        }

        boolean isParentV1(int v1, int v2) {
            if (timein[v1] <= timein[v2] && timeout[v1] >= timeout[v2])
                return true;
            else
                return false;
        }

        int searchlca(int v1, int v2) {
            if (isParentV1(v1, v2)) {
                return v1;
            } else {
                int l = 0;
                int r = glub - 1;
                while (l + 1 != r) {
                    int cur = ((l + r) - (l + r) % 2) / 2;
                    if (isParentV1(parents[v1][cur], v2)) {
                        r = cur;
                    } else {
                        l = cur;
                    }
                }
                return searchlca(parents[v1][l], v2);
            }
        }
}
