package com.pumpkinapplabs.orders.ui.inventory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.pumpkinapplabs.orders.R;
import com.pumpkinapplabs.orders.adapters.InventoryAdapter;
import com.pumpkinapplabs.orders.data.model.InventarioData;
import com.pumpkinapplabs.orders.data.model.Inventories;
import com.pumpkinapplabs.orders.data.remote.APIService;
import com.pumpkinapplabs.orders.data.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class InventoryFragment extends Fragment {

    private SharedPreferences preferencias;
    private APIService mAPIService;

    private List<Inventories> inventario = new ArrayList<>();

    private ListView listView;
    private List<InventarioData> inventory_list;
    private InventoryAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public InventoryFragment(){
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        listView = (ListView) view.findViewById(R.id.listViewInventory);
        inventory_list = Util.getDummyData();
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onListClick(InventarioData inventory);
    }
}