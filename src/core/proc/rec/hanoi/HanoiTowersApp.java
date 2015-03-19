package core.proc.rec.hanoi;

/**
 * Created by Sergei on 23.02.2015.
 */
public class HanoiTowersApp {
    public static void main (String[] args) {
        HanoiTowers towers = new HanoiTowers(new int[] {1,2,3,4,5});
        towers.display();
        towers.build();
        towers.display();
    }
}
