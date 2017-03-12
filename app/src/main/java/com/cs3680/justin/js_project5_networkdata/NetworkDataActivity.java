package com.cs3680.justin.js_project5_networkdata;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class NetworkDataActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment () {
        return NetworkDataFragment.newInstance();
    }


}
