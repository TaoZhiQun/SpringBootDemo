package com.example.test.other;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Trade {
    private String tradeId;
    private BigDecimal money;

    public Trade(String tradeId, BigDecimal money) {
        this.tradeId = tradeId;
        this.money = money;
    }

    public String getTradeId() {
        return tradeId;
    }

    public BigDecimal getMoney() {
        return money;
    }

}

public class BigDecimalTest {
    public static void main(String[] args) {
        List<Trade> tradeList = new ArrayList<Trade>() {{
            this.add(new Trade("003", new BigDecimal("20")));
            this.add(new Trade("003", new BigDecimal("20")));
            this.add(new Trade("002", new BigDecimal("20")));
        }};
        // TODO 分组求和 形式为Map<String,BigDecimal> Stream.of
        Map<String, BigDecimal> map = tradeList.stream().collect(Collectors.groupingBy(Trade::getTradeId, Collectors.reducing(BigDecimal.ZERO, Trade::getMoney, BigDecimal::add)));
        System.out.println(map);

    }
}
