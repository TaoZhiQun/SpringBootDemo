package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.mysql.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource(){
        return buildDataSource();
    }

    @Bean
    public IdGenerator getIdGenerator() {
        return new CommonSelfIdGenerator();
    }

    private DataSource buildDataSource(){
        Map<String,DataSource> dataSourceMap = new HashMap<>(1);
        dataSourceMap.put("tao",createDataSource("tao"));
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap,"tao");
        TableRule userTableRule = TableRule.builder("t_user").actualTables(Arrays.asList("t_user_0","t_user_1")).dataSourceRule(dataSourceRule).build();
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(Arrays.asList(userTableRule)).tableShardingStrategy(new TableShardingStrategy("id",new ModuloTableShardingAlgorithm())).build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return dataSource;
    }

    private static DataSource createDataSource(final String dataSourceName){
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://106.14.119.3:3306/%s",dataSourceName));
        result.setUsername("root");
        result.setPassword("youqu");
        return result;
    }

}
