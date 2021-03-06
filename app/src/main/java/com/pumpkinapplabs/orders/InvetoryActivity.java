package com.pumpkinapplabs.orders;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pumpkinapplabs.orders.adapters.InventoryAdapter;
import com.pumpkinapplabs.orders.data.model.ItemInventory;
import com.pumpkinapplabs.orders.data.utils.UtilsInventory;

import java.util.List;

public class InvetoryActivity extends AppCompatActivity {

    private ListView listView;
    private List<ItemInventory> inventory_list;
    private InventoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invetory);
        UtilsInventory.getdatainventory();
        listView = (ListView) findViewById(R.id.lvInventoryactivity);
        //inventory_list = UtilsInventory.getArrayInventory();
        inventory_list = UtilsInventory.getArrayInventory();
        adapter = new InventoryAdapter(this, R.layout.inventory_items, inventory_list);
        listView.setAdapter(adapter);
//Menu
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item){
                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.navigation_inventory:
                        intent = new Intent(InvetoryActivity.this, InvetoryActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       return true;
                    case R.id.navigation_inicio:
                        intent = new Intent(InvetoryActivity.this, MenuActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        break;
                    case R.id.navigation_pedidos:
                        intent = new Intent(InvetoryActivity.this, OrderActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        break;
                    default:
                }
                startActivity(intent);
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_logout:
                logOut();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void logOut() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}