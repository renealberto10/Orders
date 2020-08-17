package com.pumpkinapplabs.orders.ui.inventory;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.telephony.ims.ImsMmTelManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.pumpkinapplabs.orders.R;
import com.pumpkinapplabs.orders.adapters.CustomerAdapter;
import com.pumpkinapplabs.orders.adapters.InventoryAdapter;
import com.pumpkinapplabs.orders.data.model.Customer;
import com.pumpkinapplabs.orders.data.model.ItemCustomer;
import com.pumpkinapplabs.orders.data.model.ItemInventory;
import com.pumpkinapplabs.orders.data.utils.UtilCustomer;
import com.pumpkinapplabs.orders.data.utils.UtilsInventory;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CustomerFragment extends Fragment {
    private ListView listView;
    private List<ItemCustomer> customers_list;
    private CustomerAdapter adapter;
    private OnFragmentInteractionListener mListener;

    public CustomerFragment(){
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_customer, container, false);

        listView = (ListView) view.findViewById(R.id.listViewCustomer);
        customers_list = UtilCustomer.getArrayCustomer();
        //progressdialogshow();
        adapter = new CustomerAdapter(getContext(), R.layout.customer_items, customers_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mListener.onListClick(customers_list.get(position));
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
        void onListClick(ItemCustomer customer);

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
        long delayInMillis = 800;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                prog.dismiss();
            }
        }, delayInMillis);

    }
}