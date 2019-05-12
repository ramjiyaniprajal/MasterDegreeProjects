package com.ebusiness.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.ebusiness.validator.EmailValidator")
public class EmailValidator implements Validator {

    //Regex for email validation
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
            + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
            + "(\\.[A-Za-z]{2,})$";

    private Pattern pattern; //Pattern object
    private Matcher matcher; //Matcher object

    //Initializing the parameters
    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    //Validation checking
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        //Check the email validation
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            //Error message when failed to match pattern
            FacesMessage msg
                    = new FacesMessage("E-mail validation failed.",
                            "Invalid E-mail format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }

}
