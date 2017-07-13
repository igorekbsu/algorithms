package nub;
import java.util.List;

public class Nu {
    public interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }
}
