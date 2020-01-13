package core;

public class Telephone {
    private String number;

    public Telephone(String number) {
        this.number = number;
    }

    public String getNumber() {
        String returnNumber = "";
        String start = "" + number.charAt(0) + number.charAt(1);
        if(start.equals("+1")){
            returnNumber += start;
            for(int i = 2; i < 12;){
                int value = number.charAt(i);
                if(value >= 48 && value <= 57 ){
                    returnNumber += number.charAt(i);
                    i++;
                }
            }
        }
        return returnNumber;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
