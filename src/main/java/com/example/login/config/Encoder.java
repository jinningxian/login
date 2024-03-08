package com.example.login.config;

public class Encoder {

    private static final String REFERENCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+-./";

    public String encode(String plainText, char offset){

        System.out.println("HELLO WORLD:"+plainText);
        int shift = REFERENCE.indexOf(offset);
        if(shift == -1){
            throw new IllegalArgumentException("Offset character not found in reference table.");
        }
        StringBuilder encode = new StringBuilder();
        encode.append(offset);

        for(char c : plainText.toCharArray()){
            if(c == ' '){
                encode.append(c);
            }else{
                int inx = REFERENCE.indexOf(c);
                if(inx != -1){
                    int crrIndex = (inx - shift + REFERENCE.length()) % REFERENCE.length();
                    encode.append(REFERENCE.charAt(crrIndex));
                }else{
                    throw new IllegalArgumentException("Character '" + c + "' not found in reference table.");
                }
            }

        }
        return encode.toString();
    }

    public String decode(String encodedText){
        if(encodedText == null || encodedText.isEmpty()){
            return encodedText;
        }
        char offset =encodedText.charAt(0);
        int shift = REFERENCE.indexOf(offset);
        if(shift == -1){
            throw new IllegalArgumentException("Offset character not found in reference table.");
        }
        StringBuilder decoded = new StringBuilder();
        for(int i = 1; i < encodedText.length(); i++){
            char c = encodedText.charAt(i);
            int inx = REFERENCE.indexOf(c);
            if(c == ' '){
                decoded.append(c);
            }else {
                if(inx != -1){
                    int crrIndex = (inx+shift)%REFERENCE.length();
                    decoded.append(REFERENCE.charAt(crrIndex));
                }else{
                    throw new IllegalArgumentException("Character '" + c + "' not found in reference table.");
                }
            }

        }

        return decoded.toString();
    }
}
