package com.example.integrador.ui.favoritos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.integrador.R;

public class FavoritosFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pesquisar, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        textView.setText("Tela Favoritos");
        return root;
    }
}
