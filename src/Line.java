
public class Line implements Shape {
    private Point2D t;

    private Point2D s;
    private Point2D center;

    public Line(Point2D t, Point2D s) {

        this.t = t;
        this.s = s;
        this.center = new Point2D((t.getX() + s.getX()) / 2, (t.getY() + s.getY()) / 2);
    }


    public Point2D getT() {
        return t;
    }

    public void setT(Point2D t) {
        this.t = t;
    }

    public Point2D getS() {
        return s;
    }

    public void setS(Point2D s) {
        this.s = s;
    }

    public Point2D getCenter() {
        return center;
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
        return Math.min(center.distance(p2),Math.min(t.distance(p2),s.distance(p2)));
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.t.move(dx, dy, dz);
        this.s.move(dx, dy, dz);
        this.center.move(dx, dy, dz);
    }

    @Override
    public void rotate(double alpha) {
        this.t.rotate_with_center(alpha, this.center);
        this.s.rotate_with_center(alpha, this.center);
    }

    @Override
    public void zoom(double ratio) {
        this.t.zoom(ratio);
        this.s.zoom(ratio);
        Point2D newCenter = new Point2D((t.getX() + s.getX()) / 2, (t.getY() + s.getY()) / 2);
        move(center.getX() - newCenter.getX(), center.getY() - newCenter.getY(), 0);
    }


    @Override
    public String toString() {
        return "Line[ [" + t + "] , [" + s + "] ] ";
    }

}