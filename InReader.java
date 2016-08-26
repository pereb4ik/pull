/**
 * Created by leha on 26.08.16.
 */
import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class InReader {
    BufferedReader in;

    InReader(String problemName) throws IOException {
        String myIn = "input.txt";
        File tmpIn = new File(myIn);
        if (!tmpIn.exists()) {
            if (problemName == null) {
                in = new BufferedReader(new InputStreamReader(System.in));
            } else {
                in = new BufferedReader(
                        new FileReader(problemName + ".in"));
            }
        } else {
            in = new BufferedReader(new FileReader(myIn));
        }
    }

    StringTokenizer tokenizer = new StringTokenizer("");

    void updateTokenizer() throws IOException {
        String a = "a";
        while (!tokenizer.hasMoreTokens() && a != null) {
            a = in.readLine();
            if (a != null) {
                tokenizer = new StringTokenizer(a);
            }
        }
    }

    int nextInt() throws IOException {
        updateTokenizer();
        return Integer.parseInt(tokenizer.nextToken());
    }

    boolean hasNextInt() throws IOException {
        updateTokenizer();
        if (tokenizer.hasMoreTokens()) {
            return true;
        } else {
            return false;
        }
    }

    long nextLong() throws IOException {
        updateTokenizer();
        return Long.parseLong(tokenizer.nextToken());
    }

    BigInteger nextBigInteger() throws IOException {
        updateTokenizer();
        return new BigInteger(tokenizer.nextToken());
    }

    double nextDouble() throws IOException {
        updateTokenizer();
        return Double.parseDouble(tokenizer.nextToken());
    }

    String next() throws IOException {
        updateTokenizer();
        return tokenizer.nextToken();
    }

    String nextLine() throws IOException {
        return in.readLine();
    }

    void close() throws IOException {
        in.close();
    }
}
