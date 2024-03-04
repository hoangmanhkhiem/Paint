public class Rhombus implements Shape{
    private Point2D A;
    private Point2D B;
    private Point2D C;
    private Point2D D;
    private Point2D Center;

    public Rhombus(Point2D a, Point2D b) {
        this.A = a;
        this.B = b;
        this.Center = new Point2D(a.getX(), b.getY());
        this.C = new Point2D(this.A.getX(), 2 * this.Center.getY() - this.A.getY());
        this.D = new Point2D(2 * this.Center.getX() - this.B.getX(), this.B.getY());
    }

    public Point2D getA() {
        return A;
    }

    public void setA(Point2D a) {
        A = a;
    }

    public Point2D getB() {
        return B;
    }

    public void setB(Point2D b) {
        B = b;
    }

    public Point2D getC() {
        return C;
    }

    public Point2D getD() {
        return D;
    }

    public Point2D getCenter() {
        return Center;
    }

    public String toString() {
        return " Rhombus [ [" + A + "] , [" + B + "] + [" + C + "] , [" + D + "] ]";
    }


    @Override
    public double area() {
        return this.A.distance(this.B) * this.A.distance(this.C);
    }

    @Override
    public double peri() {
        return 4 * this.A.distance(this.B);
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
        this.Center = new Point2D((A.getX() + C.getX()) / 2, (A.getY() + C.getY()) / 2);
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
}
