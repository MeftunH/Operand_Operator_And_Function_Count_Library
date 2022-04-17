package pckg.Class;

import java.io.File;
import java.io.FileNotFoundException;

public class Validator {

    private String fileName;
    private FileContentOperation contentOperation;

    public Validator(String fileName) {
        this.contentOperation = new FileContentOperation();
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isJavaFile() throws IllegalArgumentException {

        String extension = getFileExtension(getFileName());
        if (!(extension.equals("java"))){
            throw new IllegalArgumentException("File is not a java file");
        }
        return true;
    }

    private String getFileExtension(String fileName) {
        String extension = "";
        extension = this.fileName.replaceAll("^.*\\.(.*)$", "$1");
        return extension;
    }

    public boolean isContentEmpty(String fileContent) throws IllegalArgumentException {
             String unCommentedContent = contentOperation.getUncommentedContent(fileContent);
            if (unCommentedContent.isEmpty()){
            throw new IllegalArgumentException("File is empty");
        }
        return false;
    }

    public boolean isFileExist() throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException("File does not exist");
        }
        return true;
    }
}
