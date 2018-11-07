package com.example.service;

import com.example.entity.PlayerInfo;
import com.example.util.Page;

public interface PlayerInfoService {
    Page<PlayerInfo> searchPlayerInfo(String playerName, String playerRegion, Integer pageNo, Integer pageSize);
}
