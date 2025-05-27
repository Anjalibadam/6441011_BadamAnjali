public class SimpleClass {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        SimpleClass sc = new SimpleClass();
        int result = sc.add(5, 7);
        System.out.println("Result: " + result);
    }
}
/*Compiled from "SimpleClass.java"
public class SimpleClass {
  public SimpleClass();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public int add(int, int);
    Code:
       0: iload_1
       1: iload_2
       2: iadd
       3: ireturn

  public static void main(java.lang.String[]);
    Code:
       0: new           #2                  // class SimpleClass
       3: dup
       4: invokespecial #3                  // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: iconst_5
      10: bipush        7
      12: invokevirtual #4                  // Method add:(II)I
      15: istore_2
      16: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      19: new           #6                  // class java/lang/StringBuilder
      22: dup
      23: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      26: ldc           #8                  // String Result:
      28: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      31: iload_2
      32: invokevirtual #10                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      35: invokevirtual #11                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      38: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      41: return
}*/
