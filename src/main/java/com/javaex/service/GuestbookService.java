package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestDao guestDao;

	// 리스트
	public List<GuestVo> exeList() {

		List<GuestVo> guestList = guestDao.guestSelect();

		return guestList;
	}

	// 등록
	public int exeWrite(GuestVo guestVo) {

		int count = guestDao.guestInsert(guestVo);

		return count;

	}

	public GuestVo exeDeleteForm(int no) {

		GuestVo guestVo = guestDao.guestSelectOne(no);

		return guestVo;
	}

	public int exeDelete(int no, String password) {
		System.out.println("exeDelete");

		int count = guestDao.guestDelete(no, password);

		return count;
	}

}
