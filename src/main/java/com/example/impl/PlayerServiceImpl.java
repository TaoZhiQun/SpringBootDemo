package com.example.impl;

import com.example.entity.PlayerInfo;
import com.example.mapper.PlayerInfoMapper;
import com.example.service.PlayerInfoService;
import com.example.util.Page;
import com.example.util.Pageable;
import com.example.util.PageableImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerInfoService {
    @Autowired
    private PlayerInfoMapper playerInfoMapper;
    @Override
    public Page<PlayerInfo> searchPlayerInfo(String playerName, String playerRegion, Integer pageNo, Integer pageSize) {
        Pageable pageable = new PageableImpl();
        pageable.setPageNo(pageNo);
        pageable.setPageSize(pageSize);
        long total =playerInfoMapper.searchTotalPlayer(playerName,playerRegion);
        pageable.setTotalPage((int)total/pageSize);
        pageable.setTotalRecord(total);

        List<PlayerInfo> playerInfoList = new ArrayList<>();
        if(total>0L){
            long offset = pageNo*pageSize-pageSize;
            playerInfoList = playerInfoMapper.searchPlayerInfo(playerName,playerRegion,offset,pageSize);
        }
        return Page.getPage(pageable,playerInfoList);
    }
}
