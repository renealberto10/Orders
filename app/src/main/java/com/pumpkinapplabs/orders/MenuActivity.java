package com.pumpkinapplabs.orders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pumpkinapplabs.orders.adapters.InventoryAdapter;
import com.pumpkinapplabs.orders.data.model.InventarioData;
import com.pumpkinapplabs.orders.data.model.Inventories;
import com.pumpkinapplabs.orders.data.remote.APIService;
import com.pumpkinapplabs.orders.data.remote.InventoryrRetrofit;
import com.pumpkinapplabs.orders.data.utils.PreferencesSave;
import com.pumpkinapplabs.orders.ui.inventory.InventoryFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity implements InventoryFragment.OnFragmentInteractionListener {

    private SharedPreferences preferencias;
    private APIService Service;
    private Call<Inventories> inventoriesCall;
    private List<InventarioData> list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        Service = InventoryrRetrofit.getApiInvetory().create(APIService.class);
        getdatainventory();

      //  if (getSupportActionBar() != null) {
       //    getSupportActionBar().hide();
      // }


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_inicio, R.id.navigation_pedidos, R.id.navigation_inventory,R.id.navigation_inventory)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
       NavigationUI.setupWithNavController(navView, navController);
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
    @Override
    public void onListClick(InventarioData inventory) {
    }

public void getdatainventory() {
    String token = PreferencesSave.getToken(preferencias);
    inventoriesCall = Service.getInventory(token);
    inventoriesCall.enqueue(new Callback<Inventories>() {
        @Override
        public void onResponse(Call<Inventories> call, Response<Inventories> response) {
           Inventories list = response.body();
           Log.d("JSON: ", list.toString());

        }

        @Override
        public void onFailure(Call<Inventories> call, Throwable t) {
          Toast.makeText(MenuActivity.this, "Error", Toast.LENGTH_LONG).show();
        }
    });
}



}