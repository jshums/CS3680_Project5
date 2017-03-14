package com.cs3680.justin.js_project5_networkdata;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justi on 3/11/2017.
 */

public class PlanetFetcher {

    private  static final String TAG = "PlanetFetcher";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                ": with " +
                urlSpec);
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<Planet> fetchItems () {

        List<Planet> planets = new ArrayList<>();

        try {
            String jsonString =
                    this.getUrlString("http://universe.tc.uvu.edu/cs3680/project/p5/planets.js");
            Log.i(TAG, "Received JSON: " + jsonString);

            try {
                parseItems(planets, jsonString);
            } catch (JSONException je) {
                Log.e(TAG, "Failed to parse JSON", je);
            }
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return planets;
    }

    private void parseItems(List<Planet> planets, String jsonBody)
        throws IOException, JSONException {
        JSONArray planetsJsonArray = new JSONArray(jsonBody);
        for (int i = 0; i < planetsJsonArray.length(); i++) {
            JSONObject planetJsonObject = planetsJsonArray.getJSONObject(i);
            Planet planet = new Planet();
            planet.setType(planetJsonObject.getString("type"));
            planet.setName(planetJsonObject.getString("name"));
            planet.setMoonCount(Integer.parseInt(planetJsonObject
                    .getString("moonCount")));
            planet.setDistanceFromSun(Double.parseDouble(planetJsonObject
                    .getString("distanceFromSun")));
            planet.setDiameterKm(Double.parseDouble(planetJsonObject
                    .getString("diameterKm")));

            try {
                JSONArray satelliteJsonArray = new JSONArray(planetsJsonArray.getJSONObject(i)
                        .getString("satellites"));

                for (int j = 0; j < satelliteJsonArray.length(); j++) {
                    JSONObject satelliteJsonObject = satelliteJsonArray.getJSONObject(j);
                    Satellite satellite = new Satellite();
                    satellite.setName(satelliteJsonObject.getString("name"));
                    satellite.setDiameterKm(Double.parseDouble(satelliteJsonObject
                            .getString("diameterKm")));
                    planet.satellites.add(satellite);
                }
            } catch (JSONException je) {
                Log.e(TAG, "No satellites for this planet", je);
            }

            planets.add(planet);
        }
    }
}
