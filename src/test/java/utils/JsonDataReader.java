package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataReader {

public List<Map<String, String>> getJsonData() throws IOException {


        ObjectMapper mapper = new ObjectMapper();



        return mapper.readValue(
                new File(System.getProperty("user.dir")
                        + "/src/test/java/TestData/LoginData.json"),
                new TypeReference<List<Map<String, String>>>() {
                }
        );
    }

}

