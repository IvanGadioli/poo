public class ActorExport {
    private int id;
    private String firstName;
    private String lastName;

    public ActorExport(int id, String firstName, String lastName) {
        this.id= id;
        this.firstName= firstName;
        this.lastName = lastName;
    }

    public int getId() {
       
        return id;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
    
        return lastName;
    }

    public String toCsvLine() {
    //   Todo fazer uma verificação se  vim sem fist name ou lastname e colocar em uma exeçao que para  de rodar e fala o erro
        return id + "," + firstName + ","+ lastName + ",";
    }
}
