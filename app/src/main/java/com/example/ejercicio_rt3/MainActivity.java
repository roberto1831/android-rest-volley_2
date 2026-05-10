package com.example.ejercicio_rt3;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtTitulo, txtCuerpo;
    Button btnLeer, btnInsertar, btnActualizar, btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los elementos del XML con los de Java
        txtUsuario = findViewById(R.id.txtUsuario);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtCuerpo = findViewById(R.id.txtCuerpo);
        btnLeer = findViewById(R.id.btnLeer);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);

        // Configurar los botones
        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leerRest();
            }
        });

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarRest(txtUsuario.getText().toString(),
                        txtTitulo.getText().toString(),
                        txtCuerpo.getText().toString());
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRest(txtUsuario.getText().toString(),
                        txtTitulo.getText().toString(),
                        txtCuerpo.getText().toString());
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarRest(txtUsuario.getText().toString(),
                        txtTitulo.getText().toString(),
                        txtCuerpo.getText().toString());
            }
        });
    }

    // Leer datos desde la web
    private void leerRest() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(
                Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtUsuario.setText(jsonObject.getString("userId"));
                    txtTitulo.setText(jsonObject.getString("title"));
                    txtCuerpo.setText(jsonObject.getString("body"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postRequest);
    }

    // Insertar datos
    private void insertarRest(final String usuario, final String titulo, final String cuerpo) {
        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest postRequest = new StringRequest(
                Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this,
                            "Resultado: " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                param.put("title", titulo);
                param.put("body", cuerpo);
                param.put("userid", usuario);
                return param;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
    }

    // Actualizar datos
    private void updateRest(final String usuario, final String titulo, final String cuerpo) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(
                Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this,
                            "Actualizado: " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                param.put("id", "1");
                param.put("title", titulo);
                param.put("body", cuerpo);
                param.put("userid", usuario);
                return param;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
    }

    // Eliminar datos
    private void eliminarRest(final String usuario, final String titulo, final String cuerpo) {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        StringRequest postRequest = new StringRequest(
                Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(MainActivity.this,
                            "Eliminado: " + response, Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                param.put("id", "1");
                param.put("title", titulo);
                param.put("body", cuerpo);
                param.put("userid", usuario);
                return param;
            }
        };
        Volley.newRequestQueue(this).add(postRequest);
    }
}
