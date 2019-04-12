package br.com.ricardo.testeandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ContactFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contactView = inflater.inflate(R.layout.fragment_contact, container, false);

        return contactView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }
}