package pckg.Class;

import java.nio.charset.StandardCharsets;

public class FileContentOperation {
    private String fileContent;

    public FileContentOperation(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getUncommentedContent() {
        String unCommentedContent = fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        return unCommentedContent;
    }

    public String getContentWithoutStringContent() {
        String withoutStringContent = fileContent.replaceAll("\"[^\"]*\"","");
        return withoutStringContent;
    }
    public String removeWhiteSpace() {
        String withoutWhiteSpace = fileContent.replaceAll("\\s+","");
        return withoutWhiteSpace;
    }


//    public String getClassName(String fileContent) {
//        String className = fileContent.split("class")[1].split("\\{")[0].trim();
//        return className;
//    }
//
//    public String getClassContent(String fileContent) {
//        String classContent = fileContent.split("class")[1].split("\\{")[1].trim();
//        return classContent;
//    }
//
//    public String getMethodName(String fileContent) {
//        String methodName = fileContent.split("\\{")[0].trim();
//        return methodName;
//    }
//
//    public String getMethodContent(String fileContent) {
//        String methodContent = fileContent.split("\\{")[1].trim();
//        return methodContent;
//    }
//
//    public String getMethodReturnType(String fileContent) {
//        String methodReturnType = fileContent.split("\\{")[0].split(" ")[0].trim();
//        return methodReturnType;
//    }
//
//    public String getMethodParameters(String fileContent) {
//        String methodParameters = fileContent.split("\\{")[0].split(" ")[1].trim();
//        return methodParameters;
//    }
//
//    public String getMethodBody(String fileContent) {
//        String methodBody = fileContent.split("\\{")[1].trim();
//        return methodBody;
//    }
//
//    public String getMethodBodyWithoutBrackets(String fileContent) {
//        String methodBodyWithoutBrackets = fileContent.split("\\{")[1].split("\\}")[0].trim();
//        return methodBodyWithoutBrackets;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnType(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnType = fileContent.split("\\{")[1].split("\\}")[0].split(" ")[1].trim();
//        return methodBodyWithoutBracketsAndReturnType;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnTypeAndParameters(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnTypeAndParameters = fileContent.split("\\{")[1].split("\\}")[0].split(" ")[2].trim();
//        return methodBodyWithoutBracketsAndReturnTypeAndParameters;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnTypeAndParametersAndBody(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnTypeAndParametersAndBody = fileContent.split("\\{")[1].split("\\}")[1].trim();
//        return methodBodyWithoutBracketsAndReturnTypeAndParametersAndBody;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturn(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturn = fileContent.split("\\{")[1].split("\\}")[1].split("return")[0].trim();
//        return methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturn;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolon(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolon = fileContent.split("\\{")[1].split("\\}")[1].split("return")[1].trim();
//        return methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolon;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolonAndReturn(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolonAndReturn = fileContent.split("\\{")[1].split("\\}")[1].split("return")[2].trim();
//        return methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolonAndReturn;
//    }
//
//    public String getMethodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolonAndReturnAndSemicolon(String fileContent) {
//        String methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolonAndReturnAndSemicolon = fileContent.split("\\{")[1].split("\\}")[1].split("return")[3].trim();
//        return methodBodyWithoutBracketsAndReturnTypeAndParametersAndBodyWithoutReturnAndSemicolonAndReturnAndSemicolon;
//    }

}
