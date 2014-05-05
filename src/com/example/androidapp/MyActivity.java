package com.example.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

    public String pName1, pName2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        getInfo();
    }

    public void getInfo() {
        Button goButton = (Button) findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView player1 = (TextView) findViewById(R.id.player1name);
                TextView player2 = (TextView) findViewById(R.id.player2name);

                boolean gotIt = false;

                player1.setHint("please enter name");
                player2.setHint("please enter name");

                if (player1.getText() != null) {
                    if (player1.getText().toString().equals("")) {
                        gotIt = true;
                    } else {
                        pName1 = player1.getText().toString();
                    }
                } else {
                    gotIt = true;
                }

                if (player2.getText() != null) {
                    if (player2.getText().toString().equals("")) {
                        gotIt = true;
                    } else {
                        pName2 = player2.getText().toString();
                    }
                } else {
                    gotIt = true;
                }

                if(!gotIt) {
                    Intent game = new Intent();
                    game.setClassName("com.example.androidapp", "com.example.androidapp.TicTacToe");
                    game.putExtra("player1", pName1);
                    game.putExtra("player2", pName2);
                    startActivity(game);
                }
            }
        });
    }

    public String getpName1() {
        return pName1;
    }

    public String getpName2() {
        return pName2;
    }
}
