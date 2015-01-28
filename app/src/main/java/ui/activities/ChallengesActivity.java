package ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Score;
import com.sromku.simple.fb.listeners.OnLoginListener;
import com.sromku.simple.fb.listeners.OnScoresListener;

import java.util.List;

import bellamica.tech.dreamteenfitness.R;

public class ChallengesActivity extends Activity {

    private static final String TAG = ChallengesActivity.class.getSimpleName();

    private SimpleFacebook mSimpleFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSimpleFacebook = SimpleFacebook.getInstance(this);
        mSimpleFacebook.login(onLoginListener);

        setContentView(R.layout.activity_challenges);
    }

    OnLoginListener onLoginListener = new OnLoginListener() {
        @Override
        public void onLogin() {
            mSimpleFacebook.getScores(onScoresListener);
        }

        @Override
        public void onNotAcceptingPermissions(Permission.Type type) {
            // user didn't accept READ or WRITE permission
            Log.w(TAG, String.format("You didn't accept %s permissions", type.name()));
        }

        @Override
        public void onThinking() {
        }

        @Override
        public void onException(Throwable throwable) {
            Log.e(TAG, throwable.getMessage());
        }

        @Override
        public void onFail(String s) {
            Log.e(TAG, "Failed. Reason: " + s);
        }
    };

    OnScoresListener onScoresListener = new OnScoresListener() {
        @Override
        public void onComplete(List<Score> scores) {
            // TODO: Parse response with cursor implementation
            Log.i(TAG, "Number of retrieved scores is " + scores.size());
        }

        @Override
        public void onException(Throwable throwable) {
            super.onException(throwable);
            throwable.printStackTrace();
        }

        @Override
        public void onThinking() {
            super.onThinking();
            Log.d(TAG, "Thinking");
        }

        @Override
        public void onFail(String reason) {
            super.onFail(reason);
            Log.e(TAG, "Failed. Reason: " + reason);
        }

        /*
     * You can override other methods here:
     * onThinking(), onFail(String reason), onException(Throwable throwable)
     */
    };

    @Override
    public void onResume() {
        super.onResume();
        mSimpleFacebook = SimpleFacebook.getInstance(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mSimpleFacebook.onActivityResult(this, requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
