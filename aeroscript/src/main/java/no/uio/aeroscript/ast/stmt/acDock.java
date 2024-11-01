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
        float altitude = ((Number) vars.get("altitude")).floatValue();
        float battery = ((Number) vars.get("battery level")).floatValue();
        vars.put("battery level", (battery - dockCost(altitude)));
        vars.put("current position", vars.get("initial position"));
        System.out.println("Dock");
        System.out.println("Battery level: " + vars.get("battery level"));   
    }

    public float dockCost(float altitude, float time, float speed) {
        return altitude + (time * 0.1f) + (speed * 1.0f);
    }

    public float dockCost(float altitude) {
        return dockCost(altitude, 0.0f, 0.0f);  
    }
}