package com.pumpkinapplabs.orders.ui.inventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pumpkinapplabs.orders.R;

public class InventoryFragment extends Fragment {

   // private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // notificationsViewModel =
           //     ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inventory, container, false);
        //final TextView textView = root.findViewById(R.id.text_notifications);
       // notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
        //    public void onChanged(@Nullable String s) {
        //        textView.setText(s);
          //  }
       // });
        return root;
    }
}