package parser.json;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CnnAPI {
    /*
      You can get API_KEY from this below link. Once you have the API_KEY, you can fetch the top-headlines news.
      https://newsapi.org/s/cnn-api

      Fetch This following CNN API, It will return some news in Json data. Store the data in the data.json file
      https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=4b2b29d7b0844eab8dd8fe9182a063ef

	   Read the articles array and construct Headline news as

	   source,
	   author,
	   title,
	   description,
	   url,
	   urlToImage,
	   publishedAt
	   content.

	   You need to design News Data Model and construct headline news.
	   You can store in Map and then into ArrayList as your choice of Data Structure.

     */

    public static void main(String[] args) throws IOException, JSONException {
        URL link = new URL( "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=4b2b29d7b0844eab8dd8fe9182a063ef");
        InputStream is = link.openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String finalContainer="";
        int tempContainer;
        while ((tempContainer = rd.read()) != -1) {
            char nextChar=(char) tempContainer;
            finalContainer= finalContainer+nextChar;
        }
        System.out.println(finalContainer);

        PrintWriter out = new PrintWriter("src/parser/json/data.json");
        out.println(finalContainer);

        out.close();

        JSONObject rootObject = new JSONObject(new String(Files.readAllBytes(new File("src/parser/json/data.json").toPath())));
        JSONArray array = rootObject.getJSONArray("articles");
        List<Articles> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject dataJson = array.getJSONObject(i);
            ObjectMapper objectMapper = new ObjectMapper();
            Articles data = null;
            try {
                data = objectMapper.readValue(dataJson.toString(), Articles.class);
            } catch (JsonMappingException e) {
                e.printStackTrace();
            }
            list.add(data);
        }
        System.out.println(list);

        //continue


    }

}
