package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // global variables to hold keys and messages
    KeyPair userKeyPair; // hold user key pair
    KeyPair bobKeyPair;  // hold Bob's key pair
    String message; //message generated by user instance
    byte[] eMessage; // store encrypted message in byte format. Required for Cipher object in Encrypt Class
    String decryptedMessage; //decrypted message in string format
    Encrypt enc = new Encrypt(); //Encrypt object
    String username;

    private int step = 0;
    private String answers;

    @FXML
    private Text nameText;
    @FXML
    private Text aPubText;
    @FXML
    private Text aPriText;
    @FXML
    private Text bPubText;
    @FXML
    private Text bPriText;
    @FXML
    private TextArea promptText;
    @FXML
    private TextField entryText;
    @FXML
    private Button nextButton;
    @FXML
    private Text aMess1;
    @FXML
    private Text aMess2;
    @FXML
    private Text aMess3;
    @FXML
    private Text aMess4;
    @FXML
    private Text aMess5;
    @FXML
    private Text aMess6;
    @FXML
    private Text aMess7;
    @FXML
    private Text aMess8;
    @FXML
    private Text aMess9;
    @FXML
    private Text aMess10;
    @FXML
    private Text aMess11;
    @FXML
    private Text aMess12;
    @FXML
    private Text bMess1;
    @FXML
    private Text bMess2;
    @FXML
    private Text bMess3;
    @FXML
    private Text bMess4;
    @FXML
    private Text bMess5;
    @FXML
    private Text bMess6;
    @FXML
    private Text bMess7;
    @FXML
    private Text bMess8;
    @FXML
    private Text bMess9;
    @FXML
    private Text bMess10;
    @FXML
    private Text bMess11;
    @FXML
    private Text bMess12;
    @FXML
    private TextArea messSent;
    @FXML
    private TextArea encryptedMess;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        promptText.setText("Welcome to the Simulated Encrypted Chat program, an educational tool for understanding encryption! \n\nPlease enter your name below.");

        nextButton.setOnAction(e -> {
                runStep(step);
                step++;
            });
    }

    private void runStep(int s){
        switch(s) {
            case 0: Step0();
                    break;
            case 1: Step1();
                    break;
            case 2: Step2();
                    break;
            case 3: Step3();
                    break;
            case 4: Step4();
                    break;
            case 5: Step5();
                    break;
            case 6: Step6();
                    break;
            case 7: Step7();
                    break;
            case 8: Step8();
                    break;
            case 9: Step9();
                    break;
            case 10: Step10();
                    break;
            case 11: Step11();
                    break;
            case 12: Step12();
                    break;
            case 13: Step13();
                break;
            case 14: Step14();
                break;
            case 15: Step15();
                break;
            case 16: Step16();
                break;
            case 17: Step17();
                break;
            case 18: Step18();
                break;
            case 19: Step19();
                break;
            case 20: Step20();
                break;
            case 21: Step21();
                break;
            case 22: Step22();
                break;
            case 23: Step23();
                break;
            case 24: Step24();
                break;
            case 25: Step25();
                break;
            case 26: Step26();
                break;
        }
    }

    private void Step0(){
        username = entryText.getText();
        nameText.setText(username + " !");
        promptText.setText("Hi, " + username + "!  \n\n" + "Encryption is the process of encoding information so only authorized parties can access it. Encryption does NOT prevent your message from being intercepted by the privacy invaders of the Internet. However, encryption does ensure that only the intended recipient(s) will be able to decode your message.");
        entryText.setText("");
    }

    private void Step1(){
        promptText.setText("As a dedicated protector of privacy, this program strives to deliver effective chat encryption so information is only accessible by intended recipients. \n\nLet’s get started!");
    }

    private void Step2(){
        promptText.setText("To encrypt anything, a key must be used alongside an encryption algorithm to encode and decode the information.\n\n" +
                "Symmetric encryption is a simple method, that requires a single key for encrypting and decrypting data. \n\n" +
                "Asymmetric encryption is a more secure method and requires different keys for encrypting and decrypting data.");
    }

    private void Step3(){
        promptText.setText("Since this program aims to provide the highest security, we use asymmetric encryption.\n\n" +
                "A key pair is generated for all our users, containing:\n\n" +
                "A public key, used to encrypt. You share this key with other users so they can send you encrypted messages.\n\n" +
                "A private key, used to decrypt. ONLY YOU should have this key. If someone else gets access to your private key, they can decrypt messages that were meant for your eyes only.\n" +
                "\n" +
                "Let’s generate your key pair, now!\n");
    }

    private void Step4(){

        try {
            userKeyPair = enc.generateRSA(); // generate user's key pair
        } catch (Exception e) {
            e.printStackTrace();
        }

        aPriText.setText(enc.privateToString(userKeyPair));
        aPubText.setText(enc.publicToString(userKeyPair));


        try {
            bobKeyPair = enc.generateRSA(); // generate bob's key pair
        } catch (Exception e) {
            e.printStackTrace();
        }

        bPriText.setText(enc.privateToString(bobKeyPair));
        bPubText.setText(enc.publicToString(bobKeyPair));

        promptText.setText("Your RSA key pair has been generated! Take a look!\n" +
                "\n" +
                "For learning purposes, we've displayed Bob's key pair as well.");

    }

    private void Step5(){
        promptText.setText("Let’s send a message to your good ‘ol friend, Bob!" +
                "\n\n" +
                "Enter your message below.");
    }

    private void Step6(){
        messSent.setText(entryText.getText());
        message = messSent.getText();
        entryText.setText("");
        promptText.setText("To ensure nobody but Bob can read the contents of your message, let’s encrypt it!\n\n" +
                "Which key are we going to encrypt with?\n" +
                "a. Bob’s public key\n" +
                "b. Bob’s private key\n" +
                "c. Your public key\n" +
                "d. Your private key\n");
    }

    private void Step7(){
        answers = entryText.getText();
        if( answers.equals("a") || answers.equals("a.") || answers.equals("A") || answers.equals("A."))
        {
            promptText.setText("Correct! The message should be encrypted using Bob’s public key.\n\n" +
                    "Then the message can only be decrypted with Bob’s private key, which only Bob should have." +
                    " This ensures only Bob will be able to decode your message. \n");
            entryText.setText("");
        } else
        {
            promptText.setText("Not quite! The message should be encrypted using Bob’s public key.\n\n" +
                    "Then the message can only be decrypted with Bob’s private key, which only Bob should have.\n" +
                    "This ensures only Bob will be able to decode your message. \n");
            entryText.setText("");
        }

    }

    private void Step8(){
        promptText.setText("We have a database of all of our users’ public keys.\n\n" +
                "We'll retrieve Bob’s public key and use it to encrypt your message.");

    }

    private void Step9(){

        //encrypt message
        try {
            eMessage = enc.encrypt(message, bobKeyPair);  //encrypted message in byte format for decrypt function later
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
        encryptedMess.setText(new String(eMessage, "UTF8")); //message is converted to string
        } catch (Exception e) {
            e.printStackTrace();
        }

        promptText.setText("Your message has been encrypted!\n\n" +
                "Check out the original and encrypted versions.");


    }

    private void Step10(){
        promptText.setText("Your message has been sent! While we’re waiting for a reply.. \n\n" +
                "Which key will Bob use to decrypt your message?\n" +
                "a. Bob’s public key\n" +
                "b. Bob’s private key\n" +
                "c. Your public key\n" +
                "d. Your private key\n");
        encryptedMess.setText("");
        messSent.setText("");

    }

    private void Step11(){
        answers = entryText.getText();
        if( answers.equals("b") || answers.equals("b.") || answers.equals("B") || answers.equals("B."))
        {
            promptText.setText("Correct! Bob will decrypt using his private key!");
        } else
        {
            promptText.setText("Not quite! Bob will decrypt using his private key.");
        }
        entryText.setText("");
        aMess1.setFill(Color.BLUE);
        aMess1.setText(message);
        aMess1.setTextAlignment(TextAlignment.RIGHT);
        bMess1.setFill(Color.BLACK);

        //decrypt message
        try {
            decryptedMessage = enc.decrypt(eMessage, bobKeyPair);
        } catch (Exception e) {
            e.printStackTrace();
        }
        bMess1.setText(decryptedMessage);
        bMess1.setTextAlignment(TextAlignment.LEFT);

    }

    private void Step12(){

        message = "Hey! What's your email and phone number?"; //Bob's response

        //encrypt message
        try {
            eMessage = enc.encrypt(message, userKeyPair);  //encrypted message in byte format for decrypt function later
        } catch (Exception e) {
            e.printStackTrace();
        }

        promptText.setText("Bob has sent you a message! \n\nSee the encrypted message below.");

        try {
            encryptedMess.setText(new String(eMessage, "UTF8")); //message is converted to string
        } catch (Exception e) {
            e.printStackTrace();
        }
        messSent.setText("");

    }

    private void Step13(){
        promptText.setText("Which key should we use to decrypt Bob's message?\n" +
                "a. Bob’s public key\n" +
                "b. Bob’s private key\n" +
                "c. Your public key\n" +
                "d. Your private key\n");
    }

    private void Step14(){
        answers = entryText.getText();
        if( answers.equals("d") || answers.equals("d.") || answers.equals("D") || answers.equals("D."))
        {
            promptText.setText("Correct! \n\nSince Bob's message was encrypted for your eyes only, the only way to decrypt it is using your private key.");
            entryText.setText("");
        } else {
            promptText.setText("Not quite! \n\nSince Bob's message was encrypted for your eyes only, the only way to decrypt it is using your private key.");
            entryText.setText("");
        }
    }

    private void Step15(){
        promptText.setText("Bob's message has been decrypted!\n\n" +
                "Check out the decrypted message below.");

        //decrypt message
        try {
            decryptedMessage = enc.decrypt(eMessage, userKeyPair);
        } catch (Exception e) {
            e.printStackTrace();
        }
        messSent.setText(decryptedMessage);
        encryptedMess.setText("");

        aMess2.setFill(Color.BLUE);
        aMess2.setText(aMess1.getText());
        aMess2.setTextAlignment(TextAlignment.RIGHT);
        bMess2.setFill(Color.BLACK);
        bMess2.setText(bMess1.getText());
        bMess2.setTextAlignment(TextAlignment.LEFT);

        aMess1.setFill(Color.BLACK);
        aMess1.setText(decryptedMessage);
        aMess1.setTextAlignment(TextAlignment.LEFT);
        bMess1.setFill(Color.BLUE);
        bMess1.setText(message);
        bMess1.setTextAlignment(TextAlignment.RIGHT);
    }

    private void Step16(){
        promptText.setText("Let's send Bob a response!\n\n" +
                "Enter a response to send Bob below.");
    }

    private void Step17() {
        messSent.setText(entryText.getText());
        message = messSent.getText();
        entryText.setText("");
        promptText.setText("Looks like your response contains some sensitive information. Good thing we can encrypt the message so only Bob could read it!\n\n\n" +
                "How should we encrypt this message for Bob?\n" +
                "a. Bob’s public key\n" +
                "b. Bob’s private key\n" +
                "c. Your public key\n" +
                "d. Your private key\n");
    }

    private void Step18(){
        answers = entryText.getText();
        if( answers.equals("a") || answers.equals("a.") || answers.equals("A") || answers.equals("A."))
        {
            promptText.setText("Correct! We’ll encrypt it using Bob’s public key so only Bob can decrypt it.\n");
            entryText.setText("");
        } else
        {
            promptText.setText("Not quite! The message should be encrypted using Bob’s public key.\n");
            entryText.setText("");
        }

    }

    private void Step19(){

       Step9();

    }

    private void Step20(){

        promptText.setText("Your message has been sent to Bob!\n");

        aMess3.setFill(Color.BLUE);
        aMess3.setText(aMess2.getText());
        aMess3.setTextAlignment(TextAlignment.RIGHT);
        bMess3.setFill(Color.BLACK);
        bMess3.setText(bMess2.getText());
        bMess3.setTextAlignment(TextAlignment.LEFT);

        aMess2.setFill(Color.BLACK);
        aMess2.setText(aMess1.getText());
        aMess2.setTextAlignment(TextAlignment.LEFT);
        bMess2.setFill(Color.BLUE);
        bMess2.setText(bMess1.getText());
        bMess2.setTextAlignment(TextAlignment.RIGHT);

        aMess1.setFill(Color.BLUE);
        aMess1.setText(messSent.getText());
        aMess1.setTextAlignment(TextAlignment.RIGHT);
        bMess1.setFill(Color.BLACK);
        bMess1.setText(messSent.getText());
        bMess1.setTextAlignment(TextAlignment.LEFT);

        messSent.setText("");
        encryptedMess.setText("");

    }

    private void Step21(){

        promptText.setText("----------------- WARNING! -----------------\n\n" +
                "Uh oh! The notorious hacker Alice is up to her evil tricks, again!\n" +
                "Looks like she has used a packet sniffing software to intercept your message to Bob!\n");
    }

    private void Step22(){

        promptText.setText("----------------- WARNING! -----------------\n\n" +
                "The encrypted message below is what Alice currently sees. \n\n" +
                "However, she's determined to decode your super secret message. She's decided to try decrypting the message using YOUR public key.\n");
        messSent.setText("");
        try {
            encryptedMess.setText(new String(eMessage, "UTF8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private void Step23(){

        promptText.setText("----------------- WARNING! -----------------\n\n" +
                "The decryption didn't work! Alice still can't understand your message. \n\n" +
                "However, she's still determined. She's decided to try decrypting the message again, this time using BOB'S public key.\n");
        //decrypt message - bobs public key -> backwards decryption w/ public key == encryption
        try {
            eMessage = enc.encrypt(message, userKeyPair);
            messSent.setText(new String(eMessage, "UTF8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Step24(){

        promptText.setText("----------------- WARNING! -----------------\n\n" +
                "The decryption failed again! Alice has finally given up! \n\n" +
                "It is impossible for Alice to decrypt the message without Bob's private key!\n\n");
        //decrypt message - bobs public key -> backwards decryption w/ public key == encryption
        try {
            eMessage = enc.encrypt(message, bobKeyPair);
            messSent.setText(new String(eMessage, "UTF8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void Step25(){

        promptText.setText("Phew! That was a close one!\n\n" +
                "Clearly, encrypting data is crucial to keeping it out of the wrong hands!");

        messSent.setText("");
        encryptedMess.setText("");
    }

    private void Step26(){

        promptText.setText("Bob is signing off!\n\n" +
                "Hopefully you now understand how encryption works and realize its importance!\n\n" +
                "Come back soon, " + username + "! \n \n" +
                " You may now close the software.");

    }
}
