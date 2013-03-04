import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class PostTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }
    @Test
    public void testingPostMethod() {
        new Post("This is testing post.").save();

        Post tPost = Post.find("byRating", 1).first();
        assertNotNull(tPost);
        assertEquals(1, tPost.rating);
        assertEquals(1, Post.count());
        assertEquals(true, tPost.message.contains("testing"));
    }
}
