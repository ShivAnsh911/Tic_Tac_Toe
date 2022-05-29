package com.example.tictactoe;


import android.os.Bundle;
import android.view.View;
//import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;
    int[][] winStates ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};//,{0,3,6},{1,4,7},{2,5,8},{},{0,4,8},{2,4,6}};
    int[] gameStates ={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int player=1; //player 1 is cross
    public void load(View view){
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked=gameStates[tag];
            if(isWinner==false && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                Toast.makeText(this, tag + " cross", Toast.LENGTH_SHORT).show();
                gameStates[tag] = player;
                player = 2;
            } //player 2 is circle
            else {
                v.setImageResource(R.drawable.circle);
                Toast.makeText(this, tag + " circle", Toast.LENGTH_SHORT).show();
                gameStates[tag] = player;
                player = 1;
            }

            for (int i = 0; i < winStates.length; i++) {
                if (gameStates[winStates[i][0]] == gameStates[winStates[i][1]] && gameStates[winStates[i][1]] == gameStates[winStates[i][2]] && gameStates[winStates[i][0]] > -1) {
                    isWinner = true;
                    Toast.makeText(this, "Player " + (player == 2 ? 1 : 2) + " Wins.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void reset(View view) {
        GridLayout gridLayout=findViewById(R.id.gridlayout);
        int totalImages=gridLayout.getChildCount();
        for(int i=0;i<totalImages;i++){
            ImageView v=(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        isWinner=false;
        imageClicked=-1;
        player=1;
        for(int i=0;i<gameStates.length;i++)
            gameStates[i]=-1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}