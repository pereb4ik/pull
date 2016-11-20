/**
 * Created by leha on 26.08.16.
 */
class InReader {
    BufferedReader in;

    InReader(String ProblemName) throws IOException {
        in = new BufferedReader(new FileReader(ProblemName));
    }

    InReader() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    StringTokenizer tokenizer = new StringTokenizer("");

    void updateTokenizer() throws IOException {
        if (!tokenizer.hasMoreTokens()) {
            String a = in.readLine();
            if (a != null) {
                tokenizer = new StringTokenizer(a);
            }
        }
    }

    boolean hasNext() throws IOException {
        updateTokenizer();
        return (tokenizer.hasMoreTokens());
    }

    int nextInt() throws IOException {
        updateTokenizer();
        return Integer.parseInt(tokenizer.nextToken());
    }

    long nextLong() throws IOException {
        updateTokenizer();
        return Long.parseLong(tokenizer.nextToken());
    }

    String next() throws IOException {
        updateTokenizer();
        return tokenizer.nextToken();
    }

    double nextDouble() throws IOException {
        updateTokenizer();
        return Double.parseDouble(tokenizer.nextToken());
    }
}
