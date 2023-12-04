import java.util.ArrayList;
import java.util.List;

public class PolyLine {
    private List<Point> points  = new ArrayList<>();
    public PolyLine() {

    }
    public PolyLine(List<Point> points) {
        this.points = points;
    }
    public void appendPoint(Point point) {
        this.getPoints().add(point);
    }
    public void appendPoint(int x, int y) {
        this.getPoints().add(new Point(x, y));
    }
    public double getLength() {
        double length = 0.0;
        for (int i = 0; i < getPoints().size() - 2; i++) {
            length += Math.sqrt((getPoints().get(i + 1).getX() - getPoints().get(i).getX()) * (getPoints().get(i + 1).getX() - getPoints().get(i).getX()) +
                    (getPoints().get(i + 1).getY() - getPoints().get(i).getY()) * (getPoints().get(i + 1).getY() - getPoints().get(i).getY()));
        }
        length += Math.sqrt((getPoints().get(getPoints().size() - 1).getX() - getPoints().get(getPoints().size() - 2).getX())
                * (getPoints().get(getPoints().size() - 1).getX() - getPoints().get(getPoints().size() - 2).getX()) +
                (getPoints().get(getPoints().size() - 1).getY() - getPoints().get(getPoints().size() - 2).getY())
                        * (getPoints().get(getPoints().size() - 1).getY() - getPoints().get(getPoints().size() - 2).getY()));
        return length;
    }

    public List<Point> getPoints() {
        return points;
    }
}
