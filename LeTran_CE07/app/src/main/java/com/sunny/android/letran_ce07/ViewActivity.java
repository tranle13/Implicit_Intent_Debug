
	// Name: Tran Le
	// AID - 1808
	// File name: ViewActivity.java

package com.sunny.android.letran_ce07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

	public class ViewActivity extends AppCompatActivity {

	private static final String FIRST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_FIRST_NAME";
	private static final String LAST_NAME = "com.fullsail.android.jav2ce08.EXTRA_STRING_LAST_NAME";
	private static final String AGE = "com.fullsail.android.jav2ce08.EXTRA_INT_AGE";
	private static final String TAG = "ViewActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		Intent received = getIntent();
		Bundle retrieve = received.getExtras();
		if (retrieve != null) {
			TextView firstName = findViewById(R.id.txt_FirstNameText);
			TextView lastName = findViewById(R.id.txt_LastNameText);
			TextView age = findViewById(R.id.txt_AgeText);

			firstName.setText(received.getStringExtra(FIRST_NAME));
			lastName.setText(received.getStringExtra(LAST_NAME));
			Integer intAge = received.getIntExtra(AGE, 0);
			age.setText(intAge.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.deleteaction_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.deleteButton) {
			Intent returnBack = new Intent();

			Intent received = getIntent();
			Bundle retrieve = received.getExtras();
			if (retrieve != null) {
				returnBack.putExtra(FIRST_NAME, received.getStringExtra(FIRST_NAME));
				returnBack.putExtra(LAST_NAME, received.getStringExtra(LAST_NAME));
				returnBack.putExtra(AGE, received.getIntExtra(AGE, 0));
				setResult(RESULT_OK, returnBack);

				finish();
			}

		}

		return super.onOptionsItemSelected(item);
	}
}
