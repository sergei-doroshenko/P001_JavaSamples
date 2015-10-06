package creational.builder;

/**
 * Created by Sergei on 16.08.2015.
 */
public class BodyMassIndex {
    private int age;
    private double weight;
    private double height;

    private BodyMassIndex(Bulder bulder) {
        this.age = bulder.age;
        this.weight = bulder.weight;
        this.height = bulder.height;
    }

    public double calculate() {
        return this.weight/(this.height * this.height / 10_000);
    }

    public static class Bulder {
        private int age;
        private double weight;
        private double height;

        public Bulder() {
        }

        public Bulder(int age) {
            this.age = age;
        }

        public Bulder age(int age) {
            this.age = age;
            return this;
        }

        public Bulder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public Bulder height(double height) {
            this.height = height;
            return this;
        }

        public BodyMassIndex build() {
            if (this.age == 0 || this.weight == 0 || this.height == 0) {
                throw new IllegalStateException("Age, weight or height is zero.");
            }

            return new BodyMassIndex(this);
        }
    }
}
