package org.sergei._0_core._6_oop._6_inner_nested.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergei on 19.03.2015.
 */
public class EventMaker {
    private List<MyListener> listeners;

    public EventMaker() {
        listeners = new ArrayList<>();
    }

    public void addListener(MyListener listener) {
        listeners.add(listener);
    }

    public void eventHappen(String event) {
        for (MyListener listener: listeners)
            listener.fireEvent(event);
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.currentThread().sleep(2000);
                        if (Math.random() < .5)
                            eventHappen("(time:" + System.currentTimeMillis() + ")");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
