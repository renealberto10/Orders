package com.pumpkinapplabs.orders.ui.pedidos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pumpkinapplabs.orders.R;

public class PedidosFragment extends Fragment {

    //private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

      //  dashboardViewModel =
           //     ViewModelProviders.of(this).get(DashboardViewModel.class);
       View root = inflater.inflate(R.layout.fragment_pedidos, container, false);
      //  final TextView textView = root.findViewById(R.id.text_dashboard);
       // dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
       //     public void onChanged(@Nullable String s) {
       //         textView.setText(s);
       //     }
     //   });
       return root;
    }
}