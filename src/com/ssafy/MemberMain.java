package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberServiceImpl;

public class MemberMain {
	
	private BufferedReader in;
	static private MemberDto curMemberDto = null;
	
	public MemberMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println("---------- 회원 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					registerMember();
					break;
				case 2:
					login();
					break;
				case 3:
					modifyMember();
					break;
				case 4:
					deleteMember();
					break;
				default:
					System.out.println("프로그램을 종료합니다!!!");
					System.exit(0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void registerMember() throws IOException {
		System.out.println("********** 멤버 등록 **********");
		MemberDto memberDto = new MemberDto();
		System.out.print("ID : ");
		memberDto.setUserId(in.readLine());
		System.out.print("이름 : ");
		memberDto.setUserName(in.readLine());
		System.out.print("PW : ");
		memberDto.setUserPass(in.readLine());
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		memberDto.setJoinDate(date.format(formatter));
		MemberServiceImpl.getMemberService().registerMember(memberDto);
	}

	private void login() throws IOException {
		System.out.println("********** 로그인 **********");
		System.out.print("ID : ");
		String userId = in.readLine();
		System.out.print("PW : ");
		String userPass = in.readLine();
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(userId, userPass);
		if (memberDto==null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println(memberDto.getUserId()+"님 환영합니다!");
			curMemberDto = memberDto;
		}
	}

	private void modifyMember() throws IOException {
		System.out.println("********** 정보 변경 **********");
		if (curMemberDto==null) {
			System.out.println("로그인 해야 합니다.");
		} else {
			System.out.print("변경할 PW : ");
			curMemberDto.setUserPass(in.readLine());
			MemberServiceImpl.getMemberService().modifyMember(curMemberDto);
		}
	}

	private void deleteMember() throws IOException {
		System.out.println("********** 계정 삭제 **********");
		System.out.println("삭제할 ID : ");
		String userId = in.readLine();
		MemberServiceImpl.getMemberService().deleteMember(userId);
		if (curMemberDto != null && curMemberDto.getUserId().equals(userId)) curMemberDto = null;
	}

	public static void main(String[] args) {
		new MemberMain();
	}
}
