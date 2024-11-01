package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.type.Memory;

public class acDescend extends Statement {
    private HashMap<Memory, Object> heap;
    private Node node;

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
            float oldAlt = ((Number) vars.get("altitude")).floatValue();
            float distance = ((Number) vars.get("distance travelled")).floatValue();
            float battery = ((Number) vars.get("battery level")).floatValue();

            vars.put("altitude", (oldAlt - exp));
            vars.put("distance travelled", (distance + exp));
            vars.put("battery level", (battery - descendCost(exp)));
            System.out.println("Descending by " + exp);
            System.out.println("Battery level: " + vars.get("battery level"));   
        }
        else {
            HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
            float altitude = ((Number) vars.get("altitude")).floatValue();
            float distance = ((Number) vars.get("distance travelled")).floatValue();
            float battery = ((Number) vars.get("battery level")).floatValue();

            vars.put("altitude", 0);
            vars.put("distance travelled", (distance + altitude));
            vars.put("battery level", (battery - descendCost(altitude)));
            System.out.println("Descending to ground, by altitude: " + altitude);
            System.out.println("Battery level: " + vars.get("battery level"));   
        }
    }

    public float descendCost(float dist, float time, float speed) {
        return dist * 0.6f + (time * 0.1f) + (speed * 1.0f);
    }

    public float descendCost(float dist) {
        return descendCost(dist, 0.0f, 0.0f);  
    }
}