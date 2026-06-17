public class ActorExport {
  private int id;
  private String firstName;
  private String lastName;

  public ActorExport(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Todos os GETS
  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  // return
  public String toCsvLine() {
    return id + "," + firstName + "," + lastName;
  }
}
