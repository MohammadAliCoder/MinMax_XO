/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minmax_xo;

import Algorithm.MiniMax_Algorithm;
import Algorithm.Players;
import Algorithm.Move;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Mohammad
 */
public class FXMLDocumentController implements Initializable {

    
    
    
    @FXML
    private AnchorPane root;

    @FXML
    private Label labelResult;
    @FXML
    private GridPane gridImages;


    @FXML
    private ImageView button00;

    @FXML
    private ImageView button01;

    @FXML
    private ImageView button02;

    @FXML
    private ImageView button10;

    @FXML
    private ImageView button11;

    @FXML
    private ImageView button12;

    @FXML
    private ImageView button20;

    @FXML
    private ImageView button21;

    @FXML
    private ImageView button22;
    
    
    char board[][] = {{ '_', '_', '_' },
                      { '_', '_', '_' },
		      { '_', '_', '_' }};
    
    public ImageView imageViewBoard[][];
    
    //___________methods ____________________
    

    @FXML
    void button00Clicked(MouseEvent event) {
       if(labelResult.getText().equals("Equality")){ 
        youPlay(0, 0);
        computerPlay();
        
          }
            
    }

    @FXML
    void button01Clicked(MouseEvent event) {
       if(labelResult.getText().equals("Equality")){ 
        youPlay(0, 1);
        computerPlay();
          }
    }

    @FXML
    void button02Clicked(MouseEvent event) {
       if(labelResult.getText().equals("Equality")){ 
        youPlay(0, 2);
        computerPlay();
          }
    }

    @FXML
    void button10Clicked(MouseEvent event) {
        if(labelResult.getText().equals("Equality")){  
        youPlay(1, 0);
          computerPlay();
          }
    }

    @FXML
    void button11Clicked(MouseEvent event) {
       if(labelResult.getText().equals("Equality")){ 
        youPlay(1, 1);
        computerPlay();
        }
    }

    @FXML
    void button12Clicked(MouseEvent event) {
        if(labelResult.getText().equals("Equality")){ 
            youPlay(1, 2);
            computerPlay();
             }
    }

    @FXML
    void button20Clicked(MouseEvent event) {
           if(labelResult.getText().equals("Equality")){ 
                youPlay(2, 0);
            computerPlay();
             }
    }

    @FXML
    void button21Clicked(MouseEvent event) {
          if(labelResult.getText().equals("Equality")){
            youPlay(2, 1);
            computerPlay();
            }
    }

    @FXML
    void button22Clicked(MouseEvent event) {
      
        if(labelResult.getText().equals("Equality")){
            youPlay(2, 2);
            computerPlay();
        }
    }

    @FXML
    void exitAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void miniAction(MouseEvent event) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void resetAction(MouseEvent event) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]='_';
            }
        }//end loops
       button00.setImage(new Image("file:./icons/non.png"));
       button01.setImage(new Image("file:./icons/non.png"));
       button02.setImage(new Image("file:./icons/non.png"));
       
       button10.setImage(new Image("file:./icons/non.png"));
       button11.setImage(new Image("file:./icons/non.png"));
       button12.setImage(new Image("file:./icons/non.png"));
       
       button20.setImage(new Image("file:./icons/non.png"));
       button21.setImage(new Image("file:./icons/non.png"));
       button22.setImage(new Image("file:./icons/non.png"));
       
       labelResult.setText("Equality");
         
         
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      labelResult.setText("Equality");
    }
    
    private void youPlay(int row, int col){
        if(MiniMax_Algorithm.isMovesLeft(board)){
            board[row][col]=Players.you_player;
            setImage(row, col, String.valueOf(Players.you_player));
            labelResult.setText(MiniMax_Algorithm.winner(MiniMax_Algorithm.evaluate(board)));
        }
        
           
            
    }
    private void computerPlay(){
         if(MiniMax_Algorithm.isMovesLeft(board)){
            Move bestMove = MiniMax_Algorithm.findBestMove(board);
            board[bestMove.row][bestMove.col]=Players.computer_player;
            setImage(bestMove.row, bestMove.col, String.valueOf(Players.computer_player));
            labelResult.setText(MiniMax_Algorithm.winner(MiniMax_Algorithm.evaluate(board)));
         }
         
    }
    private void setImage(int row, int col,String imgName){
        String path="file:./icons/";
        if(row==0 && col==0){
            button00.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==0 && col==1){
             button01.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==0 && col==2){
             button02.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==1 && col==0){
             button10.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==1 && col==1){
             button11.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==1 && col==2){
             button12.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==2 && col==0){
             button20.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==2 && col==1){
             button21.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }if(row==2 && col==2){
             button22.setImage(new Image(path+imgName.toUpperCase()+".png"));
        }
        
        
    }
    
   
   
}
