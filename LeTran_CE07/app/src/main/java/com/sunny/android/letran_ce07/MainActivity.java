package com.sunny.android.letran_ce07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


	// Name: Tran Le
	// AID - 1808
	// File name: MainActivity.java

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	private static final String FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
	private static final String LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
	private static final String AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.actionbar_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		Intent receiver = getIntent();

		if (id == R.id.actionButton) {

			if (receiver != null) {
				EditText firstName = findViewById(R.id.txt_FirstNameText);
				EditText lastName = findViewById(R.id.txt_LastNameText);
				EditText age = findViewById(R.id.txt_Age);

				String strFirstName = firstName.getText().toString();
				String strLastName = lastName.getText().toString();
				String strAge = age.getText().toString();
				int intAge = 0;

				try {
					intAge = Integer.parseInt(strAge);
				} catch (Exception e) {
					e.printStackTrace();
				}

				Intent returnBack = new Intent();

				returnBack.putExtra(FIRST_NAME, strFirstName);
				returnBack.putExtra(LAST_NAME, strLastName);
				returnBack.putExtra(AGE, intAge);


				setResult(RESULT_OK, returnBack);

				finish();
			}
		}
		return super.onOptionsItemSelected(item);
	}
}
