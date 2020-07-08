package com.pumpkinapplabs.orders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pumpkinapplabs.orders.data.model.LoginPost;
import com.pumpkinapplabs.orders.data.remote.APIService;
import com.pumpkinapplabs.orders.data.remote.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {
        private APIService mAPIService;
        private static final String TAG = "LoginActivity";
        EditText edtuser,edtpassword;
        Button btnlogin;
        TextView mResponseTv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            mResponseTv = findViewById(R.id.tv_response);
            edtuser = findViewById(R.id.user_login);
            edtpassword = findViewById(R.id.password_login);
            btnlogin = findViewById(R.id.btnlogin);
            mAPIService = ApiUtils.getAPIService();
            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setMessage("Espere, procesando informacion...");
                    progressDialog.show();

//        After 2 Seconds i dismiss progress Dialog

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                                Thread.sleep(2000);
                                if (progressDialog.isShowing())
                                    progressDialog.dismiss();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                    String struser = edtuser.getText().toString().trim();
                    String strpassword = edtpassword.getText().toString().trim();

                    if(!TextUtils.isEmpty(struser) && !TextUtils.isEmpty(strpassword)){
                        sendPost(struser, strpassword);
                    }

                }
            });

        }
//Metodo donde se envia los parametros para ejecutar el post a auth/login
    public void sendPost(String struser, final String strpassword) {
            mAPIService.savePost(struser,strpassword).enqueue(new Callback<LoginPost>() {
                @Override
                public void onResponse(Call<LoginPost> call, Response<LoginPost> response) {
//Validacion de la repuesta de post y envio de data a otro activity
                   if(response.body().getUserid()!=null) {

                       int rolid = response.body().getRol();
                       int userid = response.body().getUserid();
                       String token = response.body().getToken();

                       Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("token", token);
                        intent.putExtra("userid", userid);
                        intent.putExtra("rolid", rolid);

                        startActivity(intent);
                      /**
                        Log.i(TAG, "post submitted to API." + response.body().toString());**/
                   }
                   else
                   {
                       Toast.makeText(LoginActivity.this, "Usuario o Contrasena incorrecto", Toast.LENGTH_SHORT).show();

                   }

                }
                @Override
                public void onFailure(Call<LoginPost> call, Throwable t) {

                    Toast.makeText(LoginActivity.this, "Problema con la conexion a internet. Intente mas tarde", Toast.LENGTH_SHORT).show();
                }
            });

    }

}