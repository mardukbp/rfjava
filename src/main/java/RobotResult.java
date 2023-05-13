import java.util.Hashtable;

public class RobotResult {
    private final Hashtable<String, Object> result;

    public RobotResult(Status status, String output, Object returnValue, String error, String traceback, boolean continuable, boolean fatal) {
        result = new Hashtable<>();
        result.put("status", status.name());
        result.put("output", output);
        result.put("return", returnValue);
        result.put("error", error);
        result.put("traceback", traceback);
        result.put("continuable", continuable);
        result.put("fatal", fatal);
    }

    public Hashtable<String, Object> asHashtable() {
        return result;
    }
}
