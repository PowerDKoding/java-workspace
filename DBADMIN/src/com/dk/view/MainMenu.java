package com.dk.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.dk.controller.MemberController;
import com.dk.model.vo.Member;

public class MainMenu {

	// view : 사용자가 보게 될 시각적인 요소(화면). 입력(Scanner) 및 출력 => Console이 담당
	// 웹애플리케이션에서는 웹브라우저에서 입력, 출력을 한다.

	private Scanner sc = new Scanner(System.in);

	// MemberController 객체 생성 : 사용자의 요청을 받은 객체
	private MemberController mc = new MemberController();

	public void mainMenu() {

		while (true) {
			System.out.println("\n==상품 관리 프로그램==");
			System.out.println("1. 상품 전체 조회");
			System.out.println("2. 상품 추가");
			System.out.println("3. 상품 수정");
			System.out.println("4. 상품 삭제");
			System.out.println("5. 상품 검색");
			System.out.println("0. 프로그램 종료하기");

			System.out.println(">> 번호 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				mc.selectList();
				break; // Controll 패키지에 있는 클래스에 처리
			case 2:
				insertMember();
				break; // 현재 클래스에서 처리
			case 3:
				updateMember();
				break; // 현재 클래스에서 처리
			case 4:
				mc.deleteMember(inputMemberId());
				break; // Controll 패키지에 있는 클래스에 처리
			case 5:
				mc.selectById(inputMemberId());
				break; // Controll 패키지에 있는 클래스에 처리
			case 0:
				System.out.println("이용해 주셔서 감사합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력했습니다. 다시 입력해주세요.");
			}
		}
	}

	// 2번 선택시 보이는 회원추가 창(서브화면)
	public void insertMember() {

		System.out.println("\n== 상품 추가 ==");

		// 아이디 ~ 취미까지 입력받기
		System.out.println("상품아이디 : ");
		String productId = sc.nextLine();

		System.out.println("상품명 : ");
		String pName = sc.nextLine();

		System.out.println("상품가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println("부가설명 : ");
		String description = sc.nextLine();

		System.out.println("재고 : ");
		int stock = sc.nextInt();
		sc.nextLine();

		mc.insertMember(productId, pName, price, description, stock);
	}

	public String inputMemberId() {
		System.out.println("\n상품 아이디 입력 : ");
		return sc.nextLine();
	}

	public void updateMember() {
		System.out.println("\n== 상품 정보 변경 ==");

		// 회원 아이디, 변경할 비밀번호, 변경할 이메일, 변경할 전화번호, 변경할 주소

		String productId = inputMemberId();

		System.out.println("상품명 변경 : ");
		String pName = sc.nextLine();

		System.out.println("상품가격 변경 : ");
		int price = sc.nextInt();
		sc.nextLine();

		System.out.println("부가설명 변경 : ");
		String description = sc.nextLine();

		System.out.println("재고 변경 : ");
		int stock = sc.nextInt();
		sc.nextLine();

		mc.updateMember(productId, pName, price, description, stock);
	}

	// ----------------------응답화면-------------------------------------
	// 서비스 요청 처리후 성공했을 때 사용자가 보게될 화면
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}

	// 서비스 요청 처리 실패했을때 사용자가 보게될 화면
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}

	// 조회 서비스 요청 처리 후 조회결과가 없을 경우 사용자가 보게 될 화면
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}

	// 조회 서비스 요청 처리 후 조회결과가 여러개일 경우 사용자가 보게될 화면
	public void displayMemberList(ArrayList<Member> list) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.\n");

		for (Member m : list) {
			System.out.println(m);
		}
	}

	public void displayMember(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}

	public void displayProfile(Member m) {
		System.out.println("\n=====상품 정보=====");

		System.out.println("상품아이디 : " + m.getProductId());
		System.out.println("상  품  명 : " + m.getpName());
		System.out.println("  가  격   : " + m.getPrice());
		System.out.println(" 부가설명  : " + m.getDescription());
		System.out.println("  재  고   : " + m.getStock());

	}
}

