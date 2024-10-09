package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.type.Memory;

public class acDescend extends Statement {
    HashMap<Memory, Object> heap;
    Node node;

    public acDescend(HashMap<Memory, Object> heap, Node node) {
        this.heap = heap;
        this.node = node;
    }

    public acDescend(HashMap<Memory, Object> heap) {
        this.heap = heap;
    }

    @Override
    public void execute() {
        if (node != null) {
            float exp = (float) node.evaluate();
            HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
            float oldAlt = (float) vars.get("altitude");
            float distance = (float) vars.get("distance travelled");
            float battery = (float) vars.get("battery level");

            vars.put("altitude", (oldAlt - exp));
            vars.put("distance travelled", (distance + exp));
            vars.put("battery level", (battery - descendCost(exp)));
        }
        else {
            HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
            float distance = (float) vars.get("distance travelled");
            float battery = (float) vars.get("battery level");
            float altitude = (float) vars.get("altitude");

            vars.put("altitude", 0);
            vars.put("distance travelled", (distance + altitude));
            vars.put("battery level", (battery - descendCost(altitude)));
        }
    }

    public double descendCost(float dist, float time, float speed) {
        return dist * 0.6 + (time * 0.1) + (speed * 1);
    }

    public double descendCost(float dist) {
        return descendCost(dist, 0.0f, 0.0f);  
    }
}