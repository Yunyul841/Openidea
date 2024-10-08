package service;

import java.util.Scanner;

import dao.OpenDAO;
import dto.OpenDTO;

public class OpenService {
	OpenDAO a = new OpenDAO();
	Scanner in = new Scanner(System.in);
	
	public void memu() {
		while(true) {
			System.out.println("1. 제안하기");
			System.out.println("2. 수정하기");
			System.out.println("3. 삭제하기");
			System.out.println("4. 전체보기");
			System.out.println("5. 검색하기");
			System.out.println("6. 종료하기");
			System.out.print("선택 >> ");
			int selNum = in.nextInt();
			in.nextLine();
			if(selNum == 1) {
				add();
			}else if(selNum == 2) {
				update();
			}else if(selNum == 3) {
				delect();
			}else if(selNum == 4) {
				list();
			}else if(selNum == 5) {
				search();
			}else if(selNum == 6) {
				break;
			}
		}
	}
	private void add() {
		System.out.println("제목을 입력해주세요");
		String title = in.nextLine();
		System.out.println("작성자를 입력해주세요");
		String name = in.nextLine();
		System.out.println("내용을 입력해주세요");
		String ion = in.nextLine();
		OpenDTO open = new OpenDTO();
		open.setTitle(title);
		open.setName(name);
		open.setIon(ion);
	            
		
	}
	private void update() {
		
	}
	private void delect() {
		
	}
	private void list() {
		
	}
	private void search() {
		
	}
}
























