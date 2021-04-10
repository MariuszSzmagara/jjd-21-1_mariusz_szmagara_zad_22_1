package pl.javastart.model;

public class MailMessage {

    private Person contactPerson;
    private String textContent;
    private String subject;

    public MailMessage() {
    }

    public Person getPerson() {
        return contactPerson;
    }

    public void setPerson(Person person) {
        this.contactPerson = person;
        
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
}
