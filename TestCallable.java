
import java.util.concurrent.Callable;

public class TestCallable implements Callable {
    private Integer count = 0;
    private String name;

    @Override
    public Integer call() throws Exception {
        return ++count;
    }

    public String getName() {
        return name;
    }
}
