package com.camunda;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserClient {

    public static final String POSTS_API_URL = "https://reqres.in/api/users?page=1";
    public static String response_str = "" ;
    public static void main(String[] args) throws IOException, InterruptedException {

        URL urlObj = new URL(POSTS_API_URL);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        System.out.println("Send 'HTTP GET' request to : " + POSTS_API_URL);

        Integer responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = inputReader.readLine()) != null) {
                response.append(inputLine);
            }
            inputReader.close();
            System.out.println(response.toString());
            System.out.println("===========================================================");
            response_str = response.toString() ;
/// the following method to get only user data , we are not interested to other details about
            /// users like ad 
            response_str = get_user_data_only_from_response(response_str) ;
             
            /// parse user names and print them in console window , finally return 
            // the total number of users .
            int usersCount = printsUsersNames(response_str) ;
            System.out.println("user count is " + usersCount);

            boolean IsUserName_George = check_first_user_name(response_str) ;
    }

    }

    public static boolean check_first_user_name(String response_str ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<UserDTO> users = mapper.readValue(response_str, new TypeReference<List<UserDTO>>() {});
         if ( "George".equals( users.get(0).getFirst_Name()) )  {
             return  true  ;
         }
        return  false ;
    }

    public static int printsUsersNames(String response_str) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<UserDTO> users = mapper.readValue(response_str, new TypeReference<List<UserDTO>>() {});
        users.forEach(str->System.out.println(str.toString()));
        return users.size() ;

    }

    private static String  get_user_data_only_from_response(String response_str)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(response_str, Map.class);
        final String[] found_user_data = {""};
        map.forEach((k, v) ->
                {System.out.println( k + "  " +  v.toString() ) ;
                    if ( k == "data") {
                        try {
                            found_user_data[0] =  mapper.writeValueAsString(v);

                        } catch (JsonProcessingException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        return  found_user_data[0];
    }


}
