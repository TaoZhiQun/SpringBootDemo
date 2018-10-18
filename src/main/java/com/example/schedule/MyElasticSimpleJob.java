package com.example.schedule;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import java.io.OutputStreamWriter;

public class MyElasticSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
    }
}
