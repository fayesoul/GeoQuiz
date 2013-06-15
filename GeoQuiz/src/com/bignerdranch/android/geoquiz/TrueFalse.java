package com.bignerdranch.android.geoquiz;

public class TrueFalse {
	private int mQuestion; // holds resource ID of a string resource for this
									// question
	private boolean mTrueQuestion;

	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
	} // end constructor TrueFalse

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}

} // end class TrueFalse
