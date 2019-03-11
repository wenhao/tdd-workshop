import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void should_be_able_to_run_junit_test() throws Exception {

        // when
        App app = new App();

        // then
        assertThat(app.get()).isEqualTo("test");
    }
}
