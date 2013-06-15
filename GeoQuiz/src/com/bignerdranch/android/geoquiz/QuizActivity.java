package com.bignerdranch.android.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity // controller
{
	private Button mTrueButton;
	private Button mFalseButton;
	private ImageButton mNextButton;
	private ImageButton mPreviousButton;
	private TextView mQuestionTextView;
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_mideast, false),
			new TrueFalse(R.string.question_africa, false),
			new TrueFalse(R.string.question_americas, true),
			new TrueFalse(R.string.question_asia, true) };

	private int mCurrentIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) { // onCreate is called
																			// when instance of the
																			// activity subclass is
																			// created
		super.onCreate(savedInstanceState);
		// when an activity is created (GUI), it needs a user interface to manage
		// setContentView gets the activity its user interface
		// this method inflates a layout and puts it on screen, thus
		// putting all each widget in the layout files is instantiated
		// as defined by its attributes. R.layout.activity_quiz ->
		// res/layout/activity_quiz.xml
		setContentView(R.layout.activity_quiz);

		// get a reference for the TextView and set its text to the question
		mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

		// get a reference to an inflated widget by calling the following Activity
		// method
		mTrueButton = (Button) findViewById(R.id.true_button);
		mFalseButton = (Button) findViewById(R.id.false_button);
		mNextButton = (ImageButton) findViewById(R.id.next_button);
		mPreviousButton = (ImageButton) findViewById(R.id.previous_button);

		updateQuestion();

		mQuestionTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});

		mTrueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer(true);
			} // end method onClick
		});

		mFalseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer(false);
			} // end method onClick
		});

		mPreviousButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mCurrentIndex == 0) {
					mCurrentIndex = mQuestionBank.length - 1;
				} // end if
				else {
					mCurrentIndex = (mCurrentIndex - 1);
				} // end else
				updateQuestion();
			}
		});
		mNextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	} // end method updateQuestion

	private void checkAnswer(boolean userPressedTrue) {
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		int messageResId = 0;

		if (userPressedTrue == answerIsTrue) {
			messageResId = R.string.correct_toast;
		} // end if
		else {
			messageResId = R.string.incorrect_toast;
		} // end else

		Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
	} // end method checkAnswer
}
