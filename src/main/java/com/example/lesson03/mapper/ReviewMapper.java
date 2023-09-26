package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	public Review selectReview(int id);
	
	// return int(MyBatis가 성공된 행의 개수를 return해준다, 자체 기능)
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// parameter가 2개 이상일 때 map으로 만든다 (@Param)
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") Double point
			, @Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id
			, @Param("review") String review);
	
	public int deleteReviewById(int id);
}
