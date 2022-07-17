import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource


internal class StringCalculatorKtTest {

    lateinit var stringCalculator: StringCalculator
    @BeforeEach
    fun 인스턴스생성() {
        stringCalculator = StringCalculator();
    }
    @ParameterizedTest
    @MethodSource("calculationExpressionProvider")
    fun 문자열에서_연산자_피연산자_추출하여_연산(expressionParam: Vaildator, expected: Double) {
        //given
        val expression = expressionParam
        //when
        val calculate = stringCalculator.calculate(expression)
        //then
        assertThat(calculate).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun calculationExpressionProvider() = listOf(
            Arguments { arrayOf(Vaildator.from("1+5*10-20"),"40.0") },
            Arguments { arrayOf(Vaildator.from("1+5*10-20/2+10"),"30.0") },
            Arguments { arrayOf(Vaildator.from("1+5*10-20*7"),"280.0") },
        )
    }
}


