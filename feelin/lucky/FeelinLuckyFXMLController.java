/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feelin.lucky;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author Isaiah
 */
public class FeelinLuckyFXMLController implements Initializable {

    private Label label;
    @FXML
    private ImageView firstCard;
    @FXML
    private ImageView secondCard;
    @FXML
    private ImageView thirdCard;
    int score = 0;
    int dScore = 0;
    int hitCount = 0;

    @FXML
    private Button btnHit;
    @FXML
    private ImageView fourthCard;
    @FXML
    private Button btnHit2;
    @FXML
    private Button btnHit3;
    @FXML
    private Button btnHit4;
    @FXML
    private Label dealerName;
    @FXML
    private Label playerScore;
    @FXML
    private Label playerName;
    @FXML
    private Label dealerScore;
    @FXML
    private Button btnSet;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void hitMe(ActionEvent event) {
        String cardselection = randoCard();
        updatePicture1(cardselection);
        playerScore.setText(String.valueOf(score));
        btnHit.setDisable(true);

    }

    @FXML
    private void menuExitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void menuNewGameAction(ActionEvent event) {
        resetAllButtons();
        score = 0;
        dScore = 0;
        playerScore.setText(String.valueOf(score));
        dealerScore.setText(String.valueOf(dScore));
        firstCard.setImage(null);
        secondCard.setImage(null);
        thirdCard.setImage(null);
        fourthCard.setImage(null);
    }

    @FXML
    private void menuAboutAction(ActionEvent event) {
        String title = "About Feelin' Lucky FX";
        String message = "This product is licensed by JoBro, Inc.";
        postMessage(title, message);
    }

    @FXML
    private void menuHelpAction(ActionEvent event) {
        String title = "Rules";
        String message = "If your score equals 21 or it is closer to 21 than the Dealer, you win. "
                + "If your score is over 21 its called a 'Bust' and you lose. "
                + "If the Dealer's score is closer to 21 than your score you lose.";
        postMessage(title, message);
    }

    private String randoCard() {
        int randSuit = (int) (Math.random() * 4);
        int randName = (int) (Math.random() * 13);

        String selections = "";

        //Check the Name
        if (randName == 0) {
            selections += "ace_of_";
            score += 1;
        }

        if (randName == 1) {
            selections += "2_of_";
            score += 2;
        }

        if (randName == 2) {
            selections += "3_of_";
            score += 3;
        }

        if (randName == 3) {
            selections += "4_of_";
            score += 4;
        }

        if (randName == 4) {
            selections += "5_of_";
            score += 5;
        }

        if (randName == 5) {
            selections += "6_of_";
            score += 6;
        }

        if (randName == 6) {
            selections += "7_of_";
            score += 7;
        }

        if (randName == 7) {
            selections += "8_of_";
            score += 8;
        }

        if (randName == 8) {
            selections += "9_of_";
            score += 9;
        }

        if (randName == 9) {
            selections += "10_of_";
            score += 10;
        }

        if (randName == 10) {
            selections += "jack_of_";
            score += 11;
        }

        if (randName == 11) {
            selections += "queen_of_";
            score += 12;
        }

        if (randName == 12) {
            selections += "king_of_";
            score += 13;
        }

        //Check the Suit
        if (randSuit == 0) {
            selections += "spades";
        }

        if (randSuit == 1) {
            selections += "hearts";
        }

        if (randSuit == 2) {
            selections += "diamonds";
        }

        if (randSuit == 3) {
            selections += "clubs";
        }

        return (selections);
    }

    @FXML
    private void hitMe2(ActionEvent event) {
        String cardselection = randoCard();
        updatePicture2(cardselection);
        playerScore.setText(String.valueOf(score));
        btnHit2.setDisable(true);
    }

    @FXML
    private void hitMe3(ActionEvent event) {
        String cardselection = randoCard();
        updatePicture3(cardselection);
        playerScore.setText(String.valueOf(score));
        btnHit3.setDisable(true);
       
        
    }

    @FXML
    private void hitMe4(ActionEvent event) {
        String cardselection = randoCard();
        updatePicture4(cardselection);
        playerScore.setText(String.valueOf(score));
        btnHit4.setDisable(true);
    }

    private void updatePicture1(String selections) {
        String imageFile = "deck/" + selections + ".png";
        Image cardImage = new Image(imageFile);
        firstCard.setImage(cardImage);
    }

    private void updatePicture2(String selections) {
        String imageFile = "deck/" + selections + ".png";
        Image cardImage = new Image(imageFile);
        secondCard.setImage(cardImage);
    }

    private void updatePicture3(String selections) {
        String imageFile = "deck/" + selections + ".png";
        Image cardImage = new Image(imageFile);
        thirdCard.setImage(cardImage);
    }

    private void updatePicture4(String selections) {
        String imageFile = "deck/" + selections + ".png";
        Image cardImage = new Image(imageFile);
        fourthCard.setImage(cardImage);
    }

    private boolean checkForWin() {
        if (score == 21 || dScore > 21 || score > dScore) {
            return true;

        }
        return false;

    }

    private void postMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        //alert.setGraphic(new ImageView("images/icon.gif"));
        alert.showAndWait();
    }

    private void disableAllButtons() {
        btnHit.setDisable(true);
        btnHit2.setDisable(true);
        btnHit3.setDisable(true);
        btnHit4.setDisable(true);
        btnSet.setDisable(true);
    }

    @FXML
    private void setScore(ActionEvent event) {
        dScore = (int) (Math.random() * 24);
        dealerScore.setText(String.valueOf(dScore));

        if (score > 21) {
            disableAllButtons();
            String title = "Game Over";
            String message = "Bust, You lose.";
            postMessage(title, message);
        } else if (dScore > score) {
            disableAllButtons();
            String title = "Game Over";
            String message = "Dealer Wins.";
            postMessage(title, message);
        } else if (checkForWin()) {
            disableAllButtons();
            String title = "Game Over";
            String message = "You win!";
            postMessage(title, message);

        }
    }

    private void resetAllButtons() {
        btnHit.setDisable(false);
        btnHit2.setDisable(false);
        btnHit3.setDisable(false);
        btnHit4.setDisable(false);
        btnSet.setDisable(false);
    }

}
