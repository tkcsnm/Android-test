package hu.tkcsnm.butterfly;

/**
 * Created by tkcsnm on 2017. 02. 01..
 */

public class Butterfly extends Animal {
    int stars = 5;

    public Butterfly(String name, String color, int stars) {
        super(name, color, R.mipmap.animal_butterfly);
        this.stars = stars;
    }

    public String dispenseStars(){
        return this.stars + "/*****";
    }

    @Override
    public String getName() {
        return "my name is " + super.getName();
    }
}
