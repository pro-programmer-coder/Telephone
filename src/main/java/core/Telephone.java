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
            int i = 2;
            boolean flag = true;
            while(flag){
                int value = number.charAt(i);
                if(value >= 48 && value <= 57 ){
                    returnNumber += number.charAt(i);

                }
                if(number.length() -1 == i){
                    flag = false;
                }
                else {
                    i++;
                }
            }
            if(returnNumber.length() > 12){
                return "invalid";
            }
        }
        return returnNumber;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
