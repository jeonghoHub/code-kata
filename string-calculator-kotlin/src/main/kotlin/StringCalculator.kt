import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators
import java.util.LinkedList
import java.util.Queue

class StringCalculator() {
    fun calculate(expressionParam: Vaildator): Double {
        val operators = CalculationMaterialExtractor.operatorExtraction(expressionParam.get())
        val operands = CalculationMaterialExtractor.operandExtraction(expressionParam.get())
        return calculate(operators, operands)
    }

    private fun calculate(operators: Queue<Char>, operands: Queue<Double>): Double {
        var result: Double = operands.poll()
        while(!operators.isEmpty()) {
            result = Operator.findByOperator(operators.poll()).apply(result, operands.poll())
        }
        return result
    }

}

