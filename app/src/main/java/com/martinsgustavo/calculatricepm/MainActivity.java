// Travail Pratique II
// POO II
//
// Luiz Gustavo Martins de Farias

package com.martinsgustavo.calculatricepm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity {

    public TextView crystalLiquid;
    boolean isPolonaise = true;

    Switch swh_Pol;
    Button btn_oper1;
    Button btn_oper2;
    Button btn_esp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crystalLiquid = (TextView)findViewById(R.id.textView);

        swh_Pol = (Switch) findViewById(R.id.swh_Pol);

        btn_oper1 = (Button) findViewById(R.id.btn_oper1);
        btn_oper2 = (Button) findViewById(R.id.btn_oper2);
        btn_esp = (Button) findViewById(R.id.btn_esp);

        swh_Pol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    isPolonaise = true;
                } else {
                    isPolonaise = false;
                }
            }
        });
    }
    //Méthode pour montrer les chiffres et operandes dans l'affichage
    public void showDigit(View view){
        Button b = (Button) view;
        String c = (String) b.getText();

        if (isPolonaise && (c.equals("(") || c.equals(")"))) c = "";
        if (!isPolonaise && c.equalsIgnoreCase("ESP")) c = "";

        if (c.equalsIgnoreCase("ESP")) c = " ";

        crystalLiquid.append(c);
    }

    //Méthode pour effacer l'expression dans l'affichage
    public void btnAC(View view){
        crystalLiquid.setText("");
    }

    //Méthode pour résoudre l'expression
    public void btnEgal(View view) throws EmptyStackException{

        try {
            String exp = crystalLiquid.getText().toString();
            FabriqueExpression expression = new FabriqueExpression();

            if (isPolonaise)
                crystalLiquid.setText(String.valueOf(expression.batirFromPolonaise(exp).evaluer()));
            else
                crystalLiquid.setText(String.valueOf(expression.batirFromToInfix(exp).evaluer()));

        } catch (UnsupportedOperationException e) {
            crystalLiquid.setText(String.valueOf("Pas possible de divisé par 0."));

        } catch (EmptyStackException e) {
            crystalLiquid.setText(String.valueOf("Expression mal formée."));
        }
    }

}
