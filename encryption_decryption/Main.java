package encryption_decryption;

public class Main {

    public static String encrypt(String plainText, String key){
        String alpabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for(char c : plainText.toCharArray()){
            if(Character.isLetter(c)){
                int index = alpabets.indexOf(c);
                sb.append(String.valueOf(key.charAt(index)));
            }
            else{
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
    public static String decrypt(String encryptedText, String key){
        String alpabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for(char c : encryptedText.toCharArray()){
            if(Character.isLetter(c)){
                int index = key.indexOf(c);
                sb.append(String.valueOf(alpabets.charAt(index)));
            }
            else{
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String key = "hijknopqafwxyzglmrstubcdev";
        String enc = encrypt("How do you do no 9".toLowerCase(), key);

        System.out.println("encrypted value "+ enc);

        System.out.println("decrypt value "+decrypt(enc, key));



    }
}
