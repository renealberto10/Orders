package com.pumpkinapplabs.orders;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.media.MediaSession2Service;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pumpkinapplabs.orders.data.model.ItemCustomer;
import com.pumpkinapplabs.orders.data.model.ItemInventory;
import com.pumpkinapplabs.orders.data.utils.Constants;
import com.pumpkinapplabs.orders.data.utils.UtilCustomer;
import com.pumpkinapplabs.orders.data.utils.UtilsInventory;
import com.pumpkinapplabs.orders.ui.inventory.CustomerFragment;
import com.pumpkinapplabs.orders.ui.inventory.InventoryFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MenuActivity extends AppCompatActivity /*implements InventoryFragment.OnFragmentInteractionListener*/ {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Constants.instance(this.getApplicationContext());
        // UtilsInventory.getdatainventory();
        // UtilCustomer.getdatacustomer();

//Menu
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item){
                Intent intent = null;

                switch (item.getItemId()) {
                    case R.id.navigation_inventory:
                        intent = new Intent(MenuActivity.this, InvetoryActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        return true;
                    case R.id.navigation_inicio:
                        intent = new Intent(MenuActivity.this, MenuActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        break;
                      //  break;
                    case R.id.navigation_pedidos:
                        intent = new Intent(MenuActivity.this, OrderActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       break;
                    default:
                        return false;
                }
                startActivity(intent);
                return true;
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

    //Este evento clic hereda del fragment Inventory
   /* @Override
    public void onListClick(ItemInventory inventory) {
    }*/

    //Este evento clic hereda del fragment Inventory
  //  @Override
  //  public void onListClick(ItemCustomer customer) {
  //  }
}
