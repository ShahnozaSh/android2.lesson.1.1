package com.example.android2lesson11.ui.form;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.android2lesson11.R;

public class FormFragment extends Fragment {

    private EditText editText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    editText=view.findViewById(R.id.editText);
    view.findViewById(R.id.btnSave).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save();
        }
    });
    }

    private void save() {
        String text = editText.getText().toString().trim();//trim removes odd spaces!!!
        //in programming space is too as symbol !!! !!! !!!
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        getParentFragmentManager().setFragmentResult("rk_form", bundle);
        close();
    }

    private void close() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigateUp();
    }
}