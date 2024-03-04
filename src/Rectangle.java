public class Rectangle implements Shape{
    private Point2D A;
    private Point2D B;
    private Point2D C;

    private Point2D D;
    private Point2D Center;

    public Rectangle(Point2D a, Point2D c) {
        this.A = a;
        this.C = c;
        this.B = new Point2D(c.getX(), a.getY());
        this.D = new Point2D(a.getX(), c.getY());
        this.Center = new Point2D((a.getX() + c.getX()) / 2, (a.getY() + c.getY()) / 2);
    }

    @Override
    public double area() {
        return this.A.distance(this.B) * this.A.distance(this.D);
    }

    @Override
    public double peri() {
        return 2 * (this.A.distance(this.B) + this.A.distance(this.D));
    }

    @Override
    public double distance() {
        return Math.sqrt(Math.pow(this.Center.getX(), 2) + Math.pow(this.Center.getY(), 2));
    }

    @Override
    public double distance(Point2D p2) {
        return Math.sqrt(Math.pow(this.Center.getX() - p2.getX(), 2) + Math.pow(this.Center.getY() - p2.getY(), 2));
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.A.move(dx, dy, dz);
        this.B.move(dx, dy, dz);
        this.C.move(dx, dy, dz);
        this.D.move(dx, dy, dz);
    }

    @Override
    public void rotate(double alpha) {
        this.A.rotate_with_center(alpha, this.Center);
        this.B.rotate_with_center(alpha, this.Center);
        this.C.rotate_with_center(alpha, this.Center);
        this.D.rotate_with_center(alpha, this.Center);
    }

    @Override
    public void zoom(double ratio) {
        this.A.zoom(ratio);
        this.B.zoom(ratio);
        this.C.zoom(ratio);
        this.D.zoom(ratio);
        Point2D newCenter = new Point2D((A.getX()+C.getX())/2, (A.getY()+C.getY())/2);
        move(Center.getX() - newCenter.getX(), Center.getY() - newCenter.getY(), 0);
    }

    @Override
    public String toString() {
        return "Rectangle[ [" + A + "] , [ " + B + "] , [ " + C + "] , [" + D + "] ]";
    }

    public Point2D getCenter() {
        return this.Center;
    }
}