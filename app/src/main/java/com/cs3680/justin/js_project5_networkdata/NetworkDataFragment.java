package com.cs3680.justin.js_project5_networkdata;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justi on 3/11/2017.
 */

public class NetworkDataFragment extends Fragment {

    private static final String TAG = "NetworkDataFragment";

    private List<Planet> mPlanets = new ArrayList<>();

    public static NetworkDataFragment newInstance() {
        return new NetworkDataFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_network_data, container,
                false);

        return v;
    }

    private class FetchItemsTask extends AsyncTask<Void,Void,List<Planet>> {
        @Override
        protected List<Planet> doInBackground(Void... params) {
            return new PlanetFetcher().fetchItems();
        }

        @Override
        protected void onPostExecute(List<Planet> planets) {
            mPlanets = planets;
        }
    }
}
