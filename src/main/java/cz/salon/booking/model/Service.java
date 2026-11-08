
package cz.salon.booking.model;

public class Service {

    private String name;
    private int price;
    private int duration;

    public Service(String name, int price, int duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }
}

