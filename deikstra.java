       TreeSet<pair> a = new TreeSet<>();
        pair d[] = new pair[n];
        for (int i = 0; i < n; i++) {
            d[i] = new pair(i, Long.MAX_VALUE);
        }
        d[v1].w = 0;
        for (int i = 0; i < n; i++) {
            a.add(new pair(d[i].v, d[i].w));
        }
        while (a.size() > 0) {
            pair cur = a.pollFirst();
            if (cur.w == Long.MAX_VALUE)
                break;
            int v = cur.v;
            for (int i = 0; i < g.get(v).size(); i++) {
                int to = g.get(v).get(i).v;
                long w = g.get(v).get(i).w;
                if (d[v].w + w < d[to].w) {
                    if (a.remove(d[to])) {
                        d[to].w = d[v].w + w;
                        a.add(d[to]);
                    } else {
                        d[to].w = d[v].w + w;
                    }
                }
            }
        }
 
