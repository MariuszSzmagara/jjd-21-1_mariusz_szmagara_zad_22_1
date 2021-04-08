package pl.javastart.model;

public class MailMessage {

    private String contactPersonFirstName;
    private String contactPersonLastName;
    private String contactPersonMailAddress;
    private String textContent;
    private String subject;

    public MailMessage() {
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContactPersonFirstName() {
        return contactPersonFirstName;
    }

    public void setContactPersonFirstName(String contactPersonFirstName) {
        this.contactPersonFirstName = contactPersonFirstName;
    }

    public String getContactPersonLastName() {
        return contactPersonLastName;
    }

    public void setContactPersonLastName(String contactPersonLastName) {
        this.contactPersonLastName = contactPersonLastName;
    }

    public String getContactPersonMailAddress() {
        return contactPersonMailAddress;
    }

    public void setContactPersonMailAddress(String contactPersonMailAddress) {
        this.contactPersonMailAddress = contactPersonMailAddress;
    }
}
