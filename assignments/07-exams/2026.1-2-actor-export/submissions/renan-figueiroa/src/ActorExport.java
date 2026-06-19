
public class ActorExport{

        private int id;
        private String firstName;
        private String lastName;


// Construtor completo para inicializar todos os atributos
    public ActorExport(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toCsvLine() {
    
    String safeFirstName = (this.firstName != null) ? this.firstName : "";
    String safeLastName = (this.lastName != null) ? this.lastName : "";

    
    return String.format("%d,%s,%s", this.id, safeFirstName, safeLastName);
}
}