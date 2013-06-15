package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends Activity
{
	private Button mTrueButton;
	private Button mFalseButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{ // onCreate is called when instance of the activity subclass is created
		super.onCreate(savedInstanceState);
		// when an activity is created (GUI), it needs a user interface to manage
		// setContentView gets the activity its user interface
		// this method inflates a layout and puts it on screen, thus
		// putting all each widget in the layout files is instantiated
		// as defined by its attributes. R.layout.activity_quiz ->
		// res/layout/activity_quiz.xml
		setContentView(R.layout.activity_quiz);

		// get a reference to an inflated widget by calling the following Activity
		// method
		mTrueButton = (Button) findViewById(R.id.true_button);
		mFalseButton = (Button) findViewById(R.id.false_button);

		mTrueButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(QuizActivity.this, R.string.incorrect_toast,
						Toast.LENGTH_SHORT).show();
			} // end method onClick
		}// end anonymous inner class
				);

		mFalseButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Toast.makeText(QuizActivity.this, R.string.correct_toast,
						Toast.LENGTH_SHORT).show();
			} // end method onClick
		} // end anonymous inner class
				);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

}
