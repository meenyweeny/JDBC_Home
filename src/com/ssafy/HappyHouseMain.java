package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.service.HouseService;
import com.ssafy.happyhouse.model.service.HouseServiceImpl;

public class HappyHouseMain {

	private BufferedReader in;
	private HouseService houseService = new HouseServiceImpl();
	
	public HappyHouseMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("---------- 아파트 정보 ----------");
			System.out.println("1. 동코드 검색");
			System.out.println("2. 아파트 정보");
			System.out.println("3. 아파트 매매 정보");
			System.out.println("-------------------------------------");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------------------");
			System.out.print("메뉴 선택 : ");
			try {
				int num = Integer.parseInt(in.readLine());
				switch (num) {
				case 1:
					dongCode();
					break;
				case 2:
					aptInfo();
					break;
				case 3:
					aptDealInfo();
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
	
	private void dongCode() throws IOException {
		System.out.println("********** 동코드 검색(동이름) **********");
		System.out.print("동이름 : ");
		String dongName = in.readLine();
		System.out.println("********** 동코드 목록 **********");
		List<DongCodeDto> dongList = houseService.dongCodeList(dongName);
		for(DongCodeDto dong : dongList) {
			System.out.println(dong.toString());
		}
	}

	private void aptInfo() throws NumberFormatException, IOException {
		System.out.println("********** 아파트 정보 검색(동코드) **********");
		System.out.print("동코드 : ");
		String dongCode = in.readLine();
		System.out.println("********** 아파트 목록 **********");
		List<HouseInfoDto> aptList = houseService.searchByDongCode(Integer.parseInt(dongCode));
		for(HouseInfoDto apt : aptList) {
			System.out.println(apt.toString());
		}
	}

	private void aptDealInfo() throws NumberFormatException, IOException {
		System.out.println("********** 아파트 매매 정보 검색(아파트번호) **********");
		System.out.print("아파트번호 : ");
		String aptNo = in.readLine();
		System.out.print("거래년도 : ");
		String year = in.readLine();
		System.out.print("거래월 : ");
		String month = in.readLine();
		System.out.println("********** 아파트 매매 목록 **********");
		List<HouseDealDto> houseList = houseService.searchByAptNo(aptNo, Integer.parseInt(year), Integer.parseInt(month));
		for(HouseDealDto house : houseList) {
			System.out.println(house.toString());
		}
	}

	public static void main(String[] args) {
		new HappyHouseMain();
	}
}
