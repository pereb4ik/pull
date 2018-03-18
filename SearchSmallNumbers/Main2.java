import java.io.*;
import java.util.*;

public class Main2 {
    static class DSU {
        int parents[];

        DSU(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int a) {
            if (parents[a] == a)
                return a;
            else
                parents[a] = find(parents[a]);
            return parents[a];
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);
            parents[b] = a;
        }
    }

    static Scanner sc;

    static int kol = 0;

    static String take(String a) {
        kol++;
        StringTokenizer tok = new StringTokenizer(a);
        tok.nextToken();
        int a1 = Integer.parseInt(tok.nextToken());
        int a2 = Integer.parseInt(tok.nextToken());
        if (a1 > a2) {
            return ">";
        } else {
            return "<";
        }
    }

    static int compare(int i1, int i2) {
        System.out.println("? " + i1 + " " + i2 + "\n");
        System.out.flush();
        /*String a = sc.next();*/
        String a = take("? " + i1 + " " + i2 + "\n");
        if (a.charAt(0) == '>') {
            return 1;
        } else {
            return 0;
        }
    }

    static int n;

    static int random() {
        int a = (int) (Math.ceil(Math.random() * n));
        if (a < 0)
            a = -a;
        if (a == 0)
            return 1;
        if (a >= n)
            return n;
        return a;
    }

    public static void main(String args[]) throws IOException {
        sc = new Scanner(System.in);
        n = sc.nextInt();
        int k = sc.nextInt();
        DSU dsu = new DSU(n);
        int p[] = new int[n];
        ArrayList<Integer> chd[] = new ArrayList[n];
        for (int i = 0; i < chd.length; i++) {
            chd[i] = new ArrayList<>(100);
        }
        Arrays.fill(p, -1);
        int Size = 25;
        int constt = 500000;
        int h = constt;
        for (int i = 0; i < n - 1; i++) {
            int a = dsu.find(random() - 1);
            int b = dsu.find(random() - 1);
            h = constt;
            while ((b == a || chd[a].size() > Size || chd[b].size() > Size) && h > 0) {
                h--;
                a = dsu.find(random() - 1);
                b = dsu.find(random() - 1);
            }
            while (b == a) {
                a = dsu.find(random() - 1);
                b = dsu.find(random() - 1);
            }
            if (compare(a + 1, b + 1) > 0) {
                dsu.union(b, a);
                chd[b].add(a);
                p[a] = b;
            } else {
                dsu.union(a, b);
                chd[a].add(b);
                p[b] = a;
            }
        }

        int col = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == -1)
                col++;
        }
        int ind = 0;
        while (p[ind] != -1)
            ind++;
        String ans = new String();
        int startind = ind;
        ans += "! ";
        ans += ((ind + 1) + " ");
        for (int i = 1; i < k; i++) {
            int newind = chd[ind].get(0);
            for (int j = 1; j < chd[ind].size(); j++) {
                int v = chd[ind].get(j);
                if (compare(v + 1, newind + 1) > 0) {
                    dsu.union(newind, v);
                    chd[newind].add(v);
                    p[v] = newind;
                } else {
                    dsu.union(v, newind);
                    chd[v].add(newind);
                    p[newind] = v;
                    newind = v;
                }
            }
            ans += ((newind + 1) + " ");
            ind = newind;
        }
        System.out.println(ans);
        System.out.println("CHILDE SIZE " + chd[startind].size());
        System.out.print("COMPARE " + kol + " FREE ROOTS " + col);
    }
}
