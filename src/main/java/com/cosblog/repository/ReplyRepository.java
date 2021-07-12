package com.cosblog.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cosblog.dto.ReplySaveRequestDto;
import com.cosblog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	
	@Modifying
	@Query(value="INSERT INTO Reply(userId, boardId, content, createDate) VALUES(?1, ?2, ?3, now())", nativeQuery=true)
	int mSave(int userId, int boardid, String content); // 업데이트된 행의 개수를 리턴해줌
}
