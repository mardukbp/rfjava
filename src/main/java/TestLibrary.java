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
    public RobotResult add(int[] nums) {
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
    public RobotResult add(int a, int b) {
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
}
