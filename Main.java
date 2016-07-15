public class Main{
  int[] sort(int c[]){
    if(c.length==1) {
      return c;
    } else {
      int m = c.length/2;
      int a[] = new int[m];
      int b[] = new int[c.length-m];
      for(int i=0; i<m; i++){
          a[i] = c[i];
      }
      for(int i=0; i<c.length-m; i++){
          b[i]=c[i+m];
      }
      a = sort(a);
      b = sort(b);
      return merge(a, b);
    }
  }
  int[] merge (int a[], int b[]){
    int c[] = new int[a.length+b.length];
    int i = 0;
    int j = 0;
    while(i<a.length && j<b.length){
      if(a[i]>b[j]){
        c[i+j] = b[j];
        j++;
      } else {
        c[i+j] = a[i];
        i++;
      }
    }
    while(i<a.length){
      c[i+j] = a[i];
      i++;
    }
    while(j<b.length){
      c[i+j] = b[j];
      j++;
    }
    return c;
  }
}