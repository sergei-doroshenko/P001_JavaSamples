package core._6_oop._1_virtual;

/**
 * Created by Sergei Doroshenko on 17.03.2015.
 */
public class App05_methodInConstr {
    public static void main(String[] args) {
        /**
         * X constructor call Y's init() because ref refer to Y's instance.
         * NOT X!
         */
        X ref = new Y(); // Y init
    }
}

class X {
    X() {
        init();
    }

    void init() {
        System.out.println("X init");
    }
}

class Y extends X {
    Y(){

    }

    @Override
    void init() {
        System.out.println("Y init");
    }
}
