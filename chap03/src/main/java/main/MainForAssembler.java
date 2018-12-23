package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import assembler.Assembler;
import chap03.ChangePasswordService;
import chap03.IdPasswordNotMatchingException;
import chap03.MemberInfoPrinter;
import chap03.MemberListPrinter;
import chap03.MemberNotFoundException;
import chap03.MemberRegisterService;
import chap03.RegisterRequest;
import chap03.VersionPrinter;

public class MainForAssembler {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		
		
		String[] conf = {"classpath:conf1.xml", "classpath:conf2.xml"};
		//두개이상의 설정 파일을 사용할 경우, 이렇게 배열을 사용하면 편리함
		
		ctx = new GenericXmlApplicationContext(conf);

		
		//물론 이런식으로 배열을 안하고 하나하나 입력해줘도 됨.  
		//ctx = new GenericXmlApplicationContext("classpath:conf1.xml", "classpath:conf2.xml");
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("명령어를 입력하세요.");
			String command = reader.readLine();

			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");
				break;
			}

			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if(command.equals("list")) {
				processListCommand();
				continue;
			}else if(command.startsWith("info ")) {
				processInforCommand(command.split(" "));
				continue;
			}else if(command.equals("version")) {
				processVersionCommand();
				continue;
			}
			printHelp();
		}
	}

	private static Assembler assembler = new Assembler();
	
	
	
	private static void processNewCommand(String[] arg) {
		
		if (arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc
			= ctx.getBean("memberRegSvc", MemberRegisterService.class);
		
		
		
		
		RegisterRequest req = new RegisterRequest();
		
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		
		try {
			regSvc.register(req);
			System.out.println("등록했습니다.");
		} catch (Exception e) {
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
		
	}
	
	private static void processChangeCommand(String[] arg) {
		
		if (arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = 
				ctx.getBean("changePwdSvc", ChangePasswordService.class);

		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[2]);
			System.out.println("암호를 변경했습니다. \n");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일입니다. \n");
		}catch(IdPasswordNotMatchingException e){
			System.out.println("이메일과 암호가 일치하지 않습니다. \n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = 
				ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	
	private static void processInforCommand(String[] arg) {
		if (arg.length != 2) {
			printHelp();
			return;
		}
		
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	
	private static void processVersionCommand() {
		VersionPrinter versionPrinter = 
				ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
	
	
	
	
	
	
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}
	
	

}
