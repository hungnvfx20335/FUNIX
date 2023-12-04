public class Lamp {
    private String type;
    private boolean battery;
    private int globRating;
    public Lamp(String type, boolean battery, int globRating) {
        this.setType(type);
        this.setBattery(battery);
        this.setGlobRating(globRating);
    }
    public void turnOn() {
        System.out.print("Type Lamp: " + getType() + " ");
        if (battery) {
            System.out.print("the Lamp are on");
        } else {
            System.out.print("the Lamp are off");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBattery() {
        return battery;
    }

    public void setBattery(boolean battery) {
        this.battery = battery;
    }

    public int getGlobRating() {
        return globRating;
    }

    public void setGlobRating(int globRating) {
        this.globRating = globRating;
    }
}
