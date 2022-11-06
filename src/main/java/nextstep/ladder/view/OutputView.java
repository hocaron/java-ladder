package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {

	public void printLadder(Participants participants, Ladder ladder) {
		System.out.println("사다리 결과");

		participants.forEach(participant -> System.out.print(participant + "  "));
		System.out.println();

		ladder.forEach(line -> {
			System.out.println(line.getLine());
		});
	}

	public void printResult() {
		System.out.println("실행 결과");

	}
}
