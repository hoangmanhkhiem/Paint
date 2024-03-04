public class Triangle implements Shape{
    private Point2D A;
    private Point2D B;

    private Point2D C;
    private Point2D Center;

    public Triangle(Point2D a, Point2D b, Point2D c) {
        A = a;
        B = b;
        C = c;
        this.Center = new Point2D((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
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

    public void setC(Point2D c) {
        C = c;
    }


    public void setCenter(Point2D center) {
        Center = center;
    }

    @Override
    public double area() {
        double a = this.A.distance(this.B);
        double b = this.A.distance(this.C);
        double c = this.B.distance(this.C);
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public double peri() {
        return this.A.distance(this.B)+this.A.distance(this.Center)+this.B.distance(Center);
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public double distance(Point2D p2) {
        return Math.min(Math.min(this.A.distance(p2),this.B.distance(p2)),this.Center.distance(p2));
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.A.move(dx, dy, dz);
        this.B.move(dx, dy, dz);
        this.C.move(dx, dy, dz);
    }

    @Override
    public void rotate(double alpha) {
        this.A.rotate_with_center(alpha, this.Center);
        this.B.rotate_with_center(alpha, this.Center);
        this.C.rotate_with_center(alpha, this.Center);
    }

    @Override
    public void zoom(double ratio) {
        this.A.zoom(ratio);
        this.B.zoom(ratio);
        this.C.zoom(ratio);
        Point2D newCenter = new Point2D((A.getX() + B.getX() + C.getX()) / 3, (A.getY() + B.getY() + C.getY()) / 3);
        move(Center.getX() - newCenter.getX(), Center.getY() - newCenter.getY(), 0);
    }

    @Override
    public String toString() {
        return "Triangle[ [" + A +  "] , [" + B + "] , [" + C + "] ]";
    }

    public Point2D getCenter() {
        return Center;
    }
}