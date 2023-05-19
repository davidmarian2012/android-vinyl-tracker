package com.example.vinyl_tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class collection extends Fragment {

    private ArrayList<Vinyl> vinylList;
    private VinylAdapter vinylAdapter;
    private EditText editTextName;
    private EditText editTextArtist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_collection, container, false);

        RecyclerView recyclerViewVinyls = view.findViewById(R.id.recyclerViewVinyls);
        recyclerViewVinyls.setLayoutManager(new LinearLayoutManager(getActivity()));

        vinylList = new ArrayList<>();
        vinylAdapter = new VinylAdapter(vinylList);
        recyclerViewVinyls.setAdapter(vinylAdapter);

        editTextName = view.findViewById(R.id.editTextName);
        editTextArtist = view.findViewById(R.id.editTextArtist);

        Button buttonAddVinyl = view.findViewById(R.id.addButton);
        buttonAddVinyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vinylName = editTextName.getText().toString().trim();
                String vinylArtist = editTextArtist.getText().toString().trim();
                if (!vinylName.isEmpty() && !vinylArtist.isEmpty()) {
                    Vinyl newVinyl = new Vinyl(vinylName, vinylArtist);
                    vinylList.add(newVinyl);
                    vinylAdapter.notifyDataSetChanged();
                    editTextName.setText("");
                    buttonAddVinyl.setEnabled(true);
                }
            }
        });

        return view;
    }
}