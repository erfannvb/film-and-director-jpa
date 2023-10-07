package nvb.dev.util.validation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomRegex {

    private String validString = "^[a-zA-Z]+$";

    public String getErrorMessageForInvalidString(String fieldName) {
        return fieldName + " must just contain letters.";
    }

}
