package olsol.flow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class RestClient {

    public String getRequest(String url) throws IOException {

        Log log = LogFactory.getLog(RestClient.class.getName());
        String responseEntity = null;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            responseEntity =  entity != null ? EntityUtils.toString(entity) : null;
            log.info("Response entity: "+responseEntity);
        } catch (Exception e) {
            log.error("Unable to establish connection", e);
        }

        return responseEntity;

    }

}
