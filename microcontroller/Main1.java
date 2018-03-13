import java.io.*;
import java.util.*;

public class Main1 {
    static class Reader {
        BufferedReader in;

        Reader() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String name) throws IOException {
            in = new BufferedReader(new FileReader(name));
        }

        StringTokenizer tokin = new StringTokenizer("");

        String next() throws IOException {
            while (!tokin.hasMoreTokens()) {
                tokin = new StringTokenizer(in.readLine());
            }
            return tokin.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    static class Writer {
        PrintWriter cout;

        Writer() throws IOException {
            cout = new PrintWriter(System.out);
        }

        Writer(String name) throws IOException {
            cout = new PrintWriter(new FileWriter(name));
        }

        StringBuilder out = new StringBuilder();

        void print(Object a) {
            out.append(a);
        }

        void println(Object a) {
            out.append(a + "\n");
        }

        void close() {
            cout.print(out.toString());
            cout.close();
        }
    }

    static boolean compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() != b.size()) {
            /*System.out.print("SIZE!=\n");*/
            return false;
        } else {
            for (int i = 0; i < a.size(); i++) {
                /*System.out.print("I " + i + " " + a.get(i) + " " + b.get(i) + "\n");*/
                if ((int)a.get(i) != (int)b.get(i)) {
                    /*System.out.print("lol\n");*/
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String args[]) throws IOException {
        Reader in = new Reader();
        Writer out = new Writer();
        int n = in.nextInt();
        /*
        char[][] upp = new char[600][100];
        char[][] downn = new char[600][100];*/
        /*for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 100; j++) {
                upp[i][j] = ' ';
                downn[i][j] = ' ';
            }
        }*/
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt() - 1;
            b[a[i]] = i;
        }
        /*int h[] = new int[n];
        String aa = "";
        for (int i = 0; i < n; i++) {
            h[i] = aa.length();
            aa += ((a[i] + 1) + " ");
        }*/
        ArrayList up[] = new ArrayList[n];
        ArrayList down[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            up[i] = new ArrayList(10000);
            down[i] = new ArrayList(10000);
        }
        int i = 0;
        for (i = 0; i < n - 1; i++) {
            if (i % 2 == 1) {
                int a1 = Math.min(b[i], b[i + 1]);
                int a2 = Math.max(b[i], b[i + 1]);
                /*System.out.print("Up\n");
                System.out.print("a1: " + a1 + " size: " + up[a1].size() + "\n");
                for (int j = 0; j < up[a1].size(); j++) {
                    System.out.print(up[a1].get(j) + " ");
                }
                System.out.print("\n");
                System.out.print("a2: " + a2 + " size: " + up[a2].size() + "\n");
                for (int j = 0; j < up[a2].size(); j++) {
                    System.out.print(up[a2].get(j) + " ");
                }
                System.out.print("\n");*/
                if (compare(up[a1], up[a2])) {
                    /*int H = up[a1].size() + 1;
                    for (int j = 0; j <= H; j++) {
                        upp[h[a1]][j] = '|';
                        upp[h[a2]][j] = '|';
                    }
                    upp[h[a1]][H] = '+';
                    upp[h[a2]][H] = '+';
                    for (int j = h[a1] + 1; j < h[a2]; j++) {
                        upp[j][H] = '-';
                    }*/
                    for (int j = a1; j <= a2; j++) {
                        up[j].add(i);
                    }
                } else {
                    break;
                }
            } else {
                int a1 = Math.min(b[i], b[i + 1]);
                int a2 = Math.max(b[i], b[i + 1]);
                /*System.out.print("Down\n");
                System.out.print("a1: " + a1 + " size: " + down[a1].size() + "\n");*/
                /*for (int j = 0; j < down[a1].size(); j++) {
                    System.out.print(down[a1].get(j) + " ");
                }*/
                /*System.out.print("\n");
                System.out.print("a2: " + a2 + " size: " + down[a2].size() + "\n");*/
                /*for (int j = 0; j < down[a2].size(); j++) {
                    System.out.print(down[a2].get(j) + " ");
                }*/
                /*System.out.print("\n");*/
                if (compare(down[a1], down[a2])) {
                    /*int H = down[a1].size() + 1;
                    for (int j = 0; j <= H; j++) {
                        downn[h[a1]][j] = '|';
                        downn[h[a2]][j] = '|';
                    }
                    downn[h[a1]][H] = '+';
                    downn[h[a2]][H] = '+';
                    for (int j = h[a1] + 1; j < h[a2]; j++) {
                        downn[j][H] = '-';
                    }*/
                    for (int j = a1; j <= a2; j++) {
                        down[j].add(i);
                    }
                } else {
                    break;
                }
            }
        }
        out.print(i + 1 + "\n");
        /*for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 600; k++) {
                out.print(upp[k][j]);
            }
            out.print("\n");
        }
        for (int j = 99; j > -1; j--) {
            for (int k = 0; k < 600; k++) {
                out.print(downn[k][j]);
            }
            out.print("\n");
        }*/
        out.close();
    }
}