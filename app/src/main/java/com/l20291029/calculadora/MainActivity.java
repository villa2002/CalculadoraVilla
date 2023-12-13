package com.l20291029.calculadora;

import android.content.ClipData;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;



public class MainActivity extends AppCompatActivity {
    private Toolbar CnToolbar;
    TextView resultado, total;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPunto, btndivision, btnResta, btnMas, btnMultiplicacion, btnPorcentaje, btnBorrar, btnParentesis,btna;
    ClipData.Item menu1;
    boolean parentesis = false;
    boolean punto = true;
    String proceso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Inicial();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public void Inicial(){
        resultado = findViewById(R.id.tvTotal);
        total = findViewById(R.id.tvResultado);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btna = findViewById(R.id.btna);
        btnMas = findViewById(R.id.btnMas);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnResta = findViewById(R.id.btnResta);
        btnParentesis = findViewById(R.id.btnParentesis);
        btndivision = findViewById(R.id.btnDivision);
        btnPunto = findViewById(R.id.btnpunto);
        btnPorcentaje = findViewById(R.id.btnPorcentaje);


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    startActivity(intent);

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "0");
                punto=true;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "1");
                punto=true;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "2");
                punto=true;
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "3");
                punto=true;
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "4");
                punto=true;
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "5");
                punto=true;
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "6");
                punto=true;
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "7");
                punto=true;
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "8");
                punto=true;
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "9");
                punto=true;
            }
        });

        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "+");
                punto=true;
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "x");
                punto=true;
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "-");
                punto=true;
            }
        });



        btnParentesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(parentesis){
                   proceso = resultado.getText().toString();
                   resultado.setText(proceso+ ")");
                   parentesis=false;
               }else {
                   proceso = resultado.getText().toString();
                   resultado.setText(proceso+ "(");
                   parentesis=true;
                   punto=true;
               }
            }
        });


        btndivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "÷");
                punto=true;
            }
        });

        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(punto){
                    proceso = resultado.getText().toString();
                    resultado.setText(proceso+ ".");
                    punto=false;
                }else {
                    proceso = resultado.getText().toString();
                    resultado.setText(proceso+ "");

                }
                /*proceso = resultado.getText().toString();
                resultado.setText(proceso+ ".");*/
            }
        });

        btnPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceso = resultado.getText().toString();
                resultado.setText(proceso+ "%");
            }
        });

    }
    public void igual(View view){
        proceso = resultado.getText().toString();
        proceso = proceso.replaceAll("x", "*");
        proceso = proceso.replaceAll("%", "/100");
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        String finalResut= "";
        try{
            Scriptable scriptable = context.initStandardObjects();
            finalResut = context.evaluateString(scriptable, proceso,"javascript", 1,null).toString();
        }catch(Exception e){
            finalResut="0";

        }
        total.setText(finalResut);
    }

    public void clear(View view){
        resultado.setText("");
        total.setText("");
    }

    public void borrar(View view){
        String string = resultado.getText().toString();

        if (string.length()>=1){
            string = string.substring(0, string.length()-1);
            resultado.setText(string);
        } else if (string.length()<1){
            resultado.setText("");
        }
    }



}