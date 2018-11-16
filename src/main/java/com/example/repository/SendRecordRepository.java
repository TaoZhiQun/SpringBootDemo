package com.example.repository;

import com.example.entity.SendRecord;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

@Repository(value = "sendRecordRepository")
public interface SendRecordRepository  extends CrudRepository<SendRecord, Long> {

    //@Lock(value = LockModeType.PESSIMISTIC_WRITE)
    List<SendRecord> findByGiftIdAndToUserId(String giftId, String toUserId);

    @Modifying
    @Transactional(propagation = Propagation.REQUIRED)
    @Query(value = "delete from send_record where gift_id =:giftId and to_user_id =:toUserId", nativeQuery = true)
    void deleteByGiftIdAndToUserId(@Param("giftId")String giftId, @Param("toUserId")String toUserId);
}
