package com.example.quiz_9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.quiz_9.constants.OptionType;
import com.example.quiz_9.entity.Quiz;
import com.example.quiz_9.repository.QuizDao;
import com.example.quiz_9.service.ifs.QuizService;
import com.example.quiz_9.vo.BasicRes;
import com.example.quiz_9.vo.CreateOrUpdateReq;
import com.example.quiz_9.vo.DeleteReq;
import com.example.quiz_9.vo.Question;

@SpringBootTest
public class QuizServiceTests {

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuizDao quizDao;

	@Test
	public void createTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;煎魚;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "丹丹", "1號餐;2號餐;3號餐;4號餐", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "炒飯", "豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// 刪除測試資料 TODO
	}

	@Test
	public void createNameErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;煎魚;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "丹丹", "1號餐;2號餐;3號餐;4號餐", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "炒飯", "豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq("", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
	}

	@Test
	public void createStartDateErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;煎魚;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "丹丹", "1號餐;2號餐;3號餐;4號餐", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "炒飯", "豬肉炒飯;海鮮炒飯;干貝馬鈴薯(推);綜合炒飯", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// 今天是 2024/5/30，所以開始日期不能是當天或是之前
		CreateOrUpdateReq req = new CreateOrUpdateReq("午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
	}

	@Test
	public void createTest1() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;煎魚;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// 測試 name error
		CreateOrUpdateReq req = new CreateOrUpdateReq("", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
		// 測試 start date error: 假設今天是 2024/5/30，所以開始日期不能是當天或是之前
		req = new CreateOrUpdateReq("午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
		// 測試 end date error: 結束日期不能比開始日期早
		req = new CreateOrUpdateReq("午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param end date error!!"), "create test false!!");
		// 剩餘的邏輯全部判斷完之後，最後才會是測試成功的情境
		req = new CreateOrUpdateReq("午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
	}

	@Test
	public void createOrUpdateTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "健康餐?", "松阪豬;炸豬排;煎魚;烤雞腿", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq(5, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 15), //
				LocalDate.of(2024, 6, 15), questionList, true);
		quizService.createOrUpdate(req);
	}

	@Test
	public void updateTest() {
		Quiz quiz = new Quiz(13, "午餐吃啥?", "午餐吃啥?", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 1), "", false);
		quizDao.save(quiz);
		System.out.println("==============================");
	}

}
