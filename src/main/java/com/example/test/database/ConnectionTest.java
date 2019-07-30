package com.example.test.database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}

public class ConnectionTest {
    public static void main(String[] args) {
        Connection connection = getConn();
        String sql = "insert into t_trade(trade_id,money) values(?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            final List<Trade> tradeList = initTradeList();
            for (Trade trade : tradeList) {
                preparedStatement.setString(1, trade.getTradeId());
                preparedStatement.setBigDecimal(2, trade.getMoney());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
             connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConn() {
        String driver = "org.h2.Driver";
        //String url = "jdbc:mysql://localhost:3306/test?rewriteBatchedStatements=true&amp;useServerPrepStmts=false&amp;cachePrepStmts=true&amp;useCompression=true&amp;autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=UTF-8";
        String url ="jdbc:h2:mem:test";
        String userName = "root";
        String password = "123456";
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<Trade> initTradeList() {
        List<Trade> tradeList = new ArrayList<>();
        Trade trade1 = new Trade("001", new BigDecimal("10.00"));
        Trade trade2 = new Trade(null, new BigDecimal("20.66"));
        Trade trade3 = new Trade("001", new BigDecimal("30.00"));
        tradeList.add(trade1);
        tradeList.add(trade2);
        tradeList.add(trade3);
        return tradeList;
    }
}
