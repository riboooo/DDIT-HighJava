package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {
	 
	 public static void main(String[] args) {
		
		 FileTest03 ft3 = new FileTest03();
		 
		 ft3.displayFileList(new File("d:/"));
		 
    }	


	 //디렉토리를 매개 변수로 받아서 해당 디렉토리에 있는 모든 파일과 디렉토리 목록을 출력하는 메서드
	 
	 public void displayFileList(File dir){
		if(!dir.isDirectory()){
			System.out.println(dir.getName() + "은 디렉토리가 아닙니다");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용들 .." );
		
		// 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구한다.
		File[] files = dir.listFiles();
//		String[] filestrs = dir.list(); // 목록을 스트링으로 가져가고싶을때
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		//가져온 파일과 디렉토리 목록을 출력
		for(int i = 0; i <files.length; i++){
			String fileName = files[i].getName();
			String attr = ""; //파일의 속성이 저장될 변수 (읽기, 쓰기, 히든, 디렉토리 구분)
			String size = ""; //파일 크기
			
			if(files[i].isDirectory()){
				attr="<DIR>";
			}else{
				size = files[i].length() + "";
				attr = files[i].canRead()? "R":"";
				attr += files[i].canWrite()?"W":"";
				attr += files[i].isHidden()?"H":"";
				
			}
			
			System.out.printf("%s %5s %12s %s\n", df.format(new Date(files[i].lastModified())),
					attr, size , fileName);
			
			
		}
		
		
		
		
	 }
	 

}
