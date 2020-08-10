package com.pumpkinapplabs.orders;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.pumpkinapplabs.orders.data.model.LoginPost;
import com.pumpkinapplabs.orders.data.remote.APIService;
import com.pumpkinapplabs.orders.data.remote.ApiUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {
        private APIService mAPIService;
        private EditText edtuser,edtpassword;
        private Button btnlogin;
        private SharedPreferences preferencias;
        ProgressDialog progress;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            actionBar();
            DesignUI();

            preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progress = new ProgressDialog(LoginActivity.this);
                    progress.setMessage("Espere, procesando informacion...");
                    progress.show();
                LoginUser();
                }
            });

        }

        //Metodo super toast para mostrar notificaciones interativas y personalizadas
        @SuppressLint("WrongConstant")
        public void message (String messages){
            final String MATERIAL_COLOR = "f95d5d";
            SuperActivityToast.create(this, new Style(), Style.TYPE_BUTTON)
                    //.setButtonText("UNDO")
                    //.setButtonIconResource(R.drawable.ic_buscar)
                    //.setOnButtonClickListener("good_tag_name", null, onButtonClickListener)
                    .setProgressBarColor(Color.WHITE)
                    .setText(messages)
                    .setDuration(Style.DURATION_LONG)
                    .setFrame(Style.FRAME_LOLLIPOP)
                    //.setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_LIGHT_BLUE))
                    .setColor(PaletteUtils.getSolidColor(MATERIAL_COLOR))
                    .setAnimations(Style.ANIMATIONS_POP).show();
        }

    public void saveLoginUser(LoginPost response){
        SharedPreferences.Editor saveinfo = preferencias.edit();
                    saveinfo.putInt("user_id", response.getUserid());
                    saveinfo.putString("token", response.getToken());
                    saveinfo.putInt("rol", response.getRol());
                    saveinfo.apply();

    }
   public void LoginUser(){
            DesignUI();
       String struser = edtuser.getText().toString().trim();
       String strpassword = edtpassword.getText().toString().trim();

       if(TextUtils.isEmpty(struser)){
           String msj = "Debe de digitar su Usuario";
           message(msj);
           //Toast.makeText(LoginActivity.this, "Debe de digitar su Usuario", Toast.LENGTH_SHORT).show();
           progress.dismiss();

       }else if(TextUtils.isEmpty(strpassword)){
           String msj = "Debe de digitar su Contraseña";
           message(msj);
           //Toast.makeText(LoginActivity.this, "Debe de digitar su Contraseña", Toast.LENGTH_SHORT).show();
           progress.dismiss();
       }
        else {
           sendPost(struser, strpassword);
       }

   }

//Metodo hide Action bar
    private void actionBar (){
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    //UX Metodo
    private void DesignUI()
    {
        edtuser = findViewById(R.id.user_login);
        edtpassword = findViewById(R.id.password_login);
        btnlogin = findViewById(R.id.btnlogin);
        mAPIService = ApiUtils.getAPIService();
    }
public void loginUser(LoginPost response){
                    saveLoginUser(response);
                    Intent i = new Intent(this, MenuActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    progress.dismiss();
                    this.finish();
                }

//Metodo donde se envia los parametros para ejecutar el post a auth/login

    public void sendPost(String struser, String strpassword) {

        mAPIService.savePost(struser,strpassword).enqueue(new Callback<LoginPost>() {

            @Override
            public void onResponse(Call<LoginPost> call, Response<LoginPost> response) {

                if(response.isSuccessful()) {
                    if(response.body() !=null){
                        Log.i("Conexion exitosa", response.body().toString());
                        LoginPost jsonresponse = response.body();
                        loginUser(jsonresponse);
                    }
                    else{
                        Log.i("Conexion fallo", "Body() null");

                    }

                }
            }
            @Override
            public void onFailure(Call<LoginPost> call, Throwable t) {
                progress.dismiss();
                String msj = "Usuario o Contraseña incorrecto";
                message(msj);
                //Toast.makeText(LoginActivity.this, "Usuario o Contraseña incorrecto", Toast.LENGTH_LONG).show();

            }
        });

    }

}