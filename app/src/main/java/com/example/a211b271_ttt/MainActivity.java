package com.example.a211b271_ttt;

import static com.example.a211b271_ttt.R.drawable.zero_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean  iswinner=false;
    int imageclicked=-1;
     int player=1;
     int [][]winning={{0, 1, 2}, {3, 4, 5}, {6, 7, 8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    int []gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};

     public void load(View view){

             ImageView v = (ImageView) view;
             int tag = Integer.parseInt(v.getTag().toString());
             imageclicked=gamestate[tag];
         if(iswinner==false && imageclicked == -1) {

             if (player == 1) {
                 v.setImageResource(R.drawable.cross);
                 gamestate[tag] = player;
                 Toast.makeText(this, tag + "" + "cross", Toast.LENGTH_SHORT).show();
                 player = 2;
             } else {
                 v.setImageResource(R.drawable.zero_);
                 gamestate[tag] = player;
                 Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
                 player = 1;
             }

             for(int i = 0; i < winning.length; i++) {
                 if (gamestate[winning[i][0]] == gamestate[winning[i][1]] && gamestate[winning[i][1]] == gamestate[winning[i][2]] && gamestate[winning[i][0]] > -1) {
                     Toast.makeText(this, "winner is" + (player == 2 ? 1 : 2), Toast.LENGTH_SHORT).show();
                     iswinner = true;
                 }


             }
         }
     }
     public void Reset(View view){
         GridLayout grid_layout=findViewById(R.id.grid_layout);
         int total_images=grid_layout.getChildCount();
         for(int i=0;i<total_images;i++){
             ImageView v=(ImageView) grid_layout.getChildAt(i);
             v.setImageDrawable(null);
         }
         iswinner=false;
         imageclicked=-1;
         player=1;
         for(int i=0;i<gamestate.length;i++){
             gamestate[i]=-1;

         }


     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}