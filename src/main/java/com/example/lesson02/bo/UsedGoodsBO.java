package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // spring bean
public class UsedGoodsBO {
	
	// input(컨트롤러로부터 요청받음) : X (조건없음, *)
	// output(컨트롤러에게 돌려줌) : List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		
	}
	
}
