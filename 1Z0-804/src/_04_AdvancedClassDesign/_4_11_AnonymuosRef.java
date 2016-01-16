package _04_AdvancedClassDesign;

/**
 * Created by sergei on 1/16/16.
 */
public class _4_11_AnonymuosRef {

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
javac /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/_4_11_AnonymuosRef.java

you'll get two classes _4_11_AnonymuosRef.class and _4_11_AnonymuosRef$1.class

To get bytecode run (DON'T forget to escape $ character):
javap -c /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/_4_11_AnonymuosRef\$1.class

Compiled from "_4_11_AnonymuosRef.java"
class _04_AdvancedClassDesign._4_11_AnonymuosRef$1 implements java.lang.Runnable {
  final _04_AdvancedClassDesign._4_11_AnonymuosRef this$0;

  _04_AdvancedClassDesign._4_11_AnonymuosRef$1(_04_AdvancedClassDesign._4_11_AnonymuosRef);
    Code:
       0: aload_0
       1: aload_1
       2: putfield      #1                  // Field this$0:L_04_AdvancedClassDesign/_4_11_AnonymuosRef;
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

javap -v /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/_4_11_AnonymuosRef\$1.class

Classfile /home/sergei/projects/idea_projects/goCourses/1Z0-804/src/_04_AdvancedClassDesign/_4_11_AnonymuosRef$1.class
  Last modified Jan 16, 2016; size 741 bytes
  MD5 checksum 20b063984b700159bd7303ce9a3e9e55
  Compiled from "_4_11_AnonymuosRef.java"
class _04_AdvancedClassDesign._4_11_AnonymuosRef$1 implements java.lang.Runnable
  minor version: 0
  major version: 52
  flags: ACC_SUPER
Constant pool:
   #1 = Fieldref           #6.#22         // _04_AdvancedClassDesign/_4_11_AnonymuosRef$1.this$0:L_04_AdvancedClassDesign/_4_11_AnonymuosRef;
   #2 = Methodref          #7.#23         // java/lang/Object."<init>":()V
   #3 = Fieldref           #24.#25        // java/lang/System.out:Ljava/io/PrintStream;
   #4 = String             #26            // hello
   #5 = Methodref          #27.#28        // java/io/PrintStream.println:(Ljava/lang/String;)V
   #6 = Class              #29            // _04_AdvancedClassDesign/_4_11_AnonymuosRef$1
   #7 = Class              #31            // java/lang/Object
   #8 = Class              #32            // java/lang/Runnable
   #9 = Utf8               this$0
  #10 = Utf8               L_04_AdvancedClassDesign/_4_11_AnonymuosRef;
  #11 = Utf8               <init>
  #12 = Utf8               (L_04_AdvancedClassDesign/_4_11_AnonymuosRef;)V
  #13 = Utf8               Code
  #14 = Utf8               LineNumberTable
  #15 = Utf8               run
  #16 = Utf8               ()V
  #17 = Utf8               SourceFile
  #18 = Utf8               _4_11_AnonymuosRef.java
  #19 = Utf8               EnclosingMethod
  #20 = Class              #33            // _04_AdvancedClassDesign/_4_11_AnonymuosRef
  #21 = NameAndType        #34:#35        // getRunnable:()Ljava/lang/Runnable;
  #22 = NameAndType        #9:#10         // this$0:L_04_AdvancedClassDesign/_4_11_AnonymuosRef;
  #23 = NameAndType        #11:#16        // "<init>":()V
  #24 = Class              #36            // java/lang/System
  #25 = NameAndType        #37:#38        // out:Ljava/io/PrintStream;
  #26 = Utf8               hello
  #27 = Class              #39            // java/io/PrintStream
  #28 = NameAndType        #40:#41        // println:(Ljava/lang/String;)V
  #29 = Utf8               _04_AdvancedClassDesign/_4_11_AnonymuosRef$1
  #30 = Utf8               InnerClasses
  #31 = Utf8               java/lang/Object
  #32 = Utf8               java/lang/Runnable
  #33 = Utf8               _04_AdvancedClassDesign/_4_11_AnonymuosRef
  #34 = Utf8               getRunnable
  #35 = Utf8               ()Ljava/lang/Runnable;
  #36 = Utf8               java/lang/System
  #37 = Utf8               out
  #38 = Utf8               Ljava/io/PrintStream;
  #39 = Utf8               java/io/PrintStream
  #40 = Utf8               println
  #41 = Utf8               (Ljava/lang/String;)V
{
  final _04_AdvancedClassDesign._4_11_AnonymuosRef this$0;
    descriptor: L_04_AdvancedClassDesign/_4_11_AnonymuosRef;
    flags: ACC_FINAL, ACC_SYNTHETIC

  _04_AdvancedClassDesign._4_11_AnonymuosRef$1(_04_AdvancedClassDesign._4_11_AnonymuosRef);
    descriptor: (L_04_AdvancedClassDesign/_4_11_AnonymuosRef;)V
    flags:
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: aload_1
         2: putfield      #1                  // Field this$0:L_04_AdvancedClassDesign/_4_11_AnonymuosRef;
         5: aload_0
         6: invokespecial #2                  // Method java/lang/Object."<init>":()V
         9: return
      LineNumberTable:
        line 9: 0

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
        line 11: 0
        line 12: 8
}
SourceFile: "_4_11_AnonymuosRef.java"
EnclosingMethod: #20.#21                // _04_AdvancedClassDesign._4_11_AnonymuosRef.getRunnable
InnerClasses: #6; //class _04_AdvancedClassDesign/_4_11_AnonymuosRef$1

 */
