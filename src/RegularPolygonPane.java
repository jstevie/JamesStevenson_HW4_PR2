import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class RegularPolygonPane extends Pane {
    private Polygon polygon = new Polygon();
    private int num = 4;

    public void paint(int x) {
        // Create a polygon and place polygon to pane
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        ObservableList<Double> list = polygon.getPoints();
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight()) * 0.4;

        // Add points to the polygon list
        for (int i = 0; i < x; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / x));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / x));
        }

        getChildren().clear();
        getChildren().add(polygon);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint(num);
    }

    /*public void plus(){
        num++;
    }

    public void minus(){
        num--;
    }
    */
}
