

import olsol.flow.RestClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestClientTest {

    @Test
    public void testGetRequest() throws Exception {
        RestClient restClient = new RestClient();
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        String expectedResponse = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";
        String actualResponse = restClient.getRequest(url);
        assertEquals(expectedResponse, actualResponse);
    }

}
