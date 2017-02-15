package hu.tkcsnm.butterfly;

/**
 * Created by tkcsnm on 2017. 02. 01..
 */

public class Caterpillar extends Animal {

    protected Caterpillar(String name, String color) {
        super(name, color, R.mipmap.animal_caterpillar);
    }

    @Override
    public Animal aging() {
        super.aging();
        if (this.xp >= 5) {
            return new Butterfly(this.name, Animal.COLOR_PINK, 3);
        } else {
            return this;
        }
    }
}
