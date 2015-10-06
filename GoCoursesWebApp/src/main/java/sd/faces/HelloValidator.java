package sd.faces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Sergei on 28.04.2015.
 */
@FacesValidator("HelloMessageValidator")
public class HelloValidator implements Validator {
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String message = o.toString();
        if (message.startsWith("abc")) {
            FacesMessage msg = new FacesMessage("Hello.message validation failed. " +
                    "I don't like messages started with 'abc'.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
