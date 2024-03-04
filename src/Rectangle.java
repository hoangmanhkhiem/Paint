public class Rectangle implements Shape{
    private Point2D A;
    private Point2D B;
    private Point2D C;
    private Point2D Center;
    private double height, width;

    public Rectangle(Point2D a, Point2D b, Point2D c, Point2D center) {
        A = a;
        B = b;
        C = c;
        Center = center;
        height = this.Center.distance(this.A);
        width = this.Center.distance(this.C);
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public double peri() {
        return (height+width)*2;
    }

    @Override
    public double distance() {
        return 0;
    }

    @Override
    public double distance(Point2D p2) {
        return  Math.min(Math.min(this.A.distance(p2),this.B.distance(p2)),Math.min(this.Center.distance(p2),this.C.distance(p2)));
    }

    @Override
    public void move(double dx, double dy, double dz) {
        this.A.move(dx, dy, dz);
        this.B.move(dx, dy, dz);
        this.C.move(dx, dy, dz);
        this.Center.move(dx, dy, dz);
    }

    @Override
    public void rotate(double alpha, Point2D center) {
        this.A.rotate(alpha, center);
        this.B.rotate(alpha, center);
        this.C.rotate(alpha, center);
    }

    @Override
    public void zoom(double ratio) {
        this.A.zoom(ratio);
        this.B.zoom(ratio);
        this.C.zoom(ratio);
    }

    @Override
    public String toString() {
        return "Rectangle{(" + A + ") , ( " + B + ") , ( " + C + ") , (" + Center + ")}";
    }

    @Override
    public Point2D getCenter() {
        return Center;
    }
}