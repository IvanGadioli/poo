public class HeartRates{
    
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;

    public HeartRates(){
    }

    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;

        if(dayOfBirth > 0 && monthOfBirth > 0 && yearOfBirth > 0){
            this.dayOfBirth = dayOfBirth;
            this.monthOfBirth = monthOfBirth;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setDayOfBirth(int dayOfBirth){
        this.dayOfBirth = dayOfBirth;
    }

    public int getDayOfBirth(){
        return dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth){
        this.monthOfBirth = monthOfBirth;
    }

    public int getMonthOfBirth(){
        return monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth(){
        return yearOfBirth;
    }

    public int calculateAge(int currentYear){
        return currentYear - yearOfBirth;
    }

    public int calculateMaxHeartRate(){
        return 220 - calculateAge(2024);
    }

    public String calculateTargetHeartRate(){
        double max = calculateMaxHeartRate();
        double minTarget = max * 0.50;
        double maxTarget = max * 0.85;

        return String.format("%.0f bpm - %.0f bpm", minTarget, maxTarget);
    }

}