package nextstep.ladder.domain.result;

import java.util.List;

import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.exception.BadRequestException;

public class Results {

	private final Participants participants;
	private final List<String> results;

	public Results(Participants participants, List<String> results) {
		checkResults(participants, results);
		this.participants = participants;
		this.results = results;
	}

	private void checkResults(Participants participants, List<String> results) {
		if (participants.size() != results.size()) {
			throw new BadRequestException("참여자의 수와 실행 결과의 수가 다릅니다.");
		}
	}
}
