package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;

public class HappyHouseMain {

	private BufferedReader in;

	public HappyHouseMain() {
		in = new BufferedReader(new InputStreamReader(System.in));
		menu();
	}

	private void menu() {
		while (true) {
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
		
	}

	private void aptInfo() throws NumberFormatException, IOException {
		
	}

	private void aptDealInfo() throws NumberFormatException, IOException {
		
	}

	public static void main(String[] args) {
		new HappyHouseMain();
	}
}
