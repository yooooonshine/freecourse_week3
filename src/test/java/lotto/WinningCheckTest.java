package lotto;

import lotto.domain.*;
import lotto.utility.GameUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("당첨 확인 기능 테스트")
public class WinningCheckTest {
    @Test
    @DisplayName("1등부터 6등을 한 번씩 했을 때 결과랑 일치하는 지 테스트")
    void 당첨_확인_기능_테스트() {
        // given
        WinningNumber winningNumber = WinningNumber.create(Arrays.asList(1, 2, 3, 4, 5, 6)); //1등 번호
        BonusNumber bonusNumber = BonusNumber.create(7); //보너스 번호
        ResultNumber.create(winningNumber, bonusNumber);
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); //1등
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); //2등
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)); //3등
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 39, 40)); //4등
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 38, 39, 40)); //5등
        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);

        User user = new User(5000, lottoList);
        // when
        GameUtility.checkLottoWinning(user);
//            // then
        assertEquals(user.getLottoResult().getFirst_place(), 1);
        assertEquals(user.getLottoResult().getSecond_place(), 1);
        assertEquals(user.getLottoResult().getThird_place(), 1);
        assertEquals(user.getLottoResult().getForth_place(), 1);
        assertEquals(user.getLottoResult().getFifth_place(), 1);
    }


}