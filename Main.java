import java.io.*;
import java.util.*;

public class Main {
    static Reader in;
    static Writer out;

    static class Reader {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokin = new StringTokenizer("");

        String next() throws IOException {
            if (!tokin.hasMoreTokens())
                tokin = new StringTokenizer(in.readLine());
            return tokin.nextToken();
        }
    }

    static class Writer {
        StringBuilder out = new StringBuilder();

        void print(Object a) {
            out.append(a);
        }

        void close() {
            PrintWriter cout = new PrintWriter(System.out);
            cout.print(out.toString());
            cout.close();
        }
    }

    void slave() throws IOException {

    }

    public static void main(String args[]) throws IOException {
        in = new Reader();
        out = new Writer();
        new Main().slave();
        out.close();
    }
}
