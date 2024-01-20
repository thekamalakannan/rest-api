import com.fasterxml.jackson.databind.ObjectMapper;
import olsol.bean.Todo;
import olsol.flow.RestClient;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RestClientTest {

    public static String url = "https://jsonplaceholder.typicode.com/posts/1";
    RestClient restClient = new RestClient();

    @Test
    public void testGetRequest() throws Exception {
        String expectedResponse = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";
        String actualResponse = restClient.getRequest(url);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void convertStringToJSONObject() throws IOException {
        String jsonString = restClient.getRequest(url);
        ObjectMapper objectMapper = new ObjectMapper();
        Todo todo;
        try {
            todo = objectMapper.readValue(jsonString, Todo.class);
            assertEquals(1, todo.userId);
            assertEquals(1, todo.id);
            assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", todo.title);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
