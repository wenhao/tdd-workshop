import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AppTest
{
    @Test
    public void should_be_able_to_run_junit_test() throws Exception
    {
        // given

        // when
        App app = new App();


        // then
        assertThat(app.getTest(), is("test"));
    }
}
