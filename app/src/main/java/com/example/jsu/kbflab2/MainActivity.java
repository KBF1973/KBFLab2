package com.example.jsu.kbflab2;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import java.util.Random;

import static com.example.jsu.kbflab2.MainActivity.winningMessage.WIN;

public class MainActivity extends AppCompatActivity {

    Weapon playerWeapon, computerWeapon;
    winningMessage result;
    Button rockButton, paperButton, scissorsButton;
    Random random;
    TextView showValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorsButton = findViewById(R.id.scissorsButton);
        showValue = findViewById(R.id.scores);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

    }

    public void playerClick(View view) {

        switch (view.getId()) {

            case R.id.rockButton:
                playerWeapon = Weapon.ROCK;
                ((TextView) findViewById(R.id.playerChoice)).setText(playerWeapon.toString());
                break;

            case R.id.paperButton:
                playerWeapon = Weapon.PAPER;
                ((TextView) findViewById(R.id.playerChoice)).setText(playerWeapon.toString());
                break;

            case R.id.scissorsButton:
                playerWeapon = Weapon.SCISSORS;
                ((TextView) findViewById(R.id.playerChoice)).setText(playerWeapon.toString());
                break;

        }

        compPick();


    }

    private void compPick() {


        random = new Random();
        int ran = random.nextInt(3);

        computerWeapon = null;

        switch (ran) {

            case 0:
                computerWeapon = Weapon.ROCK;
                ((TextView) findViewById(R.id.computerChoice)).setText(computerWeapon.toString());
                break;

            case 1:
                computerWeapon = Weapon.PAPER;
                ((TextView) findViewById(R.id.computerChoice)).setText(computerWeapon.toString());
                break;

            case 2:
                computerWeapon = Weapon.SCISSORS;
                ((TextView) findViewById(R.id.computerChoice)).setText(computerWeapon.toString());
                break;

        }
        if (computerWeapon == playerWeapon) {
            result = winningMessage.TIE;
            ((TextView) findViewById(R.id.winningMessage)).setText(result.toString());

        } else if (computerWeapon == Weapon.PAPER && playerWeapon == Weapon.ROCK) {
            result = winningMessage.LOSE;
            ((TextView) findViewById(R.id.winningMessage)).setText(result.toString());


        } else if (computerWeapon == Weapon.ROCK && playerWeapon == Weapon.SCISSORS) {
            result = winningMessage.LOSE;

            ((TextView) findViewById(R.id.winningMessage)).setText(result.toString());

        } else if (computerWeapon == Weapon.SCISSORS && playerWeapon == Weapon.PAPER) {
            result = winningMessage.LOSE;
            ((TextView) findViewById(R.id.winningMessage)).setText(result.toString());

        } else {
            result = WIN;
            ((TextView) findViewById(R.id.winningMessage)).setText(result.toString());

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    }

    public enum winningMessage {
        TIE("It's a Tie"),
        WIN("YOU WIN!"),
        LOSE("YOU LOSE");

        private String message2;

        winningMessage(String msg) {message2 = msg;}


        @Override
        public String toString() {return message2;}
    }
}
