package se.iths.christoffer.adventuregame.view;

public class FakeUi implements UI{

    private String input;

    public void setInput(String input){
        this.input = input;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public String getInput(String prompt) {
        return input;
    }


}
