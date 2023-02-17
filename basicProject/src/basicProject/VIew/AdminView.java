package basicProject.VIew;

import java.util.List;
import java.util.Scanner;

import basicProject.VO.DesignerVO;
import basicProject.VO.ReservationVO;

public class AdminView {
	private static AdminView instance = new AdminView();

	private AdminView() {
	}

	public static AdminView getInstance() {
		return instance;
	}

	public int adminMenu(Scanner scanner) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━┓");
		System.out.println("┃ 1. 예약 스케줄 확인 ┃ 2. 전체 스케줄 확인 ┃ 3. 디자이너 정보 조회 ┃ 4.디자이너 퇴직처리 ┃ 5.퇴직자 조회 ┃ 0.로그 아웃 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━┛");
		System.out.print("Input。▶ ");
		return Integer.parseInt(scanner.nextLine());
	}

	public String searchDesignerName(Scanner scanner) {
		System.out.print("디자이너 이름을 입력해주세요。▶ ");
		return scanner.nextLine();
	}

	public void printSchedules(List<ReservationVO> list) {
		System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│                               전체 스케줄 목록                               │");
		System.out.println("├──────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│   예약번호        예약일시      회원명  디자이너  가격    시술               │");
		System.out.println("└──────────────────────────────────────────────────────────────────────────────┘");
		for (ReservationVO vo : list) {
			System.out.print("  " + vo.getrNo());
			System.out.print("  " + vo.getrDate());
			System.out.print("  " + vo.getMemName());
			System.out.print("   " + vo.getDsiName());
			System.out.printf("%8s", vo.getPrice());
			System.out.print("   " + vo.getMenuName() + "    \n");
		}
	}

	public void printSchedule(ReservationVO vo) {
		if (vo == null) {System.out.println("해당 디자이너가 없습니다.");return;}
		System.out.println("┌──────────────────────────────────────────────────────┐");
		System.out.println("│                    예약 스케줄 목록                  │");
		System.out.println("├──────────────────────────────────────────────────────┤");
		System.out.println("│      예약일시     회원명   디자이너  시술    가격    │");
		System.out.println("└──────────────────────────────────────────────────────┘");
		System.out.print("  " + vo.getrDate());
		System.out.print("  " + vo.getMemName());
		System.out.print("    " + vo.getDsiName());
		System.out.print("   " + vo.getMenuName());
		System.out.print("\t" + vo.getPrice() + " \n");
	}

	public boolean adminLogin(Scanner scanner) {
		System.out.print("ID。▶ ");
		String adminId = scanner.nextLine();
		System.out.print("Password。▶ ");
		String adminPw = scanner.nextLine();
		if (adminId.equals("admin")) {
			if (adminPw.equals("adad123")) {
				System.out.println("로그인 성공!!");
				return true;
			} else {
				System.out.println("비밀번호가 틀립니다.");
			}
		} else {
			System.out.println("아이디를 다시 확인해주세요.");
		}
		return false;
	}

	public void printAllDesigner(List<DesignerVO> list) {
		System.out.println("┌────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│                              디자이너 목록                             │");
		System.out.println("├────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│ 코드   이름    생년월일        휴대폰번호     직책      입사일         │");
		System.out.println("├────────────────────────────────────────────────────────────────────────┤");
		for (DesignerVO vo : list) {
			System.out.println("│ " + vo + " │");
		}
		System.out.println("└────────────────────────────────────────────────────────────────────────┘");
	}

	public void deleteSuccesses(int count) {
		if (count > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("해당 디자이너가 없습니다.");
		}
	}

	public void retire(List<DesignerVO> list) {
		System.out.println("┌────────────────────────────────┐");
		System.out.println("│           퇴직자 목록          │");
		System.out.println("├────────────────────────────────┤");
		System.out.println("│  코드      이름        직책    │");
		System.out.println("└────────────────────────────────┘");
		for (DesignerVO vo : list) {
			System.out.print("   " + vo.getDsiNo());
			System.out.print("     " + vo.getDsiName() + "       ");
			System.out.println(vo.getDsiBir());
		}
	}

}
