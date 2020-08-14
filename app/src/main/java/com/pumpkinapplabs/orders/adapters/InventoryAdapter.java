package com.pumpkinapplabs.orders.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pumpkinapplabs.orders.R;
import com.pumpkinapplabs.orders.data.model.ItemInventory;

import java.util.List;

public class InventoryAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ItemInventory> list;
    private int ARTICLE_MAX_LENGHT = 40;

    public InventoryAdapter (Context context, int layout, List<ItemInventory> list){
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() { return list.size(); }

    @Override
    public ItemInventory getItem(int position) { return list.get(position); }

    @Override
    public long getItemId(int id) { return id; }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null );
            holder = new ViewHolder();
            holder.article = (TextView) convertView.findViewById(R.id.tvarticle);
            holder.sender = (TextView) convertView.findViewById(R.id.txtsendername);
            holder.price = (TextView) convertView.findViewById(R.id.tvprice);
            holder.stock = (TextView) convertView.findViewById(R.id.tvstock);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemInventory currentInventory = getItem(position);

        //mostrar titulos mas cortos
        String shortArticle;
        if (currentInventory.getDescription().length() > ARTICLE_MAX_LENGHT){
            shortArticle = currentInventory.getDescription().substring(0, ARTICLE_MAX_LENGHT) + ".....";
        }
        else {
            shortArticle = currentInventory.getDescription();
        }
        holder.article.setText(shortArticle);
        //Mostrar solo la primera letra del articulo
        holder.sender.setText(currentInventory.getDescription().substring(0, 1));
        //Obtener el color para mostrar con la letra del articulo
//        holder.sender.getBackground().setColorFilter(Color.parseColor("#" + currentInventory.getColor()), PorterDuff.Mode.SRC);
        holder.price.setText("Precio Unitario: $" + currentInventory.getPrice());
        holder.stock.setText("Cantidad disponibles: " + currentInventory.getStock());
        return convertView;
    }

    private class ViewHolder {
        private TextView sender;
        private TextView article;
        private TextView price;
        private TextView stock;
    }
}
