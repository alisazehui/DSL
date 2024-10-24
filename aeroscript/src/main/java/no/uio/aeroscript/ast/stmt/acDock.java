package no.uio.aeroscript.ast.stmt;
import java.util.HashMap;
import no.uio.aeroscript.ast.expr.*;
import no.uio.aeroscript.type.Memory;

public class acDock extends Statement {
    private HashMap<Memory, Object> heap;

    public acDock(HashMap<Memory, Object> heap) {
        this.heap = heap;
    }

    @Override
    public void execute() {
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float altitude = (float) vars.get("altitude");
        float battery = (float) vars.get("battery level");
        vars.put("battery level", (battery - dockCost(altitude)));
        vars.put("current position", vars.get("initial position"));
    }

    public double dockCost(float altitude, float time, float speed) {
        return altitude + (time * 0.1) + (speed * 1);
    }

    public double dockCost(float altitude) {
        return dockCost(altitude, 0.0f, 0.0f);  
    }
}