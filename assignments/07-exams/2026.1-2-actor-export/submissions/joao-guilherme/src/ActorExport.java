public class ActorExport {

    private int id;
    private String firtsName;
    private String lastName;

    public ActorExport(int id, String firtsName, String lastName) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirtsName() {
        return firtsName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toCsvLine() {
        return id + "," + firtsName + "," + lastName;
    }
}