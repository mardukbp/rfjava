package com.rfjava;

import java.util.HashMap;
import java.util.Map;

public class RobotResult {
    private final Map<String, Object> result;

    private RobotResult(Status status, String output, Object returnValue, String error, String traceback, boolean continuable, boolean fatal) {
        result = new HashMap<>();
        result.put("status", status.name());
        result.put("output", output);
        result.put("return", returnValue);
        result.put("error", error);
        result.put("traceback", traceback);
        result.put("continuable", continuable);
        result.put("fatal", fatal);
    }

    public static RobotResult Pass(Object returnValue, String output) {
        return new RobotResult(
                Status.PASS,
                output,
                returnValue,
                "",
                "",
                true,
                false
        );
    }

    public static RobotResult Fail(String error) {
        return new RobotResult(
                Status.FAIL,
                "",
                "",
                error,
                "",
                true,
                false
        );
    }

    public Map<String, Object> asMap() {
        return result;
    }
}
