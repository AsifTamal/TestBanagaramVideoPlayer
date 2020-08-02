package com.bongo.asifulislam.bongotest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bongo.asifulislam.bongotest.R;


public class AnagramFragment extends Fragment {

    View view;
    TextView textView;

    public AnagramFragment() {
        // Required empty public constructor
    }

    public static AnagramFragment newInstance() {
        AnagramFragment fragment = new AnagramFragment();
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
        view = inflater.inflate(R.layout.fragment_anagram, container, false);
        final EditText firstEdttxt = (EditText) view.findViewById(R.id.frsttext);
        final EditText secondEdttxt = (EditText) view.findViewById(R.id.scndtext);
        textView = (TextView) view.findViewById(R.id.reslt);
        Button btnresl = (Button) view.findViewById(R.id.submit);

        btnresl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstEdttxt.getText().toString().isEmpty()) {
                    firstEdttxt.requestFocus();
                    return;
                }
                if (secondEdttxt.getText().toString().isEmpty()) {
                    secondEdttxt.requestFocus();
                    return;
                }

                anagram(firstEdttxt.getText().toString().toLowerCase(), secondEdttxt.getText().toString().toLowerCase());

            }
        });
        return view;
    }

    private void anagram(final String text, final String text1) {
        int n1 = text.length();
        int n2 = text1.length();


        char[] ch = new char[text.length()];


        for (int i = 0; i < text.length(); i++) {
            ch[i] = text.charAt(i);
        }

        char[] ch1 = new char[text1.length()];


        for (int i = 0; i < text1.length(); i++) {
            ch1[i] = text1.charAt(i);
        }
        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2) {
            textView.setText("Not Anagram");
        } else {
            ch = sort(ch, n1);
            ch1 = sort(ch1, n2);

            // Compare sorted strings
            for (int i = 0; i < n1; i++)
                if (ch[i] != ch1[i]) {
                    textView.setText("Not Anagram");
                } else {
                    textView.setText(" Anagram");
                }
        }

    }

    private char[] sort(char[] ch, int n1) {
        for (int i = 0; i < n1 - 1; i++) {
            for (int j = i + 1; j < n1; j++) {
                if (ch[i] > ch[j]) {
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                }
            }

        }
        return ch;
    }
}