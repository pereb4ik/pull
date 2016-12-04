class Reader {
    BufferedReader in;
    Reader() throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    Reader(String name) throws IOException{
        in = new BufferedReader(new FileReader(name));
    }
    StringTokenizer tokin = new StringTokenizer("");
    void updtokin() throws IOException {
        if(!tokin.hasMoreTokens()){
            String a = in.readLine();
            if(a != null){
                tokin = new StringTokenizer(a);
            }
        }
    }
    String next() throws IOException {
        updtokin();
        return tokin.nextToken();
    }
}
