package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
	private Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	void createGame(){
		assertNotNull(game);
	}

	@Test
	void ThrowExceptionWhenInputIsNull(){
		assertThrows(IllegalArgumentException.class, () -> {
			game.guess(null);
		});
	}
	
	@Test
	public void 입력값_자리수가_세자리가_아닐_경우() {
        assertIllegalArgument("12");
		assertIllegalArgument(null);
		assertIllegalArgument("1234");
		assertIllegalArgument("12s");

	}

	private void assertIllegalArgument(String guessNumber) {
		try {
			game.guess(guessNumber);

		} catch (IllegalArgumentException e) {

		}
	}

	@Test
	public void 입력값에_숫자_외의_뮸자가_입력될_경우() {
		assertIllegalArgument("121");
	}
	
	@Test
	public void 입력값에_중복된_숫자가_입력될_경우() {



	}
	
	@Test
	public void 숫자_세개가_전부_일치_할_경우_3_strike() {
		generateQuestion("123");
		GameResult result = game.guess("123");
	assertMatchedNumber(result, result.isSovled(), 3, 0);
	}

	private void generateQuestion(String question) {
		game.question = question;
	}

	@Test
	public void 숫자_세개가_전부_일치_하지_않을_경우_0_strike_0_ball() {
		generateQuestion("123");
		boolean sovled = false;
	int strikes = 0;
	int balls =0;
	GameResult result = game.guess("456");

	assertMatchedNumber(result, !result.isSovled(), strikes, balls);
	}

	private void assertMatchedNumber(GameResult result, boolean result1, int strikes, int balls) {
		assertThat(result).isNotNull();
		assertThat(result1);
		assertThat(result.getStrikes()).isEqualTo(strikes);
		assertThat(result.getBalls()).isEqualTo(balls);
	}

	@Test
	public void 스트라이크만_있을_경우_1_strike_0_ball() {
	generateQuestion("123");
	assertMatchedNumber(game.guess("120"), false, 2, 0);
	}
	
	@Test
	public void 볼만_있을_경우_0_strike_1_ball() {
	generateQuestion("123");
	assertMatchedNumber(game.guess("120"), false, 2, 0);
	assertMatchedNumber(game.guess("061"), false, 0, 1);
	assertMatchedNumber(game.guess("136"), false, 1, 1);
	}
	
	@Test
	public void 볼과_스트라이크가_함께_있을_경우_1_strike_1_ball() {

	}
}
