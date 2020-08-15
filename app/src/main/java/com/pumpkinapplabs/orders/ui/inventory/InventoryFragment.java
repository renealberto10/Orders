package com.pumpkinapplabs.orders.ui.inventory;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.pumpkinapplabs.orders.R;
import com.pumpkinapplabs.orders.adapters.InventoryAdapter;
import com.pumpkinapplabs.orders.data.model.Inventories;
import com.pumpkinapplabs.orders.data.model.ItemInventory;
import com.pumpkinapplabs.orders.data.remote.InventoryRetrofit;
import com.pumpkinapplabs.orders.data.remote.Service;
import com.pumpkinapplabs.orders.data.utils.Constants;
import com.pumpkinapplabs.orders.data.utils.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InventoryFragment extends Fragment {
    private ListView listView;
    private List<ItemInventory> inventory_list;
    private InventoryAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public InventoryFragment(){
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        listView = (ListView) view.findViewById(R.id.listViewInventory);
        inventory_list = Inventory.getArrayInventory();
        //progressdialogshow();
        adapter = new InventoryAdapter(getContext(), R.layout.inventory_items, inventory_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mListener.onListClick(inventory_list.get(position));
            }
        });
        return view;
    }

    //Metodo cuando adjunto el fragment a la Activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    //Metodo que genera el comportamiento despues que se mueve a otro fragment
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onListClick(ItemInventory inventory);

    }

//Barra de progreso
    public void progressdialogshow (){
        final ProgressDialog prog= new ProgressDialog(getActivity());//Assuming that you are using fragments.
        prog.setTitle("Cargando Inventario");
        prog.setMessage("Espere estamos cargando la informacion solicitada...");
        prog.setCancelable(false);
        prog.setIndeterminate(true);
        prog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        prog.show();
       prog.show();
        long delayInMillis = 10000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                prog.dismiss();
            }
        }, delayInMillis);

    }
}