package com.bongo.asifulislam.bongotest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bongo.asifulislam.bongotest.R;

import com.bongo.asifulislam.bongotest.Vahicle;



public class InterfaceClassFragment extends Fragment {

    View view;

    public InterfaceClassFragment() {
        // Required empty public constructor
    }



    public static Fragment newInstance() {
        InterfaceClassFragment fragment = new InterfaceClassFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_interface_class, container, false);


        return view;

    }
    private class car implements Vahicle {
        @Override
        public int set_num_of_wheels() {
            return 0;
        }

        @Override
        public int set_num_of_passengers() {
            return 0;
        }

        @Override
        public boolean has_gas() {
            return false;
        }
    }
    private class plane extends car
    {
        @Override
        public int set_num_of_passengers() {
            return super.set_num_of_passengers();
        }

        @Override
        public boolean has_gas() {

            return super.has_gas();
        }

        @Override
        public int set_num_of_wheels() {
            return super.set_num_of_wheels();
        }
    }
}