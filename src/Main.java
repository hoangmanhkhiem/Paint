import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Random rand = new Random();
//        for (int i = 0; i < 10; i++) {
//            int type = rand.nextInt(5);
//            switch (type) {
//                case 0:
//                    shapes.add(new Point2D(rand.nextDouble(), rand.nextDouble()));
//                    break;
//                case 1:
//                    shapes.add(new Circle(rand.nextDouble(), new Point2D(rand.nextDouble(), rand.nextDouble())));
//                    break;
//                case 2:
//                    shapes.add(new Line(new Point2D(rand.nextDouble(), rand.nextDouble()),
//                            new Point2D(rand.nextDouble(), rand.nextDouble())));
//                    break;
//                case 3:
//                    shapes.add(new Triangle(new Point2D(rand.nextDouble(), rand.nextDouble()),
//                            new Point2D(rand.nextDouble(), rand.nextDouble()),
//                            new Point2D(rand.nextDouble(), rand.nextDouble())));
//                    break;
//                case 4:
//                    shapes.add(new Rectangle(new Point2D(rand.nextDouble(), rand.nextDouble()),
//                                new Point2D(rand.nextDouble(), rand.nextDouble())));
//                    break;
//            }
//        }
        shapes.add(new Point2D(1, 2));
        shapes.add(new Circle(3, new Point2D(1, 2)));
        shapes.add(new Line(new Point2D(2, 2), new Point2D(4, 4)));
        shapes.add(new Triangle(new Point2D(10, 20), new Point2D(300, 400), new Point2D(50, 60)));
        shapes.add(new Rectangle(new Point2D(10, 20), new Point2D(40, 60)));
        System.out.println("\n\nDanh sach cac hinh:");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        double maxArea = -1, minArea = 99999;
        double sumArea = 0, sumPeri = 0;
        System.out.println("\n\n");
        for (Shape shape : shapes) {
            if (!(shape instanceof Point2D) && !(shape instanceof Line)) {
                double area = shape.area();
                System.out.println("Dien tich hinh " + shape.toString() + " = " +  String.format("%.4f",area));
                sumArea += area;
                sumPeri += shape.peri();
                if (maxArea < area)
                    maxArea = area;
                if (minArea > area)
                    minArea = area;
            }
        }
        System.out.println("\n\n");
        System.out.println("Tong chu vi = " + String.format("%.4f",sumPeri));
        System.out.println("Tong dien tich = " + String.format("%.4f",sumArea));
        System.out.println("Dien tich lon nhat = " + String.format("%.4f",maxArea));
        System.out.println("Dien tich nho nhat = " + String.format("%.4f",minArea));

        System.out.println("\n\nZoom 2 lan:");
        for(Shape shape : shapes){
            if(!(shape instanceof Point2D)){
                System.out.println("Before: " + shape.toString());
                System.out.println("Before: " + shape.area());
                double area = shape.area();
                shape.zoom(2);
                System.out.println("After: " + shape.toString());
                System.out.println("After: " + shape.area());
                System.out.println(shape.area()/area);
            }
        }

//        System.out.println("\n\nDi chuyen 1 don vi:");
//        for(Shape shape : shapes){
//                System.out.println("Before: " + shape.toString());
//                shape.move(1,1,1);
//                System.out.println("After: " + shape.toString());
//        }

//        System.out.println("\n\nXoay 90 do:");
//        for(Shape shape : shapes){
//            if(!(shape instanceof Point2D)){
//                System.out.println("Before: " + shape.toString());
//                shape.rotate(90);
//                System.out.println("After: " + shape.toString());
//            }
//        }
    }
}