import java.util.Arrays;

public class TestLibrary extends KeywordLibrary {
    public String getInit() {
        return "TestLibrary Init";
    }

    public String getIntro() {
        return "TestLibrary Intro";
    }

    @Keyword(name="Sum list")
    @Doc(doc="Sum the integer numbers in a list")
    public RobotResult sumList(int[] nums) {
        int result = Arrays.stream(nums).sum();

        return new RobotResult(
                Status.PASS,
                "",
                result,
                "",
                "",
                true,
                false
        );
    }

    @Keyword(name="Sum ints")
    @Doc(doc="Sum two integer numbers")
    public RobotResult sumInts(int a, int b) {
        int result = a + b;

        return new RobotResult(
                Status.PASS,
                "",
                result,
                "",
                "",
                true,
                false
        );
    }

    @Keyword(name="Concat strings")
    @Doc(doc="Concatenate two strings")
    public RobotResult concat(String a, String b) {
        String result = a + b;

        return new RobotResult(
                Status.PASS,
                "",
                result,
                "",
                "",
                true,
                false
        );
    }

    @Keyword(name="Concat list")
    @Doc(doc="Concatenate a list of strings using the given delimiter")
    public RobotResult concatList(String delimiter, String[] strings) {
        String result = String.join(delimiter, strings);

        return new RobotResult(
                Status.PASS,
                "",
                result,
                "",
                "",
                true,
                false
        );
    }
}
