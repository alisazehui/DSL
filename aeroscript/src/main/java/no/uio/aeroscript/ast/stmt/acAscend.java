package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.type.Memory;

public class acAscend extends Statement {
    private HashMap<Memory, Object> heap;
    private Node node;

    public acAscend(HashMap<Memory, Object> heap, Node node) {
        this.heap = heap;
        this.node = node;
    }

    @Override
    public void execute() {
        float exp = (float) node.evaluate();
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float oldAlt = ((Number) vars.get("altitude")).floatValue();
        float distance = ((Number) vars.get("distance travelled")).floatValue();
        float battery = ((Number) vars.get("battery level")).floatValue();

        vars.put("altitude", (oldAlt + exp));
        vars.put("distance travelled", (distance + exp));
        vars.put("battery level", (battery - ascendCost(exp)));
        System.out.println("Ascending by " + exp);
        System.out.println("Battery level: " + vars.get("battery level"));        
    }

    public float ascendCost(float dist, float time, float speed) {
        return dist * 0.2f + (time * 0.1f) + (speed * 1.0f);
    }

    public float ascendCost(float dist) {
        return ascendCost(dist, 0.0f, 0.0f);  
    }
}
