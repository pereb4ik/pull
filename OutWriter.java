/**
 * Created by leha on 26.08.16.
 */
class OutWriter {
    PrintWriter cout;

    OutWriter(String OutName) throws IOException {
        cout = new PrintWriter(new FileWriter(OutName));
    }

    OutWriter() throws IOException {
        cout = new PrintWriter(System.out);
    }

    StringBuilder out = new StringBuilder();

    void print(Object a) {
        out.append(a);
    }

    void prints(Object a) {
        out.append(a);
        out.append(" ");
    }

    void println(Object a) {
        out.append(a);
        out.append("\n");
    }

    void close() {
        cout.print(out.toString());
        cout.close();
    }
}
