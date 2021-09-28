package MedicalAppointment.demo.exception;

public class ElementAlreadyPresentException extends Exception {

    public ElementAlreadyPresentException() {
        super("L'element est déjà défini");
    }
}
