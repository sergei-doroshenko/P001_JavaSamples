package _04_AdvancedClassDesign;

/**
 * Created by sergei on 1/16/16.
 */
public class Outer {
    public Runnable getRunnable() {
        return new Runnable() {
            public void run() {
                System.out.println("hello");
            }
        };
    }
}
/*
Compile:
javac /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/Outer.java

you'll get two class files: Outer.class and Outer$1.class.

to get bytecode call (DON'T forget to escape $ character):
javap -c /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/Outer\$1.class

Compiled from "Outer.java"
class _04_AdvancedClassDesign.Outer$1 implements java.lang.Runnable {
  final _04_AdvancedClassDesign.Outer this$0;

  _04_AdvancedClassDesign.Outer$1(_04_AdvancedClassDesign.Outer);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #1                  // Field this$0:L_04_AdvancedClassDesign/Outer;
       5: aload_0
       6: invokespecial #2                  // Method java/lang/Object."<init>":()V
       9: return

  public void run();
    Code:
       0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #4                  // String hello
       5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}

javap -v /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/Outer\$1.class

Classfile /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/Outer$1.class
  Last modified Jan 16, 2016; size 676 bytes
  MD5 checksum a82a28cb59903383e28519c1099ad55b
  Compiled from "Outer.java"
class _04_AdvancedClassDesign.Outer$1 implements java.lang.Runnable
  minor version: 0
  major version: 52
  flags: ACC_SUPER
Constant pool:
   #1 = Fieldref           #6.#22         // _04_AdvancedClassDesign/Outer$1.this$0:L_04_AdvancedClassDesign/Outer;
   #2 = Methodref          #7.#23         // java/lang/Object."<init>":()V
   #3 = Fieldref           #24.#25        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = String             #26            // hello
   #5 = Methodref          #27.#28        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #6 = Class              #29            // _04_AdvancedClassDesign/Outer$1
   #7 = Class              #31            // java/lang/Object
   #8 = Class              #32            // java/lang/Runnable
   #9 = Utf8               this$0
  #10 = Utf8               L_04_AdvancedClassDesign/Outer;
  #11 = Utf8               <init>
  #12 = Utf8               (L_04_AdvancedClassDesign/Outer;)V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               run
  #16 = Utf8               ()V
  #17 = Utf8               SourceFile
  #18 = Utf8               Outer.java
  #19 = Utf8               EnclosingMethod
  #20 = Class              #33            // _04_AdvancedClassDesign/Outer
  #21 = NameAndType        #34:#35        // getRunnable:()Ljava/lang/Runnable;
  #22 = NameAndType        #9:#10         // this$0:L_04_AdvancedClassDesign/Outer;
  #23 = NameAndType        #11:#16        // "<init>":()V
  #24 = Class              #36            // java/lang/System
  #25 = NameAndType        #37:#38        // out:Ljava/io/PrintStream;
  #26 = Utf8               hello
  #27 = Class              #39            // java/io/PrintStream
  #28 = NameAndType        #40:#41        // println:(Ljava/lang/String;)V
  #29 = Utf8               _04_AdvancedClassDesign/Outer$1
  #30 = Utf8               InnerClasses
  #31 = Utf8               java/lang/Object
  #32 = Utf8               java/lang/Runnable
  #33 = Utf8               _04_AdvancedClassDesign/Outer
  #34 = Utf8               getRunnable
  #35 = Utf8               ()Ljava/lang/Runnable;
  #36 = Utf8               java/lang/System
  #37 = Utf8               out
  #38 = Utf8               Ljava/io/PrintStream;
  #39 = Utf8               java/io/PrintStream
  #40 = Utf8               println
  #41 = Utf8               (Ljava/lang/String;)V
{
  final _04_AdvancedClassDesign.Outer this$0;
    descriptor: L_04_AdvancedClassDesign/Outer;
    flags: ACC_FINAL, ACC_SYNTHETIC

  _04_AdvancedClassDesign.Outer$1(_04_AdvancedClassDesign.Outer);
    descriptor: (L_04_AdvancedClassDesign/Outer;)V
    flags:
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: aload_1
         2: putfield      #1                  // Field this$0:L_04_AdvancedClassDesign/Outer;
         5: aload_0
         6: invokespecial #2                  // Method java/lang/Object."<init>":()V
         9: return
      LineNumberTable:
        line 8: 0

  public void run();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         3: ldc           #4                  // String hello
         5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         8: return
      LineNumberTable:
        line 10: 0
        line 11: 8
}
SourceFile: "Outer.java"
EnclosingMethod: #20.#21                // _04_AdvancedClassDesign.Outer.getRunnable
InnerClasses:
     #6; //class _04_AdvancedClassDesign/Outer$1


 */
