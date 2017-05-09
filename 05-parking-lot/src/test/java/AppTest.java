import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AppTest
{
    @Test
    public void should_be_able_to_run_junit_test() throws Exception
    {

        // when
        App app = new App();

        // then
        assertThat(app.get(), is("test"));
    }
}
