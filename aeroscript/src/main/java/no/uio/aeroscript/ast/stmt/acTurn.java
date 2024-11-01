package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.type.Memory;

public class acTurn extends Statement {
    private HashMap<Memory, Object> heap;
    private Node node;

    public acTurn(HashMap<Memory, Object> heap, Node node) {
        this.heap = heap;
        this.node = node;
    }

    @Override
    public void execute() {
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float battery = ((Number) vars.get("battery level")).floatValue();
        float exp = (float) node.evaluate();
        vars.put("battery level", (battery - turnCost((exp))));
    }

    public float turnCost(float angle, float time, float speed) {
        return angle * 0.3f + (time * 0.1f) + (speed * 1.0f);
    }

    public float turnCost(float angle) {
        return turnCost(angle, 0.0f, 0.0f);
    }
}