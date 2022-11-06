package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private Participants participants;
	private Results results;
	private Ladder ladder;

	public void start() {
		participants = new Participants(inputView.getParticipants());
		results = new Results(participants, inputView.getResults());
		ladder = new Ladder(participants.size(), inputView.getLadderHeight());
	}

	public void draw() {
		outputView.printLadder(participants, ladder);
		outputView.printResult();

	}
}
