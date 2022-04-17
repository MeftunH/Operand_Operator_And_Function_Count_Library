package pckg.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {

    public int getFunctionCounter(String input) {
        FileContentOperation fileContentOperation = new FileContentOperation();
        input = fileContentOperation.getContentWithoutStringContent(fileContentOperation.getUncommentedContent(input));
        int functionCounter = 0;
         List<String> functions = new ArrayList<>();
        String functionPattern = "\\w+ +\\w+ *\\([^\\)]*\\) *\\{";
        Pattern pattern = Pattern.compile(functionPattern);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String function = matcher.group();
            String[] splitedFunction = function.split(" ");
            String splitedFun = splitedFunction[1];
            String[] splitedParameter = splitedFun.split("\\(");
            String spliteEnd = splitedParameter[0];
            functions.add(spliteEnd);
            functionCounter++;
        }
        return functionCounter;
    }
}
