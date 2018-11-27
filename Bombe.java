//creating a Bombe class
public class Bombe {
    private EnigmaMachine bombeEM;

    //constructor method to create a new Enigma Machine object
    public Bombe() {
        bombeEM = new EnigmaMachine();
    }


    //method to find missing plugs
    public void challenge1() throws Exception {

        char[] letterList = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (char ch1 : letterList) {
            for (char ch2 : letterList) {
                bombeEM.clearPlugboard();
                bombeEM.addPlug('D', ch1);
                bombeEM.addPlug('S', ch2);

                bombeEM.addRotor(new BasicRotor("IV"), 0);
                bombeEM.setPosition(0,8);
                bombeEM.addRotor(new BasicRotor("III"), 1);
                bombeEM.setPosition(1,4);
                bombeEM.addRotor(new BasicRotor("II"), 2);
                bombeEM.setPosition(2,21);

                bombeEM.addReflector(new Reflector("ReflectorI"));

                String message = "JBZAQVEBRPEVPUOBXFLCPJQSYFJI";
                char[] chars = message.toCharArray();
                String out = "";
                for(int i = 0; i < chars.length; i++) {
                    out += bombeEM.encodeLetter(chars[i]);
                }

                if (out.contains("ANSWER")){
                    System.out.println(out);
                    System.out.println("1st Plug: " + "[D-" + ch1 + "]");
                    System.out.println("2nd Plug: " + "[S-" + ch2 + "]");
                }
            }
        }
    }


    //method to find the initial rotor positions
    public void challenge2() throws Exception {

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    bombeEM.clearPlugboard();
                    bombeEM.addPlug('H', 'L');
                    bombeEM.addPlug('G', 'P');

                    bombeEM.addRotor(new BasicRotor("V"), 0);
                    bombeEM.setPosition(0, i);
                    bombeEM.addRotor(new BasicRotor("III"), 1);
                    bombeEM.setPosition(1, j);
                    bombeEM.addRotor(new BasicRotor("II"), 2);
                    bombeEM.setPosition(2, k);

                    bombeEM.addReflector(new Reflector("ReflectorI"));

                    String message = "AVPBLOGHFRLTFELQEZQINUAXHTJMXDWERTTCHLZTGBFUPORNHZSLGZMJNEINTBSTBPPQFPMLSVKPETWFD";
                    char[] chars = message.toCharArray();
                    String out = "";
                    for (int x = 0; x < chars.length; x++) {
                        out += bombeEM.encodeLetter(chars[x]);
                    }

                    if (out.contains("ELECTRIC")) {
                        System.out.println(out);
                        System.out.println("Initial position of 1st Basic Rotor: " + i);
                        System.out.println("Initial position of 2nd Basic Rotor: " + j);
                        System.out.println("Initial position of 3rd Basic Rotor: " + k);
                    }
                }
            }
        }
    }


    //method to find the rotors used
    public void challenge3() throws Exception {
        String[] types = new String[]{"I", "II", "III", "IV", "V"};

        for (String type1 : types) {
            for (String type2 : types) {
                for (String type3 : types) {
                    bombeEM.clearPlugboard();
                    bombeEM.addPlug('M', 'F');
                    bombeEM.addPlug('O', 'I');

                    bombeEM.addRotor(new BasicRotor(type1),0);
                    bombeEM.setPosition(0,22);
                    bombeEM.addRotor(new BasicRotor(type2), 1);
                    bombeEM.setPosition(1,24);
                    bombeEM.addRotor(new BasicRotor(type3), 2);
                    bombeEM.setPosition(2,23);

                    bombeEM.addReflector(new Reflector("ReflectorI"));

                    String message = "WMTIOMNXDKUCQCGLNOIBUYLHSFQSVIWYQCLRAAKZNJBOYWW";
                    char[] chars = message.toCharArray();
                    String out = "";
                    for(int i = 0 ; i< chars.length; i++) {
                        out += bombeEM.encodeLetter(chars[i]);
                    }
                    if (out.contains("JAVA")) {
                        System.out.println(out);
                        System.out.println("Type of 1st Basic Rotor: " + type1);
                        System.out.println("Type of 2nd Basic Rotor: " + type2);
                        System.out.println("Type of 3rd Basic Rotor: " + type3);
                    }
                }
            }
        }
    }


}
