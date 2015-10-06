package core._6_oop._4_principles.composite;

/**
 * Created by Sergei on 18.03.2015.
 */
public class AppComposit {
    public static void main(String[] args) {
        new Composite(
                new Composite(
                        new Romb(),
                        new Composite(
                            new Oval(), new Oval()
                        )
                ),
                new Composite(
                        new Romb(), new Oval()
                ),
                new Romb()
        ).draw();
    }
}
/*
Romb
Oval
Oval
Romb
Oval
Romb
*/
