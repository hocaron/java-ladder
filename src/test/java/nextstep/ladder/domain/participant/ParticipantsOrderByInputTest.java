package nextstep.ladder.domain.participant;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.exception.BadRequestException;

class ParticipantsOrderByInputTest {

	@DisplayName("입력가능한 이름을 입력하면 ParticipantsOrderByInput 가 생성된다.")
	@ParameterizedTest
	@MethodSource("generateWrongName")
	void Given_Names_Then_Participants() {
		List<String> names = List.of("pobi", "honux", "crong", "jk");

		ParticipantsOrderByInput participantsOrderByInput = new ParticipantsOrderByInput(names);
		assertThat(participantsOrderByInput.size()).isEqualTo(names.size());
	}

	@DisplayName("입력가능하지 않은 이름를 입력하면 예외를 던진다.")
	@ParameterizedTest
	@MethodSource("generateWrongName")
	void Given_WrondName_Then_ThrowException(List<String> list) {
		assertThatThrownBy(() -> new ParticipantsOrderByInput(list)).isInstanceOf(BadRequestException.class);
	}

	static Stream<List<String>> generateWrongName() {
		return Stream.of(
			List.of(""),			// 이름 길이가 0 인 경우
			List.of("test1234")		// 이름 길이가 5를 초과하는 경우
		);
	}
}