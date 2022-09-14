package com.foch.springserver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foch.springserver.model.user.User;
import com.foch.springserver.model.user.UserDao;

@RestController
public class WelfareController {

	@Autowired
	private UserDao userDao;

	/**
	 * 복지사가 일반인을 수혜자로 허용하는 함수이다.
	 * @param userId
	 * @param welfareId
	 * @return
	 */

	@PostMapping("/benefit_user_allow")
	public Map<String, String> allowBenefitUser(@RequestParam(value = "userId", defaultValue = "") String userId, @RequestParam(value = "welfareId", defaultValue = "") String welfareId) {

		Map<String, String> result = new HashMap<String, String>();

		if (userId.equals("")) {

			result.put("code", "1");
			result.put("message", "사용자 아이디를 입력해주십시오.");

		} else if (welfareId.equals("")) {

			result.put("code", "2");
			result.put("message", "복지사 아이디를 입력해주십시오.");

		} else {

			try {

				User welfareUser = userDao.findUser(welfareId);

				if (welfareUser.getType() == 3) {

					User benefitUser = userDao.findUser(userId);

					if (benefitUser == null) {

						result.put("code", "3");
						result.put("message", "존재하지 않는 사용자입니다.");

					} else if (benefitUser.getType() == 4) {

						result.put("code", "4");
						result.put("message", "이미 수혜자인 사용자입니다.");
					} else {

						/* User의 Type을 4로 변경 */
						userDao.changeType(userId, 4);
						result.put("code", "0");
						result.put("message", "수혜자로 변경을 완료했습니다.");

					}

				} else {

					result.put("code", "5");
					result.put("message", "복지사가 아닙니다.");
				}

			} catch (Exception e) {

				result.put("code", "6");
				result.put("message", "알 수 없는 오류입니다.");
			}

		}

		return result;

	}

}
