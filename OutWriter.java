/**
 * Created by leha on 26.08.16.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class OutWriter {
    PrintWriter cout;

    OutWriter(String OutName) throws IOException {
        String MyOut = "output.txt";
        File OutF = new File(MyOut);
        if (!OutF.exists()) {
            if (OutName == null) {
                cout = new PrintWriter(System.out);
            } else {
                cout = new PrintWriter(new FileWriter(OutName + ".out"));
            }
        } else {
            cout = new PrintWriter(new FileWriter(MyOut));
        }
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
