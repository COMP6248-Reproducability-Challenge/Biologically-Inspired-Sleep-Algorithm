import java.io.*;

//creating an EnigmaFile class
public class EnigmaFile {
    private EnigmaMachine eMachine = new EnigmaMachine();


    //method to read the file
    public void readFile() throws IOException, Exception {
        String path = "/Users/SyedF/IdeaProjects/Enigma/EMtest.txt";
        String line;

        BufferedReader reader = new BufferedReader(new FileReader(path));

        try{
            while((line = reader.readLine()) != null) {
                encodeFile(line.toUpperCase());  //in case the file is written with lowercase letters
            }

            reader.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    //method to encode contents in a file
    public void encodeFile(String line) throws IOException, Exception {

        char[] charArray = line.toCharArray();  //covert String to char
        char[] encodedChar = new char[line.length()];  //store encoded char

        for(int i = 0; i < charArray.length; i++) {
            if((int)charArray[i] >= 65 && (int)charArray[i] <= 90) {
                encodedChar[i] = eMachine.encodeLetter(charArray[i]);  //encode only alphabets
            }
            else {
                encodedChar[i] = charArray[i];  //no changes to non-alphabets
            }
        }
        writeFile(String.valueOf(encodedChar));
    }


    //method to write the decoded message in a new file
    public void writeFile(String line) throws IOException, Exception {

        File fOut = new File("/Users/SyedF/IdeaProjects/Enigma/EMtestOut.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fOut, true));

        try {
            if(fOut.exists() && !fOut.isDirectory()) {
                writer.write(line);
                writer.close();
            }
            else {
                PrintWriter pWriter = new PrintWriter("/Users/SyedF/IdeaProjects/Enigma/EMtestOut.txt");
                pWriter.println(line);
                pWriter.close();
            }
        }
        catch(IOException io) {
            io.printStackTrace();
        }
    }


    //method to run a test(from the EnigmaMachine)
    public void setup() throws Exception {
        eMachine.start();
    }
}


