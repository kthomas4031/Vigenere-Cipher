package project.pkg1.code.thomas.kyle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/*
Author: Kyle Thomas - U0000004031
Applied Cryptography
Professor Navid 

Project Vigenere
Start Date: 05/26/2018
End Date: 05/26/2018
*/

public class VigenereControllerController {

    //In later versions, I could put an option to change the key, in which case this would not be final
    private final String key = "THOMAS";
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea inp;

    @FXML
    private TextArea oup;

    @FXML
    private Button encryptor;

    @FXML
    private Button decryptor;

    @FXML
    void decrypt(ActionEvent event) {
        String plain = "";
        String encrypted = inp.getText().toUpperCase();
        
        for(int i = 0, j = 0 ; i < encrypted.length() ; i++){
            //Checks to see if the character at this index is a letter, if it's not it just keeps going
            if (encrypted.charAt(i) >= 'A' && encrypted.charAt(i) <= 'Z' ){
                //Appends the text to the end of the result string after decrypting it                
                plain += (char) ((encrypted.charAt(i) - key.charAt(j) + 26)% 26 + 'A');
                j = ++j % key.length();
            }else if (encrypted.charAt(i) == ' ')
                plain += ' ';
        }
        oup.setText(plain);
    }

    @FXML
    void encrypt(ActionEvent event) {
        String message = inp.getText().toUpperCase();
        
        String encrypted = "";
        
        for(int i = 0, j = 0 ; i < message.length() ; i++){
            //Checks to see if the character at this index is a letter, if it's not it just keeps going
            if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z' ){
                //Appends the text to the end of the result string after encrypting it
                encrypted += (char) ((message.charAt(i) + key.charAt(j))% 26 + 'A');
                //Originally I just wanted to add each character to key.charAt(i%6) but since spacing needs to be preserved I can't do that
                j = ++j % key.length();
            }else if (message.charAt(i) == ' ') //Preserving spacing
                encrypted += ' ';
        }
        oup.setText(encrypted);
    }

    @FXML
    void initialize() {
        assert inp != null : "fx:id=\"inp\" was not injected: check your FXML file 'VigenereController.fxml'.";
        assert oup != null : "fx:id=\"oup\" was not injected: check your FXML file 'VigenereController.fxml'.";
        assert encryptor != null : "fx:id=\"encryptor\" was not injected: check your FXML file 'VigenereController.fxml'.";
        assert decryptor != null : "fx:id=\"decryptor\" was not injected: check your FXML file 'VigenereController.fxml'.";

    }
}
