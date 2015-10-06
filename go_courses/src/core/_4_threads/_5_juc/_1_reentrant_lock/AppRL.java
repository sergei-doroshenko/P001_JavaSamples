package core._4_threads._5_juc._1_reentrant_lock;

/**
 * Created by Sergei on 06.04.2015.
 */
public class AppRL {
    public static void main(String[] args) {
        final ConditionBoundedBuffer<String> buffer = new ConditionBoundedBuffer<>(4);
        final Thread reader, writer;

        // READER
        reader = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
//                    ThreadUtils.sleep(1000);
                    try {
                        Thread.sleep(300);
                        System.out.println("->" + buffer.get());
                    } catch (InterruptedException e) {
                        System.out.println("Reader complete it's work.");

                        while(!buffer.isEmpty()) {
                            try {
                                System.out.println("-->" + buffer.get());
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        break;
                    }
                }
            }
        });

        // WRITER
        writer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char ch = 'A'; ch <= 'Z'; ch++){
                    try {
                        buffer.put("" + ch);
                        System.out.println(ch + "->");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                reader.interrupt();
            }
        });

        writer.start();
        reader.start();
    }
}
