import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public abstract class KeywordLibrary {
    Map<String, String> pythonTypes = new HashMap<String, String>(){{
        put("int", "int");
        put("boolean", "bool");
        put("double", "float");
        put("String", "str");
    }};

    private final Map<String, RobotKeyword> keywords = Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(Keyword.class))
            .collect(Collectors.toMap(
                    (method -> method.getAnnotation(Keyword.class).name()),
                    (method -> new RobotKeyword(
                            method,
                            method.getAnnotation(Keyword.class).name(),
                            method.getAnnotation(Doc.class).doc(),
                            Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.toList()),
                            Arrays.stream(method.getParameterTypes()).map(type -> pythonTypes.get(type.getTypeName())).collect(Collectors.toList())
                    ))
            ));

    public abstract String getInit();
    public abstract String getIntro();

    public List<String> getKeywordNames() {
        return new ArrayList<>(keywords.keySet());
    }

    public RobotKeyword getKeyword(String keyword) {
        return keywords.get(keyword);
    }

    private static int[] toIntArray(Object[] array) {
        return Arrays.stream(array).mapToInt(Integer.class::cast).toArray();
    }

    private static double[] toDoubleArray(Object[] array) {
        return Arrays.stream(array).mapToDouble(Double.class::cast).toArray();
    }

    private static String[] toStrArray(Object[] array) {
        return Arrays.copyOf(array, array.length, String[].class);
    }

    private boolean isIntArray(Object obj) {
        return obj instanceof Object[] && ((Object[])obj)[0] instanceof Integer;
    }

    private boolean isDoubleArray(Object obj) {
        return obj instanceof Object[] && ((Object[])obj)[0] instanceof Double;
    }

    private boolean isStrArray(Object obj) {
        return obj instanceof Object[] && ((Object[])obj)[0] instanceof String;
    }

    private Object cast(Object arg) {
        if (isIntArray(arg)) {
            return toIntArray((Object[])arg);
        }

        if (isDoubleArray(arg)) {
            return toDoubleArray((Object[])arg);
        }

        if (isStrArray(arg)) {
            return toStrArray((Object[])arg);
        }

        return arg;
    }

    public RobotResult callKeyword(String keyword, Object[] args) {
        try {
            Object[] parsedArgs = Arrays.stream(args).map(this::cast).toArray();
            return (RobotResult)keywords.get(keyword).method.invoke(this, parsedArgs);
        }
        catch (InvocationTargetException | IllegalAccessException e) {
            return RobotResult.Fail("Calling keyword failed");
        }
    }
}
