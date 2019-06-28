package com.zl.spbm;

import com.zl.spbm.entity.UserInfo;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Author: lzhang
 * @Date: 2019/6/28 15:31
 */
public class SpelTest {

    @Test
    public void spelTest() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        ParserContext parserContext = ParserContext.TEMPLATE_EXPRESSION;
        Expression expression = expressionParser.parseExpression("#{hello}", parserContext);
        System.out.println(expression.getExpressionString());
    }

    @Test
    public void parser() {
        ExpressionParser expressionParser = new SpelExpressionParser();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setUid(9527);
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("user",userInfo);
        String str = expressionParser.parseExpression("#user.getUid()+1900").getValue(context) + "";
        System.out.println(str);

    }
}
