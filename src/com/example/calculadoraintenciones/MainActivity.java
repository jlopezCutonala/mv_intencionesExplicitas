package com.example.calculadoraintenciones;

import com.example.calculadoraintenciones.R;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private String operacion;
	private EditText numero1;
	private EditText numero2;

	private Button btnSuma;
	private Button btnResta;
	private Button btnMultiplicacion;
	private Button btnDivision;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.numero1= (EditText) findViewById(R.id.numero1);
		this.numero2= (EditText) findViewById(R.id.numero2);

		this.btnSuma= (Button) findViewById(R.id.btnSuma);
		this.btnResta= (Button) findViewById(R.id.btnResta);
		this.btnMultiplicacion= (Button) findViewById(R.id.btnMultiplicacion);
		this.btnDivision= (Button) findViewById(R.id.btnDivision);
	}
	
	private void llamarIntencion(){
		Intent intent = new Intent(this, ResultadoActivity.class);
		intent.putExtra("numero1", Integer.parseInt(this.numero1.getText().toString()));
		intent.putExtra("numero2", Integer.parseInt(this.numero2.getText().toString()));
		intent.putExtra("operacion", this.operacion);
		startActivity(intent);
	}
	
	public void btnSumaOnClick(View v){
		this.operacion = "+";
		this.llamarIntencion();
	}
	
	public void btnRestaOnClick(View v){
		this.operacion = "-";
		this.llamarIntencion();
	}
	
	public void btnDivisionOnClick(View v){
		this.operacion = "/";
		this.llamarIntencion();
	}
	
	public void btnMultiplicacionOnClick(View v){
		this.operacion = "*";
		this.llamarIntencion();
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
