package com.example.tictactoej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,restart,initBtn;
    TextView tV;


    int activePlayer=1;
    ArrayList<Integer> player1=new ArrayList<Integer>();
    ArrayList<Integer>player2=new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b8=findViewById(R.id.btn8);
        b9=findViewById(R.id.btn9);
        restart=findViewById(R.id.restartBtn);

        tV=findViewById(R.id.textView);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
       // restart.setOnClickListener(this);
    }

  public  void restartClick( View view){

            b1.setText("");
            b2.setText("");
            b3.setText("");
            b4.setText("");
            b5.setText("");
            b6.setText("");
            b7.setText("");
            b8.setText("");
            b9.setText("");
      tV.setText("");




            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);

           player1.clear();
           player2.clear();
            activePlayer=1;
            winner=-1;


    }


    @Override
    public void onClick(View view) {




        Button buSelected=initBtn;
        int cellID=0;

        if(view.getId()==R.id.btn1) {
            cellID = 1;
            buSelected=b1;

        }
        if(view.getId()==R.id.btn2) {
            cellID = 2;
            buSelected=b2;
        }
        if(view.getId()==R.id.btn3) {
            cellID = 3;
            buSelected=b3;

        }     if(view.getId()==R.id.btn4) {
            cellID = 4;
            buSelected=b4;
        }
        if(view.getId()==R.id.btn5) {
            cellID = 5;
            buSelected=b5;
        }
        if(view.getId()==R.id.btn6) {
            cellID = 6;
            buSelected=b6;
        }
        if(view.getId()==R.id.btn7) {
            cellID = 7;
            buSelected=b7;
        }
        if(view.getId()==R.id.btn8) {
            cellID = 8;
            buSelected=b8;
        }     if(view.getId()==R.id.btn9) {
            cellID = 9;
            buSelected=b9;
        }

        playGame(cellID,buSelected);


    }

    void playGame(int cellID,Button buSelected){
        if(activePlayer==1)
        {
            buSelected.setText("X");
            player1.add(cellID);
            activePlayer=2;
        }
        else if(activePlayer==2)
        {
            buSelected.setText("O");
            player2.add(cellID);
            activePlayer=1;
        }
      //buSelected.isEnabled(false);
        buSelected.setEnabled(false);
        checkWinner();

    }
    int winner=-1;

    void checkWinner(){


        //rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1;

        } else if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1;
        } else if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1;
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2;
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2;
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2;
        }

        //columns
        else if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1;
        } else if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1;
        } else if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1;
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2;
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2;
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2;
        }
        //diagonals
        else if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1;
        } else if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1;
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2;
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2;
        }

        if(winner==-1 &&b1.isEnabled()==false &&b2.isEnabled()==false &&b3.isEnabled()==false &&b4.isEnabled()==false &&b5.isEnabled()==false &&b6.isEnabled()==false &&b7.isEnabled()==false &&b8.isEnabled()==false &&b9.isEnabled()==false) {
            {
                tV.setText("Game is TIE");

            }
        }



        if(winner!=-1){
            if(winner==1)
            {
                tV.setText("player 1 has won!");
            }
            if(winner==2)
            {
                tV.setText("player 2 has won!");
            }
        }

    }
}
