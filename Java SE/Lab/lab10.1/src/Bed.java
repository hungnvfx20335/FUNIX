public class Bed {
    private String type;
    private int pillows;
    private int height;
    private int sheets;
    private int quilt;
    public Bed(String type, int pillows, int height, int sheets, int quilt) {
        this.setType(type);
        this.setPillows(pillows);
        this.setHeight(height);
        this.setSheets(sheets);
        this.setQuilt(quilt);
    }
    public void make() {
        System.out.println("Type Bed: " + getType());
        System.out.println("Pillows number: " + getPillows());
        System.out.println("Height Bed: " + getHeight());
        System.out.println("Sheets number: " + getSheets());
        System.out.println("Quilt: " + getQuilt());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPillows() {
        return pillows;
    }

    public void setPillows(int pillows) {
        this.pillows = pillows;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    public int getQuilt() {
        return quilt;
    }

    public void setQuilt(int quilt) {
        this.quilt = quilt;
    }
}
