package pckg.Class;

import pckg.Interface.IContentOperation;

public class ContentOperation implements IContentOperation {
    public boolean checkContentIsNotEmpty(String content) throws IllegalArgumentException {
        if (content == null) {
            throw new IllegalArgumentException("File is null");
        }
        return true;
    }

}
