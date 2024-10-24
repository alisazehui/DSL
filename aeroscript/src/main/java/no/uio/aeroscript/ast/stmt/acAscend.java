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
        float oldAlt = (float) vars.get("altitude");
        float distance = (float) vars.get("distance travelled");
        float battery = (float) vars.get("battery level");

        vars.put("altitude", (oldAlt + exp));
        vars.put("distance travelled", (distance + exp));
        vars.put("battery level", (battery - ascendCost(exp)));
    }

    public double ascendCost(float dist, float time, float speed) {
        return dist * 0.2 + (time * 0.1) + (speed * 1);
    }

    public double ascendCost(float dist) {
        return ascendCost(dist, 0.0f, 0.0f);  
    }
}
