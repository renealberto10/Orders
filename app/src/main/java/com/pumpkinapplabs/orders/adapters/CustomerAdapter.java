package com.pumpkinapplabs.orders.adapters;

import android.content.Context;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pumpkinapplabs.orders.R;
import com.pumpkinapplabs.orders.data.model.ItemCustomer;
import com.pumpkinapplabs.orders.data.model.ItemInventory;

import java.util.List;

public class CustomerAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ItemCustomer> list;
    private int ADDRESS_MAX_LENGHT = 80;
    private int COMPANY_MAX_LENGHT = 40;

    public CustomerAdapter(Context context, int layout, List<ItemCustomer> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }
    @Override
    public int getCount() { return list.size(); }

    @Override
    public ItemCustomer getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int id) { return id; }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        if(convertView==null){

            convertView = LayoutInflater.from(context).inflate(layout, null);
            holder = new ViewHolder();
            holder.company = (TextView) convertView.findViewById(R.id.tvcompany);
            holder.sender = (TextView) convertView.findViewById(R.id.tvsendercustomer);
            holder.contact = (TextView) convertView.findViewById(R.id.tvcontact);
            holder.address = (TextView) convertView.findViewById(R.id.tvaddress);
            holder.cellphone = (TextView) convertView.findViewById(R.id.tvcellphone);
            holder.code = (TextView) convertView.findViewById(R.id.tvcode);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ItemCustomer currentCustomer = getItem(position);

        String shortCompany;
        if(currentCustomer.getBusinessName().length() > COMPANY_MAX_LENGHT){
            shortCompany = currentCustomer.getBusinessName().substring(0, COMPANY_MAX_LENGHT) + ".....";
        }else {
            shortCompany = currentCustomer.getBusinessName();
        }
        String shortAddress;
        if(currentCustomer.getAddress().length() > ADDRESS_MAX_LENGHT){
            shortAddress = currentCustomer.getAddress().substring(0, ADDRESS_MAX_LENGHT) + ".....";
        }else {
            shortAddress = currentCustomer.getAddress();
        }

        holder.company.setText(shortCompany);
        holder.sender.setText(currentCustomer.getBusinessName().substring(0, 1));
        holder.contact.setText("Contacto: " + currentCustomer.getContactName());
        holder.address.setText("Direccion: " + shortAddress);
        holder.cellphone.setText("Telefono: " + currentCustomer.getCellphone());
        holder.code.setText("Codigo: " + currentCustomer.getId());
        return convertView;
    }

    private class ViewHolder {
        private TextView sender;
        private TextView company;
        private TextView contact;
        private TextView address;
        private TextView cellphone;
        private TextView code;
    }
}
