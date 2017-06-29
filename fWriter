static class fWriter {
        Writer cout;
        StringBuilder s = new StringBuilder();
        fWriter() throws IOException {
            cout = new OutputStreamWriter(System.out);
        }

        fWriter(String name) throws IOException {
            cout = new FileWriter(name);
        }

        void print(Object a) {
            s.append(a);
        }

        void close() throws IOException {
            cout.write(s.toString());
            cout.close();
        }
    }
