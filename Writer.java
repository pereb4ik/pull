class Writer {
    PrintWriter cout;
    Writer() throws IOException {
        cout = new PrintWriter(System.out);
    }
    Writer(String name) throws IOException {
        cout = new PrintWriter(new FileWriter(name));
    }
    StringBuilder out = new StringBuilder();
    void print(Object a){
        out.append(a);
    }
    void close(){
        cout.print(out.toString());
        cout.close();
    }
}
