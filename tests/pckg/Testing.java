package pckg;

public class Testing {
  public void main(String[] args) {
    int a=5;
    int b=6;
    int c=a+b;
    b^=2;
    b++;
    b+=2;
    a--;
    if (c==b || c==b+1 && c==b+2 || c==b+3) {
      System.out.println("a+b=c");
    }
  }
  private void test() {

  }
  private int test2() {
  int a=5;
  return a;
  }
}
