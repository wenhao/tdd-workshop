import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AppTest
{
    @Test
    public void should_run_junit()
    {
        // given
        App app = new App();

        // when

        // then
        assertThat(app.get(), is("test"));
    }
}
