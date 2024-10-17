package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("실제 Main 메소드에서 예외를 발생시키는 테스트")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("정상적인 값이 들어갔을때 실제 코드에서 원하는 값이 출력되어야함")
    void 실제코드_적용_1번() {
        assertSimpleTest(() -> {
            run("//>\\n1:2,3");
            assertThat(output()).contains("[1, 2, 3]");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
