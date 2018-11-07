package com.example.mapper;

import com.example.entity.PlayerInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerInfoMapper {

    long searchTotalPlayer(@Param("playerName")String playerName, @Param("playerRegion")String playerRegion);

    List<PlayerInfo> searchPlayerInfo(@Param("playerName") String playerName, @Param("playerRegion")String playerRegion, @Param("offset")long offset, @Param("pageSize")Integer pageSize);
}
