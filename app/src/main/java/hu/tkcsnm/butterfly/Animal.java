package hu.tkcsnm.butterfly;

/**
 * Created by tkcsnm on 2017. 02. 01..
 */

public abstract class Animal {
    public static String COLOR_PINK = "#FF5EAA";
    public static String COLOR_GREEN = "#00FF00";
    public static String COLOR_BLUE = "#0000FF";

    protected String color;
    protected int xp;
    protected int energy;
    protected String name;
    protected int imageRes;

    protected Animal(String name, String color, int imageRes) {
        this.name = name;
        this.color = color;
        this.xp = 0;
        this.energy = 15;
        this.imageRes = imageRes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return this.name + " " + this.xp;
    }

    public int getXp() {
        return xp;
    }

    public int getEnergy() {
        return energy;
    }

    public Animal aging() {
        this.xp += 1;
        return this;
    }


}
