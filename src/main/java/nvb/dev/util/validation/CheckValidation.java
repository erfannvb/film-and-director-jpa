package nvb.dev.util.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import nvb.dev.exception.ValidationException;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckValidation {

    private CustomRegex regex;

    public CheckValidation() {
    }

    public <T> boolean isValid(T object) {
        try {

            ValidatorFactory factory = Validation.byDefaultProvider()
                    .configure()
                    .messageInterpolator(new ParameterMessageInterpolator())
                    .buildValidatorFactory();

            Validator validator = factory.getValidator();

            Set<ConstraintViolation<T>> violationSet = validator.validate(object);

            if (!violationSet.isEmpty()) {
                for (ConstraintViolation<T> violation : violationSet) {
                    System.out.println(violation.getMessage());
                }
                factory.close();
                return false;
            } else {
                return true;
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isFirstNameValid(String firstName) {
        Pattern pattern = Pattern.compile(regex.getValidString());
        Matcher matcher = pattern.matcher(firstName);
        if (matcher.matches()) {
            return true;
        } else {
            regex.getErrorMessageForInvalidString("firstName");
            return false;
        }
    }

    public boolean isLastNameValid(String lastName) {
        Pattern pattern = Pattern.compile(regex.getValidString());
        Matcher matcher = pattern.matcher(lastName);
        if (matcher.matches()) {
            return true;
        } else {
            regex.getErrorMessageForInvalidString("lastName");
            return false;
        }
    }


}
