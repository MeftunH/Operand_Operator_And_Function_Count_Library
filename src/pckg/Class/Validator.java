package pckg.Class;

import pckg.Interface.IContentOperation;
import pckg.Interface.IValidator;

public class Validator implements IValidator {

    private String fileName;
    private IContentOperation contentOperation;

    public Validator(String fileName,IContentOperation contentOperation) {
        this.contentOperation = contentOperation;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean isJavaFile() throws IllegalArgumentException {

        String extension = getFileExtension(getFileName());
        if (!(extension.equals("java"))){
            throw new IllegalArgumentException("File is not a java file");
        }
        return true;
    }

    private String getFileExtension(String fileName) {
        String extension = "";
        extension = fileName.replaceAll("^.*\\.(.*)$", "$1");
        return extension;
    }

    @Override
    public boolean isContentEmpty(String fileContent) throws IllegalArgumentException {
             String unCommentedContent = contentOperation.getUncommentedContent(fileContent);
            if (fileContent.isEmpty() || unCommentedContent.isEmpty()){
            throw new IllegalArgumentException("File is empty");
        }
        return true;
    }




//    @Override
//    public boolean isFileExist() throws IllegalArgumentException {
//        File file = new File(getFileName());
//        if (!file.exists()){
//            throw new IllegalArgumentException("File does not exist");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isFileReadable() throws IllegalArgumentException {
//        File file = new File(getFileName());
//        if (!file.canRead()){
//            throw new IllegalArgumentException("File is not readable");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isFileWritable() throws IllegalArgumentException {
//        File file = new File(getFileName());
//        if (!file.canWrite()){
//            throw new IllegalArgumentException("File is not writable");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isFileEmpty() throws IllegalArgumentException {
//        File file = new File(getFileName());
//        if (file.length() == 0){
//            throw new IllegalArgumentException("File is empty");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isFileValid() throws IllegalArgumentException {
//        try {
//            isJavaFile();
//            isFileExist();
//            isFileReadable();
//            isFileWritable();
//            isFileEmpty();
//            return true;
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException(e.getMessage());
//        }
//    }
//}

//    @Override
//    public boolean isValidClassName(String className) throws IllegalArgumentException {
//        if (className.isEmpty()){
//            throw new IllegalArgumentException("Class name is empty");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isValidMethodName(String methodName) throws IllegalArgumentException {
//        if (methodName.isEmpty()){
//            throw new IllegalArgumentException("Method name is empty");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isValidMethodParameters(String methodParameters) throws IllegalArgumentException {
//        if (methodParameters.isEmpty()){
//            throw new IllegalArgumentException("Method parameters are empty");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isValidMethodReturnType(String methodReturnType) throws IllegalArgumentException {
//        if (methodReturnType.isEmpty()){
//            throw new IllegalArgumentException("Method return type is empty");
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isValidMethodBody(String methodBody) throws IllegalArgumentException {
//        if (methodBody.isEmpty()){
//            throw new IllegalArgumentException("Method body is empty");
//        }
//        return true;
//    }
}
