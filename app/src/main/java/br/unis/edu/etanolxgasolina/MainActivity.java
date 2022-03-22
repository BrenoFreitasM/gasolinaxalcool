package br.unis.edu.etanolxgasolina;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtAlcool;
    EditText edtGasolina;
    Button btnVerificar;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoVerificar();
    }

    protected void carregaComponentes() {
        edtGasolina = findViewById(R.id.edtGasolina);
        edtAlcool = findViewById(R.id.edtAlcool);
        btnVerificar = findViewById(R.id.btnVerificar);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoVerificar() {
        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        double alcool = Double.parseDouble(edtAlcool.getText().toString());
        double gasolina = Double.parseDouble(edtGasolina.getText().toString());
        double res = (gasolina * 0.7);
        String resultado = "Obesidade Grau IIII (mórbida)";
        if (alcool <= res) {
            resultado = "Alcool!";
        }
        else {
            resultado = "Gasolina!";
        }
        return resultado;
    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtGasolina.setText("");
        edtAlcool.setText("");

        edtAlcool.requestFocus();
        edtGasolina.requestFocus();


    }
}