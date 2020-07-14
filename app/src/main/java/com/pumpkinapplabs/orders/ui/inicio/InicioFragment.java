package com.pumpkinapplabs.orders.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pumpkinapplabs.orders.R;

public class InicioFragment extends Fragment {

    //private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
     //   homeViewModel =
      //          ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
       // homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
         ///       textView.setText(s);
           // }
       // });
        return root;
    }
}