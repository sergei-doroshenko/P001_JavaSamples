package sd.faces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by Sergei on 28.04.2015.
 */
@FacesConverter("IntegerPairConverter")
public class IntegerPairConverter implements Converter {
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        try {
            int fst = Integer.parseInt(s.substring(0, s.indexOf(".")));
            int snd = Integer.parseInt(s.substring(s.indexOf(".") + 1));
            return new IntegerPair(fst, snd);
        } catch (RuntimeException e) {
            FacesMessage msg = new FacesMessage("Bad integer pair.",
                    "Integer pair must have format '123.456'.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        IntegerPair integerPair = (IntegerPair) o;
        return integerPair.getFst() + "." + integerPair.getSnd();
    }
}
