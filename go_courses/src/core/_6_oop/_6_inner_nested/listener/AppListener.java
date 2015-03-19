package core._6_oop._6_inner_nested.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 19.03.2015.
 */
public class AppListener {
    public static void main(String[] args) {

        {
            List list = new ArrayList() {
                {
                    add("A");
                    add("B");
                }
            };
            System.out.println("list: " + list);
            System.out.println(list.getClass().getName());
        }


        EventMaker maker = new EventMaker();
        maker.addListener(new MyListener() {
            @Override
            public void fireEvent(String event) {
                System.out.println("1st listener fired: " + event);
            }
        });

        maker.addListener(new MyListener() {
            @Override
              public void fireEvent(String event) {
                System.out.println("2nd listener fired: " + event);
            }
        });

        maker.addListener(new MyListener() {
            @Override
            public void fireEvent(String event) {
                System.out.println("3rd listener fired: " + event);
            }
        });

//        maker.start();

        /*maker.eventHappen("hello");
        maker.eventHappen("good bye");
        maker.eventHappen("fuck off");*/
    }
}
