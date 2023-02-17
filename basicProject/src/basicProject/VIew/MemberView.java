package basicProject.VIew;

import java.util.List;
import java.util.Scanner;

import basicProject.Controller.FrontController;
import basicProject.VO.MemberVO;
import basicProject.VO.ReservationVO;

public class MemberView {
	private static MemberView instance = new MemberView();

	private MemberView() {
	}

	public static MemberView getInstance() {
		return instance;
	}

	public MemberVO memberLogin(Scanner scanner) {
		System.out.print("ID。▶ ");
		String id = scanner.nextLine();
		System.out.print("Password。▶ ");
		String pwd = scanner.nextLine();
		return new MemberVO(id, pwd);
	}

	public int memberPage(Scanner scanner) {
		System.out.println("┏━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━┳━━━━━━━━━━━━━━┓");
		System.out.println("┃ 1.예약하기 ┃ 2.예약 정보 확인 ┃ 3.내 정보 ┃  0.로그 아웃 ┃");
		System.out.println("┗━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━┻━━━━━━━━━━━━━━┛");
		System.out.print("Input。▶ ");
		return Integer.parseInt(scanner.nextLine());
	}

	public void login(boolean login) {
		if (login) {
			System.out.println(" 로그인 성공!!");
			FrontController.nextPage();
		}else {
			System.out.println(" 로그인 실패ㅠㅠ");
		}
	}

	public void printMyInfo(MemberVO vo) {
		System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│                                     내 정보                                  │");
		System.out.println("├──────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│  아이디       비밀번호        이름            생년월일         전화번호      │");
		System.out.println("└──────────────────────────────────────────────────────────────────────────────┘");
		System.out.println(vo);
	}

	public ReservationVO designerName(List<ReservationVO> list,Scanner scanner) {
		System.out.println("┌───────────────────────────┐");
		System.out.println("│       디자이너 선택       │");
		System.out.println("└───────────────────────────┘");
		for (int i = 0; i < list.size(); i++) {
			System.out.print("    (" + (i + 1) + ")");
			System.out.printf(" %s\t  %s\t\n", list.get(i).getDsiName(), list.get(i).getPosition());
		}
		System.out.println(" ────────────────────────────");
		System.out.print("Designer。▶ ");
		int selectNum = Integer.parseInt(scanner.nextLine()) - 1;// 디자이너 이름을 가지고 가격을 표출
		return list.get(selectNum);
	}


	public ReservationVO reservationConditions(String dsiNo,List<ReservationVO> list2, Scanner scanner,String mid) {
	      System.out.println("┌────────────────────────────────┐");
	      System.out.println("│            시술 선택           │");
	      System.out.println("└────────────────────────────────┘");
	      for (int i = 0; i < list2.size(); i++) {
	            if (i + 1 == list2.size()) {
	               System.out.print(" (" + (i + 1) + ")");
	               System.out.printf(" %s\t%s원\t\n", list2.get(i).getMenuName(), list2.get(i).getPrice());
	            } else {
	               System.out.print(" (" + (i + 1) + ")");
	               System.out.printf(" %s\t\t%s원\t\n", list2.get(i).getMenuName(), list2.get(i).getPrice());
	            }
	         }
	      System.out.println(" ────────────────────────────────");
	      System.out.print("Style。▶ ");
	      int selectNum = Integer.parseInt(scanner.nextLine())-1;
	      String days = printDays(scanner);
	      days += printHour(scanner);
		  return new ReservationVO(days, mid, dsiNo, list2.get(selectNum).getMenuNo());
	   }


	private String printDays(Scanner scanner) {
		String[] dayArray = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
	            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	      System.out.println("┏━━━━━━━━━━━━━━━━━━━━━┓ ");
	        System.out.println("         MARCH      ");
	        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━┫");
	        System.out.println("┃ 일 월 화 수 목 금 토┃");
	           for(int i = 0; i < dayArray.length; i++) {   
	               if (i>=0 && i<4) {
	                  if (i==0) {
	                     System.out.printf("┃          %s ",dayArray[i]);
	                  } else if (i<3) {
	                     System.out.printf(" %s ",dayArray[i]);
	                  }
	                  if (i==3) {
	                     System.out.printf(" %s ┃",dayArray[i]);
	                     System.out.println();
	                  }
	               } else if (i>=4 && i<11) {           
	                  if(i==4) {
	                    System.out.printf("┃ %s ",dayArray[i]); 
	                 }else if (i<9) {
	                     System.out.printf(" %s ",dayArray[i]);
	                  } else if (i==9){
	                     System.out.printf("%s ",dayArray[i]);
	                  } else {
	                     System.out.printf("%s ┃",dayArray[i]);
	                     System.out.println();
	                  }
	               } else if (i>=11 && i<18) {   
	                  if(i==11) {
	                     System.out.printf("┃%s ",dayArray[i]);
	                  } else if (i==17) {
	                     System.out.printf("%s ┃",dayArray[i]);
	                      System.out.println();
	                  } else {
	                     System.out.printf("%s ",dayArray[i]);
	                  }
	               } else if (i>=18 && i<25){           
	                  if (i==18) {
	                     System.out.printf("┃%s ",dayArray[i]);
	                  } else if(i==24) {
	                     System.out.printf("%s ┃",dayArray[i]);
	                     System.out.println();
	                  } else {
	                     System.out.printf("%s ",dayArray[i]);
	                  }     
	              }  else {   
	                 if(i==25) {
	                   System.out.printf("┃%s ",dayArray[i]); 
	                 } else if (i==30){
	                   System.out.printf("%s    ┃",dayArray[i]);    
	                 } else {
	                    System.out.printf("%s ",dayArray[i]);    
	                 }
	              }     
	              }
	              System.out.println("\n┗━━━━━━━━━━━━━━━━━━━━━┛");     

		System.out.print("Day。▶ ");
		String days = "202303";
		int selectDay = Integer.parseInt(scanner.nextLine()) - 1;
		if (dayArray[selectDay].length() < 2) {
			days += "0";
		}
		days += dayArray[selectDay];
		return days;
	}

	private String printHour(Scanner scanner) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                      시간 선택                       ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String[] timeList = { "① 12:00", "② 13:00", "③ 14:00", "④ 15:00", "⑤ 16:00", "⑥ 17:00", "⑦ 18:00", "⑧ 19:00",
				"⑨ 20:00" };

		for (int i = 0; i < timeList.length; i++) {
			if (i >= 0 && i < 3) {
				System.out.printf("    %s   ", timeList[i]);
				if (i == 2) {
					System.out.println();
				}
			} else if (i >= 3 && i < 6) {
				System.out.printf("    %s   ", timeList[i]);
				if (i == 5) {
					System.out.println();
				}
			} else {
				System.out.printf("    %s   ", timeList[i]);
			}
		}
		System.out.print("\nHour。▶ ");
		int selectHour = Integer.parseInt(scanner.nextLine());
		String hour = null;
		switch (selectHour) {
		case 1:hour = "1200";break;
		case 2:hour = "1300";break;
		case 3:hour = "1400";break;
		case 4:hour = "1500";break;
		case 5:hour = "1600";break;
		case 6:hour = "1700";break;
		case 7:hour = "1800";break;
		case 8:hour = "1900";break;
		case 9:hour = "2000";break;
		default:break;
		}
		return hour;
	}

	public void result(int result) {
		if(result ==1) {
			System.out.println("예약이 완료되었습니다!!");
		}else if (result == 2) {
			System.out.println("예약이 되어있는 시간입니다. 다른시간을 선택해주세요.");
		}
		else {
			System.out.println("예약을 실패했습니다.");
		}
	}
	
	public int printReservation(List<ReservationVO> list, Scanner scanner) {
		if(list.isEmpty()) {
			return -3;
		}
		System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│                                         예약 정보                                           │");
		System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────┤");
		System.out.println("│   예약번호        예약일시            회원명   디자이너    가격      시술                   │");
		System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");
		int i=1;
		for (ReservationVO vo : list) {
			System.out.print("("+(i++)+")");
			System.out.println(vo);
		}
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("예약을 취소하시겠습니까? [Y┃N]。▶ ");
		String yesOrNo = scanner.nextLine();
		if (yesOrNo.equals("y") || yesOrNo.equals("Y")) {
			System.out.print("번호를 입력해주세요。▶ ");
			return Integer.parseInt(scanner.nextLine())-1;
		}
		return -2;
	}

	public void deleteSuccess(int count) {
		if (count > 0) {
			System.out.println("예약이 정상적으로 취소되었습니다!!.");
		} else if (count == -3) {
			System.out.println("예약된 정보가 없습니다.");
		}
	}

	public void noInfomation() {
		System.out.println("예약된 정보가 없습니다.");
	}

	public String createId(Scanner scanner) {
		System.out.print("ID。▶ ");
		return scanner.nextLine();
	}

	public boolean checkId(int checkId) {
		if (checkId > 0) {
			System.out.println("사용 불가능한 ID입니다. ");
			System.out.println("ID를 다시 입력해주세요. ");
			return true;
		}
		System.out.println("사용 가능한 ID입니다. ");
		return false;
	}

	public MemberVO createMember(Scanner scanner, String id) {
		System.out.print("Password。▶ ");
		String newPw = scanner.nextLine();
		System.out.print("Password Check。▶ ");
		if (!(newPw.equals(scanner.nextLine()))) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			System.out.println("비밀번호를 다시 입력해주세요. ");
			return null;
		}
		System.out.println("비밀번호가 일치합니다.");
		System.out.print("Name。▶ ");
		String newName = scanner.nextLine();
		System.out.print("Birth 【YYYYMMDD】");
		String newBir = scanner.nextLine();
		System.out.print("Phone Number。▶ ");
		String regEx = "(\\d{3})(\\d{4})(\\d{4})";
		String newPh = scanner.nextLine().replaceAll(regEx, "$1-$2-$3");
		return new MemberVO(id, newPw, newName, newBir, newPh);
	}

	public int myInfoMenu(Scanner scanner) {
		System.out.println("┏━━━━━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━┓");
		System.out.println("┃ 1.정보수정 ┃ 2.회원탈퇴 ┃ 0.뒤로가기 ┃");
		System.out.println("┗━━━━━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━┛");
		System.out.print("Input。▶ ");
		return Integer.parseInt(scanner.nextLine());
	}

	public MemberVO updateMyInfo(Scanner scanner, String id) {
		System.out.print("Password。▶ ");
		String updatePw = scanner.nextLine();
		System.out.print("Password Check。▶ ");
		if (!(updatePw.equals(scanner.nextLine()))) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			System.out.println("비밀번호를 다시 입력해주세요. ");
			return null;
		}
		System.out.println("비밀번호가 일치합니다.");
		System.out.print("Phone Number modify。▶ ");
		String updatePh = scanner.nextLine();
		return new MemberVO(id, updatePw, updatePh);
	}

	public void updateSuccess(int count) {
		if (count > 0) {
			System.out.println("정상적으로 정보가 변경되었습니다.");
		}
	}

	public String withDrawal(Scanner scanner) {
		System.out.print("정말 회원탈퇴 하시겠습니까? [Y┃N]。▶");
		return scanner.nextLine();
	}

	public boolean withDrawalSucess(int fulfill) {
		if (fulfill>0) {
			System.out.println("회원탈퇴 성공!!");
			return false;
		}
		return true;
	}
	public void errMessage() {
		System.out.println("올바른 번호를 입력해주세요.");
	}
	
}
