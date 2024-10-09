package no.uio.aeroscript.runtime;

import no.uio.aeroscript.antlr.AeroScriptBaseVisitor;
import no.uio.aeroscript.antlr.AeroScriptParser;
import no.uio.aeroscript.ast.expr.Node;
import no.uio.aeroscript.ast.expr.NumberNode;
import no.uio.aeroscript.ast.expr.OperationNode;
import no.uio.aeroscript.ast.stmt.Statement;
import no.uio.aeroscript.ast.stmt.acAscend;
import no.uio.aeroscript.ast.stmt.acDescend;
import no.uio.aeroscript.ast.stmt.acDock;
import no.uio.aeroscript.ast.stmt.acMove;
import no.uio.aeroscript.ast.stmt.acTurn;
import no.uio.aeroscript.type.Memory;
import no.uio.aeroscript.type.Point;
import no.uio.aeroscript.type.Range;

import java.util.*;

public class Interpreter extends AeroScriptBaseVisitor<Object> {
    private final HashMap<Memory, Object> heap;
    private final Stack<Statement> stack;

    public Interpreter(HashMap<Memory, Object> heap, Stack<Statement> stack) {
        this.heap = heap;
        this.stack = stack;
    }

    public Point getPosition() {
        assert heap.get(Memory.VARIABLES) instanceof HashMap;
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        return (Point) vars.get("current position");
    }

    public float getDistanceTravelled() {
        // Implement this method that returns the actual distance travelled from the variables
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float distanceTravelled = (Float) vars.get("distance travelled");

        return distanceTravelled;
    }

    public float getBatteryLevel() {
        // Implement this method that returns the actual battery level from the variables
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES);
        float batteryLevel = (Float) vars.get("battery level");

        return batteryLevel;
    }

    private void checkBattery() {
        // Implement this method that checks the battery level and triggers the reaction if the battery level is low
        HashMap<String, Object> vars = (HashMap<String, Object>) heap.get(Memory.VARIABLES); 
        float batteryLevel = (Float) vars.get("battery level");

        if (batteryLevel < 20) {
            vars.put("battery low", true);
            System.out.println("Battery low!");
            // Trigger emergency landing (descend to ground)
        }
    }

    @Override
    public Object visitProgram(AeroScriptParser.ProgramContext ctx) {
        return null;
    }

    @Override
    public Object visitExecution(AeroScriptParser.ExecutionContext ctx) {
        return null;
    }

    @Override
    public Object visitStatement(AeroScriptParser.StatementContext ctx) {
        return null;
    }

    @Override
    public Object visitAction(AeroScriptParser.ActionContext ctx) {
        if (ctx.acDock() != null) {
            return new acDock(heap);
        }
        else if (ctx.acAscend() != null) {
            return new acAscend(heap, (Node) visit(ctx.acAscend().expression()));
        }
        else if (ctx.acDescend() != null){
            if (ctx.acDescend().DESCEND() != null) {
                return new acDescend(heap, (Node) visit(ctx.acDescend().expression()));
            }
            else {
                return new acDescend(heap);
            }
        }
        else if (ctx.acMove() != null) {
            if (ctx.acMove().POINT() != null) { 
                return new acMove(heap, (Point) visit(ctx.acMove().point()));
            }
            else {
                return new acMove(heap, (Node) visit(ctx.acMove().NUMBER()));
            }
        }
        else if (ctx.acTurn() != null) {
            return new acTurn(heap, (Node) visit(ctx.acTurn().expression()));
        }
        throw new IllegalArgumentException("Invalid operation!");
    }

    
    @Override
    public Object visitPoint(AeroScriptParser.PointContext ctx) {
        Node xNode = (Node) visit(ctx.expression(0));
        Node yNode = (Node) visit(ctx.expression(1));
        float x = Float.parseFloat(xNode.evaluate().toString());
        float y = Float.parseFloat(yNode.evaluate().toString());
        return new Point(x, y);
    }

    @Override
    public Object visitRange(AeroScriptParser.RangeContext ctx) {
        Node startNode = (Node) visit(ctx.expression(0));
        Node endNode = (Node) visit(ctx.expression(1));
        float start = Float.parseFloat(startNode.evaluate().toString());
        float end = Float.parseFloat(endNode.evaluate().toString());
        return new Range(start, end);
    }

    @Override
    public Node visitExpression(AeroScriptParser.ExpressionContext ctx) {
        // Case of binary operation
        if (ctx.PLUS() != null || ctx.MINUS() != null || ctx.TIMES() != null) {
            Node left = (Node) visit(ctx.expression(0));
            Node right = (Node) visit(ctx.expression(1));
            String operator = ctx.PLUS() != null ? "PLUS" :
                    ctx.MINUS() != null ? "MINUS" :
                            "TIMES";
            return new OperationNode(operator, left, right);
        }
        // Case of negation
        else if (ctx.NEG() != null) {
            Node expr = (Node) visit(ctx.expression(0));
            return new OperationNode("NEG", expr, null);
        }
        // Case of random
        else if (ctx.RANDOM() != null) {
            Node start;
            Node end;
            if (ctx.range() != null) {
                AeroScriptParser.RangeContext rangeContext = ctx.range();
                start = (Node) visit(rangeContext.expression(0));
                end = (Node) visit(rangeContext.expression(1));
            } else {
                start = new NumberNode((float) 0);
                end = new NumberNode(100F);
            }
            return new OperationNode("RANDOM", start, end);
        }
        // Case of point
        else if (ctx.POINT() != null) {
            AeroScriptParser.PointContext pointContext = ctx.point();
            Node x = (Node) visit(pointContext.expression(0));
            Node y = (Node) visit(pointContext.expression(1));
            return new OperationNode("POINT", x, y);
        }
        // Case of number
        else if (ctx.NUMBER() != null) {
            return new NumberNode(Float.parseFloat(ctx.NUMBER().getText()));
        }
        // Case of expression in parentheses
        else if (ctx.LPAREN() != null) {
            return (Node) visit(ctx.expression(0));
        }
        return new NumberNode(Float.parseFloat(ctx.NUMBER().getText()));
    }
}
