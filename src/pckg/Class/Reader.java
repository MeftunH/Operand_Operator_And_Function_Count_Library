package pckg.Class;

import java.io.*;

public class Reader {
    private Validator validator;
    private String filePath;

    public Reader(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String readFromFile(String filePath) throws IOException {
        String allContent = null;
        validator = new Validator(filePath);
        validator.isJavaFile();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            allContent = sb.toString();
        } catch (IOException e) {
          throw new IOException("File can't be read");
        }
        validator.isContentEmpty(allContent);

        return allContent;
    }

}
