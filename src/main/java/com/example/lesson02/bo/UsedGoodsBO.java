package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service // spring bean
public class UsedGoodsBO {
	
	@Autowired // spring bean(객체)를 가져오는 것 - (Dependency Injection)
	private UsedGoodsMapper usedGoodsMapper;
	
	// input(컨트롤러로부터 요청받음) : X (조건없음, *)
	// output(컨트롤러에게 돌려줌) : List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
}
