package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int pc = 0;
    private int cc = 0;
    private int points_player = 0;
    private int points_computer = 0;
    private int tie = 0;
    private ImageView img_player;
    private ImageView img_computer;
    private ImageView button_rock;
    private ImageView button_paper;
    private ImageView button_scissors;
    private ImageView p_h1;
    private ImageView p_h2;
    private ImageView p_h3;
    private ImageView c_h1;
    private ImageView c_h2;
    private ImageView c_h3;
    private TextView text_tie;
    private TextView text_player;
    private TextView text_computer;
    private Toast toast;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setId();

        button_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_player.setImageResource(R.drawable.rock);
                pc =  1;
                duel();

            }
        });

        button_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_player.setImageResource(R.drawable.paper);
                pc =  2;
                duel();
            }
        });

        button_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_player.setImageResource(R.drawable.scissors);
                pc =  3;
                duel();
            }
        });
    }

    public void duel(){
        int num = rnd.nextInt(3)+1;
        cc = num;

        if(cc == 1){
            img_computer.setImageResource(R.drawable.rock);
        }
        else if(cc == 2){
            img_computer.setImageResource(R.drawable.paper);
        }
        else if(cc == 3){
            img_computer.setImageResource(R.drawable.scissors);
        }

        if(pc == cc){
            Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
            tie++;
        }
        else if(pc == 1 && cc == 3){
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
            points_player++;
        }
        else if(pc == 2 && cc == 1){
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
            points_player++;
        }
        else if(pc == 3 && cc == 2){
            Toast.makeText(MainActivity.this, "Te nyertél", Toast.LENGTH_SHORT).show();
            points_player++;
        }
        else if(cc == 1 && pc == 3){
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
            points_computer++;
        }
        else if(cc == 2 && pc == 1){
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
            points_computer++;
        }
        else if(cc == 3 && pc == 2){
            Toast.makeText(MainActivity.this, "Gép nyert", Toast.LENGTH_SHORT).show();
            points_computer++;
        }

        text_tie.setText("Döntetlen: " + tie);
        text_player.setText(" Player: " + points_player + "  ");
        text_computer.setText("Computer: " + points_computer);

        if(points_computer == 1){
            p_h1.setImageResource(R.drawable.heart1);
        }
        else if(points_computer == 2){
            p_h2.setImageResource(R.drawable.heart1);
        }
        else if(points_computer == 3){
            p_h3.setImageResource(R.drawable.heart1);
            alertDialog.show();
        }


        if(points_player == 1){
            c_h1.setImageResource(R.drawable.heart1);
        }
        else if(points_player == 2){
            c_h2.setImageResource(R.drawable.heart1);
        }
        else if(points_player == 3){
            c_h3.setImageResource(R.drawable.heart1);
            alertDialog.show();
        }
    }

    public void newGame(){
        p_h1.setImageResource(R.drawable.heart2);
        p_h2.setImageResource(R.drawable.heart2);
        p_h3.setImageResource(R.drawable.heart2);
        c_h1.setImageResource(R.drawable.heart2);
        c_h2.setImageResource(R.drawable.heart2);
        c_h3.setImageResource(R.drawable.heart2);
        tie = 0;
        points_player = 0;
        points_computer = 0;
        text_tie.setText("Döntetlen: " + tie);
        text_player.setText(" Player: " + points_player + "  ");
        text_computer.setText("Computer: " + points_computer);
    }

    public void setId(){
        img_player = findViewById(R.id.img_player);
        img_computer = findViewById(R.id.img_computer);
        p_h1 = findViewById(R.id.p_h1);
        p_h2 = findViewById(R.id.p_h2);
        p_h3 = findViewById(R.id.p_h3);
        c_h1 = findViewById(R.id.c_h1);
        c_h2 = findViewById(R.id.c_h2);
        c_h3 = findViewById(R.id.c_h3);
        text_tie = findViewById(R.id.text_tie);
        text_player = findViewById(R.id.text_player);
        text_computer = findViewById(R.id.text_computer);
        button_rock = findViewById(R.id.button_rock);
        button_paper = findViewById(R.id.button_paper);
        button_scissors = findViewById(R.id.button_scissors);


        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnénk egy új játékot?");
        builder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();
            }
        }).setNegativeButton("nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.cancel();
            }
        }).setCancelable(false).setTitle("Játék vége");
        alertDialog = builder.create();
    }



}