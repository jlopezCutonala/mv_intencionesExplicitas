package com.example.calculadoraintenciones;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoActivity extends ActionBarActivity {

	private String operacion;
	private int numero1;
	private int numero2;
	private int resultado;
	private TextView txtResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		this.txtResultado = (TextView) findViewById(R.id.txtResultado);
		this.cargaVariables();
		this.realizarOperacion();
		this.muestraResultado();
	}

	private void cargaVariables() {
		Bundle extras = getIntent().getExtras();
		this.operacion = extras.getString("operacion");
		this.numero1 = extras.getInt("numero1");
		this.numero2 = extras.getInt("numero2");
	}

	private void realizarOperacion() {
		if (this.operacion.equals("+")) {
			this.sumar();
		} else if (this.operacion.equals("-")) {
			this.restar();
		} else if (this.operacion.equals("*")) {
			this.multiplicar();
		} else if (this.operacion.equals("/")) {
			this.dividir();
		}
	}

	private void sumar() {
		this.resultado = this.numero1 + this.numero2;
	}

	private void restar() {
		this.resultado = this.numero1 - this.numero2;

	}

	private void multiplicar() {
		this.resultado = this.numero1 * this.numero2;
	}

	private void dividir() {
		this.resultado = this.numero1 / this.numero2;
	}

	private void muestraResultado() {
		this.txtResultado.setText(Integer.toString(this.resultado));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado, menu);
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
