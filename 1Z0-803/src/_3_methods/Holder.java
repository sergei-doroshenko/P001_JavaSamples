package _3_methods;

/**
 * Created by Sergei on 19.03.2015.
 */
class Holder{
    int value = 1;
    Holder link;
    public Holder(int val){ this.value = val; }
    public static void main(String[] args){
        final Holder a = new Holder(5);
        Holder b = new Holder(10); // b.link = null
        a.link = b;
        b.link = setIt(a, b); // a.link = b, but b.link = null
        // so a link become null and a.link.value throws NullPointerException
        System.out.println(a.link.value + " " + b.link.value); // NullPointerException
    }

    public static Holder setIt(final Holder x, final Holder y){
        x.link = y.link;
        return x;
    }

}
