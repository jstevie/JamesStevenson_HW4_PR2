import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class RegularPolygonPane extends Pane {
    private int sides = 4;

    /**
     * Creates a new regular polygon with white fill, black outline,
     * and 'i' number of sides. This is added to the RegularPolygonPane
     * @param sides Number of sides of regular polygon
     */
    private void paint(int sides) {
        // Create a polygon and place polygon to pane
        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // Add points to the polygon list
        for (int i = 0; i < sides; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / sides));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / sides));
        }

        getChildren().clear();
        getChildren().add(polygon);
    }

    /**
     * Sets width of polygon
     * @param width Width of polygon
     */
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    /**
     * Sets height of polygon and calls paint for utilization
     * in constructor
     * @param height Height of polygon
     */
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint(sides);
    }

    /**
     * Increases number of sides by one
     */
    public void plus(){
        sides++;
    }

    /**
     * Decreases number of sides by one
     */
    public void minus(){
        if (sides > 1)
            sides--;
    }
}
