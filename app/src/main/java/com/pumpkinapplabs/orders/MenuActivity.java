package com.pumpkinapplabs.orders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.pumpkinapplabs.orders.data.model.Inventories;
import com.pumpkinapplabs.orders.data.model.ItemInventory;
import com.pumpkinapplabs.orders.data.remote.InventoryRetrofit;
import com.pumpkinapplabs.orders.data.remote.Service;
import com.pumpkinapplabs.orders.data.utils.Constants;
import com.pumpkinapplabs.orders.data.utils.PreferencesSave;
import com.pumpkinapplabs.orders.ui.inventory.InventoryFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity implements InventoryFragment.OnFragmentInteractionListener {

   // private SharedPreferences preferencias;
  //  private Call<Inventories> list;
   // private String token;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Constants.instance(this.getApplicationContext());
      //  preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
      //  token = PreferencesSave.getToken(preferencias);

   //     getdatainventory();


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
    public void onListClick(ItemInventory inventory) {
    }
/**
public void getdatainventory() {
    Service serviceAPI = InventoryRetrofit.getClient();
    list = serviceAPI.getInventory("Bearer "+token);

    list.enqueue(new Callback<Inventories>() {
        @Override
        public void onResponse(Call <Inventories> call, Response<Inventories> response) {
            try {

                List<ItemInventory> arrayList = response.body().getData();
                Log.e("TAG", "response 33: "+new Gson().toJson(response.body()) );


        }
            catch (Exception e){
                Log.d("onResponse", "There is an error");
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<Inventories> call, Throwable t) {
            Log.d("onFailure", t.toString());
        }
    });


}**/
}
