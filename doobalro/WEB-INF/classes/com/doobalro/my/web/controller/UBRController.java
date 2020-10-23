package com.doobalro.my.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doobalro.my.biz.server.service.BoardService;
import com.doobalro.my.biz.server.service.ReplyService;
import com.doobalro.my.biz.server.service.UserService;
import com.doobalro.my.biz.server.vo.BoardVO;
import com.doobalro.my.biz.server.vo.ReplyVO;
import com.doobalro.my.biz.server.vo.UserVO;

@Controller
public class UBRController {
	/*
	 * 1. 蹂대뱶 delete update 由ы뵆 delete update ====> 而⑦듃濡ㅻ윭 �뵶�뿉�꽌 �쑀�� 泥댄겕 2. �쑀��
	 * �뾽�뜲�씠�듃 �떆(�씠由�) �뿰愿��맂 蹂대뱶 諛� �뙎湲� �옉�꽦�옄 �씠由� �닔�젙 �븘�슂
	 */
	// Reply


	@Resource(name = "ReplyService")
	ReplyService ReplyService;
	@Resource(name = "BoardService")
	BoardService BoardService;
	@Resource(name = "UserService")
	UserService UserService;

	@RequestMapping("introduction.do")
	public String introductionForm() {
		return "introduction";
	}

	@RequestMapping("/loginForm.do") // 嚥≪뮄�젃占쎌뵥 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/adduserForm.do") // 占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String adduserForm() {
		return "adduser";
	}

	@RequestMapping("/myinformation.do") // �슖�돦裕꾬옙�쟽�뜝�럩逾� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�슖�댙�삕
	public String updateUser() {
		return "myinformation";
	}

	@RequestMapping("/userUpdateForm.do") // 占쎌돳占쎌뜚占쎈땾占쎌젟 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String userUpdateForm() {
		return "updateUser";
	}

	@RequestMapping("/pwFindForm.do") // �뜮袁⑨옙甕곕뜇�깈筌≪뼐由� 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String pwFindForm() {
		return "pwFindForm";
	}

	@RequestMapping("/addBoardForm.do") // 野껊슣�뻻�눧占� 占쎌삂占쎄쉐 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String addBoardForm() {
		return "addBoardForm";
	}

	@RequestMapping("/updateBoardForm.do") // 寃뚯떆臾� �닔�젙 �럹�씠吏�濡�
	public ModelAndView updateBoardForm(int boardNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", BoardService.getBoard(boardNum));
		// mav.addObject("board", req.getAttribute("board"));
		mav.setViewName("updateBoardForm"); // 0425
		return mav;
	}

	////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/login.do", method=RequestMethod.POST) // �슖�돦裕꾬옙�쟽�뜝�럩逾�
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();
		uvo.setUserPhone(req.getParameter("userPhone"));
		uvo.setUserPw(req.getParameter("userPw"));

		String result = UserService.login(uvo);
		if (result.equals("로그인 성공")) {
			uvo = UserService.getUser(uvo);
			session.setAttribute("user", uvo); // �씠嫄� 瑗� �닔�젙
			session.setAttribute("city", req.getParameter("city"));
			System.out.println(uvo);
			mav.setViewName("redirect:Bike.do");

		} else {
			mav.setViewName("login");
		}

		mav.addObject("result", result);

		return mav;
	}

	@RequestMapping("/logout.do") // �슖�돦裕꾬옙�쟽�뜝�럥�닡�뜝�럩�쐨
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user");

		mav.setViewName("login");

		return mav;
	}
	

	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST) // 占쎌돳占쎌뜚揶쏉옙占쎌뿯
	public ModelAndView addUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String phone = req.getParameter("userPhone");
		String birth = req.getParameter("userBirth");
		
		if(phone.equals("")) {
			req.setAttribute("result", "휴대폰 번호를 입력해주세요");
			mav.setViewName("adduser");
			return mav;
		}else if(req.getParameter("userName").equals("")) {
			req.setAttribute("result", "이름을 입력해주세요");
			mav.setViewName("adduser");
			return mav;
		}else if(birth.equals("")) {
			req.setAttribute("result", "생년월일을 입력해주세요");
			mav.setViewName("adduser");
			return mav;
		}else if(req.getParameter("userPw").equals("")) {
			req.setAttribute("result", "패스워드를 입력해주세요");
			mav.setViewName("adduser");
			return mav;
		}
		

		if(!(this.isNumber(phone))){
			req.setAttribute("result", "Phone은 숫자만 기입 가능합니다.");
			mav.setViewName("adduser");
			return mav;
		}else if(!(this.isNumber(birth))){
			req.setAttribute("result", "생년월일은 숫자만 기입 가능합니다.");
			mav.setViewName("adduser");
			return mav;
		}else {
			UserVO uvo = new UserVO();
			uvo.setUserName(req.getParameter("userName"));
			uvo.setUserPhone(req.getParameter("userPhone"));
			uvo.setUserPw(req.getParameter("userPw"));
			uvo.setUserBirth(req.getParameter("userBirth"));
			String result = UserService.addUser(uvo);
			
			if(result.equals("가입 성공")) {
				mav.setViewName("login");
				return mav;
			}else {
				req.setAttribute("result", result);
				mav.setViewName("adduser");
				return mav;
			}
			
		}
		
		

	}
	
	public boolean isNumber(String str) {
	    char tempCh;
	    int dotCount = 0;
	    boolean result = true;

	    for (int i=0; i<str.length(); i++){
	      tempCh= str.charAt(i);
	      if ((int)tempCh < 48 || (int)tempCh > 57){
	        if(tempCh!='.' || dotCount > 0){
	          result = false;
	          break;
	        }else{
	          dotCount++;
	        }
	      }
	    }
	    return result;
	  }


	@RequestMapping(value = "/updateUser.do") 
	public ModelAndView updateUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO) req.getSession().getAttribute("user");
		String beforeName = uvo.getUserName();
		BoardVO bvo = new BoardVO();
		bvo.setUserNum(uvo.getUserNum());
		bvo.setBoardWriter(req.getParameter("userName"));
		uvo.setUserPw(req.getParameter("userPw"));
		uvo.setUserName(req.getParameter("userName"));
		uvo.setUserBirth(req.getParameter("userBirth"));
		uvo.setUserPhone(req.getParameter("userPhone"));
		
	
		String result = UserService.updateUser(uvo);
		if (result.equals("�닔�젙�릺�뿀�뒿�땲�떎.")) {
			BoardService.synchroBoard(bvo);
			ReplyService.synchroReply(uvo.getUserName(), beforeName);
			req.getSession().removeAttribute("user");
			req.getSession().setAttribute("user", uvo);
		}

		mav.addObject("result", result);
		mav.setViewName("redirect:Bike.do");
		return mav;
	}

	@RequestMapping(value = "/findPw.do") // �뜮袁⑨옙甕곕뜇�깈 筌≪뼐由�
	public ModelAndView pwFind(HttpServletRequest req) {
		System.out.println("+++++++++++++鍮꾨�踰덊샇李얘린");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();
		uvo.setUserPhone(req.getParameter("userPhone"));
		uvo.setUserBirth(req.getParameter("userBirth"));
		System.out.println(uvo);

		String result = UserService.pwFind(uvo);
		System.out.println("result" + result);
		if (result != null) {
			mav.addObject("userName", result);
			mav.setViewName("pwChange");
			return mav;
		}
		System.out.println(result);
		mav.addObject("result", result);
		mav.setViewName("redirect:login");
		return mav;
	}

	@RequestMapping(value = "/changePw.do") // �뜮袁⑨옙甕곕뜇�깈 筌≪뼐由�
	public String pwChange(HttpServletRequest req) {
		System.out.println("+++++++++++++鍮꾨�踰덊샇 蹂�寃�");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();

		String userPw = req.getParameter("userPw");
		String userPw2 = req.getParameter("userPw2");
		String userName = req.getParameter("userName");
		System.out.println("username" + userName);
		System.out.println(userPw + userPw2);

		if (!(userPw.equals(userPw2))) {
			System.out.println("鍮꾨�踰덊샇 遺덉씪移�");
			return "pwFindForm";
		} else {
			System.out.println("鍮꾨�踰덊샇 蹂�寃쏀븯湲�");
			uvo.setUserPw(userPw);
			uvo.setUserName(userName);
			System.out.println("uvo 媛믫솗�씤" + uvo);
			UserService.changePw(uvo);
			System.out.println("uvo 媛믫솗�씤2�슌�슑");
			return "login";
		}
	}

	@RequestMapping(value = "/deleteUser.do") // �뜝�럩�뤂�뜝�럩�쐸 �뜝�럡�돮�뜝�럥�떄
	public ModelAndView deleteUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO) req.getSession().getAttribute("user");
		String result = UserService.deleteUser(uvo);
		mav.addObject("result", result);
		mav.setViewName("redirect:index.jsp");
		req.getSession().removeAttribute("user");
		return mav;
	}
///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/addReply.do", method = RequestMethod.POST)
	public ModelAndView addReply(HttpServletRequest req) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.KOREA);
		Date Time = new Date();
		String nowTime = fm.format(Time);
		System.out.println("addreply");
		ReplyVO rvo = new ReplyVO();

		rvo.setBoardNum(Integer.parseInt(req.getParameter("boardNum")));
		rvo.setReplyContent(req.getParameter("replyContent"));
		rvo.setReplyDate(nowTime);
		rvo.setReplyWriter(req.getParameter("userName"));
		
		
		ReplyService.addReply(rvo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do?boardNum="+req.getParameter("boardNum")); // 占쎈퉸占쎈뼣 野껓옙 癰귣�諭뜻에占�~

		return mav;
	}
	
	
	@RequestMapping(value = "/deleteReply.do", method = RequestMethod.GET)
	public ModelAndView deleteReply(HttpServletRequest req) {
		ReplyVO rvo = this.getReply((Integer.parseInt(req.getParameter("replyNum"))));
		BoardVO bvo = this.getBoard((Integer.parseInt(req.getParameter("boardNum"))));
		
		rvo.setReplyContent(req.getParameter("replyContent"));
		bvo.setBoardRCnt(bvo.getBoardRCnt()-1);
		ReplyService.deleteReply(rvo);
		BoardService.updateBoard(bvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do?boardNum="+req.getParameter("boardNum")); // 占쎈퉸占쎈뼣 野껓옙 癰귣�諭뜻에占�~

		return mav;
	}

	@RequestMapping(value = "/updateReply.do", method = RequestMethod.POST)
	public ModelAndView updateReply(int replyNum, String replyContent) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.KOREA);
		Date Time = new Date();
		ReplyVO rvo = new ReplyVO(replyNum, replyContent, fm.format(Time));
		HashMap<String, Object> map = new HashMap<>();
		if(ReplyService.updateReply(rvo) == 1) {
			map.put("result", "success");
			map.put("boardNum", ReplyService.getReply(replyNum).getBoardNum());
		}
		else
			map.put("reulst", "fail");
		return new ModelAndView("jsonView", map);
	}

	public ReplyVO getReply(int replyNum) {
		return ReplyService.getReply(replyNum);
	}
	public BoardVO getBoard(int boardNum) {
		return BoardService.getBoard(boardNum);
	}
	
	@RequestMapping("/listBoard.do")
	public ModelAndView getAllBoard(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		if (req.getSession().getAttribute("user") == null) {
			mav.setViewName("redirect:loginForm.do");
		}else {
			mav.addObject("boardList", BoardService.getAllBoard()); // 占쎈막占쎈뱜�뵳�됰윮占쎈뱜占쎄퐬占쎌뿫 board嚥∽옙 占쎈퉸占쎈튊占쎈릭占쎄돌 ?
			mav.setViewName("boardList");
		}
		return mav;
	}
	@RequestMapping(value = "/searchBoard.do", method = RequestMethod.POST)
	public ModelAndView searchBoard(String condition, String keyword) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", BoardService.searchBoard(condition, keyword));
		mav.setViewName("boardList");
		return mav;
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getboard(int boardNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", BoardService.getBoard(boardNum));
		mav.addObject("replys", ReplyService.getAllReply(boardNum));
		mav.setViewName("board");
		return mav;
	}

	@RequestMapping(value = "/addBoard.do")
	public ModelAndView addboard(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.KOREA);
		Date Time = new Date();
		String nowTime = fm.format(Time);
		BoardVO bvo = new BoardVO();
		UserVO uvo = (UserVO) session.getAttribute("user");
		bvo.setBoardContent(req.getParameter("boardContent"));
		bvo.setBoardDate(nowTime);
		bvo.setBoardTitle(req.getParameter("boardTitle"));
		bvo.setBoardWriter(req.getParameter("boardWriter"));
		bvo.setUserNum(uvo.getUserNum());
		BoardService.addBoard(bvo);
		mav.setViewName("redirect:listBoard.do");
		return mav;
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public ModelAndView updateboard(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.KOREA);
		Date Time = new Date();
		String nowTime = fm.format(Time);
		BoardVO bvo = new BoardVO();
		bvo.setBoardContent(req.getParameter("boardContent"));
		bvo.setBoardTitle(req.getParameter("boardTitle"));
		bvo.setBoardDate(nowTime);
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		bvo.setBoardNum(boardNum);
		bvo.setBoardRCnt(BoardService.getBoard(Integer.parseInt(req.getParameter("boardNum"))).getBoardRCnt());
		BoardService.updateBoard(bvo);
		mav.setViewName("redirect:getBoard.do?boardNum="+boardNum);
		// mav.setViewName("redirect:listBoard.do");
		return mav;// �닔�젙�쓣 �솗�씤�븯�젮硫� �떎�떆 �겢由��빐 �뱾�뼱媛��빞�빐�꽌 踰덇굅濡�湲댄븳�뜲..萸�..�뀕
	}

	@RequestMapping(value = "/deleteBoard.do")
	public ModelAndView deleteboard(int boardNum) {
		ModelAndView mav = new ModelAndView();
		BoardService.deleteBoard(boardNum);
		mav.setViewName("redirect:listBoard.do");
		return mav;
	}

}
