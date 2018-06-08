package br.pucminas.teste;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText edtTexto;
    private EditText edtNumero;
    private TextView txtResultado;
    private SeekBar seekBar;

    // DECLARANDO VARIAVEIS AUXILIARES
    int progressSeekBar=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTexto = findViewById(R.id.edtTextoId);
        edtNumero = findViewById(R.id.edtNumeroID);
        txtResultado = findViewById(R.id.txtResultadoId);
        seekBar = findViewById(R.id.seekBarId);

        // ACAO A SER EXECUTAR AO ALTERAR O SEEKBAR
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressSeekBar = progress;
                txtResultado.setText("Progress SeekBar: " + String.valueOf(progressSeekBar));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public Boolean validaCampo(String campo){
        if(campo == null  || campo.equals(""))
            return false;
        return true;
    }

    // PROCEDIMENTO PARA IMPRIMIR UMA MENSAGEM NA TELA
    public void print(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    // PROCEDIMENTO PARA EXECUTAR A ACAO DE UM BOTAO
    public void onClickButton(View view){

        String texto = edtTexto.getText().toString();
        String numero = edtNumero.getText().toString();

        if(validaCampo(texto) && validaCampo(numero)){

            txtResultado.setText("Texto: " + texto + " Número: " + numero);

        }else
            print("Obrigatório informar os campos!");
    }
    public void onClickCheckBox(View view){
        Boolean checked = ((CheckBox) view).isChecked();

        if(checked)
            print("CheckBox ON");
        else
            print("CheckBox OFF");
    }
    public void OnClickRadioButton(View view){

        switch (view.getId()){
            case R.id.radioButton1Id:
                print("RadioButton1 ON");
                break;
            case R.id.radioButton2Id:
                print("RadioButton2 ON");
                break;
        }
    }
    // PROCEDIMENTO PARA EXECUTAR A ACAO DO ToggleButton
    public void onClickToggleButton(View view){
        Boolean checked = ((ToggleButton)view).isChecked();

        if(checked)
            print("ToggleButton ON");
        else
            print("ToggleButton OFF");

    }

    // PROCEDIMENTO PARA EXECUTAR A ACAO DO Switch
    public void onClickSwitch(View view){
        Boolean checked = ((Switch)view).isChecked();

        if(checked)
            print("Switch ON");
        else
            print("Switch OFF");

    }



}
