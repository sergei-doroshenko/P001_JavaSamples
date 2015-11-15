package _06_GenericsAndCollections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergei on 20.10.2015.
 */
public class App04_HashSet {
    public static void main(String []args) {
        Set<Circle> circleList = new HashSet<Circle>();
        circleList.add(new Circle(10, 20, 5));
        System.out.print("Contains Circle(10, 20, 5): ");
        System.out.println(circleList.contains(new Circle(10, 20, 5))); // true

        circleList.add(new Circle(10, 20, 5));
        System.out.println(circleList);

        System.out.println("-----------------------------------------------------------");

        Map<Integer, Circle> circleMap = new HashMap<>();
        circleMap.put(0, new Circle(10, 20, 5));
        circleMap.put(1, new Circle(12, 22, 7));
        System.out.println(circleMap);
        circleMap.put(0, new Circle(20, 30, 10));
        System.out.println(circleMap);
    }
}

class Circle {
    private int xPos, yPos, radius;

    public Circle(int x, int y, int r) {
        xPos = x;
        yPos = y;
        radius = r;
    }

    @Override
    public boolean equals(Object arg) {
        if(arg == null) return false;
        if(this == arg) return true;
        if(arg instanceof Circle) {
            Circle that = (Circle) arg;
            if( (this.xPos == that.xPos) && (this.yPos == that.yPos)
                    && (this.radius == that.radius )) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (7 * xPos) ^ (32 * yPos) >>> 4;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", radius=" + radius +
                ", hashCode=" + this.hashCode() +
                '}';
    }
}
