package org.example.sudoku;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import com.rey.material.widget.Button;


public class Sudoku extends Activity implements OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Set up click listeners for all the buttons
        Button continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        Button newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        Button aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_button:
                Intent i = new Intent(this, About.class);
                startActivity(i);
                break;
            // More buttons go here (if any) ...
            case R.id.new_button:
                openNewGameDialog();
                break;
            case R.id.exit_button:
                finish();
                break;
            case R.id.continue_button:
                startGame(Game.DIFFICULTY_CONTINUE);
                break;
// ...
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, Prefs.class));
                return true;
// More items go here (if any) ...
        }
        return false;
    }


    private static final String TAG = "Sudoku";

    private void openNewGameDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.new_game_title)
                .setItems(R.array.difficulty,
        new DialogInterface.OnClickListener()
        {

    public void onClick(DialogInterface dialoginterface, int i) {startGame(i);
    }
       })
          .show();
    }

    private void startGame(int i) {
        Log.d(TAG, "clicked on " + i);
// Start game here...

        Log.d(TAG, "clicked on " + i);
        Intent intent = new Intent(Sudoku.this, Game.class);
        intent.putExtra(Game.KEY_DIFFICULTY, i);
        startActivity(intent);
    }




}



