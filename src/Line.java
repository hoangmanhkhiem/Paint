
public class Line implements Shape {
    private Point2D t;
    private Point2D center;

    public Line(Point2D center, Point2D t) {

        this.t = t;
        this.center = center;
    }


    public Point2D getT() {
        return t;
    }

    public void setT(Point2D t) {
        this.t = t;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double peri() {
        return 0;
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public double distance(Point2D p2) {
        return Math.min(center.distance(p2), t.distance(p2));
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.t.move(dx, dy, dz);
        this.center.move(dx, dy, dz);
    }

    @Override
    public void rotate(double alpha, Point2D center) {
        this.t.rotate(alpha, center);
    }

    @Override
    public void zoom(double ratio) {
        this.t.zoom(ratio);
    }

    @Override
    public Point2D getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return "Line{ (" + t + ") , (" + center + ")}";
    }


    public void setCenter(Point2D center) {
        this.center = center;
    }
}