package Tools;
import Figures.Oval;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import sample.Controller;

public class OvalTool extends Tool{

    public OvalTool(Canvas canvas) {
        super(canvas);
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    @Override
    public void getOnMousePressed(MouseEvent event) {
        x0 = event.getX();
        y0 = event.getY();
    }

    @Override
    public void getOnMouseDragged(MouseEvent event) {
        graphicsContext.clearRect(0,0,1920,1080);
        Controller.repaintCanvas();
        x = Math.min(x0,event.getX());
        y = Math.min(y0,event.getY());
        width = Math.abs(event.getX() - x0);
        height = Math.abs(event.getY() - y0);
        graphicsContext.setStroke(color);
        graphicsContext.strokeOval(x,y,width,height);
    }

    @Override
    public void getOnMouseReleased(MouseEvent event) {
        Controller.repaintCanvas();
        Controller.addFigure(new Oval(x0,y0, event.getX(), event.getY() ,graphicsContext , color));
    }
}
