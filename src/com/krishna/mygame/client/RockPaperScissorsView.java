package com.krishna.mygame.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.core.client.GWT;

public class RockPaperScissorsView extends Composite implements EntryPoint {

	 interface RockPaperScissorsViewUiBinder extends UiBinder<Widget, RockPaperScissorsView> {}
	    private static RockPaperScissorsViewUiBinder uiBinder = GWT.create(RockPaperScissorsViewUiBinder.class);

	    @UiField
	    Button rockButton, paperButton, scissorsButton;

	    @UiField
	    Label userChoiceLabel, computerChoiceLabel, resultLabel; 

	    private String[] choices = {"Rock", "Paper", "Scissors"};

	    public RockPaperScissorsView() {
	        initWidget(uiBinder.createAndBindUi(this));
	    }

	    @UiHandler("rockButton")
	    void handleRockClick(ClickEvent e) {
	        playGame("Rock");
	    }

	    @UiHandler("paperButton")
	    void handlePaperClick(ClickEvent e) {
	        playGame("Paper");
	    }

	    @UiHandler("scissorsButton")
	    void handleScissorsClick(ClickEvent e) {
	        playGame("Scissors");
	    }

	    private void playGame(String userChoice) {
	        String computerChoice = choices[Random.nextInt(3)];
	        String result = determineWinner(userChoice, computerChoice);

	        // Update the labels with the results
	        userChoiceLabel.setText("You chose: " + userChoice);
	        computerChoiceLabel.setText("Computer chose: " + computerChoice);
	        resultLabel.setText("Result: " + result);
	    }

	    private String determineWinner(String userChoice, String computerChoice) {
	        if (userChoice.equals(computerChoice)) {
	            return "It's a tie!";
	        }
	        switch (userChoice) {
	            case "Rock":
	                return (computerChoice.equals("Scissors")) ? "You win!" : "Computer wins!";
	            case "Paper":
	                return (computerChoice.equals("Rock")) ? "You win!" : "Computer wins!";
	            case "Scissors":
	                return (computerChoice.equals("Paper")) ? "You win!" : "Computer wins!";
	        }
	        return "";
	    }

	    @Override
	    public void onModuleLoad() {
	        RootPanel.get().add(new RockPaperScissorsView());
	    }
}