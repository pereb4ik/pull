import java.io.*;
import java.util.*;

public class Main {
    static Reader in = new Reader();
    static StringBuilder out = new StringBuilder("");

    static class Reader {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokin = new StringTokenizer("");

        String next() throws IOException {
            if (!tokin.hasMoreTokens())
                tokin = new StringTokenizer(in.readLine());
            return tokin.nextToken();
        }
    }
    
    void slave() throws IOException {

    }

    public static void main(String args[]) throws IOException {
        new Main().slave();
        PrintWriter cout = new PrintWriter(System.out);
        cout.print(out.toString());
        cout.close();
    }
}
