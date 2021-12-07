package com.golden.ejecafetero.Fragments;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.golden.ejecafetero.R;

public class PreferenciasFragment extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferenciasfragment);
    }
}