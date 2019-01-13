package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;


@Component
@Data
public class Restaurant {

	// @setter : 자동으로 setChef()를 컴파일 시 생성함.
	//onMethod_ : 생성되는 setChef()에 @autowired 어노테이션을 추가함
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}
