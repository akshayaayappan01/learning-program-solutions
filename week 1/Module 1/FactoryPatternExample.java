// Product interface
interface Polygon {
    void render();
}

// Concrete Products
class Rectangle implements Polygon {
    public void render() {
        System.out.println("Rendering a Rectangle");
    }
}

class Triangle implements Polygon {
    public void render() {
        System.out.println("Rendering a Triangle");
    }
}

// Factory class
class PolygonFactory {
    // Factory Method
    public Polygon createPolygon(String type) {
        if (type == null) return null;

        switch (type.toUpperCase()) {
            case "RECTANGLE":
                return new Rectangle();
            case "TRIANGLE":
                return new Triangle();
            default:
                return null;
        }
    }
}

// Client
public class FactoryPatternExample {
    public static void main(String[] args) {
        PolygonFactory factory = new PolygonFactory();

        // Create a Rectangle and call render()
        Polygon p1 = factory.createPolygon("RECTANGLE");
        p1.render();

        // Create a Triangle and call render()
        Polygon p2 = factory.createPolygon("TRIANGLE");
        p2.render();
    }
}
