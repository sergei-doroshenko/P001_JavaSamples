package core._1_excep._6_lab;

/**
 * Created by Sergei on 28.02.2015.
 */
public class AccountImpl implements Account {
    private boolean f;
    private int id;
    private int money;

    public AccountImpl(int id, int money) {
        this.id = id;
        this.money = money;
        this.f = true;
    }

    @Override
    public void cange(int delta) throws TryAgainException, BlockAccountException {
        if (f){
            if (Math.random() < 0.4) {
                throw new TryAgainException("Try again");
            } else if (Math.random() >= 0.4 && Math.random() < 0.7) {
                f = false;
                throw new BlockAccountException("Account blocked");
            } else {
                money += delta;
            }
        } else {
            if (Math.random() < 0.5) {
                throw new TryAgainException("Try again");
            } else {
                money += delta;
            }
        }
        f = false;
    }

    public int getId() {
        return id;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
