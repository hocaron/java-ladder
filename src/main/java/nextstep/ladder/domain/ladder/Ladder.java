package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Line> {

	private final List<Line> ladder = new ArrayList<>();

	public Ladder(int length, int height) {
		IntStream.range(0, height)
			.forEach(count-> ladder.add(new Line(length)));
	}

	public Integer executeByNumber(int number) {
		int currentNumber = number;
		for (Line line : ladder) {
			currentNumber = getNextNumber(currentNumber, line);
		}
		return currentNumber;
	}

	private Integer getNextNumber(int currentNumber, Line line) {
		if (line.hasLeftLine(currentNumber)) {
			currentNumber -= 1;
		}

		if (line.hasRightLine(currentNumber)) {
			currentNumber += 1;
		}
		return currentNumber;
	}

	@Override
	public Iterator<Line> iterator() {
		return ladder.iterator();
	}

	@Override
	public void forEach(Consumer<? super Line> action) {
		Iterable.super.forEach(action);
	}
}
