static class SegmentTree {

        long a[];

        SegmentTree(int n) {
            int k2 = 1;
            while (k2 < n)
                k2 *= 2;
            k2 *= 2;
            a = new long[k2];
        }

        long sum(int l, int r) {
            return summ(0, 0, a.length / 2 - 1, l, r);
        }

        long summ(int v, int tl, int tr, int l, int r) {
            if (l > r)
                return 0;
            if (l == tl && r == tr)
                return a[v];
            int tm = (tl + tr) / 2;
            return summ(v * 2 + 1, tl, tm, l, Math.min(r, tm)) + summ(v * 2 + 2, tm + 1, tr, Math.max(l, tm + 1), r);
        }

        void set(int i, long val) {
            sett(a.length / 2 - 1 + i, val);
        }

        void sett(int v, long val) {
            a[v] += val;
            if (v != 0) {
                sett((v - 2 + v % 2) / 2, val);
            }
        }
    }
