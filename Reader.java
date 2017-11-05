class Reader {
    BufferedReader in;
    Reader() throws IOException{
        in = new BufferedReader(new InputStreamReader(System.in));
    }
    Reader(String name) throws IOException{
        in = new BufferedReader(new FileReader(name));
    }
    
    StringTokenizer tokin = new StringTokenizer("");
    
    String next() throws IOException {
        if(!tokin.hasMoreTokens()){
            tokin = new StringTokenizer(in.readLine());
        }
        return tokin.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
