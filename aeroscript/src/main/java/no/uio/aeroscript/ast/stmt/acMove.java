package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;

public class acMove extends Statement {
    private HashMap<Memory, Object> heap;
    private Node node;
    private Point point;

    public acMove(HashMap<Memory, Object> heap, Point point) {
        this.heap = heap;
        this.point = point;
    }

    public acMove(HashMap<Memory, Object> heap, Node node) {
        this.heap = heap;
        this.node = node;
    }

    @Override
    public void execute() {
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);

        if (point != null) {
            float distance = (float) vars.get("distance travelled");
            float battery = (float) vars.get("battery level");
            Point current = (Point) vars.get("current position");
            float x1 = current.getX();
            float y1 = current.getY();
            float x2 = point.getX();
            float y2 = point.getY();

            float dx = x2 - x1;
            float dy = y2 - y1;
            float exp = (float) Math.sqrt(dx * dx + dy * dy);

            vars.put("current position", point);
            vars.put("distance travelled", (distance + exp));
            vars.put("battery level", (battery - moveCostPoint(exp)));
        }
        else {
            float distance = (float) vars.get("distance travelled");
            float battery = (float) vars.get("battery level");
            Point current = (Point) vars.get("current position");
            float exp = (float) node.evaluate();

            float x1 = current.getX();
            float newX = x1 + exp;
            
            Point newPoint = new Point(newX, current.getY());

            vars.put("current position", newPoint);
            vars.put("distance travelled", (distance + exp));
            vars.put("battery level", (battery - moveCostN(exp)));
        }
    }

    public double moveCostPoint(float dist, float time, float speed) {
        return dist * 0.7 + (time * 0.1) + (speed * 1);
    }

    public double moveCostPoint(float dist) {
        return moveCostPoint(dist, 0.0f, 0.0f);  
    }

    public double moveCostN(float dist, float time, float speed) {
        return dist * 0.5 + (time * 0.1) + (speed * 1);
    }

    public double moveCostN(float dist) {
        return moveCostN(dist, 0.0f, 0.0f);  
    }
}