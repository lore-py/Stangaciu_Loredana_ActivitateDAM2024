package com.example.seminar9_actual;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main{
    private List<Situatie> situatii = new ArrayList<>();

    public void run() {
        HttpURLConnection connection = null;
        try {
            // Connect to the API
            URL url = new URL("https://pdm.ase.ro/situatii.json");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the input stream
                InputStream is = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parse the JSON response into Situatie objects
                String jsonResponse = response.toString();
                parseSituatiiFromJson(jsonResponse);

                // Print each Situatie object to verify parsing
                for (Situatie situatie : situatii) {
                    System.out.println(situatie);
                }
            } else {
                System.err.println("HTTP Error: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error fetching or parsing data: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect(); // Close the connection
            }
        }
    }

    private void parseSituatiiFromJson(String jsonResponse) {
        try {
            // Parse the JSON as an array
            JSONArray jsonArray = new JSONArray(jsonResponse);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extract each field and handle defaults
                String disciplina = jsonObject.optString("disciplina", "Unknown");
                String activitate = jsonObject.optString("activitate", "Unknown");
                float valoare = (float) jsonObject.optDouble("valoare", 0.0);
                String data = jsonObject.optString("data", "Unknown");
                String descriere = jsonObject.optString("descriere", "No description");

                // Create a Situatie object and add it to the list
                Situatie situatie = new Situatie(disciplina, activitate, valoare, data, descriere);
                situatii.add(situatie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
    }

    public List<Situatie> getSituatie() {
        return situatii;
    }
}
