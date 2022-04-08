package pckg.Class;

import pckg.Interface.IContentOperation;

import java.io.*;

public class Reader {
    private IContentOperation contentOperation;
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

        contentOperation.checkContentIsNotEmpty(allContent);

        return allContent;
    }

}
