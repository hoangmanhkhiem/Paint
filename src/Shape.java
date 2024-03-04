public interface Shape {
    public double area();
    public double peri();
    public double distance();
    public double distance(Point2D p2);


    public void move(double dx, double dy, double dz);
    public void rotate(double alpha);
    public void zoom(double ratio);
}