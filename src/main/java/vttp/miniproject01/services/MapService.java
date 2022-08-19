package vttp.miniproject01.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.miniproject01.models.CarparkAvail;
import vttp.miniproject01.models.CarparkDetails;

@Service
public class MapService {
    
    private static final String URL = "https://www.ura.gov.sg/uraDataService/invokeUraDS";

    @Value("${ACCESS_KEY}")
    private String key;

    @Value("${TOKEN}")
    private String token;

    // @Autowired
    // private Repository Repo;

    public List<CarparkAvail> getCarparkAvail() {

        String payload;

        // Create url with query string (add parameters)
        String uri = UriComponentsBuilder.fromUriString(URL)
                    .queryParam("service", "Car_Park_Availability")
                    .toUriString();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp;


        System.out.println("---------RETRIEVING CARPARK AVAILABILITY-------\n\n");
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("AccessKey", key);
            headers.set("Token", token);

            HttpEntity<String> request = new HttpEntity<>(headers);

            // resp = template.exchange(url, method, requestEntity, responseType, uriVariables)
            resp = template.exchange(uri, HttpMethod.GET, request, String.class, 1);

            payload = resp.getBody();
            // System.out.println(">>> PAYLOAD: " + payload);

            // Convert payload into JsonObject
            // Convert string to a Reader
            Reader strReader = new StringReader(payload);

            // Create a JsonReader from reader
            JsonReader jsonReader = Json.createReader(strReader);

            // Read and save the payload as Json Object
            JsonObject jObject = jsonReader.readObject();
                                            // should tally with the object name from api
            JsonArray resultArray = jObject.getJsonArray("Result");

            List<CarparkAvail> list = new LinkedList<>();
            for (int i = 0; i < resultArray.size(); i++) {
                // loop through the top _ coins
                JsonObject jo = resultArray.getJsonObject(i);
                JsonArray coord = jo.getJsonArray("geometries");
                JsonObject coordinates = coord.getJsonObject(0);

                list.add(CarparkAvail.create(jo, coordinates));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }

    public List<CarparkDetails> getCarparkDetails() {

        String payload;

        // Create url with query string (add parameters)
        String uri = UriComponentsBuilder.fromUriString(URL)
                    .queryParam("service", "Car_Park_Details")
                    .toUriString();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp;


        System.out.println("---------RETRIEVING CARPARK DETAILS-------\n\n");
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.set("AccessKey", key);
            headers.set("Token", token);

            HttpEntity<String> request = new HttpEntity<>(headers);

            // resp = template.exchange(url, method, requestEntity, responseType, uriVariables)
            resp = template.exchange(uri, HttpMethod.GET, request, String.class, 1);

            payload = resp.getBody();
            // System.out.println(">>> CARPARK DETAILS: " + payload);
            
            // Convert payload into JsonObject
            // Convert string to a Reader
            Reader strReader = new StringReader(payload);

            // Create a JsonReader from reader
            JsonReader jsonReader = Json.createReader(strReader);

            // Read and save the payload as Json Object
            JsonObject jObject = jsonReader.readObject();
                                            // should tally with the object name from api
            JsonArray resultArray = jObject.getJsonArray("Result");

            List<CarparkDetails> list = new LinkedList<>();
            for (int i = 0; i < resultArray.size(); i++) {
                // loop through the top _ coins
                JsonObject jo = resultArray.getJsonObject(i);
                JsonArray coord = jo.getJsonArray("geometries");
                JsonObject coordinates = coord.getJsonObject(0);

                list.add(CarparkDetails.create(jo, coordinates));
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
