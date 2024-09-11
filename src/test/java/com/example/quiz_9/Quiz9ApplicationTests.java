//package com.example.quiz_9;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.example.quiz_9.repository.QuizDao;
//import com.example.quiz_9.vo.Question;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//
////@SpringBootTest
//class Quiz9ApplicationTests {
//	
//	@Autowired
//	private QuizDao quizDao;
//
//	@Test
//	void contextLoads() {		
//		String str = "AB;B;C;D"; //�ﶵ
//		String ansStr = "A;AB;E"; //�^��
//		String[] strArray = str.split(";"); //["A", "AB", "E"]
//		List<String> strList = List.of(strArray); //["AB", "B", "C", "D"]
//		String[] ansArray = ansStr.split(";");//��^�������}�C
//		for(String item : ansArray) { // �@�@���
//			System.out.println(item + ": " + strList.contains(item));
//			System.out.println(item + ": " + str.contains(item));
//			System.out.println("========================");
//		}
//	}
//	
//	@Test
//	public void objectMapperTest() {
//		String str = "[{\"id\":1,\"title\":\"���d�\?\",\"options\":\"�Q����;���ޱ�;�γ�;�N���L\",\"type\":\"���\",\"is_necessary\":true},{\"id\":2,\"title\":\"����\",\"options\":\"1���\;2���\;3���\;4���\\",\"type\":\"���\",\"is_necessary\":true},{\"id\":3,\"title\":\"����\",\"options\":\"�ަת���;���A����;�z�����a��(��);��X����\",\"type\":\"���\",\"is_necessary\":true}]";
//		String qStr = "{\"id\":1,\"title\":\"���d�\?\",\"options\":\"�Q����;���ޱ�;�γ�;�N���L\",\"type\":\"���\",\"is_necessary\":true}";
//		ObjectMapper mapper = new ObjectMapper();
//		
//		try {
//			Question q = mapper.readValue(qStr, Question.class);
//			System.out.println(q);
//			//======================
//			List list = mapper.readValue(str, List.class);
//			List<Question> list1 = mapper.readValue(str, List.class);
//			List<Question> quList = mapper.readValue(str, new TypeReference<>() {});
//			System.out.println("==============");
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void test1() {
//		Map<Integer, String> map = new HashMap<>();
//		map.put(1, "AAA");
//		System.out.println(map);
//		System.out.println("=================");
//		map.forEach((k,v) -> {
//			map.replace(k, "ABC");
//			map.put(k, "DDD");
//		});
//		System.out.println(map);
//	}
//	
//	@Test
//	public void test2() {
//		List<Integer> need = new ArrayList<>(List.of(1, 2));
//		List<Integer> qIds = new ArrayList<>(List.of(1, 3));
//		System.out.println(qIds.containsAll(need));
//		System.out.println(need.containsAll(qIds));
//		List<Integer> need1 = new ArrayList<>(List.of(2, 1));
//		System.out.println(need.containsAll(need1));
//	}
//	
//	@Test
//	public void test3() {
//		List<String> list = List.of("A", "B", "C", "D", "E");
//		String str = "AABBBCDDAEEEAACCDD";
//		//�p�� A, B, C, D, E �U�X�{�F�X��
//		Map<String, Integer> map = new HashMap<>();
//		for(String item : list) {
//			String newStr = str.replace(item, "");
//			int count = str.length() - newStr.length();
//			map.put(item, count);
//		}
//		System.out.println(map);
//	}
//	
//	@Test
//	public void test4() {
//		System.out.println(0/2);
//		System.out.println(2/0);
//	}
//
//}
